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

    private static RegistryKey<PlacedFeature> registerPlacedFeature(String name) {
        return RegistryKey.of(
                RegistryKeys.PLACED_FEATURE, new Identifier(MoreOres.MOD_ID, name));
    }

    public static void registerPlacedFeatures() {
        MoreOres.LOGGER.info("Registering Placed Features");

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, AXOLOTL_ORE_PLACED_KEY);

    }
}
