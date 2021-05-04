package coda.produce;

import coda.produce.init.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Produce.MOD_ID)
public class Produce {
    public static final String MOD_ID = "produce";

    public Produce() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ProduceBlocks.REGISTER.register(bus);
        ProduceItems.REGISTER.register(bus);
        ProduceFluids.REGISTER.register(bus);
        ProduceFoliagePlacers.REGISTER.register(bus);
        ProduceFeatures.REGISTER.register(bus);
    }
}
