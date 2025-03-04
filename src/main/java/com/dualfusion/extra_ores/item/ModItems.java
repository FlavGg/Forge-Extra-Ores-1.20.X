package com.dualfusion.extra_ores.item;

import com.dualfusion.extra_ores.Extra_Ores;
import com.dualfusion.extra_ores.block.ModBlocks;
import net.minecraft.world.item.*;
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

    public static final RegistryObject<Item> PLATIN_PICKAXE = ITEMS.register("platin_pickaxe",
            () -> new PickaxeItem(ModToolTiers.PLATIN, 1, -2.8F, new Item.Properties()));

    public static final RegistryObject<Item> PLATINIUM_COMPONENT = ITEMS.register("platinium_component",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATINIUM_INGOT = ITEMS.register("platinium_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PLATINIUM_SWORD = ITEMS.register("platinium_sword",
            () -> new SwordItem(ModToolTiers.PLATINIUM,3, -2.2F, new Item.Properties()));
    public static final RegistryObject<Item> PLATINIUM_AXE = ITEMS.register("platinium_axe",
            () -> new AxeItem(ModToolTiers.PLATINIUM, 5, -3F, new Item.Properties()));
    public static final RegistryObject<Item> PLATINIUM_SHOVEL = ITEMS.register("platinium_shovel",
            () -> new ShovelItem(ModToolTiers.PLATINIUM, 1, -3F, new Item.Properties()));
    public static final RegistryObject<Item> PLATINIUM_PICKAXE = ITEMS.register("platinium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.PLATINIUM, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> PLATINIUM_HOE = ITEMS.register("platinium_hoe",
            () -> new HoeItem(ModToolTiers.PLATINIUM, -4, 0, new Item.Properties()));
    public static final RegistryObject<Item> PLATINIUM_HELMET = ITEMS.register("platinium_helmet",
            () -> new ArmorItem(ModArmorMaterials.PLATINIUM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> PLATINIUM_CHESTPLATE = ITEMS.register("platinium_chestplate",
            () -> new ArmorItem(ModArmorMaterials.PLATINIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> PLATINIUM_LEGGINGS = ITEMS.register("platinium_leggings",
            () -> new ArmorItem(ModArmorMaterials.PLATINIUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> PLATINIUM_BOOTS = ITEMS.register("platinium_boots",
            () -> new ArmorItem(ModArmorMaterials.PLATINIUM, ArmorItem.Type.BOOTS, new Item.Properties()));


    public static final RegistryObject<BlockItem> PLATIN_ORE = ITEMS.register("platin_ore",
            () -> new BlockItem(ModBlocks.PLATIN_ORE.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> DEEPSLATE_PLATIN_ORE = ITEMS.register("deepslate_platin_ore",
            () -> new BlockItem(ModBlocks.DEEPSLATE_PLATIN_ORE.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> PLATIN_BLOCK = ITEMS.register("platin_block",
            () -> new BlockItem(ModBlocks.PLATIN_BLOCK.get(), new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}