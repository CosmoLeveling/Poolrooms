package net.quiltmc.users.cosmo.pools.init;

import net.minecraft.registry.Holder;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.quiltmc.users.cosmo.pools.Pools;

public class PoolsSoundEvents {
	public static final Holder.Reference<SoundEvent> MUSIC_POOLS = get("music.yearning_canal");
	public static void register() {
	}
	public static Holder.Reference<SoundEvent> get(String id) {
		return Registry
			.registerHolder(Registries.SOUND_EVENT, Pools.id(id),
				SoundEvent.createVariableRangeEvent(Pools.id(id)));
	}
}
