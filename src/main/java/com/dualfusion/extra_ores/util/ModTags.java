package com.dualfusion.extra_ores.util;

import com.dualfusion.extra_ores.Extra_Ores;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_PLATINIUM_TOOLS = tag("needs_platinium_tools");


        public static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Extra_Ores.MOD_ID, name));
        }
    }

}
