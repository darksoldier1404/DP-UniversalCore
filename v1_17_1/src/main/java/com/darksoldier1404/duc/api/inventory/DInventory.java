package com.darksoldier1404.duc.api.inventory;


import org.bukkit.craftbukkit.v1_17_R1.inventory.CraftInventory;
import org.bukkit.craftbukkit.v1_17_R1.inventory.CraftInventoryCustom;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

@SuppressWarnings("unused")
public class DInventory extends CraftInventory {
    private final Inventory inv;
    private boolean usePage;
    private int pages = 0;
    private int currentPage;
    private ItemStack[] pageTools = new ItemStack[8];
    private ItemStack[][] pageItems = new ItemStack[][]{};

    public DInventory(InventoryHolder holder, Inventory inv) {
        super(new CraftInventoryCustom(holder, inv.getSize()).getInventory());
        this.inv = inv;
        usePage = false;
        currentPage = 0;

    }

    public DInventory(InventoryHolder holder, Inventory inv, boolean usePage) {
        super(new CraftInventoryCustom(holder, inv.getSize()).getInventory());
        this.inv = inv;
        this.usePage = usePage;
        currentPage = 0;
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

    public ItemStack[][] getPageItems() {
        return pageItems;
    }

    public ItemStack[] getPageItem(int page) {
        return pageItems[page];
    }

    public void setUsePage(boolean usePage) {
        this.usePage = usePage;
    }

    public boolean setPages(int pages) {
        this.pages = pages;
        return true;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public boolean setPageTools(ItemStack[] pageTools) {
        if (pageTools.length != 8) return false;
        this.pageTools = pageTools;
        return true;
    }

    public boolean setPageTool(int index, ItemStack item) {
        if (index < 0 || index > 8) return false;
        pageTools[index] = item;
        return true;
    }

    public void setPageItems(ItemStack[][] pageItems) {
        this.pageItems = pageItems;
    }

    public boolean setPageItem(int slot, ItemStack item) {
        if (slot < 0 || slot > 44) return false;
        pageItems[currentPage][slot] = item;
        return true;
    }

    public boolean setPageContent(int page, ItemStack[] items) {
        if (page < 0 || page > pages) return false;
        pageItems[page] = items;
        return true;
    }
    // add pageContent
    public void addPageContent(ItemStack[] items) {
        pages++;
        pageItems[pages] = items;
    }

    public void update() {
        inv.clear();
        ItemStack[] items = pageItems[currentPage];
        for (int i = 0; i < items.length; i++) {
            inv.setItem(i, items[i]);
        }
        int pt = 0;
        for (int i = 45; i < pageTools.length; i++) {
            inv.setItem(i, pageTools[pt]);
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
