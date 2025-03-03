package com.dualfusion.extra_ores.datagen;

import com.dualfusion.extra_ores.Extra_Ores;
import com.dualfusion.extra_ores.item.ModItems;
import com.dualfusion.extra_ores.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.macosx.MacOSXLibraryDL;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                               CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, Extra_Ores.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ItemTags.PICKAXES).add(ModItems.PLATINIUM_PICKAXE.get())
                .add(ModItems.PLATIN_PICKAXE.get());
        tag(ItemTags.SWORDS).add(ModItems.PLATINIUM_SWORD.get());
        tag(ItemTags.AXES).add(ModItems.PLATINIUM_AXE.get());
        tag(ItemTags.SHOVELS).add(ModItems.PLATINIUM_SHOVEL.get());
        tag(ItemTags.HOES).add(ModItems.PLATINIUM_HOE.get());
    }
}