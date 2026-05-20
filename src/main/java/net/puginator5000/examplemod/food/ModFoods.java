package net.puginator5000.examplemod.food;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.puginator5000.examplemod.ExampleMod;

public class ModFoods {
    //base settings for a food
    public static final FoodProperties FLAT_FISH = new FoodProperties.Builder().nutrition(2).saturationModifier(.25f).build();

    //the negative or positive affects of a consumable
    public static final Consumable FLAT_FISH_CONSUMABLE = Consumables.defaultFood()
            .consumeSeconds(1f)
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.POISON, 5 * 20, 1 ), .5f))
            .build();

    //example
    public static final Consumable POISON_FOOD_CONSUMABLE_COMPONENT = Consumables.defaultFood()
            //the duration is in ticks. 20 ticks = 1 second
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.POISON, 6 * 20, 1), .5f))
            .build();

    //example
    public static final FoodProperties POISON_FOOD_COMPONENT = new FoodProperties.Builder()
            .alwaysEdible()
            .build();

    public static void registeringModFoods() {
        ExampleMod.LOGGER.info("Register Mod Foods for " + ExampleMod.MOD_ID);
    }
}
