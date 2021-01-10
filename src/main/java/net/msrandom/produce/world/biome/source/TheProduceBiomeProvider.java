package net.msrandom.produce.world.biome.source;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.server.ServerWorld;
import net.msrandom.produce.ProduceMod;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;

public class TheProduceBiomeProvider extends BiomeProvider {
    public static final Codec<TheProduceBiomeProvider> CODEC = RecordCodecBuilder.create(provider -> provider.group(
                    Biome.BIOMES_CODEC.fieldOf("biomes").forGetter(produceProvider -> produceProvider.biomeList),
                    RegistryLookupCodec.getLookUpCodec(Registry.BIOME_KEY).forGetter(produceProvider -> produceProvider.lookupRegistry)
    ).apply(provider, (biomes, lookupRegistry) -> new TheProduceBiomeProvider(null, biomes, lookupRegistry)));

    private final List<Supplier<Biome>> biomeList;
    private final AtomicLong seedReference;
    private final Registry<Biome> lookupRegistry;

    protected TheProduceBiomeProvider(AtomicLong seed, List<Supplier<Biome>> biomes, Registry<Biome> lookupRegistry) {
        super(biomes.stream());
        seedReference = seed;
        biomeList = biomes;
        this.lookupRegistry = lookupRegistry;
    }

    @Override
    protected Codec<? extends BiomeProvider> getBiomeProviderCodec() {
        return CODEC;
    }

    @Override
    public BiomeProvider getBiomeProvider(long seed) {
        return new TheProduceBiomeProvider(new AtomicLong(seed), biomeList, lookupRegistry);
    }

    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        Biome sea = biomes.get(0);
        long seed;
        if (seedReference == null) {
            if (ProduceMod.server == null) {
                return sea;
            }

            ServerWorld world = ProduceMod.server.getWorld(ProduceMod.getDimensionKey());
            if (world == null) {
                return sea;
            }
            seed = world.getSeed();
        } else {
            seed = seedReference.get();
        }
        long area = seed + (x >> 7 ^ z >> 7) >> 2;
        for (int i = biomes.size(); i > 0; i--) {
            if (area % (i + 1) == 0) {
                return biomes.get(i - 1);
            }
        }
        return sea;
    }
}
