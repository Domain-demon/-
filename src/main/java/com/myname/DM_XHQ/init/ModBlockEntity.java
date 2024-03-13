package com.myname.DM_XHQ.init;

import com.myname.DM_XHQ.block.entity.BarrelIronBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.RegistryObject;

import static com.myname.DM_XHQ.TrierMod.BLOCK_ENTITY_TYPES;

public class ModBlockEntity {



    public static void register() {

    }




    public static final RegistryObject<BlockEntityType<BarrelIronBlockEntity>> BARREL_IRON_BLOCK_ENTITY =
            BLOCK_ENTITY_TYPES.register("barrel_iron",() ->
                    BlockEntityType.Builder.of(BarrelIronBlockEntity::new,ModBlock.BARREL_IRON.get()).build(null));






}
