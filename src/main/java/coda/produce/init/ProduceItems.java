package coda.produce.init;

import coda.produce.Produce;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ProduceItems {
    public static final ItemGroup GROUP = new ItemGroup(Produce.MOD_ID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ProduceBlocks.LEAFY_GREEN_LEAVES.get());
        }
    };

    public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, Produce.MOD_ID);

    public static final RegistryObject<BucketItem> SMOOTHIE_BUCKET = REGISTER.register("smoothie_bucket", () -> new BucketItem(ProduceFluids.SMOOTHIE, (new Item.Properties()).containerItem(Items.BUCKET).maxStackSize(1).group(GROUP)));

    public static final RegistryObject<BlockItem> LEAFY_GREEN_LOG = REGISTER.register("leafy_green_log", () -> new BlockItem(ProduceBlocks.LEAFY_GREEN_LOG.get(), new Item.Properties().group(GROUP)));
    public static final RegistryObject<BlockItem> LEAFY_GREEN_WOOD = REGISTER.register("leafy_green_wood", () -> new BlockItem(ProduceBlocks.LEAFY_GREEN_WOOD.get(), new Item.Properties().group(GROUP)));
    public static final RegistryObject<BlockItem> LEAFY_GREEN_LEAVES = REGISTER.register("leafy_green_leaves", () -> new BlockItem(ProduceBlocks.LEAFY_GREEN_LEAVES.get(), new Item.Properties().group(GROUP)));
    public static final RegistryObject<BlockItem> LEAFY_GREEN_PLANKS = REGISTER.register("leafy_green_planks", () -> new BlockItem(ProduceBlocks.LEAFY_GREEN_PLANKS.get(), new Item.Properties().group(GROUP)));
    public static final RegistryObject<BlockItem> BROCKOLI = REGISTER.register("brockoli", () -> new BlockItem(ProduceBlocks.BROCKOLI.get(), new Item.Properties().group(GROUP)));
}
