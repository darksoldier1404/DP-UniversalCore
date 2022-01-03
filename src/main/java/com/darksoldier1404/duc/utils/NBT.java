package com.darksoldier1404.duc.utils;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagString;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_18_R1.inventory.CraftItemStack;
import org.bukkit.entity.EntityType;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("all")
public class NBT {

    /**
     * @param objitem require ItemStack
     * @param key     require String
     * @param value   will be cast as String
     * @return ItemStack
     * @
     */
    @NotNull
    public static ItemStack setObjectTag(ItemStack objitem, String key, Object value) {
        final net.minecraft.world.item.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        final NBTTagCompound ntc = item.r() ? item.s() : new NBTTagCompound();
        ntc.a(key, NBTTagString.a(value.toString()));
        item.c(ntc);
        return CraftItemStack.asBukkitCopy(item);
    }

    /**
     * @param objitem require ItemStack
     * @param key     require String
     * @return ItemStack
     */
    @NotNull
    public static ItemStack removeTag(ItemStack objitem, String key) {
        net.minecraft.world.item.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.r() ? item.s() : new NBTTagCompound();
        item.c(ntc);
        item.c(key);
        return CraftItemStack.asBukkitCopy(item);
    }

    /**
     * @param objitem require ItemStack
     * @return Map<String, Object>
     */
    @NotNull
    public static ItemStack removeAllTags(ItemStack objitem) {
        net.minecraft.world.item.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.r() ? item.s() : new NBTTagCompound();
        for (String key : ntc.d()) {
            item.c(key);
        }
        item.c(ntc);
        return CraftItemStack.asBukkitCopy(item);
    }

    /**
     * @param objitem ItemStack
     * @param key     String
     * @return String
     */
    @NotNull
    public static String getStringTag(ItemStack objitem, String key) {
        net.minecraft.world.item.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.r() ? item.s() : new NBTTagCompound();
        return ntc.l(key).replace('"', ' ').trim();
    }

    /**
     * @param objitem ItemStack
     * @param key     String
     * @return byte
     */
    @NotNull
    public static byte getByteTag(ItemStack objitem, String key) {
        net.minecraft.world.item.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.r() ? item.s() : new NBTTagCompound();
        return ntc.f(key);
    }

    /**
     * @param objitem ItemStack
     * @param key     String
     * @return short
     */
    @NotNull
    public static short getShortTag(ItemStack objitem, String key) {
        net.minecraft.world.item.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.r() ? item.s() : new NBTTagCompound();
        return ntc.f(key);
    }

    /**
     * @param objitem ItemStack
     * @param key     String
     * @return int
     */
    @NotNull
    public static int getIntegerTag(ItemStack objitem, String key) {
        net.minecraft.world.item.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.r() ? item.s() : new NBTTagCompound();
        return ntc.h(key);
    }

    /**
     * @param objitem ItemStack
     * @param key     String
     * @return float
     */
    @NotNull
    public static float getFloatTag(ItemStack objitem, String key) {
        net.minecraft.world.item.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.r() ? item.s() : new NBTTagCompound();
        return ntc.j(key);
    }

    /**
     * @param objitem ItemStack
     * @param key     String
     * @return double
     */
    @NotNull
    public static double getDoubleTag(ItemStack objitem, String key) {
        net.minecraft.world.item.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.r() ? item.s() : new NBTTagCompound();
        return ntc.k(key);
    }

    /**
     * @param objitem ItemStack
     * @param key     String
     * @return boolean
     */
    public static boolean getBooleanTag(ItemStack objitem, String key) {
        net.minecraft.world.item.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.r() ? item.s() : new NBTTagCompound();
        return ntc.q(key);
    }

    /**
     * @param objitem ItemStack
     * @param key     String
     * @return long
     */
    @NotNull
    public static long getLongTag(ItemStack objitem, String key) {
        net.minecraft.world.item.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.r() ? item.s() : new NBTTagCompound();
        return ntc.i(key);
    }

    /**
     * @param objitem ItemStack
     * @param key     String
     * @return byte[]
     */
    @NotNull
    public static byte[] getByteArrayTag(ItemStack objitem, String key) {
        net.minecraft.world.item.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.r() ? item.s() : new NBTTagCompound();
        return ntc.m(key);
    }

    /**
     * @param objitem ItemStack
     * @param key     String
     * @return int[]
     */
    @NotNull
    public static int[] getIntArrayTag(ItemStack objitem, String key) {
        net.minecraft.world.item.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.r() ? item.s() : new NBTTagCompound();
        return ntc.n(key);
    }

    /**
     * @param objitem ItemStack
     * @param key     String
     * @return NBTTagCompound
     */
    @NotNull
    public static NBTTagCompound getCompoundTag(ItemStack objitem, String key) {
        net.minecraft.world.item.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.r() ? item.s() : new NBTTagCompound();
        return ntc.p(key);
    }

    /**
     * @param objitem ItemStack
     * @param key     String
     * @return Material
     */
    @Nullable
    public static Material getMaterialTag(ItemStack objitem, String key) {
        net.minecraft.world.item.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.r() ? item.s() : new NBTTagCompound();
        return Material.getMaterial(ntc.l(key));
    }

    /**
     * @param objitem ItemStack
     * @param key     String
     * @return InventoryType
     */
    @Nullable
    public static InventoryType getInventoryTypeTag(ItemStack objitem, String key) {
        net.minecraft.world.item.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.r() ? item.s() : new NBTTagCompound();
        return InventoryType.valueOf(ntc.l(key));
    }

    /**
     * @param objitem ItemStack
     * @param key     String
     * @return NBTTagList
     */
    @Nullable
    public static EntityType getEntityTypeTag(ItemStack objitem, String key) {
        net.minecraft.world.item.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.r() ? item.s() : new NBTTagCompound();
        return EntityType.valueOf(ntc.l(key));
    }

    /**
     * @param objitem ItemStack
     * @param key     String
     * @return boolean
     */
    public static boolean hasTagKey(ItemStack objitem, String key) {
        net.minecraft.world.item.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.r() ? item.s() : new NBTTagCompound();
        return ntc.e(key);
    }

    /**
     * @param objitem ItemStack
     * @return Map<String, Object>
     */
    @Nullable
    public static Map<String, String> getAllStringTag(ItemStack objitem) {
        net.minecraft.world.item.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.r() ? item.s() : new NBTTagCompound();
        if (ntc.d().size() == 0) {
            return null;
        }
        Map<String, String> tags = new HashMap<>();
        for (String key : ntc.d()) {
            tags.put(key, ntc.c(key).toString());
        }
        return tags;
    }

    /**
     * @param objitem ItemStack
     * @param key     String
     * @param value   String
     * @return ItemStack
     */
    @NotNull
    public static ItemStack setStringTag(ItemStack objitem, String key, String value) {
        net.minecraft.world.item.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.r() ? item.s() : new NBTTagCompound();
        ntc.a(key, value);
        item.c(ntc);
        return CraftItemStack.asBukkitCopy(item);
    }

    /**
     * @param objitem ItemStack
     * @param key     String
     * @param value   byte
     * @return ItemStack
     */
    @NotNull
    public static ItemStack setByteTag(ItemStack objitem, String key, byte value) {
        net.minecraft.world.item.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.r() ? item.s() : new NBTTagCompound();
        ntc.a(key, value);
        item.c(ntc);
        return CraftItemStack.asBukkitCopy(item);
    }

    /**
     * @param objitem ItemStack
     * @param key     String
     * @param value   short
     * @return ItemStack
     */
    @NotNull
    public static ItemStack setShortTag(ItemStack objitem, String key, short value) {
        net.minecraft.world.item.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.r() ? item.s() : new NBTTagCompound();
        ntc.a(key, value);
        item.c(ntc);
        return CraftItemStack.asBukkitCopy(item);
    }

    /**
     * @param objitem ItemStack
     * @param key     String
     * @param value   int
     * @return ItemStack
     */
    @NotNull
    public static ItemStack setIntTag(ItemStack objitem, String key, int value) {
        net.minecraft.world.item.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.r() ? item.s() : new NBTTagCompound();
        ntc.a(key, value);
        item.c(ntc);
        return CraftItemStack.asBukkitCopy(item);
    }

    /**
     * @param objitem ItemStack
     * @param key     String
     * @param value   long
     * @return ItemStack
     */
    @NotNull
    public static ItemStack setLongTag(ItemStack objitem, String key, long value) {
        net.minecraft.world.item.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.r() ? item.s() : new NBTTagCompound();
        ntc.a(key, value);
        item.c(ntc);
        return CraftItemStack.asBukkitCopy(item);
    }

    /**
     * @param objitem ItemStack
     * @param key     String
     * @param value   float
     * @return ItemStack
     */
    @NotNull
    public static ItemStack setFloatTag(ItemStack objitem, String key, float value) {
        net.minecraft.world.item.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.r() ? item.s() : new NBTTagCompound();
        ntc.a(key, value);
        item.c(ntc);
        return CraftItemStack.asBukkitCopy(item);
    }

    /**
     * @param objitem ItemStack
     * @param key     String
     * @param value   double
     * @return ItemStack
     */
    @NotNull
    public static ItemStack setDoubleTag(ItemStack objitem, String key, double value) {
        net.minecraft.world.item.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.r() ? item.s() : new NBTTagCompound();
        ntc.a(key, value);
        item.c(ntc);
        return CraftItemStack.asBukkitCopy(item);
    }

    /**
     * @param objitem ItemStack
     * @param key     String
     * @param value   byte[]
     * @return ItemStack
     */
    @NotNull
    public static ItemStack setByteArrayTag(ItemStack objitem, String key, byte[] value) {
        net.minecraft.world.item.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.r() ? item.s() : new NBTTagCompound();
        ntc.a(key, value);
        item.c(ntc);
        return CraftItemStack.asBukkitCopy(item);
    }

    /**
     * @param objitem ItemStack
     * @param key     String
     * @param value   int[]
     * @return ItemStack
     */
    @NotNull
    public static ItemStack setIntArrayTag(ItemStack objitem, String key, int[] value) {
        net.minecraft.world.item.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.r() ? item.s() : new NBTTagCompound();
        ntc.a(key, value);
        item.c(ntc);
        return CraftItemStack.asBukkitCopy(item);
    }

    /**
     * @param objitem ItemStack
     * @param key     String
     * @param value   Material
     * @return ItemStack
     */
    @NotNull
    public static ItemStack setMaterialTag(ItemStack objitem, String key, Material value) {
        net.minecraft.world.item.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.r() ? item.s() : new NBTTagCompound();
        ntc.a(key, value.name());
        item.c(ntc);
        return CraftItemStack.asBukkitCopy(item);
    }

    // ItemStackSerializer

    // Single ItemStack

    /**
     * @param objitem ItemStack
     * @param key     String
     * @param value   ItemStack
     * @return ItemStack
     */
    public static ItemStack setItemStackTag(ItemStack objitem, String key, ItemStack value) {
        String sitem = ItemStackSerializer.serialize(value);
        String[] sitems = sitem.split("(?<=\\G.{288})");

        for (int i = 0; i < sitems.length; i++) {
            objitem = NBT.setStringTag(objitem, key + i, sitems[i]);
        }
        objitem = NBT.setIntTag(objitem, key + "_size", sitems.length);
        return objitem;
    }

    /**
     * @param objitem ItemStack
     * @param key     String
     * @return ItemStack
     */
    @Nullable
    public static ItemStack getItemStackTag(ItemStack objitem, String key) {
        int length = NBT.getIntegerTag(objitem, key + "_size");
        String s = "";
        for (int i = 0; i < length; i++) {
            s += NBT.getStringTag(objitem, key + i);
        }
        return ItemStackSerializer.deserialize(s);
    }

    // Inventory

    /**
     * @param objitem ItemStack
     * @param inv Inventory
     * @param key String
     * @return ItemStack
     */
    public static ItemStack setInventoryTag(ItemStack objitem, Inventory inv, String key) {
        for (int i = 0; i < inv.getSize(); i++) {
            objitem = NBT.setItemStackTag(objitem, "inv_" + key + "_" + i+"_item", inv.getItem(i));
        }
        objitem = NBT.setIntTag(objitem, "inv_" + key + "_size", inv.getSize());
        return objitem;
    }

    /**
     * @param objitem ItemStack
     * @param key String
     * @return Inventory
     */
    @Nullable
    public static Inventory getInventoryTag(ItemStack objitem, String key) {
        Inventory inv = Bukkit.createInventory(null, NBT.getIntegerTag(objitem, "inv_" + key + "_size"));
        for (int i = 0; i < inv.getSize(); i++) {
            inv.setItem(i, NBT.getItemStackTag(objitem, "inv_" + key + "_" + i+"_item"));
        }
        return inv;
    }
}
