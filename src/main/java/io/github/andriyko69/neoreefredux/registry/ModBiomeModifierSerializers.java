package io.github.andriyko69.neoreefredux.registry;

import com.mojang.serialization.MapCodec;
import io.github.andriyko69.neoreefredux.NeoReefRedux;
import io.github.andriyko69.neoreefredux.common.world.RemoveVanillaCoralModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModBiomeModifierSerializers {
    public static final DeferredRegister<MapCodec<? extends net.neoforged.neoforge.common.world.BiomeModifier>> BIOME_MODIFIER_SERIALIZERS =
            DeferredRegister.create(NeoForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, NeoReefRedux.MOD_ID);

    public static final DeferredHolder<MapCodec<? extends net.neoforged.neoforge.common.world.BiomeModifier>, MapCodec<RemoveVanillaCoralModifier>> REMOVE_VANILLA_CORAL =
            BIOME_MODIFIER_SERIALIZERS.register("remove_vanilla_coral", () -> RemoveVanillaCoralModifier.CODEC);
}