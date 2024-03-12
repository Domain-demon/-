package com.myname.DM_XHQ.init;

import com.myname.DM_XHQ.item.custom.ShootItem;
import com.myname.DM_XHQ.item.custom.projectile.ManammoItem;
import com.myname.DM_XHQ.registry.ModArmorMaterial;
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



    //物品

    //矿锭
    public static final RegistryObject<Item> TEXT_INGOT = ITEMS.register("text_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TRIER_TAB)));

    public static final RegistryObject<Item> STYX_INGOT = ITEMS.register("styx_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TRIER_TAB).fireResistant()));



    //粗矿
    public static final RegistryObject<Item> TEXT_ORE_RAW = ITEMS.register("text_ore_raw",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TRIER_TAB)));

    public static final RegistryObject<Item> RAW_STYX_ORE = ITEMS.register("raw_styx_ore",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TRIER_TAB).fireResistant()));



    //矿粒
    public static final RegistryObject<Item> TEXT_NUGGEST = ITEMS.register("text_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TRIER_TAB)));

    public static final RegistryObject<Item> STYX_NUGGEST = ITEMS.register("styx_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TRIER_TAB).fireResistant()));






    //武器_剑
    public static final RegistryObject<Item> THE_SWORD_OF_FIRE = ITEMS.register("the_sword_of_fire",
            () -> new SwordItem(ModTires.TEXT,2,1.5f,new Item.Properties().tab(ModCreativeModeTab.TRIER_TAB)));

    public static final RegistryObject<Item> EXCALIBUR = ITEMS.register("excalibur",
            () -> new SwordItem(ModTires.TEXT,7,2.5f,new Item.Properties().tab(ModCreativeModeTab.TRIER_TAB)));

    public static final RegistryObject<Item> EXCALIBUR_DARK = ITEMS.register("excalibur_dark",
            () -> new SwordItem(ModTires.TEXT,2,1.5f,new Item.Properties().tab(ModCreativeModeTab.TRIER_TAB)));

    //武器_其他
    public static final RegistryObject<Item> HEPTAGRAM = ITEMS.register("heptagram",
            () -> new ShootItem(new Item.Properties().tab(ModCreativeModeTab.TRIER_TAB).stacksTo(1)));

    public static final RegistryObject<Item> POWER_OF_FLORA = ITEMS.register("power_of_flora",
            () -> new ShootItem(new Item.Properties().tab(ModCreativeModeTab.TRIER_TAB).stacksTo(1)));


//    public static final RegistryObject<Item> BULLET = ITEMS.register("bulletitem",
//            () -> new BulletItem(new Item.Properties().tab(ModCreativeModeTab.TRIER_TAB)));

    public static final RegistryObject<Item> MANAMMO = ITEMS.register("manammo",
            () -> new ManammoItem(new Item.Properties().tab(ModCreativeModeTab.TRIER_TAB)));

    //种子
    public static final RegistryObject<Item> MAGICROP_SEED = ITEMS.register( "magicrop_seed",
            ()-> new ItemNameBlockItem(ModBlock.MAGICROP.get(),
                    new Item.Properties().tab(ModCreativeModeTab.TRIER_TAB)));


    //作物
    public static final RegistryObject<Item> MAGICROP_FRUIT = ITEMS.register("magicrop_fruit",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TRIER_TAB)
                    .food(new FoodProperties.Builder().nutrition(2)
                            .effect(() -> new MobEffectInstance(INVISIBILITY,1200),100f)
                            .saturationMod(2f).build())));


    //唱片
    public static final RegistryObject<Item> MUSIC_DISC_XHQ = ITEMS.register("music_disc_xhq",
            ()-> new RecordItem(15,ModSoundEvent.HOYO,
                    new Item.Properties().rarity(Rarity.RARE).tab(ModCreativeModeTab.TRIER_TAB),2760));

    //盔甲
//    public static final RegistryObject<Item> WRAITH_CHESTPLATE = ITEMS.register("wraith_chestplate",
//            ()-> new ArmorItem(ModArmorMaterial.WRAITH, EquipmentSlot.CHEST,new Item.Properties().tab(ModCreativeModeTab.TRIER_TAB)));
//
    public static final RegistryObject<Item> LEGEND_HELMET = ITEMS.register("legend_helmet",
            ()-> new ArmorItem(ModArmorMaterials.LEGEND, EquipmentSlot.HEAD,new Item.Properties().tab(ModCreativeModeTab.TRIER_TAB)));

    public static final RegistryObject<Item> LEGEND_CHESTPLATE = ITEMS.register("legend_chestplate",
            ()-> new ArmorItem(ModArmorMaterials.LEGEND, EquipmentSlot.CHEST,new Item.Properties().tab(ModCreativeModeTab.TRIER_TAB)));

    public static final RegistryObject<Item> LEGEND_LEGGINGS = ITEMS.register("legend_leggings",
            ()-> new ArmorItem(ModArmorMaterials.LEGEND, EquipmentSlot.LEGS,new Item.Properties().tab(ModCreativeModeTab.TRIER_TAB)));

    public static final RegistryObject<Item> LEGEND_BOOTS = ITEMS.register("legend_boots",
            ()-> new ArmorItem(ModArmorMaterials.LEGEND, EquipmentSlot.FEET,new Item.Properties().tab(ModCreativeModeTab.TRIER_TAB)));

    public static final RegistryObject<Item> EMPTY_HELMET = ITEMS.register("empty_helmet",
            ()-> new ArmorItem(ModArmorMaterials.EMPTY, EquipmentSlot.HEAD,new Item.Properties().tab(ModCreativeModeTab.TRIER_TAB)));

    public static final RegistryObject<Item> EMPTY_CHESTPLATE = ITEMS.register("empty_chestplate",
            ()-> new ArmorItem(ModArmorMaterials.EMPTY, EquipmentSlot.CHEST,new Item.Properties().tab(ModCreativeModeTab.TRIER_TAB)));

    public static final RegistryObject<Item> EMPTY_LEGGINGS = ITEMS.register("empty_leggings",
            ()-> new ArmorItem(ModArmorMaterials.EMPTY, EquipmentSlot.LEGS,new Item.Properties().tab(ModCreativeModeTab.TRIER_TAB)));

    public static final RegistryObject<Item> EMPTY_BOOTS = ITEMS.register("empty_boots",
            ()-> new ArmorItem(ModArmorMaterials.EMPTY, EquipmentSlot.FEET,new Item.Properties().tab(ModCreativeModeTab.TRIER_TAB)));

    public static final RegistryObject<Item> TEXT_HELMET = ITEMS.register("text_helmet",
            ()-> new ArmorItem(ModArmorMaterials.TEXT, EquipmentSlot.HEAD,new Item.Properties().tab(ModCreativeModeTab.TRIER_TAB)));

    public static final RegistryObject<Item> TEXT_CHESTPLATE = ITEMS.register("text_chestplate",
            ()-> new ArmorItem(ModArmorMaterials.TEXT, EquipmentSlot.CHEST,new Item.Properties().tab(ModCreativeModeTab.TRIER_TAB)));

    public static final RegistryObject<Item> TEXT_LEGGINGS = ITEMS.register("text_leggings",
            ()-> new ArmorItem(ModArmorMaterials.TEXT, EquipmentSlot.LEGS,new Item.Properties().tab(ModCreativeModeTab.TRIER_TAB)));

    public static final RegistryObject<Item> TEXT_BOOTS = ITEMS.register("text_boots",
            ()-> new ArmorItem(ModArmorMaterials.TEXT, EquipmentSlot.FEET,new Item.Properties().tab(ModCreativeModeTab.TRIER_TAB)));

    //刷怪蛋
    public static final RegistryObject<Item> BEESOLDIER_SPAWN_EGG = ITEMS.register("beesoldier_spawn_egg",
            ()-> new ForgeSpawnEggItem(ModEntity.BEESOLDIER,0xffc100,0x000,
                    new Item.Properties().tab(ModCreativeModeTab.TRIER_TAB)));

    public static final RegistryObject<Item> ORC_SPAWN_EGG = ITEMS.register("orc_spawn_egg",
            ()-> new ForgeSpawnEggItem(ModEntity.ORC,0x7bffa3,0x7bd4ff,
                    new Item.Properties().tab(ModCreativeModeTab.TRIER_TAB)));









}
