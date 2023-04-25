package com.patrickfrom.moreores;

import com.patrickfrom.moreores.block.ModBlocks;
import com.patrickfrom.moreores.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreOres implements ModInitializer {

    public static final String MOD_ID = "moreores";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Loading Mod: " + MOD_ID + "!");
        ModBlocks.registerBlocks();
        ModItems.registerItems();
    }
}