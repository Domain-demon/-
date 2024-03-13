package com.myname.DM_XHQ.block.state.properties;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class ModBlockStateProperties {

    public static final BooleanProperty LIGHT = BooleanProperty.create("light");






    public static final int MAX_AGE = 6;
    public static final IntegerProperty AGE_6 = IntegerProperty.create("age", 0, 6);
}
