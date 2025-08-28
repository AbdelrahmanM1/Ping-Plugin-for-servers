package me.abdelrahmanmoharramdev.dayandnightplugin.listener;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.entity.Player;

public class DayListener implements Listener {

    @EventHandler
    public void onPlayerCommand(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage().toLowerCase(); // the command typed

        long time = player.getWorld().getTime();

        // If player tries /day but it's already day
        if (message.startsWith("/day") && time >= 0 && time < 12000) {
            player.sendMessage(ChatColor.RED + "It’s already day time!");
            event.setCancelled(true); // cancel the command
        }
    }
}