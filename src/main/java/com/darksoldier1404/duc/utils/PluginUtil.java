package com.darksoldier1404.duc.utils;

import com.darksoldier1404.duc.UniversalCore;
import com.darksoldier1404.duc.enums.PluginName;
import com.darksoldier1404.dvs.VirtualStorage;
import com.earth2me.essentials.Essentials;
import me.clip.placeholderapi.PlaceholderAPIPlugin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

@SuppressWarnings("all")
public class PluginUtil {
    private static final UniversalCore plugin = UniversalCore.getInstance();
    private static final String prefix = plugin.prefix;
    private static final PluginManager pm = Bukkit.getPluginManager();
    private static final Logger log = plugin.getLogger();

    public static void loadALLPlugins() {
        Plugin pl;
        pl = pm.getPlugin("Essentials");
        if (pl != null) {
            plugin.ess = (Essentials) pl;
        }
        pl = pm.getPlugin("PlaceholderAPI");
        if (pl != null) {
            plugin.papi = (PlaceholderAPIPlugin) pl;
        }
        for(PluginName name : PluginName.values()) {
            pl = pm.getPlugin(name.getName());
            if (pl != null) {
                if(name.equals(PluginName.VirtualStorage)) {
                    VirtualStorage vs = (VirtualStorage) pl;
                    if (plugin.ess == null) {
                        log.warning(prefix + " 에센셜 플러그인이 감지되지 않음.");
                        log.warning(prefix + " Essentials 플러그인이 설치되어 있지 않아 DP-VirtualStorage 플러그인의 창고 구매 기능을 비활성화 합니다.");
                        vs.ess = null;
                    } else {
                        vs.ess = plugin.ess;
                    }
                }
                plugin.getEnabledPlugins().put(name, (JavaPlugin) pl);
                log.info(prefix + name.getName() + " 플러그인 활성화.");
                if(isMetricsEnabled(name)) {
                    new Metrics((JavaPlugin) pl, name.getPluginID());
                }
            }
        }
    }

    public static boolean isPluginEnabled(JavaPlugin pl) {
        return PluginUtil.plugin.getEnabledPlugins().containsKey(PluginName.valueOf(pl.getName()));
    }

    public static void enablePlugin(JavaPlugin pl) {
        PluginUtil.plugin.getEnabledPlugins().put(PluginName.valueOf(pl.getName()), pl);
        Bukkit.getPluginManager().enablePlugin(pl);
    }

    public static void disablePlugin(JavaPlugin pl) {
        PluginUtil.plugin.getEnabledPlugins().remove(PluginName.valueOf(pl.getName()));
        Bukkit.getPluginManager().disablePlugin(pl);
    }

    public static void reloadPlugin(JavaPlugin pl) {
        PluginUtil.plugin.getEnabledPlugins().remove(PluginName.valueOf(pl.getName()));
        Bukkit.getPluginManager().disablePlugin(pl);
        PluginUtil.plugin.getEnabledPlugins().put(PluginName.valueOf(pl.getName()), pl);
        Bukkit.getPluginManager().enablePlugin(pl);
    }

    public static boolean isUpdateCheckEnabled(PluginName name) {
        return plugin.config.getStringList("Settings.update-check-excluded") == null ? true : !plugin.config.getStringList("Settings.update-check-excluded").contains(name.getName());
    }

    public static long getUpdateCheckInterval(PluginName name) {
        return plugin.config.getLong("Settings.update-check-interval");
    }

    public static boolean isMetricsEnabled(PluginName name) {
        return plugin.config.getStringList("Settings.metrics-excluded") == null ? true : !plugin.config.getStringList("Settings.metrics-excluded").contains(name.getName());
    }
}
