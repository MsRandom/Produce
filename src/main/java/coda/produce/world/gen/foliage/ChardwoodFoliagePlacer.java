package coda.produce.world.gen.foliage;

import coda.produce.init.ProduceFoliagePlacers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;

import java.util.Random;
import java.util.Set;

public class ChardwoodFoliagePlacer extends FoliagePlacer {
    public static final Codec<ChardwoodFoliagePlacer> CODEC = RecordCodecBuilder.create(placer -> func_242830_b(placer).apply(placer, ChardwoodFoliagePlacer::new));

    public ChardwoodFoliagePlacer(FeatureSpread radius, FeatureSpread offset) {
        super(radius, offset);
    }

    @Override
    protected FoliagePlacerType<?> func_230371_a_() {
        return ProduceFoliagePlacers.CHARDWOOD_FOLIAGE_PLACER.get();
    }

    @Override
    protected void func_230372_a_(IWorldGenerationReader world, Random random, BaseTreeFeatureConfig config, int trunkHeight, Foliage foliage, int foliageHeight, int radius, Set<BlockPos> leaves, int offset, MutableBoundingBox box) {
        Rotation rotation = Rotation.VALUES[random.nextInt(Rotation.VALUES.length)];
        int horizontalRadius = radius / 2;
        for (int h = -horizontalRadius; h <= horizontalRadius; h++) {
            for (int y = -radius; y <= radius; y++) {
                BlockPos position = foliage.func_236763_a_().add(h * rotation.x, y, h * rotation.z);
                if (foliage.func_236763_a_().withinDistance(position, radius * 0.75) && !this.func_230375_b_(random, y, position.getX(), position.getY(), position.getZ(), foliage.func_236765_c_())) {
                    if (TreeFeature.isReplaceableAt(world, position)) {
                        world.setBlockState(position, config.leavesProvider.getBlockState(random, position), 19);
                        box.expandTo(new MutableBoundingBox(position, position));
                        leaves.add(position);
                    }
                }
            }
        }
    }

    @Override
    public int func_230374_a_(Random random, int trunkHeight, BaseTreeFeatureConfig config) {
        return trunkHeight - 1;
    }

    @Override
    protected boolean func_230373_a_(Random random, int height, int x, int y, int z, boolean giantTrunk) {
        return height == z && y == z && (random.nextInt(2) == 0 || x == 0);
    }

    private enum Rotation {
        ROTATION_0(1, 0),
        ROTATION_45(1, 1),
        ROTATION_90(0, 1),
        ROTATION_135(-1, 1);

        private static final Rotation[] VALUES = values();
        private final int x;
        private final int z;

        Rotation(int x, int z) {
            this.x = x;
            this.z = z;
        }
    }
}
