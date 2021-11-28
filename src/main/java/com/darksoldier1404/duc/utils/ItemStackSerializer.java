package com.darksoldier1404.duc.utils;


import org.bukkit.inventory.ItemStack;

import java.util.Base64;

public class ItemStackSerializer {

    // Serialize an ItemStack to Base64 string

    public static String serialize(ItemStack item) {
        return Base64.getEncoder().encodeToString(item.serializeAsBytes());
    }

    // Deserialize an ItemStack from Base64 string

    public static ItemStack deserialize(String data) {
        return ItemStack.deserializeBytes(Base64.getDecoder().decode(data));
    }


//    public static String getEnchants(final ItemStack i) {
//        final List<String> e = new ArrayList<>();
//        final Map<Enchantment, Integer> en = i.getEnchantments();
//        for (final Enchantment t : en.keySet()) {
//            e.add(t.getName() + ":" + en.get(t));
//        }
//        return StringUtils.join(e, ",");
//    }
//
//    public static String serialize(final ItemStack i) {
//        final List<String> parts = new ArrayList<>();
//        parts.add(i.getType().name());
//        parts.add(Integer.toString(i.getAmount()));
//        parts.add(String.valueOf(i.getDurability()));
//        parts.add(i.getItemMeta().getDisplayName());
//        parts.add(StringUtils.join(i.getItemMeta().getLore(), "@"));
//        parts.add(String.valueOf(i.getData().getData()));
//        parts.add(getEnchants(i));
//        return StringUtils.join(parts, ";");
//    }
//
//    public static ItemStack deserialize(String p) {
//        p = p.replace("\"", "");
//        final String[] a = p.split(";");
//        final ItemStack i = new ItemStack(Material.getMaterial(a[0]), Integer.parseInt(a[1]));
//        i.setDurability((short) Integer.parseInt(a[2]));
//        final ItemMeta meta = i.getItemMeta();
//        meta.setDisplayName(a[3]);
//        final List<String> lore = new ArrayList<>();
//        String[] split;
//        for (int length = (split = a[4].split("@")).length, j = 0; j < length; ++j) {
//            final String s = split[j];
//            lore.add(s);
//        }
//        meta.setLore(lore);
//        i.setItemMeta(meta);
//        final MaterialData data = i.getData();
//        data.setData((byte) Integer.parseInt(a[5]));
//        i.setData(data);
//        if (a.length > 6) {
//            final String[] parts = a[6].split(",");
//            String[] array;
//            for (int length2 = (array = parts).length, k = 0; k < length2; ++k) {
//                final String s2 = array[k];
//                final String label = s2.split(":")[0];
//                final String amplifier = s2.split(":")[1];
//                final Enchantment type = Enchantment.getByName(label);
//                if (type != null) {
//                    int f;
//                    try {
//                        f = Integer.parseInt(amplifier);
//                    } catch (Exception ex) {
//                        continue;
//                    }
//                    i.addEnchantment(type, f);
//                }
//            }
//        }
//        return i;
//    }
}
