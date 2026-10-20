package net.treyvon.insomniacharm;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@EventBusSubscriber(modid = InsomniaCharm.MOD_ID)
public class Config
{
    // The builder collects all config entries. Each define call adds one option,
    // and BUILDER.build() later turns them into the finished spec.
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    // Defines an integer option named "insomniaValue" in the config file.
    // Default is 20, and the value is within the range 0-24000.
    private static final ModConfigSpec.IntValue INSOMNIA_VALUE = BUILDER
            .comment("Number of ticks a player must go without sleeping before their insomnia effect is reset")
            .defineInRange("insomniaValue", 60000, 0, 72000);


    // The finished, immutable spec.
    static final ModConfigSpec SPEC = BUILDER.build();


    // Copy of the config value for use elsewhere in the mod.
    public static int insomniaValue;

    // Called whenever the config is loaded or reloaded. Copies the current value from the spec into the static
    // field above so the rest of the mod can read it quickly without calling .get() each time.
    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        insomniaValue = INSOMNIA_VALUE.get();
    }
}