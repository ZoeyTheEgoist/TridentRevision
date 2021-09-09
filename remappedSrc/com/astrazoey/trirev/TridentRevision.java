package com.astrazoey.trirev;

import com.astrazoey.trirev.registry.TridentItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;

public class TridentRevision implements ModInitializer {

    public static final String MOD_ID = "trirev";


    private static final Identifier ELDER_GUARDIAN_LOOT_TABLE_ID = EntityType.ELDER_GUARDIAN.getLootTableId();


    @Override
    public void onInitialize() {
        TridentItems.registerItems();

        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, table, setter) -> {
            if (ELDER_GUARDIAN_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(TridentItems.ELDER_FRAGMENT));
                table.pool(poolBuilder);
            }
        });

    }

}
