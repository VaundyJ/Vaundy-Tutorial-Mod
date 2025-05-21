package net.vaundyj.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.vaundyj.tutorialmod.block.ModBlocks;
import net.vaundyj.tutorialmod.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> SILVER_SMELTABLES = List.of(ModItems.RAW_SILVER, ModBlocks.SILVER_ORE, ModBlocks.DEEPSLATE_SILVER_ORE);
        List<ItemConvertible> SILVER_BLOCK_SMELTABLES = List.of(ModBlocks.RAW_SILVER_BLOCK);
        offerSmelting(exporter, SILVER_SMELTABLES, RecipeCategory.MISC, ModItems.SILVER, 0.7F, 200, "silver");
        offerSmelting(exporter, SILVER_BLOCK_SMELTABLES, RecipeCategory.MISC, ModBlocks.SILVER_BLOCK, 6.3F, 200, "silver_block");

        offerBlasting(exporter, SILVER_SMELTABLES, RecipeCategory.MISC, ModItems.SILVER, 0.7F, 100, "silver");
        offerBlasting(exporter, SILVER_BLOCK_SMELTABLES, RecipeCategory.MISC, ModBlocks.SILVER_BLOCK, 6.3F, 100, "silver_block");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.RAW_SILVER, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_SILVER_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.SILVER, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILVER_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SILVERBOLT, 4)
                .pattern("S")
                .pattern("#")
                .pattern("F")
                .input('S', ModItems.SILVER)
                .input('#', Items.STICK)
                .input('F', Items.FEATHER)
                .criterion(hasItem(ModItems.SILVER), conditionsFromItem(ModItems.SILVER))
                .offerTo(exporter);

    }
}
