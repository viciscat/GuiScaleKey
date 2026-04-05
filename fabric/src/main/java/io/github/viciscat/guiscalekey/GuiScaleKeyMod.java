package io.github.viciscat.guiscalekey;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
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
        CommonClass.init();

        CommonClass.registerKeys(KeyMappingHelper::registerKeyMapping);

        ClientTickEvents.START_CLIENT_TICK.register(_ -> CommonClass.checkKeyPresses());
        ScreenEvents.BEFORE_INIT.register((_, screen, _, _) -> {
            ScreenKeyboardEvents.afterKeyPress(screen).register((_, key) ->
                    CommonClass.checkKeyPressesScreen(key));
            ScreenMouseEvents.afterMouseClick(screen).register((_, event, _) -> {
                CommonClass.checkMouseScreen(event);
                return false;
            });
        });
    }
}
