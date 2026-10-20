package net.treyvon.insomniacharm;

import net.minecraft.world.item.CreativeModeTabs;
import net.treyvon.insomniacharm.item.ModItems;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;


// Marks this as the entry point of the mod.
@Mod(InsomniaCharm.MOD_ID)
public class InsomniaCharm
{
    // The mod's unique ID.
    public static final String MOD_ID = "insomniacharm";

    public InsomniaCharm(IEventBus modEventBus, ModContainer modContainer)
    {
        // Hooks the item DeferredRegister into the mod event bus so that our items
        // are actually registered with the game at the right time during startup.
        ModItems.register(modEventBus);

        // Listens for the event fired when creative tab contents are being built,
        // so we can add our items to the tabs.
        modEventBus.addListener(this::addCreative);

        // Registers the config spec so FML creates and loads the config file.
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }


    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        // Adds the charm to the Tools & Utilities tab.
        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.CHARMINSOMNIA);
        }
    }
}
