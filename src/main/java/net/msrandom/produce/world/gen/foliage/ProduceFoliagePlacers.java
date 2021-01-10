package net.msrandom.produce.world.gen.foliage;

import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.msrandom.produce.ProduceMod;

public class ProduceFoliagePlacers {
    public static final DeferredRegister<FoliagePlacerType<?>> REGISTRAR = DeferredRegister.create(ForgeRegistries.FOLIAGE_PLACER_TYPES, ProduceMod.MOD_ID);
    public static final RegistryObject<FoliagePlacerType<ChardwoodFoliagePlacer>> CHARDWOOD_FOLIAGE_PLACER = REGISTRAR.register("chardwood_foliage_placer", () -> new FoliagePlacerType<>(ChardwoodFoliagePlacer.CODEC));
}
