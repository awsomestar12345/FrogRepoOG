package net.mylemonlime.FrogRepoOG.item;

import com.mojang.brigadier.LiteralMessage;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mylemonlime.FrogRepoOG.FrogRepoOG;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FrogRepoOG.MOD_ID);


    public static final RegistryObject<Item> CRATESPACE = ITEMS.register("cratespace",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TIPPER = ITEMS.register("tipper",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);

    }

}
