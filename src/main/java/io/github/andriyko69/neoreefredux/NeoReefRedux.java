package io.github.andriyko69.neoreefredux;

import io.github.andriyko69.neoreefredux.registry.ModBiomeModifierSerializers;
import io.github.andriyko69.neoreefredux.registry.ModFeatures;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

@Mod(NeoReefRedux.MOD_ID)
public class NeoReefRedux {
    public static final String MOD_ID = "neoreefredux";

    public NeoReefRedux(IEventBus modEventBus, ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        ModFeatures.FEATURES.register(modEventBus);
        ModBiomeModifierSerializers.BIOME_MODIFIER_SERIALIZERS.register(modEventBus);
    }
}
