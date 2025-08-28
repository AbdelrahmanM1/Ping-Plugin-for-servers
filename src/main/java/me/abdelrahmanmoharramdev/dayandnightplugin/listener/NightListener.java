package me.abdelrahmanmoharramdev.dayandnightplugin.listener;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.entity.Player;

public class NightListener implements Listener {

    @EventHandler
    public void onPlayerCommand(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage().toLowerCase(); // command typed

        long time = player.getWorld().getTime();

        // If player tries /night but it's already night
        if (message.startsWith("/night") && (time >= 12000 && time < 24000)) {
            player.sendMessage(ChatColor.RED + "It’s already night time!");
            event.setCancelled(true); // cancel the command
        }
    }
}
