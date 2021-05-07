package coda.produce.world.feature;

import coda.produce.init.ProduceBlocks;
import net.minecraft.block.*;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorldWriter;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;

public class LeafyGreenTreeFeature extends Feature<NoFeatureConfig> {
    private final BlockState trunk = ProduceBlocks.LEAFY_GREEN_STALK.get().getDefaultState().with(RotatedPillarBlock.AXIS, Direction.Axis.Y);
    private final BlockState leaves = ProduceBlocks.LEAFY_GREEN_LEAVES.get().getDefaultState().with(LeavesBlock.DISTANCE, 7).with(LeavesBlock.PERSISTENT, false);

    public LeafyGreenTreeFeature() {
        super(NoFeatureConfig.field_236558_a_);
    }

    @Override
    public boolean generate(ISeedReader iSeedReader, ChunkGenerator chunkGenerator, Random random, BlockPos blockPos, NoFeatureConfig noFeatureConfig) {
        if (iSeedReader.getBlockState(blockPos.down()).getBlock() == Blocks.GRASS_BLOCK) {

            for (int i = 0; i < 5; i++) {
                setBlockState(iSeedReader, blockPos.up(i), trunk);

                for (int j = 2; j <= 6; j++) {
                    setBlockState(iSeedReader, blockPos.north().up(j), leaves);
                    setBlockState(iSeedReader, blockPos.south().up(j), leaves);
                    setBlockState(iSeedReader, blockPos.west().up(j), leaves);
                    setBlockState(iSeedReader, blockPos.east().up(j), leaves);
                }

                for (int k = 5; k <= 7; k++) {
                    setBlockState(iSeedReader, blockPos.up(k), leaves);
                }

                for (int l = 4; l <= 5; l++) {
                    setBlockState(iSeedReader, blockPos.north().west().up(l), leaves);
                    setBlockState(iSeedReader, blockPos.north().east().up(l), leaves);
                    setBlockState(iSeedReader, blockPos.south().west().up(l), leaves);
                    setBlockState(iSeedReader, blockPos.south().east().up(l), leaves);
                }

            }

            return true;
        }
        return false;
    }


}
