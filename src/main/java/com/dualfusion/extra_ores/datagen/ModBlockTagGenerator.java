package com.dualfusion.extra_ores.datagen;

import com.dualfusion.extra_ores.Extra_Ores;
import com.dualfusion.extra_ores.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Extra_Ores.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.PLATIN_BLOCK.get())
                .add(ModBlocks.PLATIN_ORE.get())
                .add(ModBlocks.DEEPSLATE_PLATIN_ORE.get())
                .add(ModBlocks.PLATINIUM_BLOCK.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.PLATIN_BLOCK.get())
                .add(ModBlocks.PLATIN_ORE.get())
                .add(ModBlocks.DEEPSLATE_PLATIN_ORE.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.PLATINIUM_BLOCK.get());

    }
}
