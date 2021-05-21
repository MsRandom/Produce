package coda.produce.init;

import coda.produce.Produce;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ProduceFluids {
    public static final DeferredRegister<Fluid> REGISTER = DeferredRegister.create(ForgeRegistries.FLUIDS, Produce.MOD_ID);

    public static final RegistryObject<FlowingFluid> FLOWING_SMOOTHIE = REGISTER.register("flowing_smoothie", () -> new ForgeFlowingFluid.Flowing(ProduceFluids.SMOOTHIE_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SMOOTHIE = REGISTER.register("smoothie", () -> new ForgeFlowingFluid.Source(ProduceFluids.SMOOTHIE_PROPERTIES));
    private static final ForgeFlowingFluid.Properties SMOOTHIE_PROPERTIES = new ForgeFlowingFluid.Properties(SMOOTHIE, FLOWING_SMOOTHIE, FluidAttributes.Water.builder(new ResourceLocation(Produce.MOD_ID, "block/smoothie_still"), new ResourceLocation(Produce.MOD_ID, "block/smoothie_flowing")).density(1000).viscosity(1000)).bucket(ProduceItems.SMOOTHIE_BUCKET).explosionResistance(100).tickRate(15).block(ProduceBlocks.SMOOTHIE);
}
