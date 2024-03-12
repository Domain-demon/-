package com.myname.DM_XHQ.init;

import com.google.common.collect.ImmutableSet;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;

import static com.myname.DM_XHQ.TrierMod.POI_TYPES;

public class ModPoi {
    public static void register() {

    }

    // 注册一个POI类型，名字是trier_block_poi，对应的方块是之前的TRIER_BLOCK，最大数目是1，最远距离是1,
    // 用于村民感知该方块
    // 其中ImmutableSet用于创建一个不可变的集合。其中getStateDefinition获得方块的属性和值。getPossibleStates返回所有的状态的可能性。
    // 最大数目指的是最多可以被多少村民使用，最远距离是村民可以隔离该方块多远可以工作。

    public static final RegistryObject<PoiType> TRIER_BLOCK_POT = POI_TYPES.register("trier_block_poi",
            ()-> new PoiType(ImmutableSet.copyOf(ModBlock.TRIER_BLOCK.get().getStateDefinition().getPossibleStates()),
                    1,1));

    public static void registerPOIs() {
        try{
            // 获得PoiType类的一个registerBlockStates方法,通过invoke调用将TIRER_BLOCK_POI添加到poiType类中。
            ObfuscationReflectionHelper.findMethod(PoiType.class,
                    "registerBlockStates", PoiType.class).invoke(null, TRIER_BLOCK_POT.get());
        }catch (InvocationTargetException | IllegalAccessException exception){
            exception.printStackTrace();
        }
    }

}
