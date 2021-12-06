package com.darksoldier1404.duc.commands;

import com.darksoldier1404.duc.UniversalCore;
import com.darksoldier1404.duc.utils.UpdateChecker;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("all")
public class DUCCommand implements CommandExecutor {
    private final UniversalCore plugin = UniversalCore.getInstance();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!sender.isOp()) {
            sender.sendMessage("§cYou don't have permission to use this command!");
            return false;
        }
        if (args.length == 0) {
            sender.sendMessage("§cUsage: /duc uc - Check for updates");
            return false;
        }
        if (args[0].equalsIgnoreCase("uc")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                p.sendMessage(plugin.prefix + "설치된 모든 플러그인 업데이트 확인...");
                plugin.enabledPlugins.values().forEach(o -> UpdateChecker.check(o, p));
            } else {
                sender.sendMessage(plugin.prefix + "설치된 모든 플러그인 업데이트 확인...");
                plugin.enabledPlugins.values().forEach(UpdateChecker::check);
            }
        }
        return false;
    }
}
