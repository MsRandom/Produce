package coda.produce.init;

import coda.produce.Produce;
import coda.produce.world.surfacebuilder.BrockoliVolcanoesSurfaceBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ProduceSurfaceBuilders {
    private static final BlockState BROCKOLI = ProduceBlocks.BROCKOLI_BLOCK.getDefaultState();
    private static final BlockState CHARRED_BROCKOLI = ProduceBlocks.CHARRED_BROCKOLI_BLOCK.getDefaultState();

    public static final DeferredRegister<SurfaceBuilder<?>> REGISTER = DeferredRegister.create(ForgeRegistries.SURFACE_BUILDERS, Produce.MOD_ID);

    public static final RegistryObject<SurfaceBuilder<SurfaceBuilderConfig>> BROCKOLI_VOLCANOES = REGISTER.register("brockoli_volcanoes", () -> new BrockoliVolcanoesSurfaceBuilder(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilderConfig CHARRED_BROCKOLI_CONFIG = new SurfaceBuilderConfig(CHARRED_BROCKOLI, CHARRED_BROCKOLI, CHARRED_BROCKOLI);
    public static final SurfaceBuilderConfig BROCKOLI_CONFIG = new SurfaceBuilderConfig(BROCKOLI, BROCKOLI, BROCKOLI);

}