package coda.produce.init;

import coda.produce.Produce;
import coda.produce.entity.CauliflowerSheepEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ProduceEntities {

    public static final DeferredRegister<EntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.ENTITIES, Produce.MOD_ID);

    public static final RegistryObject<EntityType<CauliflowerSheepEntity>> CAULIFLOWER_SHEEP = create("cauliflower_sheep", EntityType.Builder.create(CauliflowerSheepEntity::new, EntityClassification.CREATURE).size(1.2F,1.3F));

    private static <T extends Entity> RegistryObject<EntityType<T>> create(String name, EntityType.Builder<T> builder) {
        return REGISTER.register(name, () -> builder.build(Produce.MOD_ID + "." + name));
    }
}
