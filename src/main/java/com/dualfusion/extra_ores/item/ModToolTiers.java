package com.dualfusion.extra_ores.item;

import com.dualfusion.extra_ores.Extra_Ores;
import com.dualfusion.extra_ores.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier PLATINIUM = TierSortingRegistry.registerTier(
            new ForgeTier(4, 2684, 10f, 5f, 25,
                ModTags.Blocks.NEEDS_PLATINIUM_TOOLS, () -> Ingredient.of(ModItems.PLATIN_INGOT.get())),
            new ResourceLocation(Extra_Ores.MOD_ID, "platinium"), List.of(Tiers.NETHERITE), List.of());
}
