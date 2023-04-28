package com.patrickfrom.moreores.data;

import com.patrickfrom.moreores.block.ModBlocks;
import com.patrickfrom.moreores.world.ModConfiguredFeatures;
import com.patrickfrom.moreores.world.ModPlacedFeatures;
import com.patrickfrom.moreores.world.OreGenerationParameters;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class DynamicRegistryProvider extends FabricDynamicRegistryProvider {
    public DynamicRegistryProvider(FabricDataOutput output,
                                   CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    private static final RuleTest STONE_RULE = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
    private static final RuleTest DEEPSLATE_RULE = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
    private static final RuleTest NETHER_CARVER_RULE = new TagMatchRuleTest(BlockTags.NETHER_CARVER_REPLACEABLES);

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
        OreGenerationParameters DIRT_ORE_GENERATION = new OreGenerationParameters(
                ModPlacedFeatures.DIRT_ORE_PLACED_KEY, ModConfiguredFeatures.ORE_DIRT_CONFIGURED_FEATURE,
                ModBlocks.DIRT_ORE, ModBlocks.DEEPSLATE_DIRT_ORE,
                9, 10,
                -24, 56
        );
        addOreToWorld(entries, DIRT_ORE_GENERATION);

        OreGenerationParameters APPLE_ORE_GENERATION = new OreGenerationParameters(
                ModPlacedFeatures.APPLE_ORE_PLACED_KEY, ModConfiguredFeatures.ORE_APPLE_CONFIGURED_FEATURE,
                ModBlocks.APPLE_ORE, ModBlocks.DEEPSLATE_APPLE_ORE,
                4, 10,
                -24, 56
        );
        addOreToWorld(entries, APPLE_ORE_GENERATION);

        OreGenerationParameters AXOLOTL_ORE_GENERATION = new OreGenerationParameters(
                ModPlacedFeatures.AXOLOTL_ORE_PLACED_KEY, ModConfiguredFeatures.ORE_AXOLOTL_CONFIGURED_FEATURE,
                ModBlocks.AXOLOTL_ORE, ModBlocks.DEEPSLATE_AXOLOTL_ORE,
                9, 2,
                -24, 56
        );
        addOreToWorld(entries, AXOLOTL_ORE_GENERATION);

        OreGenerationParameters CAKE_ORE_GENERATION = new OreGenerationParameters(
                ModPlacedFeatures.CAKE_ORE_PLACED_KEY, ModConfiguredFeatures.ORE_CAKE_CONFIGURED_FEATURE,
                ModBlocks.CAKE_ORE, ModBlocks.DEEPSLATE_CAKE_ORE,
                4, 5,
                -100, 50
        );
        addOreToWorld(entries, CAKE_ORE_GENERATION);

        OreGenerationParameters GLOWSTONE_ORE_GENERATION = new OreGenerationParameters(
                ModPlacedFeatures.GLOWSTONE_ORE_PLACED_KEY, ModConfiguredFeatures.ORE_GLOWSTONE_CONFIGURED_FEATURE,
                ModBlocks.GLOWSTONE_ORE, ModBlocks.DEEPSLATE_GLOWSTONE_ORE,
                3, 2,
                -24, 56
        );
        addOreToWorld(entries, GLOWSTONE_ORE_GENERATION);

        OreGenerationParameters GOLDEN_APPLE_ORE_GENERATION = new OreGenerationParameters(
                ModPlacedFeatures.GOLDEN_APPLE_ORE_PLACED_KEY, ModConfiguredFeatures.ORE_GOLDEN_APPLE_CONFIGURED_FEATURE,
                ModBlocks.GOLDEN_APPLE_ORE, ModBlocks.DEEPSLATE_GOLDEN_APPLE_ORE,
                4, 3,
                -24, 56
        );
        addOreToWorld(entries, GOLDEN_APPLE_ORE_GENERATION);

        OreGenerationParameters TORCH_ORE_GENERATION = new OreGenerationParameters(
                ModPlacedFeatures.TORCH_ORE_PLACED_KEY, ModConfiguredFeatures.ORE_TORCH_CONFIGURED_FEATURE,
                ModBlocks.TORCH_ORE, ModBlocks.DEEPSLATE_TORCH_ORE,
                4, 13,
                -250, 250
        );
        addOreToWorld(entries, TORCH_ORE_GENERATION);
    }

    @Override
    public String getName() {
        return null;
    }

    private static void addOreToWorld(Entries entries, OreGenerationParameters params) {
        ConfiguredFeature<?, ?> oreFeatureConfig = createOreFeatureConfig(params.block, params.deepslate, params.size);
        RegistryEntry<ConfiguredFeature<?, ?>> registryEntry = entries.add(params.configuredFeatureKey, oreFeatureConfig);

        PlacedFeature placedFeature = createPlacedFeature(registryEntry, params.count, params.minY, params.maxY);
        entries.add(params.placedFeatureKey, placedFeature);
    }

    private static ConfiguredFeature<?, ?> createOreFeatureConfig(Block block, Block deepslate, int size) {
        List<OreFeatureConfig.Target> targets = List.of(
                OreFeatureConfig.createTarget(STONE_RULE, block.getDefaultState()),
                OreFeatureConfig.createTarget(DEEPSLATE_RULE, deepslate.getDefaultState())
        );

        return new ConfiguredFeature<>(Feature.ORE, new OreFeatureConfig(targets, size));
    }

    private static PlacedFeature createPlacedFeature(RegistryEntry<ConfiguredFeature<?, ?>> registryEntry, int count, int minY, int maxY) {
        return new PlacedFeature(
                registryEntry,
                modifiersWithCount(count, HeightRangePlacementModifier.trapezoid(
                        YOffset.aboveBottom(minY),
                        YOffset.aboveBottom(maxY)
                ))
        );
    }

    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    public static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }
}
