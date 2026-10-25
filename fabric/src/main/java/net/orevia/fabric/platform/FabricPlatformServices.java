package net.orevia.fabric.platform;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.orevia.common.platform.PlatformModelData;
import net.orevia.common.platform.PlatformServicesImpl;

public final class FabricPlatformServices implements PlatformServicesImpl {

    @Override public void sendReader(net.minecraft.server.level.ServerPlayer player,
                                      ReaderPacket packet) {
        net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking.send(player,packet);
    }

    private static final PlatformModelData<FabricPlatformModelData.Data>
            MODEL_DATA = new FabricPlatformModelData();

    @Override
    public PlatformModelData<?> modelData() {
        return MODEL_DATA;
    }

    @Override
    public void requestModelDataUpdate(
            BlockEntity blockEntity
    ) {
        /*
         * Fabric does not have NeoForge's ModelDataManager.
         *
         * Model data will be consumed directly by the
         * Fabric Copycat renderer.
         */
    }

    @Override
    public PlatformModelData.ModelData getModelData(
            BlockEntity blockEntity
    ) {
        if (blockEntity instanceof CopycatBlockEntity copycat) {
            return MODEL_DATA.create(
                    copycat.getCopiedStates()
            );
        }

        return FabricPlatformModelData.empty();
    }
}