package com.myname.DM_XHQ.tabs;

import com.myname.DM_XHQ.init.ModItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab TRIER_TAB = new CreativeModeTab("triertab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItem.TEXT_INGOT.get());
        }
    };
}
