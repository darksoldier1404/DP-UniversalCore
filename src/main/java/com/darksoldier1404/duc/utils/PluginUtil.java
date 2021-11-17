package com.darksoldier1404.duc.utils;

import com.darksoldier1404.duc.UniversalCore;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class PluginUtil {
    private final UniversalCore plugin = UniversalCore.getInstance();
    private final PluginManager pm = Bukkit.getPluginManager();
    private final Logger log = plugin.getLogger();

    public void loadALLPlugins() {
        if(pm.getPlugin("DP-LegendaryCash") != null) {

            plugin.getEnabledPlugins().add((JavaPlugin) pm.getPlugin("DP-LegendaryCash"));
            log.info("[DUC] DP-LegendaryCash has been loaded.");
        }
        if(pm.getPlugin("DP-VirtualStorage") != null) {
            plugin.getEnabledPlugins().add((JavaPlugin) pm.getPlugin("DP-VirtualStorage"));
            log.info("[DUC] DP-VirtualStorage has been loaded.");
        }
    }

    public boolean isPluginEnabled(JavaPlugin plugin) {
        return this.plugin.getEnabledPlugins().contains(plugin);
    }

    public void enablePlugin(JavaPlugin plugin) {
        this.plugin.getEnabledPlugins().add(plugin);
        Bukkit.getPluginManager().enablePlugin(plugin);
    }

    public void disablePlugin(JavaPlugin plugin) {
        this.plugin.getEnabledPlugins().remove(plugin);
        Bukkit.getPluginManager().disablePlugin(plugin);
    }

    public void reloadPlugin(JavaPlugin plugin) {
        this.plugin.getEnabledPlugins().remove(plugin);
        Bukkit.getPluginManager().disablePlugin(plugin);
        this.plugin.getEnabledPlugins().add(plugin);
        Bukkit.getPluginManager().enablePlugin(plugin);
    }
}
