package com.darksoldier1404.duc.enums;

@SuppressWarnings("all")
public enum PluginName {
    LegendaryCash("DP-LegendaryCash"),
    VirtualStorage("DP-VirtualStorage"),
    ;

    private final String name;

    PluginName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
