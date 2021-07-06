package coda.produce.client.renderer;

import coda.produce.Produce;
import coda.produce.client.model.CauliflowerSheepModel;
import coda.produce.client.renderer.layer.CauliflowerSheepWoolLayer;
import coda.produce.entity.CauliflowerSheepEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CauliflowerSheepRenderer extends MobRenderer<CauliflowerSheepEntity, CauliflowerSheepModel<CauliflowerSheepEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Produce.MOD_ID, "textures/entity/cauliflower_sheep/sheared.png");

    public CauliflowerSheepRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new CauliflowerSheepModel<>(), 0.7F);
        this.addLayer(new CauliflowerSheepWoolLayer(this));
    }

    public ResourceLocation getTextureLocation(CauliflowerSheepEntity entity) {
        return TEXTURE;
    }
}
