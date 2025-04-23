package net.mylemonlime.FrogRepoOG.item;

import com.mojang.brigadier.LiteralMessage;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mylemonlime.FrogRepoOG.FrogRepoOG;
import net.mylemonlime.FrogRepoOG.item.Custom.OmnitoolItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FrogRepoOG.MOD_ID);
//------------------------------------------------------------------------------
    //Simple Cratespace item
    public static final RegistryObject<Item> CRATESPACE = ITEMS.register("cratespace",
            () -> new Item(new Item.Properties()));

    //Simple Tipper item (very good boy)
    public static final RegistryObject<Item> TIPPER = ITEMS.register("tipper",
            () -> new Item(new Item.Properties()));

    //Advanced OmniTool item
    public  static  final RegistryObject<Item> OMNITOOL = ITEMS.register("omnitool",
            () -> new OmnitoolItem(new Item.Properties().durability(32)));
// -----------------------------------------------------------------------------
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);

    }

}
