package io.github.viciscat.guiscalekey;

import io.github.viciscat.guiscalekey.platform.Services;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.gui.screens.options.controls.KeyBindsScreen;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.input.MouseButtonEvent;

import java.util.function.Consumer;

// This class is part of the common project meaning it is shared between all supported loaders. Code written here can only
// import and access the vanilla codebase, libraries used by vanilla, and optionally third party libraries that provide
// common compatible binaries. This means common code can not directly use loader specific concepts such as Forge events
// however it will be compatible with all supported mod loaders.
public class CommonClass {

    // The loader specific projects are able to import and use any code from the common project. This allows you to
    // write the majority of your code here and load it from your loader specific projects. This example has some
    // code that gets invoked by the entry point of the loader specific projects.
    public static void init() {

        Constants.LOG.info("Starting GuiScaleKeys mod on {}!", Services.PLATFORM.getPlatformName());
        //Constants.LOG.info("The ID for diamonds is {}", BuiltInRegistries.ITEM.getKey(Items.DIAMOND));

        // It is common for all supported loaders to provide a similar feature that can not be used directly in the
        // common code. A popular way to get around this is using Java's built-in service loader feature to create
        // your own abstraction layer. You can learn more about this in our provided services class. In this example
        // we have an interface in the common code and use a loader specific implementation to delegate our call to
        // the platform specific approach.
        /*if (Services.PLATFORM.isModLoaded("guiscalekey")) {

            Constants.LOG.info("Hello to guiscalekey");
        }*/
    }

    public static void registerKeys(Consumer<KeyMapping> consumer) {
        consumer.accept(Constants.DECREASE_SCALE_KEY);
        consumer.accept(Constants.INCREASE_SCALE_KEY);
    }

    public static void checkKeyPresses() {
        while (Constants.INCREASE_SCALE_KEY.consumeClick()) {
            changeGuiScale(true);
        }
        while (Constants.DECREASE_SCALE_KEY.consumeClick()) {
            changeGuiScale(false);
        }
    }

    public static void checkKeyPressesScreen(KeyEvent keyEvent) {
        if (Minecraft.getInstance().screen instanceof KeyBindsScreen) return;
        if (Constants.INCREASE_SCALE_KEY.matches(keyEvent)) {
            changeGuiScale(true);
        }
        if (Constants.DECREASE_SCALE_KEY.matches(keyEvent)) {
            changeGuiScale(false);
        }
    }

    public static void checkMouseScreen(MouseButtonEvent button) {
        if (Minecraft.getInstance().screen instanceof KeyBindsScreen) return;
        if (Constants.INCREASE_SCALE_KEY.matchesMouse(button)) {
            changeGuiScale(true);
        }
        if (Constants.DECREASE_SCALE_KEY.matchesMouse(button)) {
            changeGuiScale(false);
        }
    }

    public static void changeGuiScale(boolean up) {
        Minecraft mc = Minecraft.getInstance();
        OptionInstance<Integer> scale = mc.options.guiScale();
        int i = scale.get();
        i = i == 0 ? mc.getWindow().calculateScale(0, mc.isEnforceUnicode()) : i;
        scale.set(Math.max(1, i + (up ? 1 : -1)));
        mc.options.save();
    }
}