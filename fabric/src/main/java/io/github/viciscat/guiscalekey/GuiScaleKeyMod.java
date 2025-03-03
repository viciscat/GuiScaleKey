package io.github.viciscat.guiscalekey;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenKeyboardEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenMouseEvents;

public class GuiScaleKeyMod implements ModInitializer {
    
    @Override
    public void onInitialize() {
        
        // This method is invoked by the Fabric mod loader when it is ready
        // to load your mod. You can access Fabric and Common code in this
        // project.

        // Use Fabric to bootstrap the Common mod.
        Constants.LOG.info("Hello Fabric world!");
        CommonClass.init();

        CommonClass.registerKeys(KeyBindingHelper::registerKeyBinding);

        ClientTickEvents.START_CLIENT_TICK.register(client -> CommonClass.checkKeyPresses());
        ScreenEvents.BEFORE_INIT.register((minecraft, screen, i, i1) -> {
            ScreenKeyboardEvents.afterKeyPress(screen).register((screen1, key, scancode, modifiers) ->
                    CommonClass.checkKeyPressesScreen(key, scancode));
            ScreenMouseEvents.afterMouseClick(screen).register((screen1, x, y, mouseButton) ->
                    CommonClass.checkMouseScreen(mouseButton));
        });
    }
}
