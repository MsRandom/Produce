package coda.produce.init;

import coda.produce.Produce;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.Direction;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ProduceBlocks {
    public static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, Produce.MOD_ID);

    public static final RegistryObject<Block> LEAFY_GREEN_PLANKS = REGISTER.register("leafy_green_planks", () -> new Block(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.GREEN).hardnessAndResistance(1.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LEAFY_GREEN_STEM = REGISTER.register("leafy_green_stem", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.GREEN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LEAFY_GREEN_STALK = REGISTER.register("leafy_green_stalk", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.GREEN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LEAFY_GREEN_LEAVES = REGISTER.register("leafy_green_leaves", () -> new LeavesBlock(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()));
    public static final RegistryObject<Block> STRIPPED_LEAFY_GREEN_STEM = REGISTER.register("stripped_leafy_green_stem", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.GREEN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_LEAFY_GREEN_STALK = REGISTER.register("stripped_leafy_green_stalk", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.GREEN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LEAFY_GREEN_SLAB = REGISTER.register("leafy_green_slab", () -> new SlabBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.GREEN).hardnessAndResistance(1.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LEAFY_GREEN_STAIRS = REGISTER.register("leafy_green_stairs", () -> new StairsBlock(() -> LEAFY_GREEN_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD, MaterialColor.GREEN).hardnessAndResistance(1.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LEAFY_GREEN_PRESSURE_PLATE = REGISTER.register("leafy_green_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.GREEN).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LEAFY_GREEN_BUTTON = REGISTER.register("leafy_green_button", () -> new WoodButtonBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.GREEN).hardnessAndResistance(0.5F).sound(SoundType.WOOD).doesNotBlockMovement()));
    public static final RegistryObject<Block> LEAFY_GREEN_DOOR = REGISTER.register("leafy_green_door", () -> new DoorBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.GREEN).hardnessAndResistance(1.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LEAFY_GREEN_TRAPDOOR = REGISTER.register("leafy_green_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.GREEN).hardnessAndResistance(1.5F).sound(SoundType.WOOD).notSolid()));
    public static final RegistryObject<Block> LEAFY_GREEN_FENCE = REGISTER.register("leafy_green_fence", () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.GREEN).hardnessAndResistance(1.5F).sound(SoundType.WOOD).notSolid()));
    public static final RegistryObject<Block> LEAFY_GREEN_FENCE_GATE = REGISTER.register("leafy_green_fence_gate", () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.GREEN).hardnessAndResistance(1.5F).sound(SoundType.WOOD).notSolid()));

    public static final RegistryObject<Block> BROCKOLI = REGISTER.register("brockoli", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5f, 6.0f)));
    public static final RegistryObject<Block> BROCKOLI_SLAB = REGISTER.register("brockoli_slab", () -> new SlabBlock(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5f, 6.0f)));
    public static final RegistryObject<Block> BROCKOLI_STAIRS = REGISTER.register("brockoli_stairs", () -> new StairsBlock(() -> BROCKOLI.get().getDefaultState(), AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5f, 6.0f)));
    public static final RegistryObject<Block> BROCKOLI_WALL = REGISTER.register("brockoli_wall", () -> new WallBlock(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5f, 6.0f)));
    public static final RegistryObject<Block> BROCKOLI_BRICKS = REGISTER.register("brockoli_bricks", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5f, 6.0f)));
    public static final RegistryObject<Block> BROCKOLI_BRICK_SLAB = REGISTER.register("brockoli_brick_slab", () -> new SlabBlock(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5f, 6.0f)));
    public static final RegistryObject<Block> BROCKOLI_BRICK_STAIRS = REGISTER.register("brockoli_brick_stairs", () -> new StairsBlock(() -> BROCKOLI_BRICKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5f, 6.0f)));
    public static final RegistryObject<Block> CRACKED_BROCKOLI_BRICKS = REGISTER.register("cracked_brockoli_bricks", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5f, 6.0f)));

    public static final RegistryObject<Block> CAULIFLOWER_FLUFF = REGISTER.register("cauliflower_fluff", () -> new Block(AbstractBlock.Properties.create(Material.WOOL).sound(SoundType.CLOTH).hardnessAndResistance(1.0f)));

    public static final RegistryObject<FlowingFluidBlock> SMOOTHIE = REGISTER.register("smoothie", () ->  new FlowingFluidBlock(ProduceFluids.SMOOTHIE, AbstractBlock.Properties.create(Material.EARTH, MaterialColor.PINK).sound(SoundType.GROUND).doesNotBlockMovement().hardnessAndResistance(100.0F).noDrops()));
}
