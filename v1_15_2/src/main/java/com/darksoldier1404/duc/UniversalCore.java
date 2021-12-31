package com.darksoldier1404.duc;

import com.darksoldier1404.duc.api.placeholder.DPHManager;
import com.darksoldier1404.duc.commands.DUCCommand;
import com.darksoldier1404.duc.enums.PluginName;
import com.darksoldier1404.duc.utils.ConfigUtils;
import com.darksoldier1404.duc.utils.PluginUtil;
import com.darksoldier1404.duc.utils.SchedulerUtils;
import com.earth2me.essentials.Essentials;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@SuppressWarnings("all")
public class UniversalCore extends JavaPlugin {
    private static UniversalCore plugin;
    public YamlConfiguration config;
    public Logger log;
    public final String prefix = "§f[ §eDUC §f] ";
    public final Map<PluginName, JavaPlugin> enabledPlugins = new HashMap<>();
    public Essentials ess = null;
    public DPHManager dphm;

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
        config = ConfigUtils.loadDefaultPluginConfig(plugin);
        PluginUtil.loadALLPlugins();
        Bukkit.getScheduler().runTaskLater(plugin, () -> enabledPlugins.keySet().forEach(SchedulerUtils::initUpdateChecker), 1200L);
        getCommand("duc").setExecutor(new DUCCommand());
        dphm = new DPHManager();
    }

    @Override
    public void onDisable() {
        log.info(prefix + "DP-UniversalCore 플러그인 비활성화.");
        ConfigUtils.savePluginConfig(plugin, config);
    }
}
