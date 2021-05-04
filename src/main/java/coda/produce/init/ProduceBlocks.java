package coda.produce.init;

import coda.produce.Produce;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.Direction;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ProduceBlocks {
    public static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, Produce.MOD_ID);

    public static final RegistryObject<Block> LEAFY_GREEN_LEAVES = REGISTER.register("leafy_green_leaves", () -> new LeavesBlock(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()));
    public static final RegistryObject<Block> LEAFY_GREEN_WOOD = REGISTER.register("leafy_green_wood", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.GREEN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LEAFY_GREEN_LOG = REGISTER.register("leafy_green_log", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, state -> state.get(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.WHITE_TERRACOTTA : MaterialColor.GREEN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LEAFY_GREEN_PLANKS = REGISTER.register("leafy_green_planks", () -> new Block(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.GREEN).hardnessAndResistance(1.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BROCKOLI = REGISTER.register("brockoli", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5f, 6.0f)));

    public static final RegistryObject<FlowingFluidBlock> SMOOTHIE = REGISTER.register("smoothie", () -> new FlowingFluidBlock(ProduceFluids.SMOOTHIE, AbstractBlock.Properties.create(Material.WATER).doesNotBlockMovement().hardnessAndResistance(100.0F).noDrops()));

}
