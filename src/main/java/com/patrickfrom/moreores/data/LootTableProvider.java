package com.patrickfrom.moreores.data;

import com.patrickfrom.moreores.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.LimitCountLootFunction;
import net.minecraft.loot.operator.BoundedIntUnaryOperator;

public class LootTableProvider extends FabricBlockLootTableProvider {
    protected LootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.AXOLOTL_ORE, oreDrops(ModBlocks.AXOLOTL_ORE, Items.AXOLOTL_BUCKET));
        addDrop(ModBlocks.DEEPSLATE_AXOLOTL_ORE, oreDrops(ModBlocks.DEEPSLATE_AXOLOTL_ORE, Items.AXOLOTL_BUCKET));

        addDrop(ModBlocks.DIRT_ORE, oreDrops(ModBlocks.DIRT_ORE, Items.DIRT));
        addDrop(ModBlocks.DEEPSLATE_DIRT_ORE, oreDrops(ModBlocks.DEEPSLATE_DIRT_ORE, Items.DIRT));

        addDrop(ModBlocks.APPLE_ORE, oreDropsWithAmount(ModBlocks.APPLE_ORE, Items.APPLE, 1, 5));
        addDrop(ModBlocks.DEEPSLATE_APPLE_ORE, oreDropsWithAmount(ModBlocks.DEEPSLATE_APPLE_ORE, Items.APPLE, 1, 5));

        addDrop(ModBlocks.GOLDEN_APPLE_ORE, oreDrops(ModBlocks.GOLDEN_APPLE_ORE, Items.GOLDEN_APPLE));
        addDrop(ModBlocks.DEEPSLATE_GOLDEN_APPLE_ORE, oreDrops(ModBlocks.DEEPSLATE_GOLDEN_APPLE_ORE, Items.GOLDEN_APPLE));

        addDrop(ModBlocks.TORCH_ORE, oreDropsWithAmount(ModBlocks.TORCH_ORE, Items.TORCH, 1, 3));
        addDrop(ModBlocks.DEEPSLATE_TORCH_ORE, oreDropsWithAmount(ModBlocks.DEEPSLATE_TORCH_ORE, Items.TORCH, 1, 3));

        addDrop(ModBlocks.CAKE_ORE, oreDrops(ModBlocks.CAKE_ORE, Items.CAKE));
        addDrop(ModBlocks.DEEPSLATE_CAKE_ORE, oreDrops(ModBlocks.DEEPSLATE_CAKE_ORE, Items.CAKE));

        addDrop(ModBlocks.GLOWSTONE_ORE,
                oreDropsWithAmount(ModBlocks.GLOWSTONE_ORE, Items.GLOWSTONE_DUST, 2, 4));
        addDrop(ModBlocks.DEEPSLATE_GLOWSTONE_ORE,
                oreDropsWithAmount(ModBlocks.DEEPSLATE_GLOWSTONE_ORE, Items.GLOWSTONE_DUST, 2, 4));
    }

    public LootTable.Builder oreDropsWithAmount(Block dropWithSilkTouch, ItemConvertible drop, int min, int max) {
        return dropsWithSilkTouch(dropWithSilkTouch, this.applyExplosionDecay(dropWithSilkTouch,
                ItemEntry.builder(drop)
                        .apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.create(min, max)))
                        .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }

}
