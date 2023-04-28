package com.patrickfrom.moreores.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class DataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModelProvider::new);
        pack.addProvider(TagProvider::new);
        pack.addProvider(LootTableProvider::new);
        pack.addProvider(DynamicRegistryProvider::new);
        pack.addProvider(EnglishLanguageProvider::new);
    }
}
