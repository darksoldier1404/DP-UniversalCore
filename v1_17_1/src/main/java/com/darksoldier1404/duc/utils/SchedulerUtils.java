package com.darksoldier1404.duc.utils;

import com.darksoldier1404.duc.UniversalCore;
import com.darksoldier1404.duc.enums.PluginName;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("all")
public class SchedulerUtils {
    private static final UniversalCore core = UniversalCore.getInstance();
    private static final String prefix = core.prefix;
    public static final Map<PluginName, BukkitTask> tasks = new HashMap<>();

    public static void initUpdateChecker(PluginName name) {
        if (!PluginUtil.isUpdateCheckEnabled(name)) return;
        try {
            tasks.get(name).cancel();
            tasks.remove(name);
        } catch (Exception ignored) {

        }
        tasks.put(name, core.getServer().getScheduler().runTaskTimer(core, () -> UpdateChecker.check(core.enabledPlugins.get(name)), 0L, PluginUtil.getUpdateCheckInterval(name) * 20L));
    }

    public static void cancelUpdateChecker(JavaPlugin plugin) {
        try {
            tasks.get(PluginName.valueOf(plugin.getName())).cancel();
            tasks.remove(PluginName.valueOf(plugin.getName()));
        } catch (Exception ignored) {

        }
    }


}
