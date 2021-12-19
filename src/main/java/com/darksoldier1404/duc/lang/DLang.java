package com.darksoldier1404.duc.lang;

import org.bukkit.configuration.file.YamlConfiguration;

public class DLang {
    private static YamlConfiguration currentLang;

    public static Lang getLang() {
        return Lang.valueOf(currentLang.getString("Lang"));
    }

    public static boolean isLang(final Lang lang) {
        return getLang() == lang;
    }

    public static void setLangFile(YamlConfiguration lang) {
        currentLang = lang;
    }

    public static String get(String key) {
        return currentLang.getString(key);
    }


}
