package com.myname.DM_XHQ.init;

import com.myname.DM_XHQ.block.custom.BarrelIronBlock;
import com.myname.DM_XHQ.block.custom.MagicropBlock;
import com.myname.DM_XHQ.block.custom.NurseBlock;
import com.myname.DM_XHQ.tabs.ModCreativeModeTab;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static com.myname.DM_XHQ.TrierMod.BLOCKS;
import static com.myname.DM_XHQ.TrierMod.ITEMS;
import static net.minecraft.world.level.block.Blocks.*;

public class ModBlock {

    //方块注册

//    public static void register(IEventBus eventBus) {
//        BLOCKS.register(eventBus);
//    }

    public static void register() {

    }


    //自动注册方块物品
    private static<T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registryBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static<T extends Block> RegistryObject<Item> registryBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }



    //普通块
    public static final RegistryObject<Block> TEXT_BLOCK = registerBlock("text_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.TRIER_TAB);


    public static final RegistryObject<Block> NURSE = registerBlock("nurse",
            () -> new NurseBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.TRIER_TAB);








    //矿类块
    public static final RegistryObject<Block> TEXT_ORE = registerBlock("text_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,7)),
            ModCreativeModeTab.TRIER_TAB);
    public static final RegistryObject<Block> TEXT_ORE_DEEPSLATE = registerBlock("text_ore_deepslate",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.5f).requiresCorrectToolForDrops(),
            UniformInt.of(3,7)),
            ModCreativeModeTab.TRIER_TAB);


    public static final RegistryObject<Block> STYX_ORE = registerBlock("styx_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(DIAMOND_ORE)),
            ModCreativeModeTab.TRIER_TAB);
    public static final RegistryObject<Block> DEEPSLATE_STYX_ORE = registerBlock("deepslate_styx_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(DEEPSLATE_DIAMOND_ORE)),
            ModCreativeModeTab.TRIER_TAB);

    public static final RegistryObject<Block> STYX_BLOCK = registerBlock("styx_block",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(ANCIENT_DEBRIS)),
            ModCreativeModeTab.TRIER_TAB);

    public static final RegistryObject<Block> RAW_STYX_BLOCK = registerBlock("raw_styx_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .requiresCorrectToolForDrops().strength(5.0F, 6.0F)),
            ModCreativeModeTab.TRIER_TAB);





    //作物块
    public  static final RegistryObject<Block> MAGICROP = BLOCKS.register("magicrop",
            () -> new MagicropBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(ModSoundType.MANACROP)));


    //功能块
    public static final RegistryObject<Block> BARREL_IRON = registerBlock("barrel_iron",
            () -> new BarrelIronBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3f)),
            ModCreativeModeTab.TRIER_TAB);

    //工作块
    public static  final RegistryObject<Block> TRIER_BLOCK = registerBlock("trier_block",
            ()-> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3f).requiresCorrectToolForDrops()),
                    ModCreativeModeTab.TRIER_TAB);










}

