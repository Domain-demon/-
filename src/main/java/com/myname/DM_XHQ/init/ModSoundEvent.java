package com.myname.DM_XHQ.init;

import com.myname.DM_XHQ.TrierMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.RegistryObject;

import static com.myname.DM_XHQ.TrierMod.SOUND_EVENTS;


public class ModSoundEvent {

//    public static void register(IEventBus eventBus){
//        SOUND_EVENTS.register(eventBus);
//    }

        public static void register() {

        }

    public static final RegistryObject<SoundEvent> HOYO = SOUND_EVENTS.register("record.hoyo",
            ()-> new SoundEvent(new ResourceLocation(TrierMod.MODID, "record.hoyo")));

    public static final RegistryObject<SoundEvent> BAM = SOUND_EVENTS.register("seffect.bang.bam",
            ()-> new SoundEvent(new ResourceLocation(TrierMod.MODID, "seffect.bang.bam")));

    public static final RegistryObject<SoundEvent> DINGLINGLING = SOUND_EVENTS.register("seffect.ding.dinglingling",
            ()-> new SoundEvent(new ResourceLocation(TrierMod.MODID, "seffect.ding.dinglingling")));

    public static final RegistryObject<SoundEvent> WORK_MASTER = SOUND_EVENTS.register("entity.villager.work_master",
            ()-> new SoundEvent(new ResourceLocation(TrierMod.MODID, "entity.villager.work_master")));





//    public static final RegistryObject<SoundEvent> ENTITY_DIMI_DEATH2 = build("entity.dimi.death2");
//    //...
//
//    private static RegistryObject<SoundEvent> build(String id)
//    {
//        return SOUNDS.register(id, () -> new SoundEvent(new ResourceLocation(TrierMod.MODID, id)));
//    }


}
