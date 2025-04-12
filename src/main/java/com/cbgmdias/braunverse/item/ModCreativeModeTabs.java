package com.cbgmdias.braunverse.item;

import com.cbgmdias.braunverse.Braunverse;
import com.cbgmdias.braunverse.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs  {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Braunverse.MOD_ID);

    public static final RegistryObject<CreativeModeTab> BRAUNITE_ITEMS_TAB = CREATIVE_MODE_TABS.register("braunite_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BRAUNITE.get()))
                    .title(Component.translatable("creativetab.braunverse.braunite_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                      output.accept(ModBlocks.BRAUNITE_ORE.get());
                      output.accept(ModBlocks.DEEPSLATE_BRAUNITE_ORE.get());
                      output.accept(ModBlocks.NETHER_BRAUNITE_ORE.get());
                      output.accept(ModBlocks.BRAUNITE_BLOCK.get());

                      output.accept(ModItems.BRAUNITE.get());
                      output.accept(ModItems.BRAUNITE_WAND.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> AZURONITE_ITEMS_TAB = CREATIVE_MODE_TABS.register("azuronite_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.AZURONITE_INGOT.get()))
                    .withTabsBefore(BRAUNITE_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.braunverse.azuronite_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.AZURONITE_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_AZURONITE_ORE.get());
                        output.accept(ModBlocks.RAW_AZURONITE_BLOCK.get());
                        output.accept(ModBlocks.AZURONITE_BLOCK.get());

                        output.accept(ModItems.RAW_AZURONITE.get());
                        output.accept(ModItems.AZURONITE_INGOT.get());
                        output.accept(ModItems.AZURONITE_NUGGET.get());
                        output.accept(ModItems.AZURONITE_STICK.get());

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
