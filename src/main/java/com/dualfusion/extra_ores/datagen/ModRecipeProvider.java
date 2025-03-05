package com.dualfusion.extra_ores.datagen;

import com.dualfusion.extra_ores.Extra_Ores;
import com.dualfusion.extra_ores.block.ModBlocks;
import com.dualfusion.extra_ores.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> PLATIN_SMELTABLES = List.of(ModItems.RAW_PLATIN.get(),
            ModBlocks.PLATIN_ORE.get(), ModBlocks.DEEPSLATE_PLATIN_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        // SMELTING RECIPES :
        oreSmelting(pWriter, PLATIN_SMELTABLES, RecipeCategory.MISC, ModItems.PLATIN_INGOT.get(), 0.25f, 200, "platin");
        oreBlasting(pWriter, PLATIN_SMELTABLES, RecipeCategory.MISC, ModItems.PLATIN_INGOT.get(), 0.25f, 100, "platin");

        // PLATIN ITEMS :
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PLATIN_INGOT.get(), 9)
                .requires(ModBlocks.PLATIN_BLOCK.get())
                .unlockedBy(getHasName(ModItems.PLATIN_INGOT.get()), has(ModItems.PLATIN_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PLATIN_INGOT.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.PLATIN_NUGGET.get())
                .unlockedBy(getHasName(ModItems.PLATIN_INGOT.get()), has(ModItems.PLATIN_INGOT.get()))
                .save(pWriter, "extra_ores:platin_ingot_from_nugget");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PLATIN_NUGGET.get(), 9)
                .requires(ModItems.PLATIN_INGOT.get())
                .unlockedBy(getHasName(ModItems.PLATIN_INGOT.get()), has(ModItems.PLATIN_INGOT.get()))
                .save(pWriter);

        // PLATINIUM ITEMS :
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PLATINIUM_INGOT.get(), 9)
                .requires(ModBlocks.PLATINIUM_BLOCK.get())
                .unlockedBy(getHasName(ModItems.PLATINIUM_INGOT.get()), has(ModItems.PLATINIUM_INGOT.get()))
                .save(pWriter, "extra_ores:platinium_ingot_from_block");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PLATINIUM_INGOT.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.PLATINIUM_NUGGET.get())
                .unlockedBy(getHasName(ModItems.PLATINIUM_INGOT.get()), has(ModItems.PLATINIUM_INGOT.get()))
                .save(pWriter, "extra_ores:platinium_ingot_from_nugget");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PLATINIUM_NUGGET.get(), 9)
                .requires(ModItems.PLATINIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.PLATINIUM_INGOT.get()), has(ModItems.PLATINIUM_INGOT.get()))
                .save(pWriter, "extra_ores:platin_ingot_from_block");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PLATINIUM_COMPONENT.get())
                .pattern(" S ")
                .pattern("SAS")
                .pattern(" S ")
                .define('S', ModItems.PLATIN_INGOT.get())
                .define('A', Items.DIAMOND)
                .unlockedBy(getHasName(ModItems.PLATIN_INGOT.get()), has(ModItems.PLATINIUM_COMPONENT.get()))
                .save(pWriter);

        SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItems.PLATINIUM_COMPONENT.get()),
                        Ingredient.of(ModItems.PLATIN_INGOT.get()),
                        Ingredient.of(Items.GOLD_INGOT), RecipeCategory.MISC,
                        ModItems.PLATINIUM_INGOT.get())
                .unlocks(getHasName(ModItems.PLATIN_INGOT.get()), has(ModItems.PLATIN_INGOT.get()))
                .save(pWriter, "extra_ores:platinium_ingot");

        // BLOCKS :
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PLATIN_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.PLATIN_INGOT.get())
                .unlockedBy(getHasName(ModItems.PLATIN_INGOT.get()), has(ModItems.PLATIN_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PLATINIUM_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.PLATINIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.PLATINIUM_INGOT.get()), has(ModItems.PLATINIUM_INGOT.get()))
                .save(pWriter);

        // PLATIN GEARS :
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PLATIN_SWORD.get())
                .pattern(" S ")
                .pattern(" S ")
                .pattern(" A ")
                .define('S', ModItems.PLATIN_INGOT.get())
                .define('A', Items.STICK)
                .unlockedBy(getHasName(ModItems.PLATIN_INGOT.get()), has(ModItems.PLATIN_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PLATIN_PICKAXE.get())
                .pattern("SSS")
                .pattern(" A ")
                .pattern(" A ")
                .define('S', ModItems.PLATIN_INGOT.get())
                .define('A', Items.STICK)
                .unlockedBy(getHasName(ModItems.PLATIN_INGOT.get()), has(ModItems.PLATIN_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PLATIN_AXE.get())
                .pattern(" SS")
                .pattern(" AS")
                .pattern(" A ")
                .define('S', ModItems.PLATIN_INGOT.get())
                .define('A', Items.STICK)
                .unlockedBy(getHasName(ModItems.PLATIN_INGOT.get()), has(ModItems.PLATIN_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PLATIN_SHOVEL.get())
                .pattern(" S ")
                .pattern(" A ")
                .pattern(" A ")
                .define('S', ModItems.PLATIN_INGOT.get())
                .define('A', Items.STICK)
                .unlockedBy(getHasName(ModItems.PLATIN_INGOT.get()), has(ModItems.PLATIN_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PLATIN_HOE.get())
                .pattern(" SS")
                .pattern(" A ")
                .pattern(" A ")
                .define('S', ModItems.PLATIN_INGOT.get())
                .define('A', Items.STICK)
                .unlockedBy(getHasName(ModItems.PLATIN_INGOT.get()), has(ModItems.PLATIN_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PLATIN_HELMET.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("   ")
                .define('S', ModItems.PLATIN_INGOT.get())
                .unlockedBy(getHasName(ModItems.PLATIN_INGOT.get()), has(ModItems.PLATIN_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PLATIN_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.PLATIN_INGOT.get())
                .unlockedBy(getHasName(ModItems.PLATIN_INGOT.get()), has(ModItems.PLATIN_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PLATIN_LEGGINGS.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .define('S', ModItems.PLATIN_INGOT.get())
                .unlockedBy(getHasName(ModItems.PLATIN_INGOT.get()), has(ModItems.PLATIN_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PLATIN_BOOTS.get())
                .pattern("   ")
                .pattern("S S")
                .pattern("S S")
                .define('S', ModItems.PLATIN_INGOT.get())
                .unlockedBy(getHasName(ModItems.PLATIN_INGOT.get()), has(ModItems.PLATIN_INGOT.get()))
                .save(pWriter);

        // PLATINIUM GEARS
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PLATINIUM_SWORD.get())
                .pattern(" S ")
                .pattern(" S ")
                .pattern(" A ")
                .define('S', ModItems.PLATINIUM_INGOT.get())
                .define('A', Items.STICK)
                .unlockedBy(getHasName(ModItems.PLATINIUM_INGOT.get()), has(ModItems.PLATINIUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PLATINIUM_PICKAXE.get())
                .pattern("SSS")
                .pattern(" A ")
                .pattern(" A ")
                .define('S', ModItems.PLATINIUM_INGOT.get())
                .define('A', Items.STICK)
                .unlockedBy(getHasName(ModItems.PLATINIUM_INGOT.get()), has(ModItems.PLATINIUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PLATINIUM_AXE.get())
                .pattern(" SS")
                .pattern(" AS")
                .pattern(" A ")
                .define('S', ModItems.PLATINIUM_INGOT.get())
                .define('A', Items.STICK)
                .unlockedBy(getHasName(ModItems.PLATINIUM_INGOT.get()), has(ModItems.PLATINIUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PLATINIUM_SHOVEL.get())
                .pattern(" S ")
                .pattern(" A ")
                .pattern(" A ")
                .define('S', ModItems.PLATINIUM_INGOT.get())
                .define('A', Items.STICK)
                .unlockedBy(getHasName(ModItems.PLATINIUM_INGOT.get()), has(ModItems.PLATINIUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PLATINIUM_HOE.get())
                .pattern(" SS")
                .pattern(" A ")
                .pattern(" A ")
                .define('S', ModItems.PLATINIUM_INGOT.get())
                .define('A', Items.STICK)
                .unlockedBy(getHasName(ModItems.PLATINIUM_INGOT.get()), has(ModItems.PLATINIUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PLATINIUM_HELMET.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("   ")
                .define('S', ModItems.PLATINIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.PLATINIUM_INGOT.get()), has(ModItems.PLATINIUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PLATINIUM_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.PLATINIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.PLATINIUM_INGOT.get()), has(ModItems.PLATINIUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PLATINIUM_LEGGINGS.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .define('S', ModItems.PLATINIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.PLATINIUM_INGOT.get()), has(ModItems.PLATINIUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PLATINIUM_BOOTS.get())
                .pattern("   ")
                .pattern("S S")
                .pattern("S S")
                .define('S', ModItems.PLATINIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.PLATINIUM_INGOT.get()), has(ModItems.PLATINIUM_INGOT.get()))
                .save(pWriter);

    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  Extra_Ores.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
