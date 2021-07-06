package coda.produce.client.renderer;

import coda.produce.Produce;
import coda.produce.client.model.BlueberrishModel;
import coda.produce.entity.BlueberrishEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BlueberrishRenderer extends MobRenderer<BlueberrishEntity, BlueberrishModel<BlueberrishEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Produce.MOD_ID, "textures/entity/blueberrish.png");

    public BlueberrishRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new BlueberrishModel<>(), 0.2F);
    }

    public ResourceLocation getTextureLocation(BlueberrishEntity entity) {
        return TEXTURE;
    }
}
