/*
 *     Copyright (c) 2018 Slowloris.de
 *     Development: Weichtier
 *
 *     Ändern für den privaten nutzen erlaubt. Reuploaded verboten!
 */

package de.slowloris.api.manager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ServerManager {

    private Plugin plugin;

    public ServerManager(Plugin plugin){
        this.plugin = plugin;
    }

    public void sendPlayer(Player p, String servername){
        Bukkit.getMessenger().registerOutgoingPluginChannel(plugin, "BungeeCord");
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);
        try {
            out.writeUTF("Connect");
            out.writeUTF(servername);
        }catch (IOException exc){
            exc.printStackTrace();
        }
        p.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
        Bukkit.getMessenger().unregisterOutgoingPluginChannel(plugin, "BungeeCord");
    }
    public boolean commandExists(String command){
        if(Bukkit.getServer().getHelpMap().getHelpTopic(command) == null) {
            return false;
        }
        return true;
    }
}
