package coda.produce.world.feature;

import coda.produce.init.ProduceBlocks;
import coda.produce.world.WorldgenFiller;
import coda.produce.world.WorldgenFiller.BlockStateEntry;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;

import static net.minecraft.world.gen.feature.NoFeatureConfig.CODEC;

public class LeafyGreenTreeFeature extends Feature<NoFeatureConfig> {
    public LeafyGreenTreeFeature() {
        super(CODEC);
    }

    //NOTE all random values below have 1 added to them when randomizing, the values determine the maximum possible output, not number of outputs

    public static int minimumTrunkHeight = 9; //minimum height of the tree trunk
    public static int extraTrunkHeight = 3; //maximum possible randomized increase in height

    public static float baseBendChance = 0.3f; //starting value for bend chance
    public static float resetBendChance = 0.1f; //reset value for bend chance
    public static float extraBendChance = 0.2f;  //added to bend chance each time we don't bend
    public static int maximumPossibleBends = 1; //how many times we can bend
    public static int minimumBendHeight = 4; //the minimum height a bend can happen at

    public static int minimumSideTrunkHeight = 2; //the minimum height a side trunk can have
    public static int extraSideTrunkHeight = 1; //extra random value added to the above

    public static int branchUpwardsOffset = 3; //value added to top of trunk for branch placement
    public static int minimumDownwardsBranchOffset = 3; //branch go down, how much hmmmm?
    public static int extraDownwardsBranchOffset = 2; //this much extra!
    public static int minimumBranchHeight = 4; //minimum height of a branch
    public static int extraBranchHeight = 1; //extra random increase to branch height

    public static int minimumLeavesStart = 1; //minimum height of the branch at which leaves start
    public static int extraLeavesStart = 1; //extra to the above
    public static int minimumLeavesHeight = 6; //minimum height of leaves
    public static int extraLeavesHeight = 3; //extra leaves height

    public static int branchTopLeavesHeight = 8; //branch top leaves refers to leaves directly above the branch
    public static int extraBranchTopLeavesHeight = 3; //extra random value to the above

    public static final Direction[] DIRECTIONS = new Direction[]{Direction.WEST, Direction.NORTH, Direction.SOUTH, Direction.EAST};

    public static BlockState logBlock() {
        return ProduceBlocks.LEAFY_GREEN_STEM.get().defaultBlockState();
    }
    public static BlockState leavesBlock() {
        return ProduceBlocks.LEAFY_GREEN_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 7);
    }

    @Override
    public boolean place(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        if (reader.isEmptyBlock(pos.below())) {
            return false;
        }

        WorldgenFiller trunkFiller = new WorldgenFiller();
        WorldgenFiller leavesFiller = new WorldgenFiller();

        boolean higherStart = rand.nextBoolean();
        int extraHeight = rand.nextInt(extraTrunkHeight + 1);
        int height = minimumTrunkHeight + extraHeight + (higherStart ? 1 : 0);

        Direction[] directions = new Direction[]{Direction.NORTH, Direction.SOUTH, Direction.WEST, Direction.EAST};
        Direction bendDirection = directions[rand.nextInt(directions.length)];
        int bendOffset = 0;
        float currentBendChance = baseBendChance;
        for (int i = 0; i < height; i++) {
            BlockPos trunkPos = pos.above(i).relative(bendDirection, bendOffset);
            if (canPlace(reader, trunkPos)) {
                trunkFiller.entries.add(new BlockStateEntry(logBlock(), trunkPos));
                if (i >= minimumBendHeight && bendOffset < maximumPossibleBends && rand.nextFloat() < currentBendChance) {
                    trunkFiller.entries.add(new BlockStateEntry(logBlock(), trunkPos.relative(bendDirection, 1)));
                    currentBendChance = resetBendChance;
                    bendOffset++;
                }
                else {
                    currentBendChance+= extraBendChance;
                }
            }
            else {
                return false;
            }
        }
        Direction[] northSouth = new Direction[]{Direction.NORTH, Direction.SOUTH};
        Direction[] westEast = new Direction[]{Direction.WEST, Direction.EAST};
        BlockPos trunkPos = pos.above(height).relative(bendDirection, bendOffset);

        for (Direction direction : directions) {
            int branchBend = 0;
            int downwardsOffset = minimumDownwardsBranchOffset + rand.nextInt(extraDownwardsBranchOffset +1);
            int branchHeight = minimumBranchHeight + rand.nextInt(extraBranchHeight + 1);
            BlockPos branchPos = trunkPos.relative(direction, 1).below(downwardsOffset).above(branchUpwardsOffset);
            for (int i = -1; i <= branchHeight; i++) {
                BlockPos branchPosAgain = branchPos.above(i).relative(direction, branchBend);
                trunkFiller.entries.add(new BlockStateEntry(logBlock(), branchPosAgain));
                if (branchBend == 0) {
                    trunkFiller.entries.add(new BlockStateEntry(logBlock(), branchPosAgain.above()));
                    branchBend = 1;
                }
            }

            int topLeavesHeight = branchTopLeavesHeight + rand.nextInt(extraBranchTopLeavesHeight + 1);
            for (int i = branchHeight; i <= topLeavesHeight; i++) {
                BlockPos topLeavesPos = branchPos.above(i).relative(direction);
                leavesFiller.entries.add(new BlockStateEntry(leavesBlock(), topLeavesPos));
            }

            Direction[] leavesDirections = direction == Direction.NORTH || direction == Direction.SOUTH ? westEast : northSouth;
            for (Direction leavesDirection : leavesDirections) {
                int leavesStart = minimumLeavesStart + rand.nextInt(extraLeavesStart + 1);
                int leavesHeight = minimumLeavesHeight + rand.nextInt(extraLeavesHeight + 1);
                for (int i = leavesStart; i <= leavesHeight; i++) {
                    BlockPos leavesPos = branchPos.relative(leavesDirection).above(i).relative(direction);
                    leavesFiller.entries.add(new BlockStateEntry(leavesBlock(), leavesPos));
                }
            }
        }
        for (Direction direction : directions) {
            int sideTrunkHeight = minimumSideTrunkHeight + rand.nextInt(extraSideTrunkHeight + 1);
            for (int i = 0; i < sideTrunkHeight; i++) {
                BlockPos sideTrunkPos = pos.relative(direction).above(i);
                if (canPlace(reader, sideTrunkPos)) {
                    trunkFiller.entries.add(new BlockStateEntry(logBlock(), sideTrunkPos));
                }
                else {
                    return false;
                }
            }
            downwardsTrunk(reader, trunkFiller, pos.relative(direction));
        }
        trunkFiller.fill(reader, true);
        leavesFiller.fill(reader, true);
        return true;
    }

    public static void downwardsTrunk(ISeedReader reader, WorldgenFiller filler, BlockPos pos) {
        int i = 0;
        do {
            i++;
            BlockPos trunkPos = pos.below(i);
            if (canPlace(reader, trunkPos)) {
                filler.entries.add(new BlockStateEntry(logBlock(), trunkPos));
            }
            else {
                break;
            }
            if (i > reader.getMaxBuildHeight()) {
                break;
            }
        }
        while (true);
    }

    public static boolean canGrowTree(ISeedReader reader, BlockPos pos) {
        if (!reader.getBlockState(pos.below()).getBlock().equals(Blocks.GRASS)) {
            return false;
        }
        for (Direction direction : DIRECTIONS) {
            BlockPos sandPos = pos.below().relative(direction);
            if (!reader.getBlockState(sandPos).getBlock().equals(Blocks.GRASS)) {
                return false;
            }
        }
        return canPlace(reader, pos);
    }

    public static boolean canPlace(ISeedReader reader, BlockPos pos) {
        if (World.isOutsideBuildHeight(pos)) {
            return false;
        }
        BlockState state = reader.getBlockState(pos);
        return reader.getBlockState(pos).getBlock().equals(ProduceBlocks.LEAFY_GREEN_SAPLING.get()) || reader.isEmptyBlock(pos) || state.getMaterial().isReplaceable();
    }
}