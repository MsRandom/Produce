package coda.produce.client;

import coda.produce.Produce;
import coda.produce.client.renderer.CauliflowerSheepRenderer;
import coda.produce.init.ProduceBlocks;
import coda.produce.init.ProduceEntities;
import coda.produce.item.ProduceSpawnEggItem;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
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
    }

    @SubscribeEvent
    public static void itemColors(ColorHandlerEvent.Item event) {
        ItemColors handler = event.getItemColors();
        IItemColor eggColor = (stack, tintIndex) -> ((ProduceSpawnEggItem) stack.getItem()).getColor(tintIndex);
        for (ProduceSpawnEggItem e : ProduceSpawnEggItem.UNADDED_EGGS) handler.register(eggColor, e);
    }

    @SubscribeEvent
    public static void blockColors(ColorHandlerEvent.Block event) {
        event.getBlockColors().register((state, reader, pos, tintIndex) -> reader != null && pos != null ? BiomeColors.getWaterColor(reader, pos) : -1, ProduceBlocks.SMOOTHIE.get());
    }
}
