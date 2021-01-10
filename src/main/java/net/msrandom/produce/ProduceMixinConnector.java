package net.msrandom.produce;

import org.spongepowered.asm.mixin.Mixins;
import org.spongepowered.asm.mixin.connect.IMixinConnector;

public class ProduceMixinConnector implements IMixinConnector {
    @Override
    public void connect(){
        Mixins.addConfiguration(ProduceMod.MOD_ID + ".mixin.json");
    }
}
