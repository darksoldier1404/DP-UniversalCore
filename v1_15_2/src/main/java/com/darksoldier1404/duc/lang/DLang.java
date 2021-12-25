package com.darksoldier1404.duc.lang;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("all")
public class DLang {
    private YamlConfiguration currentLang;

    public DLang(@NotNull YamlConfiguration lang) {
        this.currentLang = lang;
    }

    public void setLangFile(YamlConfiguration lang) {
        currentLang = lang;
    }

    @Nullable
    public String get(String key) {
        String s = currentLang.getString(key);
        String[] args = currentLang.getString(key + ".args").split("\\|");
        if(s != null) {
            for (int i = 0; i < args.length; i++) {
                s = s.replace("{" + i + "}", args[i]);
            }
            return ChatColor.translateAlternateColorCodes('&', s);
        }
        return null;
    }
}
