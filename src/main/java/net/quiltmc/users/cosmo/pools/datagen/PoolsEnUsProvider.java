package net.quiltmc.users.cosmo.pools.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.quiltmc.users.cosmo.pools.init.PoolsBlocks;
import net.quiltmc.users.cosmo.pools.init.PoolsItemGroups;

public class PoolsEnUsProvider extends FabricLanguageProvider {
	public PoolsEnUsProvider(FabricDataOutput dataOutput) {
		super(dataOutput);
	}

	@Override
	public void generateTranslations(TranslationBuilder translationBuilder) {
		translationBuilder.add(PoolsBlocks.CUT_STEEL,"Cut Steel");
		translationBuilder.add(PoolsBlocks.CUT_STEEL_STAIRS,"Cut Steel Stairs");
		translationBuilder.add(PoolsBlocks.CUT_STEEL_SLABS,"Cut Steel Slabs");
		translationBuilder.add(PoolsBlocks.CUT_STEEL_WALLS,"Cut Steel Walls");
		translationBuilder.add(PoolsBlocks.STEEL_GRATE,"Steel Grate");
		translationBuilder.add(PoolsBlocks.STEEL_BLOCK, "Steel Block");
		translationBuilder.add(PoolsItemGroups.CUSTOM_ITEM_GROUP_KEY,"Pools");
		translationBuilder.add(PoolsBlocks.SKY_BLOCK,"Sky Block");
		translationBuilder.add(PoolsBlocks.CAGED_LIGHT, "Caged Light");
		translationBuilder.add(PoolsBlocks.FLAT_LIGHT,"Flat Light");
	}
}
