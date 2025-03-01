package com.dualfusion.extra_ores.item;

import com.dualfusion.extra_ores.Extra_Ores;
import com.dualfusion.extra_ores.block.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Extra_Ores.MOD_ID);

    public static final RegistryObject<Item> PLATIN_INGOT = ITEMS.register("platin_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_PLATIN = ITEMS.register("raw_platin",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATIN_NUGGET = ITEMS.register("platin_nugget",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PLATINIUM_SWORD = ITEMS.register("platinium_sword",
            () -> new SwordItem(ModToolTiers.PLATINIUM,3, -2.4F, new Item.Properties()));

    public static final RegistryObject<BlockItem> PLATIN_ORE_ITEM = ITEMS.register("platin_ore_item",
            () -> new BlockItem(ModBlocks.PLATIN_ORE.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> DEEPSLATE_PLATIN_ORE_ITEM = ITEMS.register("deepslate_platin_ore_item",
            () -> new BlockItem(ModBlocks.DEEPSLATE_PLATIN_ORE.get(), new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}