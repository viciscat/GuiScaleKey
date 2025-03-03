package io.github.viciscat.guiscalekey;

import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class GuiScaleKeyMod {

    public GuiScaleKeyMod() {

        // This method is invoked by the Forge mod loader when it is ready
        // to load your mod. You can access Forge and Common code in this
        // project.

        // Use Forge to bootstrap the Common mod.
        Constants.LOG.info("Hello Forge world!");
        CommonClass.init();
        MinecraftForge.EVENT_BUS.register(this);

    }

    @SubscribeEvent
    public void screenKeyPressEvent(ScreenEvent.KeyPressed event) {
        CommonClass.checkKeyPressesScreen(event.getKeyCode(), event.getScanCode());
    }

    @SubscribeEvent
    public void screenMouseEvent(ScreenEvent.MouseButtonPressed event) {
        CommonClass.checkMouseScreen(event.getButton());
    }

    @SubscribeEvent
    public void registerKeys(RegisterKeyMappingsEvent event) {
        CommonClass.registerKeys(event::register);
    }

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent.Pre event) {
        CommonClass.checkKeyPresses();
    }
}