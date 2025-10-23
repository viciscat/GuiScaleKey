package io.github.viciscat.guiscalekey;

import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Constants.MOD_ID)
public class GuiScaleKeyMod {

    public GuiScaleKeyMod(FMLJavaModLoadingContext context) {

        // This method is invoked by the Forge mod loader when it is ready
        // to load your mod. You can access Forge and Common code in this
        // project.

        // Use Forge to bootstrap the Common mod.
        CommonClass.init();
        ScreenEvent.KeyPressed.Post.BUS.addListener(this::screenKeyPressEvent);
        RegisterKeyMappingsEvent.BUS.addListener(this::registerKeys);
        ScreenEvent.MouseButtonPressed.Post.BUS.addListener(this::screenMouseEvent);
        TickEvent.ClientTickEvent.Pre.BUS.addListener(this::onClientTick);

    }

    public void screenKeyPressEvent(ScreenEvent.KeyPressed.Post event) {
        CommonClass.checkKeyPressesScreen(event.getInfo());
    }

    public void screenMouseEvent(ScreenEvent.MouseButtonPressed.Post event) {
        CommonClass.checkMouseScreen(event.getInfo());
    }

    public void registerKeys(RegisterKeyMappingsEvent event) {
        CommonClass.registerKeys(event::register);
    }

    public void onClientTick(TickEvent.ClientTickEvent.Pre event) {
        CommonClass.checkKeyPresses();
    }
}