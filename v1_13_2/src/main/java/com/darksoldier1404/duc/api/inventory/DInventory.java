package com.darksoldier1404.duc.api.inventory;


import org.bukkit.craftbukkit.v1_13_R2.inventory.CraftInventoryCustom;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class DInventory extends CraftInventoryCustom {
    private final String handlerName;
    private boolean usePage;
    private int pages = 0;
    private int currentPage;
    private ItemStack[] pageTools = new ItemStack[8];
    private Map<Integer, ItemStack[]> pageItems = new HashMap<>();

    public DInventory(InventoryHolder holder, String title, JavaPlugin plugin) {
        super(holder, InventoryType.CHEST, title);
        usePage = false;
        currentPage = 0;
        handlerName = plugin.getName();
    }

    public DInventory(InventoryHolder holder, String title, boolean usePage, JavaPlugin plugin) {
        super(holder, InventoryType.CHEST, title);
        this.handlerName = plugin.getName();
        this.usePage = usePage;
        currentPage = 0;
    }

        public String getHandlerName() {
        return handlerName;
    }
    
    public boolean isValidHandler(JavaPlugin plugin) {
        return plugin.getName().equals(handlerName);
    }

    public boolean isUsePage() {
        return usePage;
    }

    public int getPages() {
        return pages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public ItemStack[] getPageTools() {
        return pageTools;
    }

    public Map<Integer, ItemStack[]> getPageItems() {
        return pageItems;
    }

    public void setUsePage(boolean usePage) {
        this.usePage = usePage;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setPageTools(ItemStack[] pageTools) {
        this.pageTools = pageTools;
    }

    public void setPageTool(int index, ItemStack item) {
        pageTools[index] = item;
    }

    public boolean setPageItems(Map<Integer, ItemStack[]> pageItems) {
        this.pageItems = pageItems;
        return true;
    }

    public boolean setPageItem(int slot, ItemStack item) {
        if (slot < 0 || slot > 44) return false;
        pageItems.get(currentPage)[slot] = item;
        return true;
    }

    public boolean setPageContent(int page, ItemStack[] items) {
        if (page < 0 || page > pages) return false;
        pageItems.put(page, items);
        return true;
    }
    // add pageContent
    public void addPageContent(ItemStack[] items) {
        pages++;
        pageItems.put(pages, items);
    }

    public void update() {
        clear();
        for (int i = 0; i < pageItems.get(currentPage).length; i++) {
            setItem(i, pageItems.get(currentPage)[i]);
        }
        int pt = 0;
        for (int i = 45; i < pageTools.length; i++) {
            setItem(i, pageTools[pt]);
            pt++;
        }
    }

    public boolean nextPage() {
        if (!usePage) return false;
        if (currentPage >= pages) return false;
        currentPage++;
        update();
        return true;
    }

    public boolean prevPage() {
        if (!usePage) return false;
        if (currentPage <= 0) return false;
        currentPage--;
        update();
        return true;
    }

    public boolean turnPage(int page) {
        if (!usePage) return false;
        if (page < 0 || page > pages) return false;
        currentPage = page;
        update();
        return true;
    }
}
