package com.patrickfrom.moreores.world;

import com.patrickfrom.moreores.MoreOres;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> AXOLOTL_ORE_PLACED_KEY = registerPlacedFeature("ore_axolotl");
    public static final RegistryKey<PlacedFeature> DIRT_ORE_PLACED_KEY = registerPlacedFeature("ore_dirt");
    public static final RegistryKey<PlacedFeature> APPLE_ORE_PLACED_KEY = registerPlacedFeature("ore_apple");
    public static final RegistryKey<PlacedFeature> GOLDEN_APPLE_ORE_PLACED_KEY = registerPlacedFeature("ore_golden_apple");

    public static void registerPlacedFeatures() {
        MoreOres.LOGGER.info("Registering Placed Features");

        addUndergroundOreFeature(AXOLOTL_ORE_PLACED_KEY);
        addUndergroundOreFeature(DIRT_ORE_PLACED_KEY);
        addUndergroundOreFeature(APPLE_ORE_PLACED_KEY);
        addUndergroundOreFeature(GOLDEN_APPLE_ORE_PLACED_KEY);
    }

    private static RegistryKey<PlacedFeature> registerPlacedFeature(String name) {
        return RegistryKey.of(
                RegistryKeys.PLACED_FEATURE, new Identifier(MoreOres.MOD_ID, name));
    }

    private static void addUndergroundOreFeature(RegistryKey<PlacedFeature> registryKey) {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, registryKey);
    }

}
