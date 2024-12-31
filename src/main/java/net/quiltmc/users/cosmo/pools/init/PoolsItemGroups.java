package net.quiltmc.users.cosmo.pools.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.quiltmc.users.cosmo.pools.Pools;

public class PoolsItemGroups {
	public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Pools.id("itemgroup"));
	public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
		.icon(() -> new ItemStack(PoolsBlocks.CUT_STEEL))
		.name(Text.translatable("itemGroup.fabric_docs_reference"))
		.build();

	public static final void Register(){
		// Register the group.
		Registry.register(Registries.ITEM_GROUP, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);

// Register items to the custom item group.
		ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
			itemGroup.addItem(PoolsBlocks.CUT_STEEL);
			itemGroup.addItem(PoolsBlocks.CUT_STEEL_SLABS);
			itemGroup.addItem(PoolsBlocks.CUT_STEEL_STAIRS);
			itemGroup.addItem(PoolsBlocks.CUT_STEEL_WALLS);
			itemGroup.addItem(PoolsBlocks.STEEL_GRATE);
			itemGroup.addItem(PoolsBlocks.STEEL_BLOCK);
			itemGroup.addItem(PoolsBlocks.CAGED_LIGHT);
		});
	}
}
