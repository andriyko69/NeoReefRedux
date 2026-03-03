package io.github.andriyko69.neoreefredux;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@EventBusSubscriber(modid = NeoReefRedux.MOD_ID)
public final class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.BooleanValue DISABLE_VANILLA_CORALS;

    static {
        BUILDER.push("worldgen");

        DISABLE_VANILLA_CORALS = BUILDER
                .comment("If true, vanilla corals will not generate in the world.")
                .define("disableVanillaCorals", false);

        BUILDER.pop();
    }

    public static final ModConfigSpec SPEC = BUILDER.build();

    public static boolean disableVanillaCorals;

    @SubscribeEvent
    static void onConfigLoading(final ModConfigEvent.Loading event) {
        if (event.getConfig().getSpec() != SPEC) return;
        bake();
    }

    @SubscribeEvent
    static void onConfigReloading(final ModConfigEvent.Reloading event) {
        if (event.getConfig().getSpec() != SPEC) return;
        bake();
    }

    private static void bake() {
        disableVanillaCorals = DISABLE_VANILLA_CORALS.get();
    }
}