package net.msrandom.produce;

import net.minecraft.server.MinecraftServer;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.msrandom.produce.block.ProduceBlocks;
import net.msrandom.produce.fluid.ProduceFluids;
import net.msrandom.produce.item.ProduceItems;
import net.msrandom.produce.world.biome.source.TheProduceBiomeProvider;
import net.msrandom.produce.world.gen.foliage.ProduceFoliagePlacers;

import java.util.concurrent.atomic.AtomicReference;

@Mod(ProduceMod.MOD_ID)
public class ProduceMod {
    public static final String MOD_ID = "produce";
    public static MinecraftServer server;
    private static final AtomicReference<RegistryKey<World>> keyReference = new AtomicReference<>();

    public ProduceMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ProduceBlocks.REGISTRAR.register(bus);
        ProduceItems.REGISTRAR.register(bus);
        ProduceFluids.REGISTRAR.register(bus);
        ProduceFoliagePlacers.REGISTRAR.register(bus);
        Registry.register(Registry.BIOME_PROVIDER_CODEC, new ResourceLocation(MOD_ID, "the_produce"), TheProduceBiomeProvider.CODEC);
    }

    public static RegistryKey<World> getDimensionKey() {
        if (keyReference.get() == null) {
            keyReference.set(RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation(MOD_ID, "the_produce")));
        }
        return keyReference.get();
    }
}
