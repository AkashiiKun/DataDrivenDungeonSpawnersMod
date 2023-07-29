package io.github.akashiikun.ddds.tag;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.entity.EntityType;

import java.util.concurrent.CompletableFuture;

import static io.github.akashiikun.ddds.DataDrivenDungeonSpawnersMod.MONSTER_ROOM_MOBS;

public class DungeonsTagGenerator extends FabricTagProvider.EntityTypeTagProvider {
    public DungeonsTagGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        getOrCreateTagBuilder(MONSTER_ROOM_MOBS)
                .add(EntityType.ZOMBIE)
                .add(EntityType.SKELETON)
                .add(EntityType.SPIDER);
    }
}
