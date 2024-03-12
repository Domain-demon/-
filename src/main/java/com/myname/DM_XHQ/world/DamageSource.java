package com.myname.DM_XHQ.world;

public class DamageSource extends net.minecraft.world.damagesource.DamageSource {
    public DamageSource(String pMessageId) {
        super(pMessageId);
    }

//    public static net.minecraft.world.damagesource.DamageSource buttel(AbstractBullet pArrow, @Nullable Entity pIndirectEntity) {
//        return (new IndirectEntityDamageSource("buttel", pArrow, pIndirectEntity)).setProjectile();
//    }
//
//    public static net.minecraft.world.damagesource.DamageSource manammo(Manammo p_19350_, @Nullable Entity p_19351_) {
//        return p_19351_ == null ? (new IndirectEntityDamageSource("onManaFire", p_19350_, p_19350_)).setIsFire().setProjectile() : (new IndirectEntityDamageSource("manammo", p_19350_, p_19351_)).setIsFire().setProjectile();
//    }


}
