package coda.produce;

import coda.produce.client.ClientEvents;
import coda.produce.entity.CauliflowerSheepEntity;
import coda.produce.init.*;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Produce.MOD_ID)
public class Produce {
    public static final String MOD_ID = "produce";

    public Produce() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.addListener(this::registerClient);
        bus.addListener(this::registerEntityAttributes);

        ProduceBlocks.REGISTER.register(bus);
        ProduceSurfaceBuilders.REGISTER.register(bus);
        ProduceCarvers.REGISTER.register(bus);
        ProduceItems.REGISTER.register(bus);
        ProduceEntities.REGISTER.register(bus);
        ProduceFeatures.REGISTER.register(bus);
        ProduceFluids.REGISTER.register(bus);
        ProduceFoliagePlacers.REGISTER.register(bus);
    }

    private void registerEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(ProduceEntities.CAULIFLOWER_SHEEP.get(), CauliflowerSheepEntity.createAttributes().create());
    }

    private void registerClient(FMLClientSetupEvent event) {
        ClientEvents.init();
    }

    public static final ItemGroup GROUP = new ItemGroup(Produce.MOD_ID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ProduceBlocks.LEAFY_GREEN_LEAVES.get());
        }
    };
}
