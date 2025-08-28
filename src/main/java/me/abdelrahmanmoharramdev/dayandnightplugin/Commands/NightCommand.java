package me.abdelrahmanmoharramdev.dayandnightplugin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NightCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can run this command!");
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("dayandnightplugin.night")) {
            player.sendMessage(ChatColor.RED +"You don’t have permission!");
            return true;
        }

        player.getWorld().setTime(13000);
        player.sendMessage(ChatColor.GREEN + "NightTime has been set by " + player.getName() + "!");
        return true;
    }
}
