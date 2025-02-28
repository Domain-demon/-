package com.myname.DM_XHQ.init;

import com.myname.DM_XHQ.TrierMod;
import com.myname.DM_XHQ.entity.mob.BeeSoldier;
import com.myname.DM_XHQ.entity.mob.Orc;
import com.myname.DM_XHQ.entity.projectile.ThrownManammo;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.myname.DM_XHQ.TrierMod.ENTITY_TYPES;

public class ModEntity {

//
//    public static void register(IEventBus eventBus) {
//        ENTITY_TYPES.register(eventBus);
//    }




    public static void register() {

    }

    private static <T extends Entity> RegistryObject<EntityType<T>> throwableItem(String name, EntityType.EntityFactory<T> factory) {
        return ENTITY_TYPES.register("thrown_" + name, () -> (EntityType.Builder.of(factory, MobCategory.MISC).sized(0.25F, 0.25F)
                .clientTrackingRange(4).updateInterval(10).build(name)));
    }



//    public static final RegistryObject<EntityType<Bullet>> BULLET =
//            ENTITY_TYPES.register("bulletitem", () ->
//                EntityType.Builder.<Bullet>of(Bullet::new, MobCategory.MISC)
//                        .sized(0.5F, 0.5F).build("bulletitem"));
//
//    public static final RegistryObject<EntityType<Manammo>> MANAMMO =
//            ENTITY_TYPES.register("manammo", () ->
//                EntityType.Builder.<Manammo>of(Manammo::new, MobCategory.MISC).build("manammo"));



//    public static final EntityType<LargeFireball> FIREBALL =
//            register("fireball", EntityType.Builder.<LargeFireball>of(LargeFireball::new, MobCategory.MISC)
//                    .sized(1.0F, 1.0F).clientTrackingRange(4).updateInterval(10));
//
//    public static final EntityType<SmallFireball> SMALL_FIREBALL =
//            register("small_fireball", EntityType.Builder.<SmallFireball>of(SmallFireball::new, MobCategory.MISC)
//                    .sized(0.3125F, 0.3125F).clientTrackingRange(4).updateInterval(10));



    public static final RegistryObject<EntityType<ThrownManammo>> THROWN_MANAMMO = throwableItem("thrown_manammo", ThrownManammo::new);









    public static final RegistryObject<EntityType<BeeSoldier>> BEESOLDIER =
            ENTITY_TYPES.register("beesoldier", () ->
                EntityType.Builder.of(BeeSoldier::new, MobCategory.MONSTER)
                        .sized(0.4f,1.5f)
                        .build(new ResourceLocation(TrierMod.MODID,"beesoldier").toString()));

    public static final RegistryObject<EntityType<Orc>> ORC =
            ENTITY_TYPES.register("orc", () ->
                    EntityType.Builder.of(Orc::new, MobCategory.MONSTER)
                            .sized(0.4f,1.5f)
                            .build(new ResourceLocation(TrierMod.MODID,"orc").toString()));






}
