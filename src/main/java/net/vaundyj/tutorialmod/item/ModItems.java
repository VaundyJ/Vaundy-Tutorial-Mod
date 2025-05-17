package net.vaundyj.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.vaundyj.tutorialmod.TutorialMod;

public class ModItems {
    public static final Item SILVER = registerItem( "silver", new Item(new Item.Settings()));
    public static final Item RAW_SILVER = registerItem( "raw_silver", new Item(new Item.Settings()));
    public static final Item SILVERBOLT = registerItem("silverbolt", new Item(new Item.Settings()));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(SILVER);
            entries.add(RAW_SILVER);


    });
    }
}
