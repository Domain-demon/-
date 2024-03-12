package com.myname.DM_XHQ.init;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSoundType extends SoundType {

    public ModSoundType(float pVolume, float pPitch, SoundEvent pBreakSound, SoundEvent pStepSound, SoundEvent pPlaceSound, SoundEvent pHitSound, SoundEvent pFallSound) {
        super(pVolume, pPitch, pBreakSound, pStepSound, pPlaceSound, pHitSound, pFallSound);
    }

    public static final ModSoundType MANACROP = new ModSoundType(1.0F, 1.0F, ModSoundEvent.BAM.get(), SoundEvents.GRASS_STEP, SoundEvents.CROP_PLANTED, SoundEvents.GRASS_HIT, SoundEvents.GRASS_FALL);



}
