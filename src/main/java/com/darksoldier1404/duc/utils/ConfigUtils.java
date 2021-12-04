package com.darksoldier1404.duc.utils;

import com.darksoldier1404.duc.UniversalCore;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@SuppressWarnings("all")
public class ConfigUtils {
    private static final UniversalCore core = UniversalCore.getInstance();
    private static final Logger log = core.log;

    public static void test() {
        Player p = null;

    }

    @NotNull
    public static YamlConfiguration loadDefaultPluginConfig(@NotNull JavaPlugin plugin) {
        File fconfig = new File(plugin.getDataFolder(), "config.yml");
        if (!fconfig.exists()) {
            plugin.saveResource("config.yml", false);
            log.info("[DUC] " + plugin.getName() + " 콘피그 파일 생성.");
        }
        log.info("[DUC] " + plugin.getName() + " 콘피그 파일 불러오기 성공.");
        return YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder(), "config.yml"));
    }

    // save plugin's config
    public static void savePluginConfig(@NotNull JavaPlugin plugin, @NotNull YamlConfiguration config) {
        try {
            config.save(new File(plugin.getDataFolder(), "config.yml"));
            log.info("[DUC] " + plugin.getName() + " 콘피그 파일 저장 성공.");
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
            log.warning("[DUC] " + plugin.getName() + " 콘피그 파일 리로드 실패, 파일이 존재하지 않습니다.");
            e.printStackTrace();
        }
        return null;
    }

    public static void saveCustomData(@NotNull JavaPlugin plugin, @NotNull YamlConfiguration config, @NotNull String fileName, @NotNull String path) {
        try {
            config.save(new File(plugin.getDataFolder() + "/" + path, fileName + ".yml"));
            log.info("[DUC] " + plugin.getName() + " " + fileName + " 파일 저장 성공.");
        } catch (Exception e) {
            log.warning("[DUC] " + plugin.getName() + " " + fileName + " 파일 저장 실패.");
            e.printStackTrace();
        }
    }

    public static void saveCustomData(@NotNull JavaPlugin plugin, @NotNull YamlConfiguration config, @NotNull String fileName) {
        try {
            config.save(new File(plugin.getDataFolder(), fileName + ".yml"));
            log.info("[DUC] " + plugin.getName() + " " + fileName + " 파일 저장 성공.");
        } catch (Exception e) {
            log.warning("[DUC] " + plugin.getName() + " " + fileName + " 파일 저장 실패.");
            e.printStackTrace();
        }
    }

    // load
    @Nullable
    public static YamlConfiguration loadCustomData(@NotNull JavaPlugin plugin, @NotNull String fileName, @NotNull String path) {
        try {
            YamlConfiguration data = YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder() + "/" + path, fileName + ".yml"));
            log.info("[DUC] " + plugin.getName() + " " + fileName + " 파일 불러오기 성공.");
            return data;
        } catch (Exception e) {
            log.warning("[DUC] " + plugin.getName() + " " + fileName + " 파일 불러오기 실패.");
            e.printStackTrace();
        }
        return null;
    }

    @Nullable
    public static YamlConfiguration loadCustomData(@NotNull JavaPlugin plugin, @NotNull String fileName) {
        try {
            YamlConfiguration data = YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder(), fileName + ".yml"));
            log.info("[DUC] " + plugin.getName() + " " + fileName + " 파일 불러오기 성공.");
            return data;
        } catch (Exception e) {
            log.warning("[DUC] " + plugin.getName() + " " + fileName + " 파일 불러오기 실패.");
            e.printStackTrace();
        }
        return null;
    }

    public static List<YamlConfiguration> loadCustomDataList(@NotNull JavaPlugin plugin, @NotNull String path) {
        List<YamlConfiguration> dataList = new ArrayList<>();
        File folder = new File(plugin.getDataFolder() + "/" + path);
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try {
                        YamlConfiguration data = YamlConfiguration.loadConfiguration(file);
                        log.info("[DUC] " + plugin.getName() + " " + file.getName() + " 파일 불러오기 성공.");
                        dataList.add(data);
                    } catch (Exception e) {
                        log.warning("[DUC] " + plugin.getName() + " " + file.getName() + " 파일 불러오기 실패.");
                        e.printStackTrace();
                    }
                }
            }
        }
        return dataList;
    }

    // create
    @Nullable
    public static YamlConfiguration createCustomData(@NotNull JavaPlugin plugin, @NotNull String fileName, @NotNull String path) {
        try {
            File file = new File(plugin.getDataFolder() + "/" + path, fileName + ".yml");
            if (!file.exists()) {
                file.createNewFile();
                log.info("[DUC] " + plugin.getName() + " " + fileName + " 파일 생성 성공.");
                return YamlConfiguration.loadConfiguration(file);
            }
            log.info("[DUC] " + plugin.getName() + " " + fileName + " 이미 존재하는 파일입니다.");
            return null;
        } catch (Exception e) {
            log.warning("[DUC] " + plugin.getName() + " " + fileName + " 파일 생성 실패.");
            e.printStackTrace();
            return null;
        }
    }

    @Nullable
    public static YamlConfiguration createCustomData(@NotNull JavaPlugin plugin, @NotNull String fileName) {
        try {
            File file = new File(plugin.getDataFolder(), fileName + ".yml");
            if (!file.exists()) {
                file.createNewFile();
                log.info("[DUC] " + plugin.getName() + " " + fileName + " 파일 생성 성공.");
                return YamlConfiguration.loadConfiguration(file);
            }
            log.info("[DUC] " + plugin.getName() + " " + fileName + " 이미 존재하는 파일입니다.");
            return null;
        } catch (Exception e) {
            log.warning("[DUC] " + plugin.getName() + " " + fileName + " 파일 생성 실패.");
            e.printStackTrace();
            return null;
        }
    }

    @NotNull
    public static YamlConfiguration initUserData(@NotNull JavaPlugin plugin, @NotNull String fileName, @NotNull String path, YamlConfiguration defaultData) {
        File file = new File(plugin.getDataFolder() + "/" + path, fileName + ".yml");
        if (!file.exists()) {
            return defaultData;
        } else {
            return YamlConfiguration.loadConfiguration(file);
        }
    }

    @NotNull
    public static YamlConfiguration initUserData(@NotNull JavaPlugin plugin, @NotNull String fileName, YamlConfiguration defaultData) {
        File file = new File(plugin.getDataFolder() + "/data", fileName + ".yml");
        if (!file.exists()) {
            return defaultData;
        } else {
            return YamlConfiguration.loadConfiguration(file);
        }
    }
}
