package com.patrickfrom.moreores.world;

import com.patrickfrom.moreores.MoreOres;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_DIRT_CONFIGURED_FEATURE
            = registerFeature("ore_dirt");

    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_APPLE_CONFIGURED_FEATURE
            = registerFeature("ore_apple");

    public static final RegistryKey<ConfiguredFeature<?,?>> ORE_AXOLOTL_CONFIGURED_FEATURE =
            registerFeature("ore_axolotl");

    public static final RegistryKey<ConfiguredFeature<?,?>> ORE_CAKE_CONFIGURED_FEATURE =
            registerFeature("ore_cake");

    public static final RegistryKey<ConfiguredFeature<?,?>> ORE_GLOWSTONE_CONFIGURED_FEATURE =
            registerFeature("ore_glowstone");

    public static final RegistryKey<ConfiguredFeature<?,?>> ORE_GOLDEN_APPLE_CONFIGURED_FEATURE =
            registerFeature("ore_golden_apple");

    public static final RegistryKey<ConfiguredFeature<?,?>> ORE_TORCH_CONFIGURED_FEATURE =
            registerFeature("ore_torch");

    private static RegistryKey<ConfiguredFeature<?,?>> registerFeature(String id) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(MoreOres.MOD_ID, id));
    }
}
