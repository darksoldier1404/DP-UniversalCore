package com.darksoldier1404.duc.utils;


import org.bukkit.inventory.ItemStack;

import java.util.Base64;

@SuppressWarnings("all")
public class ItemStackSerializer {

    // Serialize an ItemStack to Base64 string

    public static String serialize(ItemStack item) {
        return Base64.getEncoder().encodeToString(item.serializeAsBytes());
    }

    // Deserialize an ItemStack from Base64 string

    public static ItemStack deserialize(String data) {
        return ItemStack.deserializeBytes(Base64.getDecoder().decode(data));
    }
}
