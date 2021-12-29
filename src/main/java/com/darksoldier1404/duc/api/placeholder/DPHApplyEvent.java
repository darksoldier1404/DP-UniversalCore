package com.darksoldier1404.duc.api.placeholder;

import org.bukkit.command.CommandSender;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public class DPHApplyEvent extends Event implements Cancellable {
    @NotNull
    private static final HandlerList HANDLERS = new HandlerList();
    private final CommandSender requester;
    private final String key;
    private final String value;
    private final String result;
    private final boolean isWithColor;
    private final boolean isGlobalValue;
    private boolean cancelled;

    public DPHApplyEvent(@NotNull CommandSender requester, @NotNull String key, @NotNull String value, @NotNull String result, boolean isWithColor, boolean isGlobalValue) {
        this.requester = requester;
        this.key = key;
        this.value = value;
        this.result = result;
        this.isWithColor = isWithColor;
        this.isGlobalValue = isGlobalValue;
    }

    @NotNull
    public CommandSender getRequester() {
        return this.requester;
    }

    @NotNull
    public String getKey() {
        return key;
    }

    @NotNull
    public String getValue() {
        return value;
    }

    @NotNull
    public String getResult() {
        return result;
    }

    public boolean isWithColor() {
        return isWithColor;
    }

    public boolean isGlobalValue() {
        return isGlobalValue;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
