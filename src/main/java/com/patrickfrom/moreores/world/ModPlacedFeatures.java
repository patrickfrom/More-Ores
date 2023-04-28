package com.patrickfrom.moreores.world;

import com.patrickfrom.moreores.MoreOres;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> AXOLOTL_ORE_PLACED_KEY = registerPlacedFeature("ore_axolotl");
    public static final RegistryKey<PlacedFeature> DIRT_ORE_PLACED_KEY = registerPlacedFeature("ore_dirt");
    public static final RegistryKey<PlacedFeature> APPLE_ORE_PLACED_KEY = registerPlacedFeature("ore_apple");
    public static final RegistryKey<PlacedFeature> GOLDEN_APPLE_ORE_PLACED_KEY = registerPlacedFeature("ore_golden_apple");
    public static final RegistryKey<PlacedFeature> TORCH_ORE_PLACED_KEY = registerPlacedFeature("ore_torch");
    public static final RegistryKey<PlacedFeature> CAKE_ORE_PLACED_KEY = registerPlacedFeature("ore_cake");
    public static final RegistryKey<PlacedFeature> GLOWSTONE_ORE_PLACED_KEY = registerPlacedFeature("ore_glowstone");

    public static void registerPlacedFeatures() {
        MoreOres.LOGGER.info("Registering Placed Features");

        addUndergroundOreFeature(AXOLOTL_ORE_PLACED_KEY);
        addUndergroundOreFeature(DIRT_ORE_PLACED_KEY);
        addUndergroundOreFeature(APPLE_ORE_PLACED_KEY);
        addUndergroundOreFeature(GOLDEN_APPLE_ORE_PLACED_KEY);
        addUndergroundOreFeature(TORCH_ORE_PLACED_KEY);
        addUndergroundOreFeature(CAKE_ORE_PLACED_KEY);
        addUndergroundOreFeature(GLOWSTONE_ORE_PLACED_KEY);
    }

    private static RegistryKey<PlacedFeature> registerPlacedFeature(String name) {
        return RegistryKey.of(
                RegistryKeys.PLACED_FEATURE, new Identifier(MoreOres.MOD_ID, name));
    }

    private static void addUndergroundOreFeature(RegistryKey<PlacedFeature> registryKey) {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, registryKey);
    }

    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    public static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }

    public static PlacedFeature createPlacedFeature(RegistryEntry<ConfiguredFeature<?, ?>> registryEntry, int count, int minY, int maxY) {
        return new PlacedFeature(
                registryEntry,
                modifiersWithCount(count, HeightRangePlacementModifier.trapezoid(
                        YOffset.aboveBottom(minY),
                        YOffset.aboveBottom(maxY)
                ))
        );
    }
}
