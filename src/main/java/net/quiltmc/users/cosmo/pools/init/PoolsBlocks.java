package net.quiltmc.users.cosmo.pools.init;

import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.quiltmc.users.cosmo.pools.Pools;
import net.quiltmc.users.cosmo.pools.blocks.Caged_Light;
import net.quiltmc.users.cosmo.pools.blocks.GrateBlock;
import net.quiltmc.users.cosmo.pools.blocks.SkyBlock;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class PoolsBlocks {
	public static final Block CUT_STEEL = registerBlock("cut_steel",new Block(QuiltBlockSettings.copyOf(Blocks.IRON_BLOCK)));
	public static final Block SKY_BLOCK = registerBlock("sky_block",new SkyBlock(QuiltBlockSettings.copyOf(Blocks.GLASS).nonOpaque()));
	public static final Block STEEL_GRATE = registerBlock("steel_grate", new GrateBlock(QuiltBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));
	public static final Block CUT_STEEL_STAIRS = registerBlock("cut_steel_stairs", new StairsBlock(PoolsBlocks.CUT_STEEL.getDefaultState(),QuiltBlockSettings.copyOf(Blocks.IRON_BLOCK)));
	public static final Block CUT_STEEL_SLABS = registerBlock("cut_steel_slabs", new SlabBlock(QuiltBlockSettings.copyOf(Blocks.IRON_BLOCK)));
	public static final Block CUT_STEEL_WALLS = registerBlock("cut_steel_walls", new WallBlock(QuiltBlockSettings.copyOf(Blocks.IRON_BLOCK)));
	public static final Block STEEL_BLOCK = registerBlock("steel_block", new Block(QuiltBlockSettings.copyOf(Blocks.IRON_BLOCK)));
	public static final Block CAGED_LIGHT = registerBlock("caged_light", new Caged_Light(QuiltBlockSettings.copyOf(Blocks.SOUL_LANTERN)));
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
