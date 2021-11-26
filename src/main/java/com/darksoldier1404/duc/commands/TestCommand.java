package com.darksoldier1404.duc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class TestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(args.length == 0) {
            if(!sender.isOp()) {
                sender.sendMessage("§cYou don't have permission to use this command!");
                return false;
            }
//            Player p = (Player) sender;
//            ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
//            ItemStack value = item.clone();
//            ItemMeta im = value.getItemMeta();
//            im.setDisplayName("§f§l아이템 이름");
//            im.setCustomModelData(1234);
//            im.setLore(Arrays.asList("adasdasdlkjhasdkjhl","adasdasdlkjhasdkjhl","adasdasdlkjhasdkjhl","adasdasdlkjhasdkjhl","adasdasdlkjhasdkjhl","adasdasdlkjhasdkjhl","adasdasdlkjhasdkjhl","adasdasdlkjhasdkjhl","adasdasdlkjhasdkjhl","adasdasdlkjhasdkjhl","adasdasdlkjhasdkjhl","adasdasdlkjhasdkjhl","adasdasdlkjhasdkjhl","adasdasdlkjhasdkjhl"));
//            im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
//            im.addEnchant(Enchantment.ARROW_FIRE, 1, true);
//            value.setItemMeta(im);
//            item = NBT.setItemStackTag(item, "test", value);
//            System.out.println("before additem : "+NBT.getStringTag(item, "test_size"));
//            p.getInventory().addItem(item);
//            System.out.println("after additem : "+NBT.getStringTag(item, "test_size"));
//            ItemStack r = NBT.getItemStackTag(item, "test");
//            p.getInventory().addItem(r);
        }
        return false;
    }
}
