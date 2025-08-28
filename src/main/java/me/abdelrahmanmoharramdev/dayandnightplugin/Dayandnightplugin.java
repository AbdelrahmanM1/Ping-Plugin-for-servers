package me.abdelrahmanmoharramdev.dayandnightplugin;

import org.bukkit.plugin.java.JavaPlugin;
import me.abdelrahmanmoharramdev.dayandnightplugin.Commands.DayCommand;
import me.abdelrahmanmoharramdev.dayandnightplugin.Commands.NightCommand;
import me.abdelrahmanmoharramdev.dayandnightplugin.listener.DayListener;
import me.abdelrahmanmoharramdev.dayandnightplugin.listener.NightListener;


public final class Dayandnightplugin extends JavaPlugin {

    @Override
    public void onEnable() {
        //register listeners
        getServer().getPluginManager().registerEvents(new DayListener(), this);
        getServer().getPluginManager().registerEvents(new NightListener(), this);


        // register commands
        getCommand("day").setExecutor(new DayCommand());
        getCommand("night").setExecutor(new NightCommand());

        getLogger().info("Day and night plugin Enabled made by 3bdoabk");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Day and night plugin  disabled made by 3bdoabk");
    }
}
