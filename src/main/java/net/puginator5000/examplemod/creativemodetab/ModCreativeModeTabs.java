package net.puginator5000.examplemod.creativemodetab;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.fabricmc.fabric.api.datagen.v1.advancement.FabricAdvancementBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.puginator5000.examplemod.ExampleMod;
import net.puginator5000.examplemod.block.ModBlocks;
import net.puginator5000.examplemod.item.ModItems;

public class ModCreativeModeTabs {

    private static final CreativeModeTab PUGINATOR_MOD_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(ExampleMod.MOD_ID, "mod_items"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModItems.FLUORITE))
                    .title(Component.translatable("creativemodetab.examplemod.mod_items"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.FLUORITE);
                        output.accept(ModItems.FLAT_FISH);
                        output.accept(ModItems.RAW_FLUORITE);
                        output.accept(ModItems.RUBY);
                        output.accept(ModItems.RUBY_RING);
                    })
            .build());

    private static final CreativeModeTab BLOCKS_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(ExampleMod.MOD_ID, "mod_blocks"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.FLUORITE_BLOCK))
                    .title(Component.translatable("creativemodetab.examplemod.mod_blocks"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.FLUORITE_BLOCK);
                        output.accept(ModBlocks.FLUORITE_DEEPSLATE_ORE);
                        output.accept(ModBlocks.FLUORITE_ORE);
                    })
                    .build());


    public static void registerCreativeModeTabs() {
        ExampleMod.LOGGER.info("Registering Creative Mode Tabs for " + ExampleMod.MOD_ID);
    }
}
