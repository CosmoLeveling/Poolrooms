package net.quiltmc.users.cosmo.pools.world;

import com.google.common.collect.Lists;
import net.ludocrypt.limlib.api.world.maze.DepthLikeMaze;
import net.ludocrypt.limlib.api.world.maze.MazeComponent;
import net.minecraft.util.random.RandomGenerator;

import java.util.List;
import java.util.Objects;

public class PoolsDepthFirstMaze extends DepthLikeMaze {
	public RandomGenerator random;

	public PoolsDepthFirstMaze(int width, int height, RandomGenerator RandomGenerator) {
		super(width, height);
		this.random = RandomGenerator;
	}
	public void changeEdges() {
		if (Objects.equals(this.stack.peek(), new Vec2i(0, 0))){
			this.cellState(this.stack.peek()).go(Face.DOWN);
			this.cellState(this.stack.peek()).go(Face.LEFT);
		}
		if (Objects.equals(this.stack.peek(), new Vec2i(10, 0))){
			this.cellState(this.stack.peek()).go(Face.UP);
			this.cellState(this.stack.peek()).go(Face.LEFT);
		}
		if (Objects.equals(this.stack.peek(), new Vec2i(0, 10))){
			this.cellState(this.stack.peek()).go(Face.DOWN);
			this.cellState(this.stack.peek()).go(Face.RIGHT);
		}
		if (Objects.equals(this.stack.peek(), new Vec2i(10, 10))){
			this.cellState(this.stack.peek()).go(Face.UP);
			this.cellState(this.stack.peek()).go(Face.RIGHT);
		}
		if (this.stack.peek().getX() == 2 && this.stack.peek().getY() == 0) {
			this.cellState(this.stack.peek()).go(Face.UP);
		}
	}
	@Override
	public void create() {
		visit(new Vec2i(0, 0));
		this.visitedCells++;
		this.stack.push(new Vec2i(0, 0));
		changeEdges();
		while (visitedCells < this.width * this.height) {
			List<Face> neighbours = Lists.newArrayList();

			for (Face face : Face.values()) {
				if (this.hasNeighbour(this.stack.peek(), face)) {
					neighbours.add(face);
				}

			}
			changeEdges();
			if (!neighbours.isEmpty()) {
				Face nextFace = neighbours.get(random.nextInt(neighbours.size()));
				this.cellState(this.stack.peek()).go(nextFace);
				this.cellState(this.stack.peek().go(nextFace)).go(nextFace.mirror());
				this.visit(this.stack.peek().go(nextFace));
				this.stack.push(this.stack.peek().go(nextFace));

				this.visitedCells++;
				changeEdges();
			} else {
				changeEdges();
				this.stack.pop();
			}

		}
	}
}
