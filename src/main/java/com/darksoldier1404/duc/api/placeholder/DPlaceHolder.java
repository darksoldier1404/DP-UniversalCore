package com.darksoldier1404.duc.api.placeholder;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitTask;

@SuppressWarnings("unused")
public class DPlaceHolder {
    private final CommandSender requester;
    private String key;
    private String value;
    private boolean useTask = false;
    private BukkitTask task;
    private long interval;
    private boolean isGlobalValue = false;

    public DPlaceHolder(CommandSender requester, String key, String value) {
        this.requester = requester;
        this.key = key;
        this.value = value;
    }

    public DPlaceHolder(CommandSender requester, String key, String value, boolean isGlobalValue) {
        this.requester = requester;
        this.key = key;
        this.value = value;
        this.isGlobalValue = isGlobalValue;
    }

    public DPlaceHolder(CommandSender requester, String key, String value, long interval) {
        this.requester = requester;
        this.key = key;
        this.value = value;
        this.useTask = true;
    }

    public DPlaceHolder(CommandSender requester, String key, String value, long interval, boolean isGlobalValue) {
        this.requester = requester;
        this.key = key;
        this.value = value;
        this.useTask = true;
        this.interval = interval;
    }

    public CommandSender getRequester() {
        return requester;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public boolean isUseTask() {
        return useTask;
    }

    public BukkitTask getTask() {
        return task;
    }

    public long getInterval() {
        return interval;
    }

    public boolean isGlobalValue() {
        return isGlobalValue;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setUseTask(boolean useTask) {
        this.useTask = useTask;
        try {
            task.cancel();
        } catch (Exception ignored) {
        }
    }

    public void setTask(BukkitTask task) {
        this.task = task;
    }

    public void setInterval(long interval) {
        this.interval = interval;
    }

    public void setGlobalValue(boolean isGlobalValue) {
        this.isGlobalValue = isGlobalValue;
    }

    public String apply() {
        String r = key.replace("{" + key + "}", value);
        Bukkit.getPluginManager().callEvent(new DPHApplyEvent(requester, key, value, r, false, isGlobalValue));
        return r;
    }

    public String applyWithColor() {
        String r = ChatColor.translateAlternateColorCodes('&', key.replace("{" + key + "}", value));
        Bukkit.getPluginManager().callEvent(new DPHApplyEvent(requester, key, value, r, true, isGlobalValue));
        return r;
    }

}
