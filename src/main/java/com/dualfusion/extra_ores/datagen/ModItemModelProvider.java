package com.dualfusion.extra_ores.datagen;

import com.dualfusion.extra_ores.Extra_Ores;
import com.dualfusion.extra_ores.block.ModBlocks;
import com.dualfusion.extra_ores.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Extra_Ores.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        // PLATIN ITEMS :
        simpleItem(ModItems.PLATIN_INGOT);
        simpleItem(ModItems.PLATIN_NUGGET);
        simpleItem(ModItems.RAW_PLATIN);

        // PLATINIUM ITEMS :
        simpleItem(ModItems.PLATINIUM_INGOT);
        simpleItem(ModItems.PLATINIUM_NUGGET);
        simpleItem(ModItems.PLATINIUM_COMPONENT);

        // BLOCKS + ORE :
        evenSimplerBlockItem(ModBlocks.PLATIN_BLOCK);
        evenSimplerBlockItem(ModBlocks.PLATINIUM_BLOCK);
        evenSimplerBlockItem(ModBlocks.PLATIN_ORE);
        evenSimplerBlockItem(ModBlocks.DEEPSLATE_PLATIN_ORE);

        // PLATIN GEARS :
        handheldItem(ModItems.PLATIN_SWORD);
        handheldItem(ModItems.PLATIN_PICKAXE);
        handheldItem(ModItems.PLATIN_AXE);
        handheldItem(ModItems.PLATIN_SHOVEL);
        handheldItem(ModItems.PLATIN_HOE);

        trimmedArmorItem(ModItems.PLATIN_CHESTPLATE);
        trimmedArmorItem(ModItems.PLATIN_HELMET);
        trimmedArmorItem(ModItems.PLATIN_LEGGINGS);
        trimmedArmorItem(ModItems.PLATIN_BOOTS);

        // PLATINIUM GEARS :
        handheldItem(ModItems.PLATINIUM_SWORD);
        handheldItem(ModItems.PLATINIUM_PICKAXE);
        handheldItem(ModItems.PLATINIUM_AXE);
        handheldItem(ModItems.PLATINIUM_SHOVEL);
        handheldItem(ModItems.PLATINIUM_HOE);

        trimmedArmorItem(ModItems.PLATINIUM_CHESTPLATE);
        trimmedArmorItem(ModItems.PLATINIUM_HELMET);
        trimmedArmorItem(ModItems.PLATINIUM_LEGGINGS);
        trimmedArmorItem(ModItems.PLATINIUM_BOOTS);

    }

    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = Extra_Ores.MOD_ID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = new ResourceLocation(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);

                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                new ResourceLocation(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Extra_Ores.MOD_ID,"item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(Extra_Ores.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(Extra_Ores.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Extra_Ores.MOD_ID,"item/" + item.getId().getPath()));
    }
}
