package com.darksoldier1404.duc.utils;

import com.darksoldier1404.duc.UniversalCore;
import com.darksoldier1404.dvs.VirtualStorage;
import com.earth2me.essentials.Essentials;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class PluginUtil {
    private static final UniversalCore plugin = UniversalCore.getInstance();
    private static final PluginManager pm = Bukkit.getPluginManager();
    private static final Logger log = plugin.getLogger();

    public static void loadALLPlugins() {
        Plugin pl;
        pl = pm.getPlugin("Essentials");
        if (pl != null) {
            plugin.getEnabledPlugins().put(pl.getName(), (JavaPlugin) pl);
            log.info("[DUC] Essentials 플러그인 감지됨.");
        }
        pl = pm.getPlugin("PlaceholderAPI");
        if (pl != null) {
            plugin.getEnabledPlugins().put(pl.getName(), (JavaPlugin) pl);
            log.info("[DUC] PlaceholderAPI 플러그인 감지됨.");
        }
        pl = pm.getPlugin("DP-LegendaryCash");
        if (pl != null) {
            plugin.getEnabledPlugins().put(pl.getName(), (JavaPlugin) pl);
            log.info("[DUC] DP-LegendaryCash 플러그인 감지됨.");
        }
        pl = pm.getPlugin("DP-VirtualStorage");
        if (pl != null) {
            VirtualStorage vs = (VirtualStorage) pl;
            if(!plugin.getEnabledPlugins().containsKey("Essentials")) {
                log.warning("[DUC] 에센셜 플러그인이 감지되지 않음");
                log.warning("[DUC] Essentials 플러그인이 설치되어 있지 않아 DP-VirtualStorage 플러그인의 창고 구매 기능을 비활성화 합니다.");
                vs.ess = null;
            }else{
                vs.ess = (Essentials) plugin.getEnabledPlugins().get("Essentials");
                plugin.getEnabledPlugins().put(pl.getName(), (JavaPlugin) pl);
                log.info("[DUC] DP-VirtualStorage 플러그인 감지됨.");
            }
        }
    }

    public static boolean isPluginEnabled(JavaPlugin pl) {
        return PluginUtil.plugin.getEnabledPlugins().containsKey(pl.getName());
    }

    public static void enablePlugin(JavaPlugin pl) {
        PluginUtil.plugin.getEnabledPlugins().put(pl.getName(), pl);
        Bukkit.getPluginManager().enablePlugin(pl);
    }

    public static void disablePlugin(JavaPlugin pl) {
        PluginUtil.plugin.getEnabledPlugins().remove(pl.getName());
        Bukkit.getPluginManager().disablePlugin(pl);
    }

    public static void reloadPlugin(JavaPlugin pl) {
        PluginUtil.plugin.getEnabledPlugins().remove(pl.getName());
        Bukkit.getPluginManager().disablePlugin(pl);
        PluginUtil.plugin.getEnabledPlugins().put(pl.getName(), pl);
        Bukkit.getPluginManager().enablePlugin(pl);
    }
}
