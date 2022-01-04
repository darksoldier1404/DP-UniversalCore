package com.darksoldier1404.duc.utils;

import net.md_5.bungee.api.ChatColor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("all")
public class ColorUtils {
    // code from https://www.spigotmc.org/threads/1-16-1-new-color-utils-rgb-and-hex-parsing.451068/
    private static final Pattern hexPattern = Pattern.compile("<#([A-Fa-f0-9]){6}>");
    public static String applyColor(String message){
        Matcher matcher = hexPattern.matcher(message);
        while (matcher.find()) {
            final ChatColor hexColor = ChatColor.of(matcher.group().substring(1, matcher.group().length() - 1));
            final String before = message.substring(0, matcher.start());
            final String after = message.substring(matcher.end());
            message = before + hexColor + after;
            matcher = hexPattern.matcher(message);
        }
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
