package com.cbgmdias.braunverse.block;

import com.cbgmdias.braunverse.Braunverse;
import com.cbgmdias.braunverse.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Braunverse.MOD_ID);


    public static final RegistryObject<Block> BRAUNITE_BLOCK = registerBlock("braunite_block",
            () -> new Block(
                    BlockBehaviour.Properties.of()
                            .strength(6f, 1200f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> RAW_AZURONITE_BLOCK = registerBlock("raw_azuronite_block",
            () -> new Block(
                    BlockBehaviour.Properties.of()
                            .strength(3f, 6f)
                            .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> AZURONITE_BLOCK = registerBlock("azuronite_block",
            () -> new Block(
                    BlockBehaviour.Properties.of()
                            .strength(5f, 30f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.METAL)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
