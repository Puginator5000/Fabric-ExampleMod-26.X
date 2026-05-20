package net.puginator5000.examplemod.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.puginator5000.examplemod.ExampleMod;
import net.puginator5000.examplemod.food.ModFoods;

import java.util.Properties;
import java.util.function.Function;

public class ModItems {

    // ITEM CREATION ---------------------------------------------------------------------------------------------------------------

    public static final Item FLUORITE = registerItem("fluorite", Item::new); //transformed from a lambda
    public static final Item RAW_FLUORITE = registerItem("raw_fluorite", Item::new);
    public static final Item RUBY = registerItem("ruby", Item::new);
    public static final Item RUBY_RING = registerItem("ruby_ring", Item::new);
    public static final Item FLAT_FISH = registerItem("flat_fish", properties -> new Item(properties.
            food(ModFoods.FLAT_FISH, ModFoods.FLAT_FISH_CONSUMABLE)));

    //------------------------------------------------------------------------------------------------------------------------------

    //Helps registers Items
    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(ExampleMod.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(ExampleMod.MOD_ID, name)))));
    }

    public static void registerModItems() {
        ExampleMod.LOGGER.info("Register Mod Items for " + ExampleMod.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
                output.accept(FLUORITE);
                output.accept(RAW_FLUORITE);
                output.accept(RUBY);
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(output -> {
            output.accept(RUBY_RING);
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(output -> {
            output.accept(FLAT_FISH);
        });

    }

}
