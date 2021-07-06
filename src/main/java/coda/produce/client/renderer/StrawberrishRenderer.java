package coda.produce.client.renderer;

import coda.produce.Produce;
import coda.produce.client.model.StrawberrishModel;
import coda.produce.entity.StrawberrishEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class StrawberrishRenderer extends MobRenderer<StrawberrishEntity, StrawberrishModel<StrawberrishEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Produce.MOD_ID, "textures/entity/strawberrish.png");

    public StrawberrishRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new StrawberrishModel<>(), 0.2F);
    }

    public ResourceLocation getTextureLocation(StrawberrishEntity entity) {
        return TEXTURE;
    }
}