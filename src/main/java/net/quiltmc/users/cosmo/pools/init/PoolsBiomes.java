package net.quiltmc.users.cosmo.pools.init;

import com.mojang.serialization.Codec;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.quiltmc.users.cosmo.pools.Pools;
import net.quiltmc.users.cosmo.pools.world.chunk.PoolsTestingChunkGenerator;

public class PoolsBiomes {
	public static final RegistryKey<Biome> POOLS_BIOME = RegistryKey
		.of(RegistryKeys.BIOME, Pools.id(PoolsWorlds.POOLS));
	public static void register() {
		get("yearning_canal_chunk_generator", PoolsTestingChunkGenerator.CODEC);
	}
	public static <C extends ChunkGenerator, D extends Codec<C>> D get(String id, D chunkGeneratorCodec) {
		return Registry.register(Registries.CHUNK_GENERATOR, Pools.id(id), chunkGeneratorCodec);
	}
}
