package io.github.akashiikun.ddds.mixin;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.levelgen.feature.MonsterRoomFeature;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static io.github.akashiikun.ddds.DataDrivenDungeonSpawnersMod.MONSTER_ROOM_MOBS;

@Mixin(MonsterRoomFeature.class)
public abstract class MonsterRoomFeatureMixin {
    @Shadow @Final private static EntityType<?>[] MOBS;

    @Inject(method = "randomEntityId", at = @At("RETURN"), cancellable = true)
    private void newRandomEntityId(RandomSource randomSource, CallbackInfoReturnable<EntityType<?>> cir) {
        Object[] CUSTOM_TAG = BuiltInRegistries.ENTITY_TYPE.getTag(MONSTER_ROOM_MOBS).get().stream().map(Holder::value).toArray();

        if(CUSTOM_TAG.length != 0) {
            cir.setReturnValue((EntityType<?>) Util.getRandom(CUSTOM_TAG, randomSource));
        } else {
            cir.setReturnValue(Util.getRandom(MOBS, randomSource));
        }
    }
}
