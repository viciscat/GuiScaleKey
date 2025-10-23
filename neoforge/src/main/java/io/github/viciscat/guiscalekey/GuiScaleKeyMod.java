package io.github.viciscat.guiscalekey;


import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.ScreenEvent;
import net.neoforged.neoforge.common.NeoForge;

@Mod(Constants.MOD_ID)
public class GuiScaleKeyMod {

    public GuiScaleKeyMod(IEventBus eventBus) {

        // This method is invoked by the NeoForge mod loader when it is ready
        // to load your mod. You can access NeoForge and Common code in this
        // project.

        // Use NeoForge to bootstrap the Common mod.
        CommonClass.init();
        NeoForge.EVENT_BUS.register(this);
        eventBus.addListener(this::registerKeys);
    }

    @SubscribeEvent
    public void screenKeyPressEvent(ScreenEvent.KeyPressed.Post event) {
        CommonClass.checkKeyPressesScreen(event.getKeyEvent());
    }

    @SubscribeEvent
    public void screenMouseEvent(ScreenEvent.MouseButtonPressed.Post event) {
        CommonClass.checkMouseScreen(event.getMouseButtonEvent());
    }

    public void registerKeys(RegisterKeyMappingsEvent event) {
        CommonClass.registerKeys(event::register);
    }

    @SubscribeEvent
    public void onClientTick(ClientTickEvent.Pre event) {
        CommonClass.checkKeyPresses();
    }
}