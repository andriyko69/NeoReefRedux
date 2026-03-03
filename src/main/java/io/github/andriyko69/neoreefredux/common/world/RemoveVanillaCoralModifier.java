package io.github.andriyko69.neoreefredux.common.world;

import com.mojang.serialization.MapCodec;
import io.github.andriyko69.neoreefredux.Config;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.ModifiableBiomeInfo;
import org.jetbrains.annotations.NotNull;

public record RemoveVanillaCoralModifier() implements BiomeModifier {

    public static final MapCodec<RemoveVanillaCoralModifier> CODEC =
            MapCodec.unit(RemoveVanillaCoralModifier::new);

    private static ResourceKey<PlacedFeature> pf(String id) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath("minecraft", id));
    }

    @Override
    public void modify(@NotNull Holder<Biome> biome, @NotNull Phase phase, ModifiableBiomeInfo.BiomeInfo.@NotNull Builder builder) {
        if (!Config.disableVanillaCorals) return;
        if (phase != Phase.REMOVE) return;
        if (!biome.is(net.minecraft.tags.BiomeTags.IS_OCEAN)) return;

        var features = builder.getGenerationSettings().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);

        features.removeIf(holder ->
                holder.is(pf("coral_tree")) ||
                        holder.is(pf("coral_claw")) ||
                        holder.is(pf("coral_mushroom")) ||
                        holder.is(pf("warm_ocean_vegetation"))
        );
    }

    @Override
    public @NotNull MapCodec<? extends BiomeModifier> codec() {
        return CODEC;
    }
}