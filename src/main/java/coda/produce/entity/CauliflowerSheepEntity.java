package coda.produce.entity;

import coda.produce.init.ProduceBlocks;
import coda.produce.init.ProduceEntities;
import coda.produce.init.ProduceItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Random;

public class CauliflowerSheepEntity extends AnimalEntity {
    private static final DataParameter<Boolean> SHEARED = EntityDataManager.defineId(CauliflowerSheepEntity.class, DataSerializers.BOOLEAN);
    private int shearedTicks;

    public CauliflowerSheepEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.1D, Ingredient.of(Items.WHEAT), false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
    }

    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.2F);
    }

    @Nullable
    @Override
    public AgeableEntity getBreedOffspring(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        return ProduceEntities.CAULIFLOWER_SHEEP.get().create(p_241840_1_);
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return new ItemStack(ProduceItems.CAULIFLOWER_SHEEP_SPAWN_EGG.get());
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(SHEARED, false);
    }

    @Override
    public void aiStep() {
        super.aiStep();
    }

    public boolean isSheared() {
        return this.entityData.get(SHEARED);
    }

    private void setSheared(boolean sheared) {
        this.entityData.set(SHEARED, sheared);
    }

    public void shear() {
        if (!level.isClientSide) {
            shearedTicks = 12000;
            setSheared(true);
        }
    }

    @Override
    public ActionResultType mobInteract(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getItemInHand(hand);
        Item item = stack.getItem();
        if (!isSheared() && item == Items.SHEARS && !level.isClientSide && !isBaby()) {
            shear();
            this.playSound(SoundEvents.SHEEP_SHEAR, getSoundVolume(), 1);
            player.getItemInHand(hand).hurtAndBreak(1, player, (p_213613_1_) -> {
                p_213613_1_.broadcastBreakEvent(hand);
            });
            spawnAtLocation(new ItemStack(ProduceBlocks.CAULIFLOWER_FLUFF.get(), random.nextInt(2) + 1), 1);
            return ActionResultType.SUCCESS;
        }
        else {
            return super.mobInteract(player, hand);
        }
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return false;
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.SHEEP_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.SHEEP_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.SHEEP_DEATH;
    }

    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.SHEEP_STEP, 0.15F, 1.0F);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.95F * sizeIn.height;
    }

    public static boolean canSheepSpawn(EntityType<? extends CauliflowerSheepEntity> animal, IWorld worldIn, SpawnReason reason, BlockPos pos, Random random) {
        return worldIn.getBlockState(pos.below()).is(Blocks.MYCELIUM) && worldIn.getRawBrightness(pos, 0) > 8;
    }
}

