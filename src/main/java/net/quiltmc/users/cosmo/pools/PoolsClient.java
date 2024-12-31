package net.quiltmc.users.cosmo.pools;

import net.minecraft.client.render.RenderLayer;
import net.quiltmc.users.cosmo.pools.init.PoolsBlocks;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.quiltmc.qsl.block.extensions.api.client.BlockRenderLayerMap;

public class PoolsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient(ModContainer mod) {
		BlockRenderLayerMap.put(RenderLayer.getCutout(),PoolsBlocks.SKY_BLOCK);
		BlockRenderLayerMap.put(RenderLayer.getCutout(),PoolsBlocks.STEEL_GRATE);
		BlockRenderLayerMap.put(RenderLayer.getCutout(),PoolsBlocks.CAGED_LIGHT);
	}
}
