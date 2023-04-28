package com.patrickfrom.moreores.data;

import com.patrickfrom.moreores.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.DIRT_ORE)
                .add(ModBlocks.DEEPSLATE_DIRT_ORE)
                .add(ModBlocks.AXOLOTL_ORE)
                .add(ModBlocks.DEEPSLATE_AXOLOTL_ORE)
                .add(ModBlocks.APPLE_ORE)
                .add(ModBlocks.DEEPSLATE_APPLE_ORE)
                .add(ModBlocks.GOLDEN_APPLE_ORE)
                .add(ModBlocks.DEEPSLATE_GOLDEN_APPLE_ORE)
                .add(ModBlocks.TORCH_ORE)
                .add(ModBlocks.DEEPSLATE_TORCH_ORE)
                .add(ModBlocks.CAKE_ORE)
                .add(ModBlocks.DEEPSLATE_CAKE_ORE)
        ;

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.AXOLOTL_ORE)
                .add(ModBlocks.DEEPSLATE_AXOLOTL_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.GOLDEN_APPLE_ORE)
                .add(ModBlocks.DEEPSLATE_GOLDEN_APPLE_ORE);
    }
}
