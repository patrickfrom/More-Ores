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
            new Block(FabricBlockSettings.of(Material.METAL)
                    .hardness(0.5f)
                    .strength(1.0f)
                    .requiresTool()
            ));

    public static final Block AXOLOTL_ORE = registerBlock("axolotl_ore",
            new Block(FabricBlockSettings.of(Material.METAL)
                    .hardness(1.5f)
                    .strength(1.0f)
                    .requiresTool()
            ));

    public static final Block APPLE_ORE = registerBlock("apple_block",
            new Block(FabricBlockSettings.of(Material.METAL)
                    .hardness(0.5f)
                    .strength(1.0f)
                    .requiresTool()
            ));

    public static final Block GOLDEN_APPLE_ORE = registerBlock("golden_apple_block",
            new Block(FabricBlockSettings.of(Material.METAL)
                    .hardness(3f)
                    .strength(1.0f)
                    .requiresTool()
            ));

    private static Block registerBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(MoreOres.MOD_ID, name), block);
    }

    public static void registerBlocks() {
        MoreOres.LOGGER.info("Creating Blocks");
    }
}