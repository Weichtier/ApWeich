/*
 *     Copyright (c) 2018 Slowloris.de
 *     Development: Weichtier
 *
 *     Ändern für den privaten nutzen erlaubt. Reuploaded verboten!
 */

package de.slowloris.api.builder;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardBuilder {
    private Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();
    private Objective obj = board.getObjective("board");
    private int line = 0;
    private String empty = " ";

    public ScoreboardBuilder(){
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);

        if(board.getObjective("board") == null) board.registerNewObjective("board", "dummy");

    }

    public void setTitle(String title){
        obj.setDisplayName(title);
    }

    public void addLine(String content){
        obj.getScore(content).setScore(line);
        line--;
    }
    public void emptyLine(){
        addLine(empty);
        empty+= " ";
    }

    public void send(Player p){

    }
    public void send(){
        for (Player p : Bukkit.getOnlinePlayers()){
            send(p);
        }
    }
}
