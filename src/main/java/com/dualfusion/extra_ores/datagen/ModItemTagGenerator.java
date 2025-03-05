package com.dualfusion.extra_ores.datagen;

import com.dualfusion.extra_ores.Extra_Ores;
import com.dualfusion.extra_ores.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                               CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, Extra_Ores.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ItemTags.PICKAXES).add(ModItems.PLATINIUM_PICKAXE.get(),
                (ModItems.PLATIN_PICKAXE.get()));

        tag(ItemTags.SWORDS).add(ModItems.PLATINIUM_SWORD.get(),
                (ModItems.PLATIN_SWORD.get()));

        tag(ItemTags.AXES).add(ModItems.PLATINIUM_AXE.get(),
                (ModItems.PLATIN_AXE.get()));

        tag(ItemTags.SHOVELS).add(ModItems.PLATINIUM_SHOVEL.get(),
                (ModItems.PLATIN_SHOVEL.get()));

        tag(ItemTags.HOES).add(ModItems.PLATINIUM_HOE.get(),
                (ModItems.PLATIN_HOE.get()));

        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.PLATINIUM_HELMET.get(),
                        ModItems.PLATINIUM_CHESTPLATE.get(),
                        ModItems.PLATINIUM_LEGGINGS.get(),
                        ModItems.PLATINIUM_BOOTS.get(),
                        ModItems.PLATIN_HELMET.get(),
                        ModItems.PLATIN_CHESTPLATE.get(),
                        ModItems.PLATINIUM_LEGGINGS.get(),
                        ModItems.PLATINIUM_BOOTS.get());


    }
}