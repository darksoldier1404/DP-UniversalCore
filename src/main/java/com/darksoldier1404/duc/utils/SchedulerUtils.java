package com.darksoldier1404.duc.utils;

import com.darksoldier1404.duc.UniversalCore;
import com.darksoldier1404.duc.enums.PluginName;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.Map;

public class SchedulerUtils {
    private static final UniversalCore core = UniversalCore.getInstance();
    private static final String prefix = core.prefix;
    public static final Map<PluginName, BukkitTask> tasks = new HashMap<>();

    public static void initUpdateChecker(JavaPlugin plugin, int interval) {
        try{
            tasks.get(PluginName.valueOf(plugin.getName())).cancel();
            tasks.remove(PluginName.valueOf(plugin.getName()));
        }catch(Exception ignored){

        }
        tasks.put(PluginName.valueOf(plugin.getName()), plugin.getServer().getScheduler().runTaskTimer(plugin, () -> UpdateChecker.check(plugin), 0L, interval * 20L));
    }

    public static void cancelUpdateChecker(JavaPlugin plugin) {
        try{
            tasks.get(PluginName.valueOf(plugin.getName())).cancel();
            tasks.remove(PluginName.valueOf(plugin.getName()));
        }catch(Exception ignored){

        }
    }


}
