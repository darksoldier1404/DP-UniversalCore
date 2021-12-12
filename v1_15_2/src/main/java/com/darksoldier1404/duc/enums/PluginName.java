package com.darksoldier1404.duc.enums;

@SuppressWarnings("all")
public enum PluginName {
    UniversalCore("DP-UniversalCore", 13426),
    LegendaryCash("DP-LegendaryCash", 13387),
    VirtualStorage("DP-VirtualStorage", 13386),
    SimplePrefix("DP-SimplePrefix", 13460),
    ItemEditor("DP-ItemEditor", 13462),
    SimpleMenu("DP-SimpleMenu", 13499),
    SimpleAnnouncement("DP-SimpleAnnouncement", 13561),
    ;

    private final String name;
    private final int pluginID;

    PluginName(String name, int pluginID) {
        this.name = name;
        this.pluginID = pluginID;
    }

    public String getName() {
        return name;
    }

    public int getPluginID() {
        return pluginID;
    }

    public static PluginName getByName(String name) {
        for (PluginName pluginName : values()) {
            if (pluginName.getName().equals(name)) {
                return pluginName;
            }
        }
        return null;
    }

    public static PluginName getByID(int id) {
        for (PluginName pluginName : values()) {
            if (pluginName.getPluginID() == id) {
                return pluginName;
            }
        }
        return null;
    }
}
