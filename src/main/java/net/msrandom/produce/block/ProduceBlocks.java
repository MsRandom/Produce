package net.msrandom.produce.block;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.msrandom.produce.ProduceMod;
import net.msrandom.produce.item.ProduceItems;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ProduceBlocks {
    public static final DeferredRegister<Block> REGISTRAR = DeferredRegister.create(ForgeRegistries.BLOCKS, ProduceMod.MOD_ID);
    public static final Block CHARDWOOD_LEAVES = register("chardwood_leaves", new LeavesBlock(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid());
    public static final Block CHARDWOOD_LEAVES = register(new LeavesBlock(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid());

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        return register(name, block, BlockItem::new);
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block, @Nonnull BiFunction<Block, Item.Properties, BlockItem> itemFunction) {
        return register(name, block, itemFunction, new Item.Properties().group(ProduceItems.GROUP));
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block, @Nonnull BiFunction<Block, Item.Properties, BlockItem> itemFunction, @Nullable Item.Properties itemProperties) {
        RegistryObject<T> registryObject = REGISTRAR.register(name, block);
        ProduceItems.REGISTRAR.register(name, () -> itemFunction.apply(registryObject.get(), itemProperties));
        return registryObject;
    }
}
