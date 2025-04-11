package com.cbgmdias.braunverse.item;

import com.cbgmdias.braunverse.Braunverse;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Braunverse.MOD_ID);

    public static final RegistryObject<Item> BRAUNITE = ITEMS.register("braunite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_AZURONITE = ITEMS.register("raw_azuronite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> AZURONITE_INGOT = ITEMS.register("azuronite_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> AZURONITE_NUGGET = ITEMS.register("azuronite_nugget",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
