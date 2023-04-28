package com.patrickfrom.moreores.world;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;

public class OreGenerationParameters {
    public RegistryKey<PlacedFeature> placedFeatureKey;
    public RegistryKey<ConfiguredFeature<?, ?>> configuredFeatureKey;
    public Block block;
    public Block deepslate;
    public int size;
    public int count;
    public int minY;
    public int maxY;

    public OreGenerationParameters(RegistryKey<PlacedFeature> placedFeatureKey,
                                   RegistryKey<ConfiguredFeature<?, ?>> configuredFeatureKey,
                                   Block block, Block deepslate, int size, int count, int minY, int maxY) {

        this.placedFeatureKey = placedFeatureKey;
        this.configuredFeatureKey = configuredFeatureKey;
        this.block = block;
        this.deepslate = deepslate;
        this.size = size;
        this.count = count;
        this.minY = minY;
        this.maxY = maxY;
    }
}