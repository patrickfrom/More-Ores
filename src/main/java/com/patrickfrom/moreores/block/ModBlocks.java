package com.patrickfrom.moreores.block;

import com.patrickfrom.moreores.MoreOres;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block DIRT_ORE = registerBlock("dirt_ore",
            FabricBlockSettings.of(Material.METAL).hardness(0.5f));

    public static final Block DEEPSLATE_DIRT_ORE = registerBlock("deepslate_dirt_ore",
            FabricBlockSettings.of(Material.METAL).hardness(1.5f));

    public static final Block TORCH_ORE = registerBlock("torch_ore",
            FabricBlockSettings.of(Material.METAL).hardness(0.5f));

    public static final Block DEEPSLATE_TORCH_ORE = registerBlock("deepslate_torch_ore",
            FabricBlockSettings.of(Material.METAL).hardness(1.5f));

    public static final Block AXOLOTL_ORE = registerBlock("axolotl_ore",
            FabricBlockSettings.of(Material.METAL).hardness(2.0f));

    public static final Block DEEPSLATE_AXOLOTL_ORE = registerBlock("deepslate_axolotl_ore",
           FabricBlockSettings.of(Material.METAL).hardness(3.0f));

    public static final Block APPLE_ORE = registerBlock("apple_ore",
            FabricBlockSettings.of(Material.METAL).hardness(0.5f));

    public static final Block DEEPSLATE_APPLE_ORE = registerBlock("deepslate_apple_ore",
            FabricBlockSettings.of(Material.METAL).hardness(1.5f));

    public static final Block GOLDEN_APPLE_ORE = registerBlock("golden_apple_ore",
            FabricBlockSettings.of(Material.METAL).hardness(5.0f));

    public static final Block DEEPSLATE_GOLDEN_APPLE_ORE = registerBlock("deepslate_golden_apple_ore",
            FabricBlockSettings.of(Material.METAL).hardness(6.0f));

    public static final Block CAKE_ORE = registerBlock("cake_ore",
            FabricBlockSettings.of(Material.METAL).hardness(1.5f));

    public static final Block DEEPSLATE_CAKE_ORE = registerBlock("deepslate_cake_ore",
            FabricBlockSettings.of(Material.METAL).hardness(2.5f));


    private static Block registerBlock(String name, FabricBlockSettings settings) {
        return Registry.register(Registries.BLOCK, new Identifier(MoreOres.MOD_ID, name), new Block(settings.requiresTool()));
    }

    public static void registerBlocks() {
        MoreOres.LOGGER.info("Creating Blocks");
    }
}