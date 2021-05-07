package coda.produce.client;

import coda.produce.Produce;
import coda.produce.client.renderer.CauliflowerSheepRenderer;
import coda.produce.init.ProduceEntities;
import coda.produce.item.ProduceSpawnEggItem;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = Produce.MOD_ID)
public class ClientEvents {

    @OnlyIn(Dist.CLIENT)
    public static void init() {
        RenderingRegistry.registerEntityRenderingHandler(ProduceEntities.CAULIFLOWER_SHEEP.get(), CauliflowerSheepRenderer::new);
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void itemColors(ColorHandlerEvent.Item event) {
        ItemColors handler = event.getItemColors();
        IItemColor eggColor = (stack, tintIndex) -> ((ProduceSpawnEggItem) stack.getItem()).getColor(tintIndex);
        for (ProduceSpawnEggItem e : ProduceSpawnEggItem.UNADDED_EGGS) handler.register(eggColor, e);
    }
}
