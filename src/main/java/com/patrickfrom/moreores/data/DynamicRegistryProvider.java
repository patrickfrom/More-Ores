package com.patrickfrom.moreores.data;

import com.patrickfrom.moreores.block.ModBlocks;
import com.patrickfrom.moreores.world.OreGenerationParameters;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;

import java.util.concurrent.CompletableFuture;

import static com.patrickfrom.moreores.world.ModConfiguredFeatures.*;
import static com.patrickfrom.moreores.world.ModPlacedFeatures.*;

public class DynamicRegistryProvider extends FabricDynamicRegistryProvider {
    public DynamicRegistryProvider(FabricDataOutput output,
                                   CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    private static void addOreToWorld(Entries entries, OreGenerationParameters params) {
        ConfiguredFeature<?, ?> oreFeatureConfig = createOreFeatureConfig(params.block, params.deepslate, params.size);

        RegistryEntry<ConfiguredFeature<?, ?>> registryEntry = entries.add(params.configuredFeatureKey, oreFeatureConfig);

        PlacedFeature placedFeature = createPlacedFeature(registryEntry, params.count, params.minY, params.maxY);
        entries.add(params.placedFeatureKey, placedFeature);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
        OreGenerationParameters DIRT_ORE_GENERATION = new OreGenerationParameters(
                DIRT_ORE_PLACED_KEY, ORE_DIRT_CONFIGURED_FEATURE,
                ModBlocks.DIRT_ORE, ModBlocks.DEEPSLATE_DIRT_ORE,
                9, 10,
                -24, 56
        );
        addOreToWorld(entries, DIRT_ORE_GENERATION);

        OreGenerationParameters APPLE_ORE_GENERATION = new OreGenerationParameters(
                APPLE_ORE_PLACED_KEY, ORE_APPLE_CONFIGURED_FEATURE,
                ModBlocks.APPLE_ORE, ModBlocks.DEEPSLATE_APPLE_ORE,
                4, 10,
                -24, 56
        );
        addOreToWorld(entries, APPLE_ORE_GENERATION);

        OreGenerationParameters AXOLOTL_ORE_GENERATION = new OreGenerationParameters(
                AXOLOTL_ORE_PLACED_KEY, ORE_AXOLOTL_CONFIGURED_FEATURE,
                ModBlocks.AXOLOTL_ORE, ModBlocks.DEEPSLATE_AXOLOTL_ORE,
                9, 2,
                -24, 56
        );
        addOreToWorld(entries, AXOLOTL_ORE_GENERATION);

        OreGenerationParameters CAKE_ORE_GENERATION = new OreGenerationParameters(
                CAKE_ORE_PLACED_KEY, ORE_CAKE_CONFIGURED_FEATURE,
                ModBlocks.CAKE_ORE, ModBlocks.DEEPSLATE_CAKE_ORE,
                4, 5,
                -100, 50
        );
        addOreToWorld(entries, CAKE_ORE_GENERATION);

        OreGenerationParameters GLOWSTONE_ORE_GENERATION = new OreGenerationParameters(
                GLOWSTONE_ORE_PLACED_KEY, ORE_GLOWSTONE_CONFIGURED_FEATURE,
                ModBlocks.GLOWSTONE_ORE, ModBlocks.DEEPSLATE_GLOWSTONE_ORE,
                3, 2,
                -24, 56
        );
        addOreToWorld(entries, GLOWSTONE_ORE_GENERATION);

        OreGenerationParameters GOLDEN_APPLE_ORE_GENERATION = new OreGenerationParameters(
                GOLDEN_APPLE_ORE_PLACED_KEY, ORE_GOLDEN_APPLE_CONFIGURED_FEATURE,
                ModBlocks.GOLDEN_APPLE_ORE, ModBlocks.DEEPSLATE_GOLDEN_APPLE_ORE,
                4, 3,
                -24, 56
        );
        addOreToWorld(entries, GOLDEN_APPLE_ORE_GENERATION);

        OreGenerationParameters TORCH_ORE_GENERATION = new OreGenerationParameters(
                TORCH_ORE_PLACED_KEY, ORE_TORCH_CONFIGURED_FEATURE,
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
}
