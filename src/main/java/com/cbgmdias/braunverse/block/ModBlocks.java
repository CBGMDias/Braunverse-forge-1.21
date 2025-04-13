package com.cbgmdias.braunverse.block;

import com.cbgmdias.braunverse.Braunverse;
import com.cbgmdias.braunverse.item.ModItems;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
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
                            .strength(10f, 1200f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> ANCIENT_BRAUNITE_BLOCK = registerBlock("ancient_braunite_block",
            () -> new Block(
                    BlockBehaviour.Properties.of()
                        .strength(-1.0F, 3600000.0F)
                        .noLootTable()
                        .sound(SoundType.AMETHYST_CLUSTER)));

    public static final RegistryObject<Block> RAW_AZURONITE_BLOCK = registerBlock("raw_azuronite_block",
            () -> new Block(
                    BlockBehaviour.Properties.of()
                            .strength(3f, 10f)
                            .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> AZURONITE_BLOCK = registerBlock("azuronite_block",
            () -> new Block(
                    BlockBehaviour.Properties.of()
                            .strength(5f, 20f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.METAL)));

    public static final RegistryObject<Block> AZURONITE_ORE = registerBlock("azuronite_ore",
            () -> new DropExperienceBlock(ConstantInt.of(0),
                    BlockBehaviour.Properties.of()
                            .strength(4f, 8f)
                            .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> DEEPSLATE_AZURONITE_ORE = registerBlock("deepslate_azuronite_ore",
            () -> new DropExperienceBlock(ConstantInt.of(0),
                    BlockBehaviour.Properties.of()
                            .strength(5.5f, 10f)
                            .sound(SoundType.DEEPSLATE)
                            .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> BRAUNITE_ORE = registerBlock("braunite_ore",
            () -> new DropExperienceBlock(UniformInt.of(5,9),
                    BlockBehaviour.Properties.of()
                            .strength(5f, 1200f)
                            .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> DEEPSLATE_BRAUNITE_ORE = registerBlock("deepslate_braunite_ore",
            () -> new DropExperienceBlock(UniformInt.of(5,9),
                    BlockBehaviour.Properties.of()
                            .strength(6.5f, 1200f)
                            .sound(SoundType.DEEPSLATE)
                            .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> NETHER_BRAUNITE_ORE = registerBlock("nether_braunite_ore",
            () -> new DropExperienceBlock(UniformInt.of(5,9),
                    BlockBehaviour.Properties.of()
                            .strength(5.5f, 1200f)
                            .sound(SoundType.NETHER_ORE)
                            .requiresCorrectToolForDrops()));


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
