package com.myname.DM_XHQ.entity.mob;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

// 继承了Monster，怪物的实体  Ianimatable是Geckolib接口，用于动画相关的操作。
public class Orc extends Monster implements IAnimatable, FlyingAnimal {


    public static final int TICKS_PER_FLAP = Mth.ceil(1.4959966F);


    // 管理实体的动画控制器
    private AnimationFactory factory = GeckoLibUtil.createFactory(this);
    public Orc(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.moveControl = new FlyingMoveControl(this, 20, true);

        this.setPathfindingMalus(BlockPathTypes.DANGER_FIRE, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER_BORDER, 16.0F);
        this.setPathfindingMalus(BlockPathTypes.COCOA, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.FENCE, -1.0F);
    }

    // 设置实体的属性
    public static AttributeSupplier setAttributes() {
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.FLYING_SPEED, (double)1.2F)
                .add(Attributes.MOVEMENT_SPEED, (double)0.6F)
                .add(Attributes.ATTACK_DAMAGE, 10.0D)
                .add(Attributes.FOLLOW_RANGE, 48.0D).build();
    }

    // 实体的AI
    // 数值越小优先级越高
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1,new FloatGoal(this));// 在水中浮动
        this.goalSelector.addGoal(2,new MeleeAttackGoal(this,1.2D,true));// 近战攻击，攻击速度，是否长时间追踪目标
        this.goalSelector.addGoal(4,new WaterAvoidingRandomStrollGoal(this,1.0D));// 在陆地上漫步。
        this.goalSelector.addGoal(5,new RandomLookAroundGoal(this));//随机看向周围

        this.targetSelector.addGoal(2,new NearestAttackableTargetGoal<>(this, Player.class,true));// 攻击最近的可攻击目标，玩家，是否检查视线
        this.targetSelector.addGoal(3,new NearestAttackableTargetGoal<>(this, AbstractVillager.class,true));
        this.targetSelector.addGoal(3,new NearestAttackableTargetGoal<>(this, IronGolem.class,true));
        this.targetSelector.addGoal(4,new NearestAttackableTargetGoal<>(this, Creeper.class,true));
        this.targetSelector.addGoal(4,new NearestAttackableTargetGoal<>(this, Zombie.class,true));
        this.targetSelector.addGoal(4,new NearestAttackableTargetGoal<>(this, Skeleton.class,true));
        super.registerGoals();
    }


    // 根据动画事件设置控制器
    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event){
        if(event.isMoving()){
            event.getController().setAnimation( new AnimationBuilder().addAnimation("animation.orc.run", ILoopType.EDefaultLoopTypes.LOOP));
            // 继续播放
            return PlayState.CONTINUE;
        }
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.orc.walk", ILoopType.EDefaultLoopTypes.PLAY_ONCE));
        return PlayState.CONTINUE;

    }

    private PlayState attackPredicate(AnimationEvent event) {
        if(this.swinging && event.getController().getAnimationState().equals(AnimationState.Stopped)) {
            event.getController().markNeedsReload();
            event.getController().setAnimation( new AnimationBuilder().addAnimation( "animation.orc.attack", ILoopType.EDefaultLoopTypes.PLAY_ONCE));
            this.swinging = false;
        }
        return PlayState.CONTINUE;
    }


    // 注册控制器
    @Override
    public void registerControllers(AnimationData data) {
        // 实体，名称，频率，函数式接口
        data.addAnimationController(new AnimationController(this, "controller",
                0,this::predicate));
        data.addAnimationController(new AnimationController(this, "attackController",
                0,this::attackPredicate));
    }
    // 返回动画控制器
    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    // 走路
    protected void playStepSound(BlockPos pPos, BlockState pBlock) {
        this.playSound(SoundEvents.BEE_LOOP,0.15F,1.0F);
    }
    // 环境
    protected SoundEvent getAmbientSound() {
        return null;
    }
    // 受到攻击
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.BEE_HURT;
    }
    // 死亡
    protected SoundEvent getDeathSound() {
        return SoundEvents.BEE_DEATH;
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume() {
        return 0.4F;
    }


    public boolean doHurtTarget(Entity pEntity) {
        boolean flag = pEntity.hurt(DamageSource.sting(this), (float)((int)this.getAttributeValue(Attributes.ATTACK_DAMAGE)));
        if (flag) {
            this.doEnchantDamageEffects(this, pEntity);
            if (pEntity instanceof LivingEntity) {
                ((LivingEntity)pEntity).setStingerCount(((LivingEntity)pEntity).getStingerCount() + 1);
                int i = 0;
                if (this.level.getDifficulty() == Difficulty.NORMAL) {
                    i = 10;
                } else if (this.level.getDifficulty() == Difficulty.HARD) {
                    i = 18;
                }

                if (i > 0) {
                    ((LivingEntity)pEntity).addEffect(new MobEffectInstance(MobEffects.POISON, i * 20, 0), this);
                }
            }

//            this.stopBeingAngry();
            this.playSound(SoundEvents.BEE_LOOP_AGGRESSIVE, 1.0F, 1.0F);
            this.playSound(SoundEvents.BEE_STING, 1.0F, 1.0F);
        }

        return flag;
    }

    public void tick() {
        super.tick();
    }

    protected PathNavigation createNavigation(Level pLevel) {
        FlyingPathNavigation flyingpathnavigation = new FlyingPathNavigation(this, pLevel) {
            public boolean isStableDestination(BlockPos p_27947_) {
                return !this.level.getBlockState(p_27947_.below()).isAir();
            }
        };
        flyingpathnavigation.setCanOpenDoors(false);
        flyingpathnavigation.setCanFloat(false);
        flyingpathnavigation.setCanPassDoors(true);
        return flyingpathnavigation;
    }



    public boolean isFlapping() {
        return this.isFlying() && this.tickCount % TICKS_PER_FLAP == 0;
    }


    @Override
    public boolean isFlying() {
        return !this.onGround;
    }

    public MobType getMobType() {
        return MobType.ARTHROPOD;
    }

    public boolean causeFallDamage(float pFallDistance, float pMultiplier, DamageSource pSource) {
        return false;
    }

    protected void checkFallDamage(double pY, boolean pOnGround, BlockState pState, BlockPos pPos) {
    }

}









