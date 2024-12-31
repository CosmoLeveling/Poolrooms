package net.quiltmc.users.cosmo.pools.init;

import com.mojang.serialization.Lifecycle;
import net.ludocrypt.limlib.api.LimlibRegistrar;
import net.ludocrypt.limlib.api.LimlibRegistryHooks;
import net.ludocrypt.limlib.api.LimlibWorld;
import net.minecraft.registry.HolderProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.int_provider.ConstantIntProvider;
import net.minecraft.world.biome.source.FixedBiomeSource;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.quiltmc.users.cosmo.pools.Pools;
import net.quiltmc.users.cosmo.pools.world.biome.PoolsBiome;
import net.quiltmc.users.cosmo.pools.world.chunk.PoolsTestingChunkGenerator;

import java.util.OptionalLong;

public class PoolsWorlds implements LimlibRegistrar {
	public static final Identifier POOLS_ID = new Identifier(Pools.MOD_ID, "pools");

	public static String POOLS = "pools";

	public static final LimlibWorld MY_WORLD =
		new LimlibWorld(
			() -> new DimensionType(OptionalLong.of(6000), true, false, false, false, 1.0, true, false, 0, 512, 512,
				TagKey.of(RegistryKeys.BLOCK, Pools.id(POOLS)), Pools.id(POOLS), 0.725F,
				new DimensionType.MonsterSettings(false, false, ConstantIntProvider.ZERO, 0)),
		(registry) ->
		new DimensionOptions(
		registry.get(RegistryKeys.DIMENSION_TYPE)
			.getHolder(RegistryKey
						   .of(RegistryKeys.DIMENSION_TYPE, POOLS_ID))
		.get(),
		new PoolsTestingChunkGenerator(
			new FixedBiomeSource(registry
		.get(RegistryKeys.BIOME)
						.getHolder(PoolsBiomes.POOLS_BIOME)
						.get())
			,PoolsTestingChunkGenerator.createGroup(),11,11)));
	@Override
	public void registerHooks() {
		LimlibWorld.LIMLIB_WORLD.register(
			RegistryKey.of(LimlibWorld.LIMLIB_WORLD_KEY, POOLS_ID),
			MY_WORLD,
			Lifecycle.stable()
		);

		LimlibRegistryHooks.hook(RegistryKeys.BIOME, ((infoLookup, registryKey, registry) -> {
			HolderProvider<PlacedFeature> features = infoLookup.lookup(RegistryKeys.PLACED_FEATURE).get().getter();
			HolderProvider<ConfiguredCarver<?>> carvers = infoLookup.lookup(RegistryKeys.CONFIGURED_CARVER).get().getter();
			registry.register(PoolsBiomes.POOLS_BIOME, PoolsBiome.create(features, carvers), Lifecycle.stable());
		}));

	}
}
