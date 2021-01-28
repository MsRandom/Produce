package net.msrandom.produce.item;

import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.msrandom.produce.ProduceMod;
import net.msrandom.produce.block.ProduceBlocks;
import net.msrandom.produce.fluid.ProduceFluids;

public class ProduceItems {
    public static final ItemGroup GROUP = new ItemGroup(ProduceMod.MOD_ID) {
        @Override
        public ItemStack createIcon() {
            return ItemStack.EMPTY; //TODO
        }
    };
    public static final DeferredRegister<Item> REGISTRAR = DeferredRegister.create(ForgeRegistries.ITEMS, ProduceMod.MOD_ID);

    public static final RegistryObject<BucketItem> SMOOTHIE_BUCKET = REGISTRAR.register("smoothie_bucket", () -> new BucketItem(ProduceFluids.SMOOTHIE, (new Item.Properties()).containerItem(Items.BUCKET).maxStackSize(1).group(GROUP)));
//    public static final RegistryObject<BlockItem> BROCKOLI = REGISTRAR.register("brockoli", () -> new BlockItem(ProduceBlocks.BROCKOLI.get(), new Item.Properties().group(GROUP)));
}
