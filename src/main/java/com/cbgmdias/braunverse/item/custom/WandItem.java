package com.cbgmdias.braunverse.item.custom;

import com.cbgmdias.braunverse.block.ModBlocks;
import net.minecraft.core.particles.ParticleTypes;
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

public class WandItem extends Item {
    private static final Map<Block, Block> WAND_MAP =
            Map.ofEntries(
                    Map.entry(ModBlocks.BRAUNITE_BLOCK.get(), ModBlocks.ANCIENT_BRAUNITE_BLOCK.get()),
                    Map.entry(ModBlocks.ANCIENT_BRAUNITE_BLOCK.get(), ModBlocks.BRAUNITE_BLOCK.get()),

                    Map.entry(Blocks.STONE, Blocks.COBBLESTONE),
                    Map.entry(Blocks.COBBLESTONE, Blocks.STONE_BRICKS),
                    Map.entry(Blocks.STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS),
                    Map.entry(Blocks.CRACKED_STONE_BRICKS, Blocks.STONE),

                    Map.entry(Blocks.DEEPSLATE, Blocks.COBBLED_DEEPSLATE),
                    Map.entry(Blocks.COBBLED_DEEPSLATE, Blocks.DEEPSLATE_BRICKS),
                    Map.entry(Blocks.DEEPSLATE_BRICKS, Blocks.CRACKED_DEEPSLATE_BRICKS),
                    Map.entry(Blocks.CRACKED_DEEPSLATE_BRICKS, Blocks.DEEPSLATE),

                    Map.entry(Blocks.END_STONE, Blocks.END_STONE_BRICKS),
                    Map.entry(Blocks.END_STONE_BRICKS, Blocks.END_STONE)
            );

    public WandItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Block clickedBlock = level.getBlockState(pContext.getClickedPos()).getBlock();

        if (WAND_MAP.containsKey(clickedBlock)) {
            if(!level.isClientSide()) {
                level.setBlockAndUpdate(pContext.getClickedPos(), WAND_MAP.get(clickedBlock).defaultBlockState());

                pContext.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), ((ServerPlayer) pContext.getPlayer()),
                        item -> pContext.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, pContext.getClickedPos(), SoundEvents.AMETHYST_BLOCK_RESONATE, SoundSource.BLOCKS);
                ((ServerLevel) level).sendParticles(
                        ParticleTypes.GLOW,                    // Tipo da partícula
                        pContext.getClickedPos().getX() + 0.5,          // X (centralizado no bloco)
                        pContext.getClickedPos().getY() + 1.0,          // Y (um pouco acima do bloco)
                        pContext.getClickedPos().getZ() + 0.5,          // Z (centralizado no bloco)
                        20,                                             // Quantidade de partículas
                        0.2, 0.2, 0.2,                 // Desvio (espalhamento)
                        0.01                                            // Velocidade das partículas
                );
            }
        }

        return InteractionResult.SUCCESS;
    }
}
