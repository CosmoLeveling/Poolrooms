package net.quiltmc.users.cosmo.pools.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.util.Identifier;
import net.quiltmc.users.cosmo.pools.init.PoolsBlocks;
import net.quiltmc.users.cosmo.pools.init.PoolsItemGroups;

public class PoolsEnUsProvider extends FabricLanguageProvider {
	public PoolsEnUsProvider(FabricDataOutput dataOutput) {
		super(dataOutput);
	}

	@Override
	public void generateTranslations(TranslationBuilder translationBuilder) {
		translationBuilder.add(PoolsBlocks.WHITE_TILES,"White Tiles");
		translationBuilder.add(PoolsBlocks.WHITE_TILES_STAIRS,"White Tiles Stairs");
		translationBuilder.add(PoolsBlocks.WHITE_TILES_SLABS,"White Tiles Slabs");
		translationBuilder.add(PoolsBlocks.WHITE_TILES_WALLS,"White Tiles Walls");
		translationBuilder.add(PoolsItemGroups.CUSTOM_ITEM_GROUP_KEY,"Pools");
		translationBuilder.add(PoolsBlocks.SKY_BLOCK,"Sky Block");
	}
}
