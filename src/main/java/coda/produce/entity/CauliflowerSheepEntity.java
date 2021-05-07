package coda.produce.entity;

import coda.produce.init.ProduceBlocks;
import coda.produce.init.ProduceEntities;
import coda.produce.init.ProduceItems;
import net.minecraft.block.BlockState;
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
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;

public class CauliflowerSheepEntity extends AnimalEntity {
    private static final DataParameter<Boolean> SHEARED = EntityDataManager.createKey(CauliflowerSheepEntity.class, DataSerializers.BOOLEAN);
    private int shearedTicks;

    public CauliflowerSheepEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.1D, Ingredient.fromItems(Items.WHEAT), false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
    }

    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 20.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.2F);
    }

    @Nullable
    @Override
    public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        return ProduceEntities.CAULIFLOWER_SHEEP.get().create(p_241840_1_);
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return new ItemStack(ProduceItems.CAULIFLOWER_SHEEP_SPAWN_EGG.get());
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(SHEARED, false);
    }

    @Override
    public void livingTick() {
        super.livingTick();
    }

    public boolean isSheared() {
        return this.dataManager.get(SHEARED);
    }

    private void setSheared(boolean sheared) {
        this.dataManager.set(SHEARED, sheared);
    }

    public void shear() {
        if (!world.isRemote) {
            shearedTicks = 12000;
            setSheared(true);
        }
    }

    @Override
    public ActionResultType func_230254_b_(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getHeldItem(hand);
        Item item = stack.getItem();
        if (!isSheared() && item == Items.SHEARS && !world.isRemote && !isChild()) {
            shear();
            this.playSound(SoundEvents.ENTITY_SHEEP_SHEAR, getSoundVolume(), 1);
            player.getHeldItem(hand).damageItem(1, player, (p_213613_1_) -> {
                p_213613_1_.sendBreakAnimation(hand);
            });
            entityDropItem(new ItemStack(ProduceBlocks.CAULIFLOWER_FLUFF.get(), rand.nextInt(2) + 1), 1);
            return ActionResultType.SUCCESS;
        }
        else {
            return super.func_230254_b_(player, hand);
        }
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return false;
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SHEEP_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_SHEEP_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SHEEP_DEATH;
    }

    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.ENTITY_SHEEP_STEP, 0.15F, 1.0F);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.95F * sizeIn.height;
    }
}

