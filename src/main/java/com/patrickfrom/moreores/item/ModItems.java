package com.patrickfrom.moreores.item;

import com.patrickfrom.moreores.MoreOres;
import com.patrickfrom.moreores.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item DIRT_ORE = registerItem("dirt_ore",
            ModBlocks.DIRT_ORE);

    public static final Item DEEPSLATE_DIRT_ORE = registerItem("deepslate_dirt_ore",
            ModBlocks.DEEPSLATE_DIRT_ORE);

    public static final Item AXOLOTL_ORE = registerItem("axolotl_ore",
            ModBlocks.AXOLOTL_ORE);

    public static final Item DEEPSLATE_AXOLOTL_ORE = registerItem("deepslate_axolotl_ore",
            ModBlocks.DEEPSLATE_AXOLOTL_ORE);

    public static final Item APPLE_ORE = registerItem("apple_ore",
            ModBlocks.APPLE_ORE);

    public static final Item DEEPSLATE_APPLE_ORE = registerItem("deepslate_apple_ore",
            ModBlocks.DEEPSLATE_APPLE_ORE);

    public static final Item GOLDEN_APPLE_ORE = registerItem("golden_apple_ore",
            ModBlocks.GOLDEN_APPLE_ORE);

    public static final Item DEEPSLATE_GOLDEN_APPLE_ORE = registerItem("deepslate_golden_apple_ore",
            ModBlocks.DEEPSLATE_GOLDEN_APPLE_ORE);

    public static final Item TORCH_ORE = registerItem("torch_ore",
            ModBlocks.TORCH_ORE);

    public static final Item DEEPSLATE_TORCH_ORE = registerItem("deepslate_torch_ore",
            ModBlocks.DEEPSLATE_TORCH_ORE);


    private static Item registerItem(String name, Block block) {
        Item blockItem = new BlockItem(block, new Item.Settings());

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> content.add(blockItem));
        return Registry.register(Registries.ITEM, new Identifier(MoreOres.MOD_ID, name), blockItem);
    }

    public static void registerItems() {
        MoreOres.LOGGER.info("Registering Items");
    }
}
