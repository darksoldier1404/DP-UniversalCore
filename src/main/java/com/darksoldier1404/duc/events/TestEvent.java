package com.darksoldier1404.duc.events;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class TestEvent implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onChat(PlayerChatEvent e) {
        e.setMessage(PlaceholderAPI.setPlaceholders(e.getPlayer(), e.getMessage()));
    }
}
