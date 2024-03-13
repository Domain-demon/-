package com.myname.DM_XHQ.block.custom;

import com.myname.DM_XHQ.block.state.properties.ModBlockStateProperties;
import com.myname.DM_XHQ.init.ModItem;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;


public class MagicropBlock extends CropBlock {
    public static final int MAX_AGE = 6;

    //加入一个属性，该属性用于表示作物的生长阶段，整数类型，最小值0，最大值6.

//    public static final IntegerProperty AGE_6 = IntegerProperty.create("age", 0, 6);
    public static final IntegerProperty AGE = ModBlockStateProperties.AGE_6;

    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 5.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 9.0D, 16.0D)};

    public MagicropBlock(Properties properties) {
        super(properties);
    }

    public VoxelShape getShape(BlockState p_52297_, BlockGetter p_52298_, BlockPos p_52299_, CollisionContext p_52300_) {
        return SHAPE_BY_AGE[p_52297_.getValue(this.getAgeProperty())];
    }


    // 获得当前的作物生长的阶段。
    @Override
    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    // 获得作物最大的生长阶段。
    @Override
    public int getMaxAge() {
        return 6;
    }

    //  对应的种子在下面
    @Override
    protected ItemLike getBaseSeedId() {
        return ModItem.MAGICROP_SEED.get();
    }


    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockStateBuilder) {
        blockStateBuilder.add(AGE);
    }


}
