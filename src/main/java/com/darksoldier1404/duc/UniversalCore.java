package com.darksoldier1404.duc;

import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UniversalCore extends JavaPlugin {
    private static UniversalCore plugin;
    private Logger log;
    private final List<JavaPlugin> enabledPlugins = new ArrayList<>();

    public static UniversalCore getInstance() {
        return plugin;
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
    }

    @Override
    public void onDisable() {
        plugin = null;
        log.info("UniversalCore has been disabled");
    }
}
