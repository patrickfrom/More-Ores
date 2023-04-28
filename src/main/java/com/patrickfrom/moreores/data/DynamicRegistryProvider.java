package com.patrickfrom.moreores.data;

import com.patrickfrom.moreores.MoreOres;
import com.patrickfrom.moreores.block.ModBlocks;
import com.patrickfrom.moreores.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class DynamicRegistryProvider extends FabricDynamicRegistryProvider {
    public DynamicRegistryProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    private static final RuleTest STONE_RULE = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
    private static final RuleTest DEEPSLATE_RULE = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_DIRT_FEATURE = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(MoreOres.MOD_ID, "ore_dirt"));


    private static final List<OreFeatureConfig.Target> DIRT_ORE_TARGET = List.of(OreFeatureConfig
            .createTarget(STONE_RULE, ModBlocks.DIRT_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(DEEPSLATE_RULE, ModBlocks.DEEPSLATE_DIRT_ORE.getDefaultState()));

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
        ConfiguredFeature<?, ?> ORE_DIRT = new ConfiguredFeature<>(Feature.ORE, new OreFeatureConfig(DIRT_ORE_TARGET, 9));
        RegistryEntry<ConfiguredFeature<?, ?>> ore_dirt_entry = entries.add(ORE_DIRT_FEATURE, ORE_DIRT);

        PlacedFeature PLACED_ORE_DIRT = new PlacedFeature(ore_dirt_entry,
                modifiersWithCount(10, HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-162),
                        YOffset.aboveBottom(162))));
        entries.add(ModPlacedFeatures.DIRT_ORE_PLACED_KEY, PLACED_ORE_DIRT);
    }

    @Override
    public String getName() {
        return null;
    }

    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    public static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }
}
