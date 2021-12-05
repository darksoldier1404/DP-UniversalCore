package com.darksoldier1404.duc.enums;

@SuppressWarnings("all")
public enum PluginName {
    UniversalCore("DP-UniversalCore"),
    LegendaryCash("DP-LegendaryCash"),
    VirtualStorage("DP-VirtualStorage"),
    SimplePrefix("DP-SimplePrefix"),
    ;

    private final String name;

    PluginName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static PluginName getByName(String name) {
        for (PluginName pluginName : values()) {
            if (pluginName.getName().equals(name)) {
                return pluginName;
            }
        }
        return null;
    }
}
