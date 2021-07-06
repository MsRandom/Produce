package coda.produce;

import coda.produce.client.ClientEvents;
import coda.produce.entity.CauliflowerSheepEntity;
import coda.produce.init.*;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Produce.MOD_ID)
public class Produce {
    public static final String MOD_ID = "produce";

    public Produce() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.addListener(this::registerClient);
        bus.addListener(this::registerEntityAttributes);
        bus.addListener(this::registerCommon);

        ProduceBlocks.REGISTER.register(bus);
        ProduceSurfaceBuilders.REGISTER.register(bus);
        ProduceCarvers.REGISTER.register(bus);
        ProduceItems.REGISTER.register(bus);
        ProduceEntities.REGISTER.register(bus);
        ProduceFeatures.REGISTER.register(bus);
        ProduceFluids.REGISTER.register(bus);
    }

    private void registerEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(ProduceEntities.CAULIFLOWER_SHEEP.get(), CauliflowerSheepEntity.createAttributes().build());
        event.put(ProduceEntities.STRAWBERRISH.get(), AbstractFishEntity.createAttributes().build());
        event.put(ProduceEntities.BLUEBERRISH.get(), AbstractFishEntity.createAttributes().build());
    }

    private void registerCommon(FMLCommonSetupEvent event) {
        EntitySpawnPlacementRegistry.register(ProduceEntities.CAULIFLOWER_SHEEP.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, CauliflowerSheepEntity::canSheepSpawn);
        EntitySpawnPlacementRegistry.register(ProduceEntities.STRAWBERRISH.get(), EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AbstractFishEntity::checkFishSpawnRules);
        EntitySpawnPlacementRegistry.register(ProduceEntities.BLUEBERRISH.get(), EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AbstractFishEntity::checkFishSpawnRules);
    }

    private void registerClient(FMLClientSetupEvent event) {
        ClientEvents.init();
    }

    public static final ItemGroup GROUP = new ItemGroup(Produce.MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ProduceBlocks.LEAFY_GREEN_LEAVES.get());
        }
    };
}
