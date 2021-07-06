package coda.produce.init;

import coda.produce.Produce;
import coda.produce.world.carver.ProduceCaveWorldCarver;
import coda.produce.world.carver.VolcanoesCanyonWorldCarver;
import coda.produce.world.surfacebuilder.BrockoliVolcanoesSurfaceBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.carver.EmptyCarverConfig;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ProduceCarvers {
    public static final DeferredRegister<WorldCarver<?>> REGISTER = DeferredRegister.create(ForgeRegistries.WORLD_CARVERS, Produce.MOD_ID);

    public static final RegistryObject<WorldCarver<ProbabilityConfig>> VOLCANOES_CANYON_CARVER = REGISTER.register("volcanoes_carver", () -> new VolcanoesCanyonWorldCarver(ProbabilityConfig.CODEC));
    public static final RegistryObject<WorldCarver<ProbabilityConfig>> PRODUCE_CAVE_CARVER = REGISTER.register("produce_cave_carver", () -> new ProduceCaveWorldCarver(ProbabilityConfig.CODEC));

}
