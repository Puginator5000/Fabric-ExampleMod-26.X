package net.puginator5000.examplemod;

import net.fabricmc.api.ModInitializer;

import net.puginator5000.examplemod.block.ModBlocks;
import net.puginator5000.examplemod.creativemodetab.ModCreativeModeTabs;
import net.puginator5000.examplemod.food.ModFoods;
import net.puginator5000.examplemod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
	public static final String MOD_ID = "examplemod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModCreativeModeTabs.registerCreativeModeTabs();
		ModFoods.registeringModFoods();
		ModBlocks.registerModBlocks();
	}
}