package coda.produce.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class StrawberrishModel<T extends Entity> extends EntityModel<T> {
    public ModelRenderer body;
    public ModelRenderer tail;
    public ModelRenderer finRight;
    public ModelRenderer finLeft;

    public StrawberrishModel() {
        this.texWidth = 32;
        this.texHeight = 32;
        this.finRight = new ModelRenderer(this, 0, 2);
        this.finRight.setPos(-2.0F, 1.0F, 0.0F);
        this.finRight.addBox(0.0F, 0.0F, -1.0F, 0.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(finRight, 0.0F, 0.0F, 0.6108652381980153F);
        this.body = new ModelRenderer(this, 0, 1);
        this.body.setPos(0.0F, 22.0F, 0.0F);
        this.body.addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.tail = new ModelRenderer(this, 0, -3);
        this.tail.setPos(0.0F, 0.0F, 3.0F);
        this.tail.addBox(0.0F, -2.0F, 0.0F, 0.0F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.finLeft = new ModelRenderer(this, 0, 2);
        this.finLeft.mirror = true;
        this.finLeft.setPos(2.0F, 1.0F, 0.0F);
        this.finLeft.addBox(0.0F, 0.0F, -1.0F, 0.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(finLeft, 0.0F, 0.0F, -0.6108652381980153F);
        this.body.addChild(this.finRight);
        this.body.addChild(this.tail);
        this.body.addChild(this.finLeft);
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        ImmutableList.of(this.body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float f = 1.0F;
        if (!entityIn.isInWater()) {
            f = 1.5F;
        }

        this.tail.yRot = -f * 0.45F * MathHelper.sin(0.6F * ageInTicks);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
