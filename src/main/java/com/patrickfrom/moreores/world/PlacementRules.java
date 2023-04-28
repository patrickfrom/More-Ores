package com.patrickfrom.moreores.world;

import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;

public class PlacementRules {
    public static final RuleTest STONE_RULE = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
    public static final RuleTest DEEPSLATE_RULE = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
    public static final RuleTest NETHER_CARVER_RULE = new TagMatchRuleTest(BlockTags.NETHER_CARVER_REPLACEABLES);
}
