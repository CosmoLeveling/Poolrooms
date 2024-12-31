package net.quiltmc.users.cosmo.pools.init;

import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.quiltmc.users.cosmo.pools.Pools;
import net.quiltmc.users.cosmo.pools.blocks.GrateBlock;
import net.quiltmc.users.cosmo.pools.blocks.SkyBlock;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class PoolsBlocks {
	public static final Block WHITE_TILES = registerBlock("white_tiles",new Block(QuiltBlockSettings.copyOf(Blocks.IRON_BLOCK)));
	public static final Block SKY_BLOCK = registerBlock("sky_block",new SkyBlock(QuiltBlockSettings.copyOf(Blocks.GLASS).nonOpaque()));
	public static final Block STEEL_GRATE = registerBlock("steel_grate", new GrateBlock(QuiltBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));
	public static final Block WHITE_TILES_STAIRS = registerBlock("white_tiles_stairs", new StairsBlock(PoolsBlocks.WHITE_TILES.getDefaultState(),QuiltBlockSettings.copyOf(Blocks.IRON_BLOCK)));
	public static final Block WHITE_TILES_SLABS = registerBlock("white_tiles_slabs", new SlabBlock(QuiltBlockSettings.copyOf(Blocks.IRON_BLOCK)));
	public static final Block WHITE_TILES_WALLS = registerBlock("white_tiles_walls", new WallBlock(QuiltBlockSettings.copyOf(Blocks.IRON_BLOCK)));

	private static Block registerBlock(String name, Block block) {
		registerBlockItem(name,block);
		return Registry.register(Registries.BLOCK,Pools.id(name),block);
	}

	private static Item registerBlockItem(String name, Block block) {
		return Registry.register(Registries.ITEM,
			new Identifier(Pools.MOD_ID , name) ,
			new BlockItem(block, new QuiltItemSettings()));
	}

	public static void register() {
		Pools.LOGGER.info("Registering ModBlocks for " + Pools.MOD_ID);
	}
}
