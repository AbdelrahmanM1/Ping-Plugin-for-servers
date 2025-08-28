package me.abdelrahmanmoharramdev.dayandnightplugin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DayCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can run this command!");
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("dayandnightplugin.day")) {
            player.sendMessage(ChatColor.RED + "You don’t have permission!");
            return true;
        }

        player.getWorld().setTime(1000); // Day time
        player.sendMessage(ChatColor.GREEN + "Daytime has been set by " + player.getName() + "!");
        return true;
    }
}
