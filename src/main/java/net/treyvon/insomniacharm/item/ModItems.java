package net.treyvon.insomniacharm.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.treyvon.insomniacharm.InsomniaCharm;
import net.treyvon.insomniacharm.item.custom.CharmItem;

public class ModItems {
    // Creates the deferred register that holds all of this mod's items.
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(InsomniaCharm.MOD_ID);

    // Registers the charm item under the name "insomniacharm".
    public static final DeferredItem<Item> CHARMINSOMNIA = ITEMS.registerItem("insomniacharm", CharmItem::new,
            new Item.Properties().stacksTo(1));

    // Called from the main mod class constructor. Attaches the register to the mod event bus
    // so the items above are actually registered when the game fires its registry event.
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
