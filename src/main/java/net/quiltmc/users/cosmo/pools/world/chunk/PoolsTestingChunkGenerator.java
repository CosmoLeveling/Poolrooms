package net.quiltmc.users.cosmo.pools.world.chunk;

import com.mojang.datafixers.util.Either;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.ludocrypt.limlib.api.world.Manipulation;
import net.ludocrypt.limlib.api.world.NbtGroup;
import net.ludocrypt.limlib.api.world.chunk.AbstractNbtChunkGenerator;
import net.ludocrypt.limlib.api.world.maze.DepthFirstMaze;
import net.ludocrypt.limlib.api.world.maze.MazeComponent;
import net.ludocrypt.limlib.api.world.maze.MazeGenerator;
import net.ludocrypt.limlib.api.world.maze.MazePiece;
import net.minecraft.server.world.ChunkHolder;
import net.minecraft.server.world.ServerLightingProvider;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.structure.StructureTemplateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.ChunkRegion;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.world.gen.RandomState;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.quiltmc.users.cosmo.pools.Pools;
import net.quiltmc.users.cosmo.pools.init.PoolsWorlds;
import net.quiltmc.users.cosmo.pools.world.PoolsDepthFirstMaze;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Function;

public class PoolsTestingChunkGenerator extends AbstractNbtChunkGenerator {
	public static final Codec<PoolsTestingChunkGenerator> CODEC = RecordCodecBuilder.create((instance) -> {
		return instance.group(BiomeSource.CODEC.fieldOf("biome_source").stable().forGetter((chunkGenerator) -> {
			return chunkGenerator.populationSource;
		}), NbtGroup.CODEC.fieldOf("nbt_group").stable().forGetter((chunkGenerator) -> {
			return chunkGenerator.nbtGroup;
		}), Codec.INT.fieldOf("width").stable().forGetter((chunkGenerator) -> {
			return chunkGenerator.mazeGenerator.width;
		}), Codec.INT.fieldOf("height").stable().forGetter((chunkGenerator) -> {
			return chunkGenerator.mazeGenerator.height;})).apply(instance, instance.stable(PoolsTestingChunkGenerator::new));
	});

		MazeGenerator<MazeComponent> mazeGenerator;

	public PoolsTestingChunkGenerator(BiomeSource biomeSource, NbtGroup group, int width, int height) {
		super(biomeSource, group);
		this.mazeGenerator = new MazeGenerator<MazeComponent>(width, height, /* Cell X Thickness */ 15, /* Cell Y Thickness */ 15, /* Seed Modifier */ 0);
	}

	public static NbtGroup createGroup() {
		return NbtGroup.Builder.create(PoolsWorlds.POOLS_ID)
			.with("pools_default", 1, 1)
			.with("pools_center",1,1)
			.with("pools_f",1,1)
			.with("pools_i",1,1)
			.with("pools_l",1,1)
			.with("pools_n",1,1)
			.with("pools_t",1,1)
			.build();
	}

	@Override
	protected Codec<? extends ChunkGenerator> getCodec() {
		return CODEC;
	}

	@Override
	public CompletableFuture<Chunk> populateNoise(ChunkRegion region, ChunkStatus targetStatus, Executor executor, ServerWorld world, ChunkGenerator generator, StructureTemplateManager structureTemplateManager, ServerLightingProvider lightingProvider, Function<Chunk, CompletableFuture<Either<Chunk, ChunkHolder.Unloaded>>> fullChunkConverter, List<Chunk> chunks, Chunk chunk) {
		mazeGenerator.generateMaze(new MazeComponent.Vec2i(chunk.getPos().getStartPos().add(0,10,0)),region,this::newMaze,this::decorateCell);
		if (Objects.equals(chunk.getPos(), new ChunkPos(0, 0))) {
			generateNbt(region, chunk.getPos().getStartPos(),nbtGroup.pick("pools_center",RandomGenerator.createLegacy()));
		}else{
			generateNbt(region, chunk.getPos().getStartPos(),nbtGroup.pick("pools_default",RandomGenerator.createLegacy()));
		}
		return CompletableFuture.completedFuture(chunk);
	}
	public MazeComponent newMaze(ChunkRegion region, MazeComponent.Vec2i mazePos, int width, int height, RandomGenerator random) {
		PoolsDepthFirstMaze maze = new PoolsDepthFirstMaze(width, height, random);
		maze.generateMaze();
		return maze;
	}

	public void decorateCell(ChunkRegion region, MazeComponent.Vec2i pos, MazeComponent.Vec2i mazePos, MazeComponent maze, MazeComponent.CellState state, MazeComponent.Vec2i thickness, RandomGenerator random) {
		Pair<MazePiece, Manipulation> piece = MazePiece.getFromCell(state, random);
		int X = pos.getX()/9;
		int Y = pos.getY()/9;
		if (piece.getFirst() != MazePiece.E) {
			generateNbt(region, pos.toBlock().add(0, 10, 0), nbtGroup.pick("pools_" + piece.getFirst().getAsLetter(), RandomGenerator.createLegacy()), piece.getSecond());
		}
	}
	@Override
	public int getPlacementRadius() {
		return 1;
	}

	@Override
	public int getWorldHeight() {
		return 384;
	}

	@Override
	public int getSeaLevel() {
		return 0;
	}

	@Override
	public int getMinimumY() {
		return 0;
	}

	@Override
	public void method_40450(List<String> list, RandomState randomState, BlockPos pos) {

	}

}
