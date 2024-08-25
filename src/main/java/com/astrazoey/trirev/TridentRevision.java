package com.astrazoey.trirev;

import com.astrazoey.trirev.registry.TridentItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;

public class TridentRevision implements ModInitializer {

    public static final String MOD_ID = "trirev";


    private static final Identifier ELDER_GUARDIAN_LOOT_TABLE_ID = EntityType.ELDER_GUARDIAN.getLootTableId();


    @Override
    public void onInitialize() {
        TridentItems.registerItems();

        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && ELDER_GUARDIAN_LOOT_TABLE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .with(ItemEntry.builder(TridentItems.ELDER_FRAGMENT));

                tableBuilder.pool(poolBuilder);
            }
        });


    }

}
