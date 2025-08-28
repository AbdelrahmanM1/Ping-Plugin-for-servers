package me.abdelrahmanmoharramdev.serverping;

import org.bukkit.plugin.java.JavaPlugin;
import me.abdelrahmanmoharramdev.serverping.Commands.PingCommand;

public final class Serverping extends JavaPlugin {

    @Override
    public void onEnable() {
        // Startup of plugin
        getLogger().info("Serverping Enabled made by 3bdoabk");

        // Register commands
        getCommand("ping").setExecutor(new PingCommand());
    }

    @Override
    public void onDisable() {
        // Disabling
        getLogger().info("Serverping Disabled made by 3bdoabk");
    }
}
