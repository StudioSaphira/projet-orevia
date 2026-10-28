# Minerais et génération

Les classes Common sont Vanilla et les blocs sont enregistrés par Saphyra.
Fabric injecte les placements via son API de biomes ; NeoForge utilise les mêmes placements avec des biome modifiers.

| Ressource | Y inclusifs | Pic | Tentatives/chunk éligible | Blocs/filon |
|---|---|---|---|---|
| Bauxite | 64 à 160 | Uniforme dans la couche proche de la surface | 8 | 5–12 |
| Nickel | -48 à 48 | -16 | 6 | 3–8 |
| Chromite | -56 à 0 | -32 | 3 | 2–5 |
| Pyrolusite | -32 à 64 | 16 | 5 | 4–9 |
| Corindon | -48 à 30 | -16 | 1–2 | 1–3 |

Les hauteurs des graines des quatre minerais suivent une distribution triangulaire discrète, asymétrique lorsque nécessaire. Les listes pondérées Vanilla rendent les pics exacts sans nouveau codec de hauteur. Le filon entier reste dans les limites Y.

La bauxite remplace la roche naturelle ou la terre cuite des badlands, de 2 à 12 blocs sous la surface du terrain, sans toucher l'air ou l'eau. Elle est limitée aux biomes jungle, savane et badlands. Chaque colonne choisie tire uniformément sa profondeur admissible ; aucune génération en altitude dans l'air.

Les autres minerais existent dans tout l'Overworld. Les tags preferred_* conservent toutes les tentatives dans les montagnes et les biomes de grottes indiqués, et la moitié en moyenne ailleurs. Le biome souterrain ET le biome de surface sont examinés. Les collines windswept sont incluses ; les grottes ordinaires sans biome dédié n'ont pas de bonus automatique. Ces tags sont extensibles par datapack.

Une tentative choisit uniformément sa taille, puis cherche un groupe connecté dans la roche. Elle est abandonnée si la taille demandée ne tient pas : le nombre de filons réussis peut être inférieur aux tentatives. Des filons voisins peuvent se rejoindre. Les variantes pierre/ardoise sont choisies d'après le bloc remplacé et non d'après une frontière Y arbitraire.

## Transformation et récolte

Silk Touch rend le minerai lui-même ; sinon le minerai rend une ressource brute, avec le bonus Fortune et les règles d'explosion du fer Vanilla. Une pioche du niveau requis reste nécessaire, même avec Silk Touch. La bauxite garde son drop de bloc avec ou sans enchantement.

| Minerai | Pioche minimum | Dureté pierre / abîmes |
|---|---|---|
| Nickel | Pierre | 3 / 4,5 |
| Pyrolusite | Pierre | 3 / 4,5 |
| Chromite | Fer | 4 / 5,5 |
| Corindon | Diamant | 5 / 6,5 |

Ces valeurs sont un équilibrage de jeu inspiré des minéraux, pas une conversion Mohs. La pyrolusite massive est plus tendre que ses cristaux. Sources : https://www.mindat.org/min-1036.html ; https://www.mindat.org/show.php?id=3318 ; https://www.mindat.org/show.php?id=1136 .

Le nickel, la chromite et la pyrolusite bruts se compactent par neuf et se décompactent sans perte. Le corindon brut reste uniquement un objet, sans bloc de stockage. Neuf lingots de nickel donnent un bloc de nickel, également réversible. Les blocs bruts ont les propriétés du bloc de fer brut, avec le niveau de pioche de leur minerai.

Seuls le nickel brut et ses deux minerais se cuisent : 1 entrée donne 1 lingot, 0,7 XP, 200 ticks au four ou 100 au haut-fourneau. Les blocs de stockage ne se cuisent pas. Les recettes se débloquent à l'obtention de leur ingrédient.

Textures provisoires : les objets raw_chromite, raw_pyrolusite, raw_corundum réutilisent leur texture de minerai, faute d'images dédiées. Les PNG existants sont préservés.

La génération concerne uniquement les nouveaux chunks. Pour modifier les taux/hauteurs, éditer les placed_feature ; les bornes de sécurité et tailles sont dans MineralDeposit. Ne pas ajouter de références à Fabric/NeoForge dans Common.
