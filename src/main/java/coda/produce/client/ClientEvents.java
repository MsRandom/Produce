package coda.produce.client;

import coda.produce.Produce;
import coda.produce.client.renderer.BlueberrishRenderer;
import coda.produce.client.renderer.CauliflowerSheepRenderer;
import coda.produce.client.renderer.StrawberrishRenderer;
import coda.produce.init.ProduceBlocks;
import coda.produce.init.ProduceEntities;
import coda.produce.item.ProduceSpawnEggItem;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.world.GrassColors;
import net.minecraft.world.biome.BiomeColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = {Dist.CLIENT}, bus = Mod.EventBusSubscriber.Bus.MOD, modid = Produce.MOD_ID)
public class ClientEvents {

    public static void init() {
        RenderingRegistry.registerEntityRenderingHandler(ProduceEntities.CAULIFLOWER_SHEEP.get(), CauliflowerSheepRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ProduceEntities.BLUEBERRISH.get(), BlueberrishRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ProduceEntities.STRAWBERRISH.get(), StrawberrishRenderer::new);

        RenderTypeLookup.setRenderLayer(ProduceBlocks.LEAFY_GREEN_SAPLING.get(), RenderType.cutout());
    }

    @SubscribeEvent
    public static void itemColors(ColorHandlerEvent.Item event) {
        ItemColors handler = event.getItemColors();
        IItemColor eggColor = (stack, tintIndex) -> ((ProduceSpawnEggItem) stack.getItem()).getColor(tintIndex);
        for (ProduceSpawnEggItem e : ProduceSpawnEggItem.UNADDED_EGGS) handler.register(eggColor, e);
    }
}
