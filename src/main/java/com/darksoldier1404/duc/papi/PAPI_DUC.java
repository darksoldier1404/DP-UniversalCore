package com.darksoldier1404.duc.papi;

import com.darksoldier1404.duc.UniversalCore;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PAPI_DUC extends PlaceholderExpansion {
    private final UniversalCore plugin = UniversalCore.getInstance();

    @Override
    public @NotNull String getIdentifier() {
        return plugin.getDescription().getName();
    }

    @Override
    public @NotNull String getAuthor() {
        return plugin.getDescription().getAuthors().toString();
    }

    @Override
    public @NotNull String getVersion() {
        return plugin.getDescription().getVersion();
    }

    @Nullable
    @Override
    public String onPlaceholderRequest(Player p, @NotNull String req) {
        if(req.equalsIgnoreCase("duc.version")) {
            return getVersion();
        }
        return null;
    }
}
