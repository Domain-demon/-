package com.myname.DM_XHQ.init;

import com.myname.DM_XHQ.item.custom.projectile.ManammoItem;
import com.myname.DM_XHQ.registry.ModArmorMaterials;
import com.myname.DM_XHQ.registry.ModTires;
import com.myname.DM_XHQ.tabs.ModCreativeModeTab;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.RegistryObject;

import static com.myname.DM_XHQ.TrierMod.ITEMS;
import static net.minecraft.world.effect.MobEffects.INVISIBILITY;

public class ModItem {
    //注册物品
//    public static void register(IEventBus eventBus) {
//        ITEMS.register(eventBus);
//    }

    public static void register() {

    }

    private static Item.Properties defaultBuilder() {
        return new Item.Properties().tab(ModCreativeModeTab.TRIER_TAB);
    }



    //物品

    //矿锭
    public static final RegistryObject<Item> TEXT_INGOT = ITEMS.register("text_ingot", () -> new Item(defaultBuilder()));

    public static final RegistryObject<Item> STYX_INGOT = ITEMS.register("styx_ingot", () -> new Item(defaultBuilder().fireResistant()));



    //粗矿
    public static final RegistryObject<Item> RAW_TEXT_ORE = ITEMS.register("raw_text_ore", () -> new Item(defaultBuilder()));

    public static final RegistryObject<Item> RAW_STYX_ORE = ITEMS.register("raw_styx_ore", () -> new Item(defaultBuilder().fireResistant()));



    //矿粒
    public static final RegistryObject<Item> TEXT_NUGGET = ITEMS.register("text_nugget", () -> new Item(defaultBuilder()));

    public static final RegistryObject<Item> STYX_NUGGET = ITEMS.register("styx_nugget", () -> new Item(defaultBuilder().fireResistant()));






    //武器_剑
    public static final RegistryObject<Item> EXCALIBUR = ITEMS.register("excalibur", () -> new SwordItem(ModTires.TEXT,7,2.5f, defaultBuilder()));
    public static final RegistryObject<Item> EXCALIBUR_DARK = ITEMS.register("excalibur_dark", () -> new SwordItem(ModTires.TEXT,2,1.5f, defaultBuilder()));
    public static final RegistryObject<Item> FIRE_SWORD = ITEMS.register("fire_sword", () -> new SwordItem(ModTires.TEXT,2,1.5f, defaultBuilder()));
    public static final RegistryObject<Item> STYX_SWOED = ITEMS.register("styx_sword", () -> new SwordItem(ModTires.TEXT,2,1.5f, defaultBuilder()));


    //杂物

    public static final RegistryObject<Item> MANAMMO = ITEMS.register("manammo", () -> new ManammoItem(defaultBuilder()));

    //种子
    public static final RegistryObject<Item> MAGICROP_SEED = ITEMS.register( "magicrop_seed", ()-> new ItemNameBlockItem(ModBlock.MAGICROP.get(), defaultBuilder()));


    //作物
    public static final RegistryObject<Item> MAGICROP_FRUIT = ITEMS.register("magicrop_fruit", () -> new Item(defaultBuilder().food(new FoodProperties.Builder().nutrition(2)
            .effect(() -> new MobEffectInstance(INVISIBILITY,1200),100f)
            .saturationMod(2f).build())));


    //唱片
    public static final RegistryObject<Item> MUSIC_DISC_XHQ = ITEMS.register("music_disc_xhq", ()-> new RecordItem(15,ModSoundEvent.HOYO, defaultBuilder().rarity(Rarity.RARE),2760));

    //盔甲
//    public static final RegistryObject<Item> WRAITH_CHESTPLATE = ITEMS.register("wraith_chestplate",
//            ()-> new ArmorItem(ModArmorMaterial.WRAITH, EquipmentSlot.CHEST,defaultBuilder()));
//
    public static final RegistryObject<Item> STYX_HELMET = ITEMS.register("styx_helmet", ()-> new ArmorItem(ModArmorMaterials.STYX, EquipmentSlot.HEAD, defaultBuilder()));

    public static final RegistryObject<Item> STYX_CHESTPLATE = ITEMS.register("styx_chestplate", ()-> new ArmorItem(ModArmorMaterials.STYX, EquipmentSlot.CHEST, defaultBuilder()));

    public static final RegistryObject<Item> STYX_LEGGINGS = ITEMS.register("styx_leggings", ()-> new ArmorItem(ModArmorMaterials.STYX, EquipmentSlot.LEGS, defaultBuilder()));

    public static final RegistryObject<Item> STYX_BOOTS = ITEMS.register("styx_boots", ()-> new ArmorItem(ModArmorMaterials.STYX, EquipmentSlot.FEET, defaultBuilder()));

    public static final RegistryObject<Item> EMPTY_HELMET = ITEMS.register("empty_helmet", ()-> new ArmorItem(ModArmorMaterials.EMPTY, EquipmentSlot.HEAD, defaultBuilder()));

    public static final RegistryObject<Item> EMPTY_CHESTPLATE = ITEMS.register("empty_chestplate", ()-> new ArmorItem(ModArmorMaterials.EMPTY, EquipmentSlot.CHEST, defaultBuilder()));

    public static final RegistryObject<Item> EMPTY_LEGGINGS = ITEMS.register("empty_leggings", ()-> new ArmorItem(ModArmorMaterials.EMPTY, EquipmentSlot.LEGS, defaultBuilder()));

    public static final RegistryObject<Item> EMPTY_BOOTS = ITEMS.register("empty_boots", ()-> new ArmorItem(ModArmorMaterials.EMPTY, EquipmentSlot.FEET, defaultBuilder()));

    public static final RegistryObject<Item> TEXT_HELMET = ITEMS.register("text_helmet", ()-> new ArmorItem(ModArmorMaterials.TEXT, EquipmentSlot.HEAD, defaultBuilder()));

    public static final RegistryObject<Item> TEXT_CHESTPLATE = ITEMS.register("text_chestplate", ()-> new ArmorItem(ModArmorMaterials.TEXT, EquipmentSlot.CHEST, defaultBuilder()));

    public static final RegistryObject<Item> TEXT_LEGGINGS = ITEMS.register("text_leggings", ()-> new ArmorItem(ModArmorMaterials.TEXT, EquipmentSlot.LEGS, defaultBuilder()));

    public static final RegistryObject<Item> TEXT_BOOTS = ITEMS.register("text_boots", ()-> new ArmorItem(ModArmorMaterials.TEXT, EquipmentSlot.FEET, defaultBuilder()));


    //刷怪蛋
    public static final RegistryObject<Item> BEESOLDIER_SPAWN_EGG = ITEMS.register("beesoldier_spawn_egg", ()-> new ForgeSpawnEggItem(ModEntity.BEESOLDIER,0xffc100,0x000, defaultBuilder()));

    public static final RegistryObject<Item> ORC_SPAWN_EGG = ITEMS.register("orc_spawn_egg", ()-> new ForgeSpawnEggItem(ModEntity.ORC,0x7bffa3,0x7bd4ff, defaultBuilder()));









}
