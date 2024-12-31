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
		BlockStateModelGenerator.BlockTexturePool white_tiles_blocks = blockStateModelGenerator.registerCubeAllModelTexturePool(PoolsBlocks.WHITE_TILES);
		white_tiles_blocks.stairs(PoolsBlocks.WHITE_TILES_STAIRS);
		white_tiles_blocks.slab(PoolsBlocks.WHITE_TILES_SLABS);
		white_tiles_blocks.wall(PoolsBlocks.WHITE_TILES_WALLS);
		blockStateModelGenerator.registerSimpleCubeAll(PoolsBlocks.STEEL_GRATE);
	}

	@Override
	public void generateItemModels(ItemModelGenerator itemModelGenerator) {

	}
}
