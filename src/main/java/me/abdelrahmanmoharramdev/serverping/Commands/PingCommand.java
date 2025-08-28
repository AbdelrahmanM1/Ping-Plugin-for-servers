package me.abdelrahmanmoharramdev.serverping.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class PingCommand implements CommandExecutor {

    private final HashMap<UUID, Long> cooldowns = new HashMap<>();
    private final long COOLDOWN = 5000; // 5 seconds in milliseconds

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cOnly players can use this command!");
            return true;
        }

        Player player = (Player) sender;
        UUID uuid = player.getUniqueId();

        // Check if player is on cooldown
        if (cooldowns.containsKey(uuid)) {
            long lastUsed = cooldowns.get(uuid);
            long timePassed = System.currentTimeMillis() - lastUsed;

            if (timePassed < COOLDOWN) {
                long timeLeft = (COOLDOWN - timePassed) / 1000; // in seconds
                player.sendMessage("§cYou must wait " + timeLeft + "s before using /ping again!");
                return true;
            }
        }

        // Update cooldown
        cooldowns.put(uuid, System.currentTimeMillis());

        // Ping logic
        if (args.length == 0) {
            int ping = player.getPing();
            player.sendMessage("§aYour ping is: §e" + ping + "ms");
        } else {
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                player.sendMessage("§cThat player is not online.");
                return true;
            }

            int ping = target.getPing();
            player.sendMessage("§a" + target.getName() + "§f's ping is: §e" + ping + "ms");
        }

        return true;
    }
}
