package net.mylemonlime.FrogRepoOG.item.Custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;

public class OmnitoolItem extends Item {
    private  static  final  Map<Block, Block> CHISEL_MAP =
            Map.of(
                    //EXAMPLE Chisel map
                    Blocks.STONE, Blocks.STONE_BRICKS,
                    Blocks.END_STONE, Blocks.END_STONE_BRICKS,
                    Blocks.DEEPSLATE, Blocks.DEEPSLATE_BRICKS
            );

    public OmnitoolItem(Properties pProperties){
        super(pProperties);
    }
//Chisel Functionality
    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        //acquire information on block clicked
        Block clickedBlock = level.getBlockState(pContext.getClickedPos()).getBlock();
        //reference clicked block with the chisel map
        if(CHISEL_MAP.containsKey(clickedBlock)){
            //check if client-side or server-side (prevents cheating!)
            if(!level.isClientSide()){
                //update the clicked block
                level.setBlockAndUpdate(pContext.getClickedPos(), CHISEL_MAP.get(clickedBlock).defaultBlockState());
                //damage the tool
                pContext.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), ((ServerPlayer) pContext.getPlayer()),
                        item -> pContext.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));
                //make a sound about it
                level.playSound(null, pContext.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);
            }
        }
        //add animation to our use
        return InteractionResult.SUCCESS;
    }
}
