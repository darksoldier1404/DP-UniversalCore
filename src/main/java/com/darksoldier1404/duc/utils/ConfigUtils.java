package com.darksoldier1404.duc.utils;

import com.darksoldier1404.duc.UniversalCore;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.logging.Logger;

public class ConfigUtils {
    private static final UniversalCore uc = UniversalCore.getInstance();
    private static final Logger log = uc.getLogger();

    @NotNull
    public static YamlConfiguration loadDefaultPluginConfig(@NotNull JavaPlugin plugin) {
        File fconfig = new File(plugin.getDataFolder(), "config.yml");
        if (!fconfig.exists()) {
            plugin.saveResource("config.yml", false);
        }
        return YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder(), "config.yml"));
    }
    // save plugin's config
    public static void savePluginConfig(@NotNull JavaPlugin plugin, @NotNull YamlConfiguration config) {
        try {
            config.save(new File(plugin.getDataFolder(), "config.yml"));
        } catch (Exception e) {
            log.warning("[DUC] " + plugin.getName() + " 콘피그 파일 저장 실패.");
            e.printStackTrace();
        }
    }

    // reload plugin's config
    @Nullable
    public static YamlConfiguration reloadPluginConfig(@NotNull JavaPlugin plugin, @NotNull YamlConfiguration config) {
        try {
            return YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder(), "config.yml"));
        } catch (Exception e) {
            log.warning("[DUC] " + plugin.getName() + " 콘피그 파일 다시 불러오기 실패, 파일이 존재하지 않습니다.");
            e.printStackTrace();
        }
        return null;
    }
}
