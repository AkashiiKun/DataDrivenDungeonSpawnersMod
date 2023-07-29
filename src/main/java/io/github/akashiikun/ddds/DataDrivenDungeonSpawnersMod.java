package io.github.akashiikun.ddds;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataDrivenDungeonSpawnersMod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("ddds");
	public static TagKey<EntityType<?>> MONSTER_ROOM_MOBS = TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("monster_room_mobs"));

	@Override
	public void onInitialize() {
	}
}