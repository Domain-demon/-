package com.myname.DM_XHQ.init;


import com.myname.DM_XHQ.TrierMod;
import com.myname.DM_XHQ.entity.mob.BeeSoldier;
import com.myname.DM_XHQ.entity.mob.Orc;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

public class ModEvent {


    @Mod.EventBusSubscriber(modid = TrierMod.MODID)
    public static class ForgeEvent {
        @SubscribeEvent
        public static void addCustomTrades(VillagerTradesEvent event) {
            // 如果会是xxx职业
            if (event.getType() == ModVillager.TRIER_MASTER.get()) {
                // 获得交易列表，int2ObjectMap对象，不同等级提供的交易项目
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                // 创一个ItemStack，xxx物品，10个
                ItemStack stack = new ItemStack(ModItem.EXCALIBUR.get(), 1);
                int villagerLevel = 1;
                //添加一个新的交易。获得的物品的是 stack，提供的物品是绿宝石，2个，1表示最大的交易次数，8表示交易返回经验值，0.2f表示价格乘区。
                trades.get(villagerLevel).add((trader,rand) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 20),
                        stack, 1, 8, 0.2f
                ));
            }
        }

    }


    @Mod.EventBusSubscriber(modid = TrierMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class  ModEventBusEvents {
        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
            event.put(ModEntity.BEESOLDIER.get(), BeeSoldier.setAttributes());
            event.put(ModEntity.ORC.get(), Orc.setAttributes());

        }


    }


}
