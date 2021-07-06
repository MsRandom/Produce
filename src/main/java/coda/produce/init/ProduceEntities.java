package coda.produce.init;

import coda.produce.Produce;
import coda.produce.entity.BlueberrishEntity;
import coda.produce.entity.CauliflowerSheepEntity;
import coda.produce.entity.StrawberrishEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ProduceEntities {

    public static final DeferredRegister<EntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.ENTITIES, Produce.MOD_ID);

    public static final RegistryObject<EntityType<CauliflowerSheepEntity>> CAULIFLOWER_SHEEP = create("cauliflower_sheep", EntityType.Builder.of(CauliflowerSheepEntity::new, EntityClassification.CREATURE).sized(1.2F,1.3F));
    public static final RegistryObject<EntityType<BlueberrishEntity>> BLUEBERRISH = create("blueberrish_sheep", EntityType.Builder.of(BlueberrishEntity::new, EntityClassification.WATER_AMBIENT).sized(0.4F,0.4F));
    public static final RegistryObject<EntityType<StrawberrishEntity>> STRAWBERRISH = create("strawberrish_sheep", EntityType.Builder.of(StrawberrishEntity::new, EntityClassification.WATER_AMBIENT).sized(0.4F,0.4F));

    private static <T extends Entity> RegistryObject<EntityType<T>> create(String name, EntityType.Builder<T> builder) {
        return REGISTER.register(name, () -> builder.build(Produce.MOD_ID + "." + name));
    }
}
