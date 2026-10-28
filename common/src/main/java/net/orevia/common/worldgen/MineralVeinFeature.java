package net.orevia.common.worldgen;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

/** Builds a connected vein, committing only when the requested size fits natural rock. */
public final class MineralVeinFeature extends Feature<NoneFeatureConfiguration> {

    private final MineralDeposit deposit;

    public MineralVeinFeature(MineralDeposit deposit) {
        super(NoneFeatureConfiguration.CODEC);
        this.deposit = deposit;
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        RandomSource random = context.random();
        BlockPos origin = context.origin();

        if (deposit == MineralDeposit.BAUXITE) {
            int surface = level.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, origin.getX(), origin.getZ());
            int low = Math.max(deposit.minY(), surface - 12);
            int high = Math.min(deposit.maxY(), surface - 2);
            if (low > high) return false;
            origin = new BlockPos(origin.getX(), low + random.nextInt(high - low + 1), origin.getZ());
            if (!level.getBiome(new BlockPos(origin.getX(), surface, origin.getZ())).is(deposit.preferredBiomes())) {
                return false;
            }
        } else if (!preferred(level, origin) && random.nextBoolean()) {
            // Half of the attempts outside preferred biomes are retained.
            return false;
        }

        int size = deposit.minSize() + random.nextInt(deposit.maxSize() - deposit.minSize() + 1);
        List<BlockPos> vein = collect(level, origin, random, size);
        if (vein.size() != size) return false;

        for (BlockPos pos : vein) {
            boolean deep = level.getBlockState(pos).is(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
            level.setBlock(pos, deposit.block(deep).defaultBlockState(), Block.UPDATE_CLIENTS);
        }
        return true;
    }

    /** Checks both the underground biome and the surface biome above this column. */
    private boolean preferred(WorldGenLevel level, BlockPos pos) {
        int surface = level.getHeight(Heightmap.Types.WORLD_SURFACE_WG, pos.getX(), pos.getZ());
        return level.getBiome(pos).is(deposit.preferredBiomes())
                || level.getBiome(new BlockPos(pos.getX(), surface, pos.getZ())).is(deposit.preferredBiomes());
    }

    /** Randomized frontier growth keeps every selected block face-connected to the seed. */
    private List<BlockPos> collect(WorldGenLevel level, BlockPos origin, RandomSource random, int size) {
        List<BlockPos> vein = new ArrayList<>();
        List<BlockPos> frontier = new ArrayList<>();
        Set<BlockPos> visited = new HashSet<>();
        frontier.add(origin);
        visited.add(origin);

        while (!frontier.isEmpty() && vein.size() < size) {
            BlockPos pos = frontier.remove(random.nextInt(frontier.size()));
            if (!replaceable(level, pos)) continue;
            vein.add(pos);
            for (Direction direction : Direction.values()) {
                BlockPos neighbor = pos.relative(direction);
                if (visited.add(neighbor)) frontier.add(neighbor);
            }
        }
        return vein;
    }

    /** Preserves non-host blocks and keeps bauxite covered, within 12 blocks of the surface. */
    private boolean replaceable(WorldGenLevel level, BlockPos pos) {
        if (pos.getY() < deposit.minY() || pos.getY() > deposit.maxY()
                || level.isOutsideBuildHeight(pos) || !level.ensureCanWrite(pos)) return false;

        BlockState state = level.getBlockState(pos);
        boolean natural = state.is(BlockTags.STONE_ORE_REPLACEABLES)
                || state.is(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        if (deposit != MineralDeposit.BAUXITE) return natural;
        if (!natural && !state.is(BlockTags.TERRACOTTA)) return false;

        int depth = level.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, pos.getX(), pos.getZ()) - pos.getY();
        if (depth < 2 || depth > 12) return false;
        for (Direction direction : Direction.values()) {
            BlockState neighbor = level.getBlockState(pos.relative(direction));
            if (neighbor.isAir() || !neighbor.getFluidState().isEmpty()) return false;
        }
        return true;
    }
}
