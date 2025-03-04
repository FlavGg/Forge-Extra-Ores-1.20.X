package com.dualfusion.extra_ores.item;

import com.dualfusion.extra_ores.Extra_Ores;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Extra_Ores.MOD_ID);

    public static final RegistryObject<CreativeModeTab> EO_TAB = CREATIVE_MODE_TABS.register("eo_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PLATIN_INGOT.get()))
                    .title(Component.translatable("creativetab.eo_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.PLATINIUM_SWORD.get());
                        output.accept(ModItems.PLATINIUM_PICKAXE.get());
                        output.accept(ModItems.PLATINIUM_AXE.get());
                        output.accept(ModItems.PLATINIUM_SHOVEL.get());
                        output.accept(ModItems.PLATINIUM_HOE.get());
                        output.accept(ModItems.PLATINIUM_HELMET.get());
                        output.accept(ModItems.PLATINIUM_CHESTPLATE.get());
                        output.accept(ModItems.PLATINIUM_LEGGINGS.get());
                        output.accept(ModItems.PLATINIUM_BOOTS.get());
                        output.accept(ModItems.PLATIN_PICKAXE.get());
                        output.accept(ModItems.PLATIN_ORE.get());
                        output.accept(ModItems.DEEPSLATE_PLATIN_ORE.get());
                        output.accept(ModItems.RAW_PLATIN.get());
                        output.accept(ModItems.PLATIN_BLOCK.get());
                        output.accept(ModItems.PLATIN_INGOT.get());
                        output.accept(ModItems.PLATIN_NUGGET.get());
                        output.accept(ModItems.PLATINIUM_BLOCK.get());
                        output.accept(ModItems.PLATINIUM_INGOT.get());
                        output.accept(ModItems.PLATINIUM_COMPONENT.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}