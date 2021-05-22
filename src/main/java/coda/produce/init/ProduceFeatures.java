package coda.produce.init;

import coda.produce.Produce;
import coda.produce.entity.CauliflowerSheepEntity;
import coda.produce.world.feature.LeafyGreenTreeFeatureButGood;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ProduceFeatures
{

    public static final DeferredRegister<Feature<?>> REGISTER = DeferredRegister.create(ForgeRegistries.FEATURES, Produce.MOD_ID);
    public static final LeafyGreenTreeFeatureButGood LEAFY_TREE = new LeafyGreenTreeFeatureButGood();
}
