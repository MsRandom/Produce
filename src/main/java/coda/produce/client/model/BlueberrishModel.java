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
public class BlueberrishModel<T extends Entity> extends EntityModel<T> {
    public ModelRenderer body;
    public ModelRenderer finLeft;
    public ModelRenderer finRight;
    public ModelRenderer caudalFin1;
    public ModelRenderer caudalFin2;
    public ModelRenderer caudalFin3;
    public ModelRenderer caudalFin4;

    public BlueberrishModel() {
        this.texWidth = 32;
        this.texHeight = 32;
        this.caudalFin1 = new ModelRenderer(this, 0, 0);
        this.caudalFin1.mirror = true;
        this.caudalFin1.setPos(0.0F, 0.0F, 2.5F);
        this.caudalFin1.addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(caudalFin1, -0.5235987755982988F, 0.0F, 0.0F);
        this.finLeft = new ModelRenderer(this, 0, 3);
        this.finLeft.mirror = true;
        this.finLeft.setPos(2.0F, 1.0F, 0.0F);
        this.finLeft.addBox(0.0F, 0.0F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(finLeft, 0.0F, 0.0F, -0.6108652381980153F);
        this.caudalFin3 = new ModelRenderer(this, 0, 0);
        this.caudalFin3.setPos(0.5F, 0.5F, 2.5F);
        this.caudalFin3.addBox(0.0F, -1.0F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(caudalFin3, 0.0F, -0.5235987755982988F, 0.0F);
        this.caudalFin4 = new ModelRenderer(this, 0, 2);
        this.caudalFin4.setPos(-0.5F, 0.5F, 2.5F);
        this.caudalFin4.addBox(-2.0F, -1.0F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(caudalFin4, 0.0F, 0.5235987755982988F, 0.0F);
        this.caudalFin2 = new ModelRenderer(this, 0, 2);
        this.caudalFin2.mirror = true;
        this.caudalFin2.setPos(0.0F, 1.0F, 2.5F);
        this.caudalFin2.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(caudalFin2, 0.5235987755982988F, 0.0F, 0.0F);
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setPos(0.0F, 22.0F, 0.0F);
        this.body.addBox(-2.0F, -2.0F, -2.5F, 4.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.finRight = new ModelRenderer(this, 0, 3);
        this.finRight.setPos(-2.0F, 1.0F, 0.0F);
        this.finRight.addBox(0.0F, 0.0F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(finRight, 0.0F, 0.0F, 0.6108652381980153F);
        this.body.addChild(this.caudalFin1);
        this.body.addChild(this.finLeft);
        this.body.addChild(this.caudalFin3);
        this.body.addChild(this.caudalFin4);
        this.body.addChild(this.caudalFin2);
        this.body.addChild(this.finRight);
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        ImmutableList.of(this.body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
