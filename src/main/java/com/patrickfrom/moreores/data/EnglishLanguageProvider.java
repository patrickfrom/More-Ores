package com.patrickfrom.moreores.data;

import com.patrickfrom.moreores.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class EnglishLanguageProvider extends FabricLanguageProvider {
    protected EnglishLanguageProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.AXOLOTL_ORE, "Axolotl Ore");
        translationBuilder.add(ModItems.DEEPSLATE_AXOLOTL_ORE, "Deepslate Axolotl Ore");
        translationBuilder.add(ModItems.DIRT_ORE, "Dirt Ore");
        translationBuilder.add(ModItems.APPLE_ORE, "Apple Ore");
        translationBuilder.add(ModItems.GOLDEN_APPLE_ORE, "Golden Apple Ore");
    }
}
