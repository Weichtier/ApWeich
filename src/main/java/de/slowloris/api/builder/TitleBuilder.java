/*
 *     Copyright (c) 2018 Slowloris.de
 *     Development: Weichtier
 *
 *     Ändern für den privaten nutzen erlaubt. Reuploaded verboten!
 */

package de.slowloris.api.builder;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class TitleBuilder {


    private String title;
    private String subtitle;
    private int fadeInTicks;
    private int fadeOutTicks;
    private int displayTicks;
    private String target;


    public TitleBuilder() {

    }

    public void newTitle(String title){
        this.title = title;
        this.subtitle = null;
        this.fadeInTicks = 10; // 0.5 seconds
        this.fadeOutTicks = 10; // 0.5 seconds
        this.displayTicks = 60; // 3 seconds
        this.target = "@a"; //target all players
    }

    public TitleBuilder setSubtitle(String subtitle) {
        this.subtitle = subtitle;
        return this;
    }

    public TitleBuilder setFadeInTicks(int fadeInTicks) {
        this.fadeInTicks = fadeInTicks;
        return this;
    }

    public TitleBuilder setFadeOutTicks(int fadeOutTicks) {
        this.fadeOutTicks = fadeOutTicks;
        return this;
    }

    public TitleBuilder setDisplayTicks(int displayTicks) {
        this.displayTicks = displayTicks;
        return this;
    }

    public TitleBuilder setTargetPlayer(Player player) {
        this.target = String.format("@a[name=%s]", player.getName());
        return this;
    }

    public TitleBuilder setTargetPlayer(String playerName) {
        this.target = String.format("@a[name=%s]", playerName);
        return this;
    }

    public TitleBuilder setTargetTeam(String teamName) {
        this.target = String.format("@a[team=%s]", teamName);
        return this;
    }

    public TitleBuilder setTargetNotTeam(String teamName) {
        this.target = String.format("@a[!team=%s]", teamName);
        return this;
    }

    public void send() {
        String cmdTime = String.format("title %s times %d %d %d", target, fadeInTicks, displayTicks, fadeOutTicks);
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), cmdTime);
        if (subtitle != null) {
            String cmdSub = String.format("title %s subtitle {text:\"%s\"}", target, ChatColor.translateAlternateColorCodes('&', subtitle));
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), cmdSub);
        }
        String cmdTitle = String.format("title %s title {text:\"%s\"}", target, ChatColor.translateAlternateColorCodes('&', title));
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), cmdTitle);
    }


}