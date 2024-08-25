package com.astrazoey.trirev.registry;

import com.astrazoey.trirev.TridentRevision;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class TridentItems {

    public static final Item ELDER_FRAGMENT = new Item(new Item.Settings());
    private static void addItemsToIngredientsTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(ELDER_FRAGMENT);
    }

    public static void registerItems() {
        Registry.register(Registries.ITEM, new Identifier(TridentRevision.MOD_ID, "elder_fragment"), ELDER_FRAGMENT);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(TridentItems::addItemsToIngredientsTabItemGroup);
    }
}
