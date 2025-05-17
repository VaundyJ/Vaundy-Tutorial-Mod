package net.vaundyj.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.vaundyj.tutorialmod.TutorialMod;
import net.vaundyj.tutorialmod.block.ModBlocks;

public class ModItemGroups {

    public static final ItemGroup TUTORIAL_MOD_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "tutorial_mod_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.SILVERBOLT))
                    .displayName(Text.translatable("itemgroup.tutorialmod.tutorial_mod_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.SILVER);
                        entries.add(ModItems.RAW_SILVER);
                        entries.add(ModItems.SILVERBOLT);
                        entries.add(ModBlocks.SILVER_ORE);
                        entries.add(ModBlocks.SILVER_BLOCK);
                        entries.add(ModBlocks.DEEPSLATE_SILVER_ORE);
                        entries.add(ModBlocks.RAW_SILVER_BLOCK);

                    }).build());

    public static void registerItemGroups(){
        TutorialMod.LOGGER.info("Registering Item Group for " + TutorialMod.MOD_ID);
    }
}
