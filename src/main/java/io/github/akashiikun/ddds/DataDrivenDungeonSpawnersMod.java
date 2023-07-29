package io.github.akashiikun.ddds;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataDrivenDungeonSpawnersMod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("ddds");
	public static TagKey<EntityType<?>> MONSTER_ROOM_MOBS = TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("monster_room_mobs"));

	@Override
	public void onInitialize() {
		ResourceManagerHelper.get(PackType.SERVER_DATA).registerReloadListener(new SimpleSynchronousResourceReloadListener() {
			@Override
			public ResourceLocation getFabricId() {
				return new ResourceLocation("monster_room_mobs");
			}

			@Override
			public void onResourceManagerReload(ResourceManager resourceManager) {
				MONSTER_ROOM_MOBS = TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("monster_room_mobs"));
			}
		});
	}
}