package com.myname.DM_XHQ.registry;

import com.myname.DM_XHQ.init.ModItem;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTires {
    public static final ForgeTier TEXT = new ForgeTier(2,1400,2f,2f,
            50, BlockTags.NEEDS_IRON_TOOL,() -> Ingredient.of(ModItem.TEXT_INGOT.get()));

}
