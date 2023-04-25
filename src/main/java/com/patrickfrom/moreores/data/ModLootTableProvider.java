package com.patrickfrom.moreores.data;

import com.patrickfrom.moreores.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.item.Items;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    protected ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.AXOLOTL_ORE, oreDrops(ModBlocks.AXOLOTL_ORE, Items.AXOLOTL_BUCKET));
        addDrop(ModBlocks.DIRT_ORE, oreDrops(ModBlocks.DIRT_ORE, Items.DIRT));
        addDrop(ModBlocks.APPLE_ORE, oreDrops(ModBlocks.APPLE_ORE, Items.APPLE));
        addDrop(ModBlocks.GOLDEN_APPLE_ORE, oreDrops(ModBlocks.GOLDEN_APPLE_ORE, Items.GOLDEN_APPLE));
    }
}
