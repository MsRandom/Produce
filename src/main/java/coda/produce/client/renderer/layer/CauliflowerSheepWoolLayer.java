package coda.produce.client.renderer.layer;

import coda.produce.Produce;
import coda.produce.client.model.CauliflowerSheepModel;
import coda.produce.entity.CauliflowerSheepEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CauliflowerSheepWoolLayer extends LayerRenderer<CauliflowerSheepEntity, CauliflowerSheepModel<CauliflowerSheepEntity>> {
    private static final RenderType TEXTURE = RenderType.getEntityCutoutNoCull(new ResourceLocation(Produce.MOD_ID, "textures/entity/cauliflower_sheep/normal.png"));

    public CauliflowerSheepWoolLayer(IEntityRenderer<CauliflowerSheepEntity, CauliflowerSheepModel<CauliflowerSheepEntity>> rendererIn) {
        super(rendererIn);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, CauliflowerSheepEntity entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(this.getRenderType());
        if (!entitylivingbaseIn.isSheared()) {
            this.getEntityModel().render(matrixStackIn, ivertexbuilder,  packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        }
    }

    public RenderType getRenderType() {
        return TEXTURE;
    }
}