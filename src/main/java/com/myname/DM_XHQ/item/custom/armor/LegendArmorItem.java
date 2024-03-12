//package com.myname.DM_XHQ.item.custom.armor;
//
//import net.minecraft.world.entity.EquipmentSlot;
//import net.minecraft.world.item.ArmorMaterial;
//import software.bernie.geckolib3.core.IAnimatable;
//import software.bernie.geckolib3.core.PlayState;
//import software.bernie.geckolib3.core.builder.AnimationBuilder;
//import software.bernie.geckolib3.core.builder.ILoopType;
//import software.bernie.geckolib3.core.controller.AnimationController;
//import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
//import software.bernie.geckolib3.core.manager.AnimationData;
//import software.bernie.geckolib3.core.manager.AnimationFactory;
//import software.bernie.geckolib3.item.GeoArmorItem;
//import software.bernie.geckolib3.util.GeckoLibUtil;
//
//public class LegendArmorItem extends GeoArmorItem implements IAnimatable {
//
//    protected static final AnimationBuilder IDLE_ANIM = new AnimationBuilder().addAnimation("misc.idle", ILoopType.EDefaultLoopTypes.LOOP);
//
//    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);
//
//    public LegendArmorItem(ArmorMaterial materialIn, EquipmentSlot slot, Properties builder) {
//        super(materialIn, slot, builder);
//    }
//
//    private <T extends LegendArmorItem> PlayState idleAnimController(final AnimationEvent<T> event) {
//        event.getController().setAnimation(IDLE_ANIM);
//
//        return PlayState.CONTINUE;
//    }
//
//    @Override
//    public void registerControllers(AnimationData data) {
//        data.addAnimationController(new AnimationController(this, "Idle Controller", 0, this::idleAnimController));
//    }
//
//    @Override
//    public AnimationFactory getFactory() {
//        return this.factory;
//    }
//
//
//
//
//
//
//
//}
