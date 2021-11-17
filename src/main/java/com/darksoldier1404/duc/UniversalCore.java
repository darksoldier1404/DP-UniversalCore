package com.darksoldier1404.duc;

import com.darksoldier1404.duc.utils.PluginUtil;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class UniversalCore extends JavaPlugin {
    private static UniversalCore plugin;
    private Logger log;
    private final Map<String, JavaPlugin> enabledPlugins = new HashMap<>();

    public static UniversalCore getInstance() {
        return plugin;
    }

    public Map<String, JavaPlugin> getEnabledPlugins() {
        return enabledPlugins;
    }

    @Override
    public @NotNull Logger getLogger() {
        return log;
    }

    @Override
    public void onEnable() {
        plugin = this;
        log = getLogger();
        log.info("UniversalCore has been enabled");
        PluginUtil.loadALLPlugins();
    }

    @Override
    public void onDisable() {
        plugin = null;
        log.info("UniversalCore has been disabled");
    }
}
