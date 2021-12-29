package com.darksoldier1404.duc.api.placeholder;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class DPlaceHolder {
    private final CommandSender requester;
    private String key;
    private Object value;
    private boolean useTask = false;
    private BukkitTask task;
    private long interval;
    private boolean isGlobalValue = false;

    public DPlaceHolder(CommandSender requester, String key, Object value) {
        this.requester = requester;
        this.key = key;
        this.value = value;
    }

    public DPlaceHolder(CommandSender requester, String key, Object value, boolean isGlobalValue) {
        this.requester = requester;
        this.key = key;
        this.value = value;
        this.isGlobalValue = isGlobalValue;
    }

    public DPlaceHolder(CommandSender requester, String key, Object value, long interval) {
        this.requester = requester;
        this.key = key;
        this.value = value;
        this.useTask = true;
    }

    public DPlaceHolder(CommandSender requester, String key, Object value, long interval, boolean isGlobalValue) {
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

    public Object getValue() {
        return value;
    }

    public Object getValueAsString() {
        return value.toString();
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

    // 값이 기본 자료형일 경우에만 사용
    public String apply(String s) {
        String r = s.replace("{" + key + "}", value.toString());
        Bukkit.getPluginManager().callEvent(new DPHApplyEvent(requester, key, value, r, false, isGlobalValue));
        return r;
    }

    public String applyWithColor(String s) {
        String r = ChatColor.translateAlternateColorCodes('&', s.replace("{" + key + "}", value.toString()));
        Bukkit.getPluginManager().callEvent(new DPHApplyEvent(requester, key, value, r, true, isGlobalValue));
        return r;
    }

    // 값이 리스트일 경우
    public String apply(String s, int index) {
        if(value instanceof List) {
            List list = (List) value;
            if(index >= 0 && index < list.size()) {
                String r = s.replace("{" + key + "}", list.get(index).toString());
                Bukkit.getPluginManager().callEvent(new DPHApplyEvent(requester, key, value, r, false, isGlobalValue));
                return r;
            }
        }
        return s;
    }

    // 값이 맵일 경우
    public String apply(String s, String key) {
        if(value instanceof Map) {
            Map map = (Map) value;
            if(map.containsKey(key)) {
                String r = s.replace("{" + this.key + "}", map.get(key).toString());
                Bukkit.getPluginManager().callEvent(new DPHApplyEvent(requester, key, value, r, false, isGlobalValue));
                return r;
            }
        }
        return s;
    }

    public String applyAsPlayer(String s, Player p) {
        if(value instanceof Map) {
            Map map = (Map) value;
            if(map.containsKey(p.getUniqueId())) {
                String r = s.replace("{" + key + "}", map.get(p.getUniqueId()).toString());
                Bukkit.getPluginManager().callEvent(new DPHApplyEvent(p, key, value, r, false, isGlobalValue));
                return r;
            }
        }
        return s;
    }

    public String applyAsPlayerWithColor(String s, Player p) {
        if(value instanceof Map) {
            Map map = (Map) value;
            if(map.containsKey(p.getUniqueId())) {
                String r = ChatColor.translateAlternateColorCodes('&', s.replace("{" + key + "}", map.get(p.getUniqueId()).toString()));
                Bukkit.getPluginManager().callEvent(new DPHApplyEvent(p, key, value, r, true, isGlobalValue));
                return r;
            }
        }
        return s;
    }

}
