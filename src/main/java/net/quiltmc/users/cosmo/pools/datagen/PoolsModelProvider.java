package net.quiltmc.users.cosmo.pools.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.model.BlockStateModelGenerator;
import net.quiltmc.users.cosmo.pools.init.PoolsBlocks;

public class PoolsModelProvider extends FabricModelProvider {
	public PoolsModelProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
		BlockStateModelGenerator.BlockTexturePool white_tiles_blocks = blockStateModelGenerator.registerCubeAllModelTexturePool(PoolsBlocks.CUT_STEEL);
		white_tiles_blocks.stairs(PoolsBlocks.CUT_STEEL_STAIRS);
		white_tiles_blocks.slab(PoolsBlocks.CUT_STEEL_SLABS);
		white_tiles_blocks.wall(PoolsBlocks.CUT_STEEL_WALLS);
		blockStateModelGenerator.registerSimpleCubeAll(PoolsBlocks.STEEL_GRATE);
		blockStateModelGenerator.registerSimpleCubeAll(PoolsBlocks.STEEL_BLOCK);
	}

	@Override
	public void generateItemModels(ItemModelGenerator itemModelGenerator) {

	}
}
