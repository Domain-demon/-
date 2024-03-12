package com.myname.DM_XHQ.init;

import com.google.common.collect.ImmutableSet;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.registries.RegistryObject;

import static com.myname.DM_XHQ.TrierMod.VILLAGER_PROFESSIONS;

public class ModVillager {

    public static void register() {

    }

    // 注册一个村民的职业
    // 名称是trier_master，
    // poi表示了工作的方块
    // 最后一个表示工作的发出的声音

    public static final RegistryObject<VillagerProfession> TRIER_MASTER = VILLAGER_PROFESSIONS.register("trier_master",
            ()-> new VillagerProfession("trier_master",x->x.get() == ModPoi.TRIER_BLOCK_POT.get(),
                    x->x.get() == ModPoi.TRIER_BLOCK_POT.get(),ImmutableSet.of(),ImmutableSet.of(),
                    ModSoundEvent.WORK_MASTER.get()));




}
