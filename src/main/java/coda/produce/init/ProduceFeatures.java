package coda.produce.init;

import coda.produce.Produce;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ProduceFeatures {
    public static final DeferredRegister<Feature<?>> REGISTER = DeferredRegister.create(ForgeRegistries.FEATURES, Produce.MOD_ID);

//    public static final RegistryObject<LeafyGreenTreeFeature> LEAFY_GREEN_TREE = REGISTER.register("leafy_green_tree", LeafyGreenTreeFeature::new);

}
