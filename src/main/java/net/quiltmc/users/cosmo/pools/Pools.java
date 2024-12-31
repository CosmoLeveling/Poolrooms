package net.quiltmc.users.cosmo.pools;

import io.github.fabricators_of_create.porting_lib.entity.events.PlayerEvents;
import net.minecraft.util.Identifier;
import net.quiltmc.users.cosmo.pools.init.*;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.lifecycle.api.client.event.ClientTickEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pools implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("poolrooms");
	public static final String MOD_ID = "pools";

    @Override
    public void onInitialize(ModContainer mod) {
        LOGGER.info("Hello Quilt world from {}! Stay fresh!", mod.metadata().name());
		PoolsBiomes.register();
		PoolsSoundEvents.register();
		PoolsBlocks.register();
		PoolsItemGroups.Register();
	}
	public static Identifier id(String id) {
		return new Identifier(MOD_ID, id);
	}
}
