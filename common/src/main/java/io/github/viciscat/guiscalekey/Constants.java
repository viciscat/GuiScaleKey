package io.github.viciscat.guiscalekey;

import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Constants {

	public static final String MOD_ID = "guiscalekey";
	public static final String MOD_NAME = "Gui Scale Key";
	public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

	public static final KeyMapping INCREASE_SCALE_KEY = new KeyMapping(
			"key.guiscalekeybind.increase_scale",
			GLFW.GLFW_KEY_F7,
			"key.categories.guiscalekeybind"
	);
	public static final KeyMapping DECREASE_SCALE_KEY = new KeyMapping(
			"key.guiscalekeybind.decrease_scale",
			GLFW.GLFW_KEY_F6,
			"key.categories.guiscalekeybind"
	);
}