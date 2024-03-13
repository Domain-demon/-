package com.myname.DM_XHQ.block.entity;

import com.myname.DM_XHQ.block.custom.BarrelIronBlock;
import com.myname.DM_XHQ.init.ModBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.ContainerOpenersCounter;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BarrelIronBlockEntity extends RandomizableContainerBlockEntity {
    private NonNullList<ItemStack> items = NonNullList.withSize(27,ItemStack.EMPTY);

    private ContainerOpenersCounter openersCounten = new ContainerOpenersCounter() {
        @Override
        protected void onOpen(Level level, BlockPos pos, BlockState state) {
            BarrelIronBlockEntity.this.updateBlockState(state, true);
        }

        @Override
        protected void onClose(Level level, BlockPos pos, BlockState state) {
//            level.setBlock(pos,state.setValue(BarrelIronBlock.OPEN,false),3);
            BarrelIronBlockEntity.this.updateBlockState(state, false);
        }

        @Override
        protected void openerCountChanged(Level p_155463_, BlockPos p_155464_, BlockState p_155465_, int p_155466_, int p_155467_) {

        }

        @Override
        protected boolean isOwnContainer(Player player) {
            if (player.containerMenu instanceof ChestMenu){
                Container container = ((ChestMenu) player.containerMenu).getContainer();
                return container == BarrelIronBlockEntity.this;
            }else {
                return false;
            }
        }
    };

    public BarrelIronBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntity.BARREL_IRON_BLOCK_ENTITY.get(), pos, state);
    }


    @Override
    protected void saveAdditional(CompoundTag compoundTag) {
        super.saveAdditional(compoundTag);
        if (!this.trySaveLootTable(compoundTag)){
            ContainerHelper.saveAllItems(compoundTag,this.items);
        }
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.items = NonNullList.withSize(this.getContainerSize(),ItemStack.EMPTY);
        if (!this.tryLoadLootTable(tag)){
            ContainerHelper.loadAllItems(tag,this.items);
        };
    }

    @Override
    public int getContainerSize() {
        return 27;
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> items) {
        this.items = items;
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("block.triermod.barrel_iron");
    }

    @Override
    protected AbstractContainerMenu createMenu(int i, Inventory inventory) {
        return ChestMenu.threeRows(i,inventory,this);
    }



    @Override
    public void startOpen(Player player){
        if (this.remove && !player.isSpectator()){
            this.openersCounten.incrementOpeners(player,this.getLevel(),this.getBlockPos(),this.getBlockState());
        }
    }

    @Override
    public void stopOpen(Player player){
        if (this.remove && !player.isSpectator()){
            this.openersCounten.decrementOpeners(player,this.getLevel(),this.getBlockPos(),this.getBlockState());
        }
    }

    public void recheckOpen(){
        if (this.remove){
            this.openersCounten.recheckOpeners(this.getLevel(),this.getBlockPos(),this.getBlockState());
        }
    }

    void updateBlockState(BlockState p_58607_, boolean b) {
        this.level.setBlock(this.getBlockPos(), p_58607_.setValue(BarrelIronBlock.OPEN, b), 3);
    }




}
