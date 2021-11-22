package com.darksoldier1404.duc.utils;

import com.darksoldier1404.duc.UniversalCore;
import com.darksoldier1404.duc.enums.PluginName;
import com.darksoldier1404.dvs.VirtualStorage;
import com.earth2me.essentials.Essentials;
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
        pl = pm.getPlugin("DP-LegendaryCash");
        if (pl != null) {
            plugin.getEnabledPlugins().put(PluginName.LegendaryCash, (JavaPlugin) pl);
            log.info(prefix + " DP-LegendaryCash 플러그인 활성화.");
            new Metrics((JavaPlugin) pl, 13387);
        }
        pl = pm.getPlugin("DP-VirtualStorage");
        if (pl != null) {
            VirtualStorage vs = (VirtualStorage) pl;
            if(plugin.getServer().getPluginManager().getPlugin("Essentials") == null) {
                log.warning(prefix + " 에센셜 플러그인이 감지되지 않음.");
                log.warning(prefix + " Essentials 플러그인이 설치되어 있지 않아 DP-VirtualStorage 플러그인의 창고 구매 기능을 비활성화 합니다.");
                vs.ess = null;
            }else{
                vs.ess = (Essentials) plugin.getServer().getPluginManager().getPlugin("Essentials");
                plugin.getEnabledPlugins().put(PluginName.VirtualStorage, (JavaPlugin) pl);
                log.info(prefix + " DP-VirtualStorage 플러그인 활성화.");
                new Metrics((JavaPlugin) pl, 13386);
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
        return plugin.config.getBoolean("Settings."+name.getName()+".update-check");
    }

    public static long getUpdateCheckInterval(PluginName name) {
        return plugin.config.getLong("Settings."+name.getName()+".update-check-interval");
    }

    public static boolean isMetricsEnabled(PluginName name) {
        return plugin.config.getBoolean("Settings."+name.getName()+".use-metrics");
    }
}
