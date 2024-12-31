package net.quiltmc.users.cosmo.pools;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistrySetBuilder;
import net.quiltmc.users.cosmo.pools.datagen.PoolsEnUsProvider;
import net.quiltmc.users.cosmo.pools.datagen.PoolsModelProvider;

public class PoolsDataGeneration implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(PoolsModelProvider::new);
		pack.addProvider(PoolsEnUsProvider::new);
	}
}
