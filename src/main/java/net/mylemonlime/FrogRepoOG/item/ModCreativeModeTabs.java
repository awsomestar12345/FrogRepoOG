package net.mylemonlime.FrogRepoOG.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.animal.frog.Frog;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.mylemonlime.FrogRepoOG.FrogRepoOG;
import net.mylemonlime.FrogRepoOG.block.ModBlocks;

public class ModCreativeModeTabs {

    public  static  final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FrogRepoOG.MOD_ID);

    public static  final RegistryObject<CreativeModeTab> FROGREPOOG_TAB = CREATIVE_MODE_TABS.register("frogrepoog_tab",
    () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CRATESPACE.get()))
            .title(Component.translatable("creativetab.frogrepoog.frogrepoog"))
            .displayItems((itemDisplayParameters, output) ->{
                output.accept(ModItems.CRATESPACE.get());
                output.accept(ModItems.TIPPER.get());
                output.accept(ModItems.OMNITOOL.get());

                output.accept(ModBlocks.CRATESPACE_BLOCK.get());
                output.accept(ModBlocks.CRATESPACE_BLOCK_DOOR.get());
                output.accept(ModBlocks.FUNCTIONAL_BLOCK.get());


            }).build());

    public  static  void  register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
