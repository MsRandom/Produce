package coda.produce.init;

import coda.produce.Produce;
import coda.produce.item.ProduceSpawnEggItem;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ProduceItems {
    public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, Produce.MOD_ID);

    public static final RegistryObject<Item> SMOOTHIE_BUCKET = REGISTER.register("smoothie_bucket", () -> new BucketItem(ProduceFluids.SMOOTHIE, (new Item.Properties()).containerItem(Items.BUCKET).maxStackSize(1).group(Produce.GROUP)));

    public static final RegistryObject<Item> CAULIFLOWER_SHEEP_SPAWN_EGG = REGISTER.register("cauliflower_sheep_spawn_egg", () -> new ProduceSpawnEggItem(ProduceEntities.CAULIFLOWER_SHEEP, 0xf9f1dd, 0xa1cf70, new Item.Properties().group(Produce.GROUP)));

    // Blocks
    public static final RegistryObject<Item> LEAFY_GREEN_PLANKS = REGISTER.register("leafy_green_planks", () -> new BlockItem(ProduceBlocks.LEAFY_GREEN_PLANKS.get(), new Item.Properties().group(Produce.GROUP)));
    public static final RegistryObject<Item> LEAFY_GREEN_STEM = REGISTER.register("leafy_green_stem", () -> new BlockItem(ProduceBlocks.LEAFY_GREEN_STEM.get(), new Item.Properties().group(Produce.GROUP)));
    public static final RegistryObject<Item> LEAFY_GREEN_STALK = REGISTER.register("leafy_green_stalk", () -> new BlockItem(ProduceBlocks.LEAFY_GREEN_STALK.get(), new Item.Properties().group(Produce.GROUP)));
    public static final RegistryObject<Item> LEAFY_GREEN_LEAVES = REGISTER.register("leafy_green_leaves", () -> new BlockItem(ProduceBlocks.LEAFY_GREEN_LEAVES.get(), new Item.Properties().group(Produce.GROUP)));
    public static final RegistryObject<Item> STRIPPED_LEAFY_GREEN_STEM = REGISTER.register("stripped_leafy_green_stem", () -> new BlockItem(ProduceBlocks.STRIPPED_LEAFY_GREEN_STEM.get(), new Item.Properties().group(Produce.GROUP)));
    public static final RegistryObject<Item> STRIPPED_LEAFY_GREEN_STALK = REGISTER.register("stripped_leafy_green_stalk", () -> new BlockItem(ProduceBlocks.STRIPPED_LEAFY_GREEN_STALK.get(), new Item.Properties().group(Produce.GROUP)));
    public static final RegistryObject<Item> LEAFY_GREEN_SLAB = REGISTER.register("leafy_green_slab", () -> new BlockItem(ProduceBlocks.LEAFY_GREEN_SLAB.get(), new Item.Properties().group(Produce.GROUP)));
    public static final RegistryObject<Item> LEAFY_GREEN_STAIRS = REGISTER.register("leafy_green_stairs", () -> new BlockItem(ProduceBlocks.LEAFY_GREEN_STAIRS.get(), new Item.Properties().group(Produce.GROUP)));
    public static final RegistryObject<Item> LEAFY_GREEN_PRESSURE_PLATE = REGISTER.register("leafy_green_pressure_plate", () -> new BlockItem(ProduceBlocks.LEAFY_GREEN_PRESSURE_PLATE.get(), new Item.Properties().group(Produce.GROUP)));
    public static final RegistryObject<Item> LEAFY_GREEN_BUTTON = REGISTER.register("leafy_green_button", () -> new BlockItem(ProduceBlocks.LEAFY_GREEN_BUTTON.get(), new Item.Properties().group(Produce.GROUP)));
    public static final RegistryObject<Item> LEAFY_GREEN_DOOR = REGISTER.register("leafy_green_door", () -> new BlockItem(ProduceBlocks.LEAFY_GREEN_DOOR.get(), new Item.Properties().group(Produce.GROUP)));
    public static final RegistryObject<Item> LEAFY_GREEN_TRAPDOOR = REGISTER.register("leafy_green_trapdoor", () -> new BlockItem(ProduceBlocks.LEAFY_GREEN_TRAPDOOR.get(), new Item.Properties().group(Produce.GROUP)));
    public static final RegistryObject<Item> LEAFY_GREEN_FENCE = REGISTER.register("leafy_green_fence", () -> new BlockItem(ProduceBlocks.LEAFY_GREEN_FENCE.get(), new Item.Properties().group(Produce.GROUP)));
    public static final RegistryObject<Item> LEAFY_GREEN_FENCE_GATE = REGISTER.register("leafy_green_fence_gate", () -> new BlockItem(ProduceBlocks.LEAFY_GREEN_FENCE_GATE.get(), new Item.Properties().group(Produce.GROUP)));
    public static final RegistryObject<Item> CAULIFLOWER_FLUFF = REGISTER.register("cauliflower_fluff", () -> new BlockItem(ProduceBlocks.CAULIFLOWER_FLUFF.get(), new Item.Properties().group(Produce.GROUP)));
    public static final RegistryObject<Item> BROCKOLI = REGISTER.register("brockoli", () -> new BlockItem(ProduceBlocks.BROCKOLI.get(), new Item.Properties().group(Produce.GROUP)));
    public static final RegistryObject<Item> BROCKOLI_BRICKS = REGISTER.register("brockoli_bricks", () -> new BlockItem(ProduceBlocks.BROCKOLI_BRICKS.get(), new Item.Properties().group(Produce.GROUP)));
    public static final RegistryObject<Item> CRACKED_BROCKOLI_BRICKS = REGISTER.register("cracked_brockoli_bricks", () -> new BlockItem(ProduceBlocks.CRACKED_BROCKOLI_BRICKS.get(), new Item.Properties().group(Produce.GROUP)));
    public static final RegistryObject<Item> BROCKOLI_STAIRS = REGISTER.register("brockoli_stairs", () -> new BlockItem(ProduceBlocks.BROCKOLI_STAIRS.get(), new Item.Properties().group(Produce.GROUP)));
    public static final RegistryObject<Item> BROCKOLI_SLAB = REGISTER.register("brockoli_slab", () -> new BlockItem(ProduceBlocks.BROCKOLI_SLAB.get(), new Item.Properties().group(Produce.GROUP)));
    public static final RegistryObject<Item> BROCKOLI_WALL = REGISTER.register("brockoli_wall", () -> new BlockItem(ProduceBlocks.BROCKOLI_WALL.get(), new Item.Properties().group(Produce.GROUP)));
    public static final RegistryObject<Item> BROCKOLI_BRICK_SLAB = REGISTER.register("brockoli_brick_slab", () -> new BlockItem(ProduceBlocks.BROCKOLI_BRICK_SLAB.get(), new Item.Properties().group(Produce.GROUP)));
    public static final RegistryObject<Item> BROCKOLI_BRICK_STAIRS = REGISTER.register("brockoli_brick_stairs", () -> new BlockItem(ProduceBlocks.BROCKOLI_BRICK_STAIRS.get(), new Item.Properties().group(Produce.GROUP)));
}
