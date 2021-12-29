package com.darksoldier1404.duc.api.placeholder;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class DPHManager {
    private final Map<String, DPlaceHolder> placeholders = new HashMap<>();

    public void register(DPlaceHolder placeholder, String key) {
        placeholders.put(key, placeholder);
    }

    public void unregister(String key) {
        placeholders.remove(key);
    }

    public DPlaceHolder getPlaceholder(String key) {
        return placeholders.get(key);
    }

    public Map<String, DPlaceHolder> getPlaceholders() {
        return placeholders;
    }

}
