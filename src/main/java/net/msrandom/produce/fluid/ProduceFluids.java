package net.msrandom.produce.fluid;

import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.msrandom.produce.ProduceMod;
import net.msrandom.produce.block.ProduceBlocks;
import net.msrandom.produce.item.ProduceItems;

public class ProduceFluids {
    public static final DeferredRegister<Fluid> REGISTRAR = DeferredRegister.create(ForgeRegistries.FLUIDS, ProduceMod.MOD_ID);
    public static final RegistryObject<FlowingFluid> FLOWING_SMOOTHIE = REGISTRAR.register("flowing_smoothie", () -> new ForgeFlowingFluid.Flowing(ProduceFluids.SMOOTHIE_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SMOOTHIE = REGISTRAR.register("smoothie", () -> new ForgeFlowingFluid.Source(ProduceFluids.SMOOTHIE_PROPERTIES));
    private static final ForgeFlowingFluid.Properties SMOOTHIE_PROPERTIES = new ForgeFlowingFluid.Properties(SMOOTHIE, FLOWING_SMOOTHIE, FluidAttributes.builder(new ResourceLocation(""), new ResourceLocation("")).density(100).viscosity(1500)).bucket(ProduceItems.SMOOTHIE_BUCKET).explosionResistance(100).tickRate(20).block(ProduceBlocks.SMOOTHIE);
}
