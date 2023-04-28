package com.patrickfrom.moreores.data;

import com.patrickfrom.moreores.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DIRT_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DEEPSLATE_DIRT_ORE);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.AXOLOTL_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DEEPSLATE_AXOLOTL_ORE);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.APPLE_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DEEPSLATE_APPLE_ORE);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.GOLDEN_APPLE_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DEEPSLATE_GOLDEN_APPLE_ORE);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.TORCH_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DEEPSLATE_TORCH_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}
