package coda.produce.init;

import coda.produce.world.gen.foliage.ChardwoodFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import coda.produce.Produce;

public class ProduceFoliagePlacers {
    public static final DeferredRegister<FoliagePlacerType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.FOLIAGE_PLACER_TYPES, Produce.MOD_ID);
     public static final RegistryObject<FoliagePlacerType<ChardwoodFoliagePlacer>> CHARDWOOD_FOLIAGE_PLACER = REGISTER.register("chardwood_foliage_placer", () -> new FoliagePlacerType<>(ChardwoodFoliagePlacer.CODEC));
}
