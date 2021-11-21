package com.darksoldier1404.duc;

import com.darksoldier1404.duc.enums.PluginName;
import com.darksoldier1404.duc.utils.ConfigUtils;
import com.darksoldier1404.duc.utils.PluginUtil;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class UniversalCore extends JavaPlugin {
    private static UniversalCore plugin;
    private YamlConfiguration config;
    private Logger log;
    public final String prefix = "§f[ §eDUC §f] ";
    private final Map<PluginName, JavaPlugin> enabledPlugins = new HashMap<>();

    public static UniversalCore getInstance() {
        return plugin;
    }

    public Map<PluginName, JavaPlugin> getEnabledPlugins() {
        return enabledPlugins;
    }

    @Override
    public void onEnable() {
        plugin = this;
        log = getLogger();
        log.info(prefix + "DP-UniversalCore 플러그인 활성화.");
        PluginUtil.loadALLPlugins();
        ConfigUtils.loadDefaultPluginConfig(plugin);
    }

    @Override
    public void onDisable() {
        log.info(prefix + "DP-UniversalCore 플러그인 비활성화.");
        ConfigUtils.savePluginConfig(plugin, config);
    }
}
