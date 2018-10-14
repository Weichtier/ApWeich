/*
 *     Copyright (c) 2018 Slowloris.de
 *     Development: Weichtier
 *
 *     Ändern für den privaten nutzen erlaubt. Reuploaded verboten!
 */

package de.slowloris.example.listener;

import de.slowloris.example.main.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandPreListener implements Listener {
    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event){
        String command = event.getMessage().split(" ")[0];
        if(!(Main.getApi().getServerManager().commandExists(command))){
            event.setCancelled(true);
            event.getPlayer().sendMessage("§cExample §8| §c Command not Found");
        }
    }
}
