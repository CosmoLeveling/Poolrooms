package net.quiltmc.users.cosmo.pools.blocks;

import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class Caged_Light extends FacingBlock {
	protected static final VoxelShape UP = Block.createCuboidShape(5,0,5,11,7,11);
	protected static final VoxelShape DOWN = Block.createCuboidShape(5,9,5,11,16,11);
	protected static final VoxelShape EAST = Block.createCuboidShape(0,5,5,7,11,11);
	protected static final VoxelShape WEST = Block.createCuboidShape(9,5,5,16,11,11);
	protected static final VoxelShape NORTH = Block.createCuboidShape(5,5,9,11,11,16);
	protected static final VoxelShape SOUTH = Block.createCuboidShape(5,5,0,11,11,7);
	public Caged_Light(AbstractBlock.Settings settings) {
		super(settings);
		this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(FACING, Direction.UP));
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		if (state.get(FACING) == Direction.SOUTH){
			return SOUTH;
		} else if (state.get(FACING) == Direction.NORTH) {
			return NORTH;
		} else if (state.get(FACING) == Direction.UP) {
			return UP;
		} else if (state.get(FACING) == Direction.DOWN) {
			return DOWN;
		} else if (state.get(FACING) == Direction.WEST) {
			return WEST;
		} else {
			return EAST;
		}
	}

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		if (state.get(FACING) == Direction.SOUTH){
			return SOUTH;
		} else if (state.get(FACING) == Direction.NORTH) {
			return NORTH;
		} else if (state.get(FACING) == Direction.UP) {
			return UP;
		} else if (state.get(FACING) == Direction.DOWN) {
			return DOWN;
		} else if (state.get(FACING) == Direction.WEST) {
			return WEST;
		} else {
			return EAST;
		}
	}

	public BlockState getPlacementState(ItemPlacementContext ctx) {
		Direction direction = ctx.getSide();
		BlockState blockState = ctx.getWorld().getBlockState(ctx.getBlockPos().offset(direction.getOpposite()));
		return blockState.isOf(this) && blockState.get(FACING) == direction ? (BlockState)this.getDefaultState().with(FACING, direction.getOpposite()) : (BlockState)this.getDefaultState().with(FACING, direction);
	}
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(new Property[]{FACING});
	}
}
