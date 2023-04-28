package com.patrickfrom.moreores.world;

import com.patrickfrom.moreores.MoreOres;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

import static com.patrickfrom.moreores.world.PlacementRules.DEEPSLATE_RULE;
import static com.patrickfrom.moreores.world.PlacementRules.STONE_RULE;

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

    public static ConfiguredFeature<?, ?> createOreFeatureConfig(Block block, Block deepslate, int size) {
        List<OreFeatureConfig.Target> targets = List.of(
                OreFeatureConfig.createTarget(STONE_RULE, block.getDefaultState()),
                OreFeatureConfig.createTarget(DEEPSLATE_RULE, deepslate.getDefaultState())
        );

        return new ConfiguredFeature<>(Feature.ORE, new OreFeatureConfig(targets, size));
    }
}
