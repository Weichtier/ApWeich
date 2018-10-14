/*
 *     Copyright (c) 2018 Slowloris.de
 *     Development: Weichtier
 *
 *     Ändern für den privaten nutzen erlaubt. Reuploaded verboten!
 */

package de.slowloris.api;

import de.slowloris.api.manager.ServerManager;
import de.slowloris.api.builder.ScoreboardBuilder;
import de.slowloris.api.builder.TitleBuilder;
import org.bukkit.plugin.Plugin;

public class WeichApi {

    private Plugin plugin;
    private ServerManager serverManager;

    public WeichApi(Plugin plugin){
        this.plugin = plugin;
        this.serverManager = new ServerManager(this.plugin);
    }



    public ScoreboardBuilder getNewScoreboardBuilder(){
        return new ScoreboardBuilder();
    }

    public TitleBuilder getNewTitleBuilder(){
        return new TitleBuilder();
    }

    public String getPluginVersion(){
        return plugin.getDescription().getVersion();
    }

    public ServerManager getServerManager() {
        return serverManager;
    }
}
