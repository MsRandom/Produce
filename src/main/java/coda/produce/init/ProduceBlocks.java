package coda.produce.init;

import coda.produce.Produce;
import coda.produce.block.LeafyGreenSaplingBlock;
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

    public static final RegistryObject<Block> LEAFY_GREEN_PLANKS = REGISTER.register("leafy_green_planks", () -> new Block(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_GREEN).strength(1.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LEAFY_GREEN_STEM = REGISTER.register("leafy_green_stem", () -> new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_GREEN).strength(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LEAFY_GREEN_STALK = REGISTER.register("leafy_green_stalk", () -> new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_GREEN).strength(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LEAFY_GREEN_LEAVES = REGISTER.register("leafy_green_leaves", () -> new LeavesBlock(AbstractBlock.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion()));
    public static final RegistryObject<Block> STRIPPED_LEAFY_GREEN_STEM = REGISTER.register("stripped_leafy_green_stem", () -> new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_GREEN).strength(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_LEAFY_GREEN_STALK = REGISTER.register("stripped_leafy_green_stalk", () -> new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_GREEN).strength(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LEAFY_GREEN_SLAB = REGISTER.register("leafy_green_slab", () -> new SlabBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_GREEN).strength(1.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LEAFY_GREEN_STAIRS = REGISTER.register("leafy_green_stairs", () -> new StairsBlock(() -> LEAFY_GREEN_PLANKS.get().defaultBlockState(), AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_GREEN).strength(1.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LEAFY_GREEN_PRESSURE_PLATE = REGISTER.register("leafy_green_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_GREEN).noCollission().strength(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LEAFY_GREEN_BUTTON = REGISTER.register("leafy_green_button", () -> new WoodButtonBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_GREEN).strength(0.5F).sound(SoundType.WOOD).noCollission()));
    public static final RegistryObject<Block> LEAFY_GREEN_DOOR = REGISTER.register("leafy_green_door", () -> new DoorBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_GREEN).strength(1.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LEAFY_GREEN_TRAPDOOR = REGISTER.register("leafy_green_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_GREEN).strength(1.5F).sound(SoundType.WOOD).noOcclusion()));
    public static final RegistryObject<Block> LEAFY_GREEN_FENCE = REGISTER.register("leafy_green_fence", () -> new FenceBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_GREEN).strength(1.5F).sound(SoundType.WOOD).noOcclusion()));
    public static final RegistryObject<Block> LEAFY_GREEN_FENCE_GATE = REGISTER.register("leafy_green_fence_gate", () -> new FenceGateBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_GREEN).strength(1.5F).sound(SoundType.WOOD).noOcclusion()));
    public static final RegistryObject<Block> LEAFY_GREEN_SAPLING = REGISTER.register("leafy_green_sapling", () -> new LeafyGreenSaplingBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_GREEN).strength(1.5F).sound(SoundType.GRASS).noOcclusion().noCollission()));

    public static final Block BROCKOLI_BLOCK = new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GREEN).sound(SoundType.STONE).strength(1.5f, 6.0f));
    public static final Block CHARRED_BROCKOLI_BLOCK = new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BROWN).sound(SoundType.STONE).strength(1.5f, 6.0f));
    public static final RegistryObject<Block> BROCKOLI = REGISTER.register("brockoli", () -> BROCKOLI_BLOCK);
    public static final RegistryObject<Block> BROCKOLI_SLAB = REGISTER.register("brockoli_slab", () -> new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GREEN).sound(SoundType.STONE).strength(1.5f, 6.0f)));
    public static final RegistryObject<Block> BROCKOLI_STAIRS = REGISTER.register("brockoli_stairs", () -> new StairsBlock(() -> BROCKOLI.get().defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GREEN).sound(SoundType.STONE).strength(1.5f, 6.0f)));
    public static final RegistryObject<Block> BROCKOLI_WALL = REGISTER.register("brockoli_wall", () -> new WallBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GREEN).sound(SoundType.STONE).strength(1.5f, 6.0f)));
    public static final RegistryObject<Block> BROCKOLI_BRICKS = REGISTER.register("brockoli_bricks", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GREEN).sound(SoundType.STONE).strength(1.5f, 6.0f)));
    public static final RegistryObject<Block> BROCKOLI_BRICK_SLAB = REGISTER.register("brockoli_brick_slab", () -> new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GREEN).sound(SoundType.STONE).strength(1.5f, 6.0f)));
    public static final RegistryObject<Block> BROCKOLI_BRICK_STAIRS = REGISTER.register("brockoli_brick_stairs", () -> new StairsBlock(() -> BROCKOLI_BRICKS.get().defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GREEN).sound(SoundType.STONE).strength(1.5f, 6.0f)));
    public static final RegistryObject<Block> CRACKED_BROCKOLI_BRICKS = REGISTER.register("cracked_brockoli_bricks", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GREEN).sound(SoundType.STONE).strength(1.5f, 6.0f)));
    public static final RegistryObject<Block> CHARRED_BROCKOLI = REGISTER.register("charred_brockoli", () -> CHARRED_BROCKOLI_BLOCK);

    public static final RegistryObject<Block> CAULIFLOWER_FLUFF = REGISTER.register("cauliflower_fluff", () -> new Block(AbstractBlock.Properties.of(Material.WOOL, MaterialColor.QUARTZ).sound(SoundType.WOOL).strength(1.0f)));

    public static final RegistryObject<FlowingFluidBlock> SMOOTHIE = REGISTER.register("smoothie", () ->  new FlowingFluidBlock(ProduceFluids.SMOOTHIE, AbstractBlock.Properties.of(Material.DIRT, MaterialColor.COLOR_PINK).sound(SoundType.GRAVEL).noCollission().strength(100.0F).noDrops().noOcclusion()));
}
