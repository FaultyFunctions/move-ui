package net.craftmayham.movehotbar;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.api.ClientModInitializer;

import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;

public class MoveHotbar implements ClientModInitializer {
    public static final String MOD_ID = "move-hotbar";

	public static File file = new File(FabricLoader.getInstance().getConfigDir().toFile(), "move-ui.json");
	public static Gson gson = new GsonBuilder().setPrettyPrinting().create();
	public static Config config = new Config();

	public static class Config {

		public int hotbarx = 0;
		public int hotbary = 0;
		public int textx = 0;
		public int texty = 0;
		public int expx = 0;
		public int expy = 0;
		public int expdx=0;
		public int expdy=0;
		public int healthx=0;
		public int healthy=0;
		public int healthspacing=0;
		public int hungerx=0;
		public int hungery=0;
		public int hungerspacing=0;
		public int actionbarx=0;
		public int actionbary=0;
		public int bossbarx=0;
		public int bossbary=0;
	}

	public static void saveConfig() {
		try {
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(gson.toJson(getConfig()));
			fileWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void loadConfig() {
		try {
			if (file.exists()) {
				config = gson.fromJson(Files.readString(file.toPath()), Config.class);
			} else {
				config = new Config();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		setConfig(config);
	}

	public static void setConfig(Config config) {
		MoveHotbar.config = config;
	}
	public static Config getConfig() {
		return config;
	}
	public static int getHotbarX() {
		return config.hotbarx;
	}
	public static int getHotbarY() {
		return config.hotbary;
	}
	public static int getTextX() {
		return config.textx;
	}
	public static int getTextY() {
		return config.texty;
	}
	public static int getExpX() {
		return config.expx;
	}
	public static int getExpY() {
		return config.expy;
	}
	public static int getExpDX() {
		return config.expdx;
	}
	public static int getExpDY() {
		return config.expdy;
	}
	public static int getHealthX() {
		return config.healthx;
	}
	public static int getHealthY() {
		return config.healthy;
	}
	public static int getHealthSpacing() {
		return config.healthspacing;
	}
	public static int getHungerX() {
		return config.hungerx;
	}
	public static int getHungerY() {
		return config.hungery;
	}
	public static int getHungerSpacing() {
		return config.hungerspacing;
	}
	public static int getActionBarX() { return config.actionbarx; }
	public static int getActionBarY() { return config.actionbary; }
	public static int getBossBarX() { return config.bossbarx; }
	public static int getBossBarY() { return config.bossbary; }

	public static void putObjects() {
		FabricLoader.getInstance().getObjectShare().put("movehotbar:x", config.hotbarx);
		FabricLoader.getInstance().getObjectShare().put("movehotbar:y", config.hotbary);
		FabricLoader.getInstance().getObjectShare().put("text:x", config.textx);
		FabricLoader.getInstance().getObjectShare().put("text:y", config.texty);
		FabricLoader.getInstance().getObjectShare().put("exp:x", config.expx);
		FabricLoader.getInstance().getObjectShare().put("exp:y", config.expy);
		FabricLoader.getInstance().getObjectShare().put("expd:x", config.expdx);
		FabricLoader.getInstance().getObjectShare().put("expd:y", config.expdy);
		FabricLoader.getInstance().getObjectShare().put("health:x", config.healthx);
		FabricLoader.getInstance().getObjectShare().put("health:y", config.healthy);
		FabricLoader.getInstance().getObjectShare().put("health:spacing", config.healthspacing);
		FabricLoader.getInstance().getObjectShare().put("hunger:x", config.hungerx);
		FabricLoader.getInstance().getObjectShare().put("hunger:y", config.hungery);
		FabricLoader.getInstance().getObjectShare().put("hunger:spacing", config.hungerspacing);
		FabricLoader.getInstance().getObjectShare().put("actionbar:x", config.actionbarx);
		FabricLoader.getInstance().getObjectShare().put("actionbar:y", config.actionbary);
		FabricLoader.getInstance().getObjectShare().put("bossbar:x", config.bossbarx);
		FabricLoader.getInstance().getObjectShare().put("bossbar:y", config.bossbary);
	}
	@Override
	public void onInitializeClient() {
		if (!file.exists()) {
			saveConfig();
		}
		loadConfig();
		putObjects();
	}

}