package net.treyvon.insomniacharm.item.custom;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.player.Player;

import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import static net.treyvon.insomniacharm.Config.insomniaValue;

public class CharmItem extends Item implements ICurioItem{
    public CharmItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {

        // Check if the player is a ServerPlayer (to avoid client-side issues)
        if (slotContext.entity() instanceof ServerPlayer serverPlayer) {
            int timeSinceLastRest = serverPlayer.getStats().getValue(Stats.CUSTOM.get(Stats.TIME_SINCE_REST));

            // Check if the stat is over the insomniaValue
            if (timeSinceLastRest > insomniaValue) {
                // Reset the "time since last rest" stat
                serverPlayer.resetStat(Stats.CUSTOM.get(Stats.TIME_SINCE_REST));
            }
        }
    }
}





