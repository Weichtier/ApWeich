/*
 *     Copyright (c) 2018 Slowloris.de
 *     Development: Weichtier
 *
 *     Ändern für den privaten nutzen erlaubt. Reuploaded verboten!
 */

package de.slowloris.example.main;

import de.slowloris.api.WeichApi;
import de.slowloris.example.listener.CommandPreListener;
import de.slowloris.example.listener.JoinListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static WeichApi api;
    private static PluginManager pluginManager = Bukkit.getPluginManager();


    @Override
    public void onEnable() {

        api = new WeichApi(this);
        getLogger().info("Enabling Example-Plugin Version " + api.getPluginVersion());
        getPluginManager().registerEvents(new JoinListener(), this);
        getPluginManager().registerEvents(new CommandPreListener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Disabling Example-Plugin Version " + api.getPluginVersion());
    }


    public static WeichApi getApi() {
        return api;
    }

    public static PluginManager getPluginManager() {
        return pluginManager;
    }
}
