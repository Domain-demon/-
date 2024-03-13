//package com.myname.DM_XHQ.block.custom;
//
//import com.myname.DM_XHQ.block.state.properties.ModBlockStateProperties;
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.world.level.block.state.StateDefinition;
//import net.minecraft.world.level.block.state.properties.BooleanProperty;
//
//import java.util.Timer;
//import java.util.TimerTask;
//
//
//
//public class FlickerBlock extends Block {
//
//    public static final BooleanProperty LIGHT = ModBlockStateProperties.LIGHT;
//
//    int time = 1;
//    private BlockState defaultBlockState;
//
//
//    public FlickerBlock(Properties pProperties) {
//        super(pProperties);
//        this.registerDefaultState(this.getStateDefinition().any()
//                .setValue(LIGHT, Boolean.FALSE));
//
////        Timer timer = new Timer(true);
////        // 注意，javax.swing包中也有一个Timer类，如果import中用到swing包,要注意名字的冲突。
////
////        TimerTask task = new TimerTask() {
////            public void run() {
////                //每次需要执行的代码放到这里面。
////                FlickerBlock.this.defaultBlockState(FlickerBlock.this.getStateDefinition().any().getValue(LIGHT));
////            }
////        };
////
////        long delay = 1000;
////        long period = 1000;
////
////        timer.schedule(task, delay, period);
////        // delay为long,period为long：从现在起过delay毫秒以后，每隔period
////        // 毫秒执行一次。
//
//    }
//
//
//
////    private BlockState defaultBlockState(Boolean value) {
////        if(value){
////            value = false;
////        }else {
////            value = true;
////        }
////        return this.defaultBlockState;
////    }
//
//
//    //添加方块状态
//    @Override
//    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
//        builder.add(LIGHT);
//    }
//
//
//
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
