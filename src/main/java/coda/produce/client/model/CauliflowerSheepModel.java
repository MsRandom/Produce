package coda.produce.client.model;

import coda.produce.entity.CauliflowerSheepEntity;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Collections;

@OnlyIn(Dist.CLIENT)
public class CauliflowerSheepModel<T extends Entity> extends AgeableModel<CauliflowerSheepEntity> {
    public ModelRenderer body;
    public ModelRenderer neck;
    public ModelRenderer tail;
    public ModelRenderer legRight;
    public ModelRenderer legLeft;
    public ModelRenderer armleft;
    public ModelRenderer armRight;
    public ModelRenderer head;
    public ModelRenderer nose;
    public ModelRenderer earLeft;
    public ModelRenderer earRight;
    public ModelRenderer bodyFluff;
    public ModelRenderer neckFluff;
    public ModelRenderer headFluff;

    public CauliflowerSheepModel() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.headFluff = new ModelRenderer(this, 71, 12);
        this.headFluff.setRotationPoint(0.0F, -2.0F, 3.98F);
        this.headFluff.addBox(-4.0F, -2.5F, -10.0F, 8.0F, 5.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.neck = new ModelRenderer(this, 5, 50);
        this.neck.setRotationPoint(0.0F, 0.0F, -9.5F);
        this.neck.addBox(-3.0F, -3.0F, -5.0F, 6.0F, 6.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.neckFluff = new ModelRenderer(this, 36, 8);
        this.neckFluff.setRotationPoint(0.0F, 5.0F, 4.0F);
        this.neckFluff.addBox(-4.0F, -4.5F, -9.02F, 8.0F, 9.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.earLeft = new ModelRenderer(this, 1, 47);
        this.earLeft.mirror = true;
        this.earLeft.setRotationPoint(3.0F, 0.0F, -1.0F);
        this.earLeft.addBox(-1.0F, -1.0F, -0.5F, 3.0F, 7.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(earLeft, 0.0F, 0.0F, -0.27314402127920984F);
        this.head = new ModelRenderer(this, 1, 5);
        this.head.setRotationPoint(0.0F, -1.5F, -4.0F);
        this.head.addBox(-3.5F, -1.5F, -5.0F, 7.0F, 7.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.legLeft = new ModelRenderer(this, 109, 7);
        this.legLeft.mirror = true;
        this.legLeft.setRotationPoint(2.5F, 2.0F, 5.5F);
        this.legLeft.addBox(-2.0F, -1.0F, -2.0F, 4.0F, 13.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.armRight = new ModelRenderer(this, 109, 30);
        this.armRight.setRotationPoint(-2.0F, 4.0F, -5.5F);
        this.armRight.addBox(-1.5F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.bodyFluff = new ModelRenderer(this, 51, 28);
        this.bodyFluff.setRotationPoint(0.0F, 0.5F, 0.0F);
        this.bodyFluff.addBox(-9.5F, -8.5F, -9.5F, 19.0F, 17.0F, 19.0F, 0.0F, 0.0F, 0.0F);
        this.body = new ModelRenderer(this, 0, 20);
        this.body.setRotationPoint(0.0F, 10.0F, 0.0F);
        this.body.addBox(-4.0F, -4.0F, -8.9F, 8.0F, 8.0F, 18.0F, 0.0F, 0.0F, 0.0F);
        this.nose = new ModelRenderer(this, 26, 8);
        this.nose.setRotationPoint(0.0F, 3.0F, -5.0F);
        this.nose.addBox(-2.5F, -2.5F, -3.0F, 5.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.armleft = new ModelRenderer(this, 109, 30);
        this.armleft.mirror = true;
        this.armleft.setRotationPoint(2.0F, 4.0F, -5.5F);
        this.armleft.addBox(-1.5F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.legRight = new ModelRenderer(this, 109, 7);
        this.legRight.setRotationPoint(-2.5F, 2.0F, 5.5F);
        this.legRight.addBox(-2.0F, -1.0F, -2.0F, 4.0F, 13.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.earRight = new ModelRenderer(this, 1, 47);
        this.earRight.setRotationPoint(-3.0F, 0.0F, -1.0F);
        this.earRight.addBox(-2.0F, -1.0F, -0.5F, 3.0F, 7.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(earRight, 0.0F, 0.0F, 0.27314402127920984F);
        this.tail = new ModelRenderer(this, 30, 51);
        this.tail.setRotationPoint(0.0F, -2.5F, 9.5F);
        this.tail.addBox(-2.5F, -1.5F, -2.0F, 5.0F, 7.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(tail, 0.3186971254089062F, 0.0F, 0.0F);
        this.head.addChild(this.headFluff);
        this.body.addChild(this.neck);
        this.head.addChild(this.neckFluff);
        this.head.addChild(this.earLeft);
        this.neck.addChild(this.head);
        this.body.addChild(this.legLeft);
        this.body.addChild(this.armRight);
        this.body.addChild(this.bodyFluff);
        this.head.addChild(this.nose);
        this.body.addChild(this.armleft);
        this.body.addChild(this.legRight);
        this.head.addChild(this.earRight);
        this.body.addChild(this.tail);
        this.body.addChild(this.bodyFluff);
        this.head.addChild(this.neckFluff);
        this.head.addChild(this.headFluff);
    }

    @Override
    protected Iterable<ModelRenderer> getHeadParts() {
        return Collections.EMPTY_LIST;
    }

    @Override
    protected Iterable<ModelRenderer> getBodyParts() {
        return ImmutableList.of(body);
    }

    @Override
    public void setRotationAngles(CauliflowerSheepEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float speed = 1.0f;
        float degree = 1.0f;
        this.head.rotateAngleX = MathHelper.cos(-1.0F + limbSwing * speed * 0.4F) * degree * 0.2F * limbSwingAmount + 0.1F;
        this.tail.rotateAngleZ = MathHelper.cos(-1.0F + limbSwing * speed * 0.4F) * degree * 0.4F * limbSwingAmount;
        this.earLeft.rotateAngleZ = MathHelper.cos(-2.0F + limbSwing * speed * 0.4F) * degree * 0.5F * limbSwingAmount - 0.325F;
        this.earRight.rotateAngleZ = MathHelper.cos(-2.0F + limbSwing * speed * 0.4F) * degree * -0.5F * limbSwingAmount + 0.325F;
        this.legRight.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.4F) * degree * 1.0F * limbSwingAmount;
        this.legLeft.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.4F) * degree * -1.0F * limbSwingAmount;
        this.armRight.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.4F) * degree * -1.0F * limbSwingAmount;
        this.armleft.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.4F) * degree * 1.0F * limbSwingAmount;
        this.neck.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.4F) * degree * 0.2F * limbSwingAmount;
        this.bodyFluff.rotateAngleZ = MathHelper.cos(-2.0F + limbSwing * speed * 0.4F) * degree * 0.3F * limbSwingAmount;
        this.bodyFluff.rotationPointY = MathHelper.cos(limbSwing * speed * 0.45F) * degree * 0.05F * limbSwingAmount + 0.5F;
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
