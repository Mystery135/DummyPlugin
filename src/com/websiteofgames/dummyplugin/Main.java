package com.websiteofgames.dummyplugin;

import com.websiteofgames.dummyplugin.commands.SpawnDummyCommand;
import com.websiteofgames.dummyplugin.events.ClickedInGUI;
import com.websiteofgames.dummyplugin.events.DummyAttackedEvent;


import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {
    @Override
    public void onEnable() {


        getCommand("spawndummy").setExecutor(new SpawnDummyCommand());
        getServer().getPluginManager().registerEvents(new DummyAttackedEvent(), this);
        getServer().getPluginManager().registerEvents(new ClickedInGUI(), this);
    }

    @Override
    public void onDisable() {

        getServer().getConsoleSender().sendMessage("§6[§bDummyPlugin§6]§r " + "§cDisabled!");


    }
}

