package io.github.viciscat.guiscalekey;

import net.minecraft.client.KeyMapping;
import net.minecraft.resources.ResourceLocation;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Constants {

	public static final String MOD_ID = "guiscalekeys";
	public static final String MOD_NAME = "Gui Scale Keys";
	public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);
	private static final KeyMapping.Category CATEGORY = new KeyMapping.Category(ResourceLocation.fromNamespaceAndPath(MOD_ID, MOD_ID));

	public static final KeyMapping INCREASE_SCALE_KEY = new KeyMapping(
			"key.guiscalekeys.increase_scale",
			GLFW.GLFW_KEY_F7,
			CATEGORY
	);
	public static final KeyMapping DECREASE_SCALE_KEY = new KeyMapping(
			"key.guiscalekeys.decrease_scale",
			GLFW.GLFW_KEY_F6,
			CATEGORY
	);
	}