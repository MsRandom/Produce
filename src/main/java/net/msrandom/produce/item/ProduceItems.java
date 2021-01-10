package net.msrandom.produce.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.msrandom.produce.ProduceMod;

public class ProduceItems {
    public static final ItemGroup GROUP = new ItemGroup(ProduceMod.MOD_ID) {
        @Override
        public ItemStack createIcon() {
            return ItemStack.EMPTY; //TODO
        }
    };
    public static final DeferredRegister<Item> REGISTRAR = DeferredRegister.create(ForgeRegistries.ITEMS, ProduceMod.MOD_ID);
}
