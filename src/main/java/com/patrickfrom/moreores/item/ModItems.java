package com.patrickfrom.moreores.item;

import com.patrickfrom.moreores.MoreOres;
import com.patrickfrom.moreores.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item DIRT_ORE = registerItem("dirt_ore",
            new BlockItem(ModBlocks.DIRT_ORE, new Item.Settings()));

    public static final Item AXOLOTL_ORE = registerItem("axolotl_ore",
            new BlockItem(ModBlocks.AXOLOTL_ORE, new Item.Settings()));

    public static final Item APPLE_ORE = registerItem("apple_ore",
            new BlockItem(ModBlocks.APPLE_ORE, new Item.Settings()));

    public static final Item GOLDEN_APPLE_ORE = registerItem("golden_apple_ore",
            new BlockItem(ModBlocks.GOLDEN_APPLE_ORE, new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> content.add(item));
        return Registry.register(Registries.ITEM, new Identifier(MoreOres.MOD_ID, name), item);
    }

    public static void registerItems() {
        MoreOres.LOGGER.info("Registering Items");
    }
}
