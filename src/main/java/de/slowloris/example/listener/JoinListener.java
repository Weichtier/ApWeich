/*
 *     Copyright (c) 2018 Slowloris.de
 *     Development: Weichtier
 *
 *     Ändern für den privaten nutzen erlaubt. Reuploaded verboten!
 */

package de.slowloris.example.listener;

import de.slowloris.api.builder.ItemBuilder;
import de.slowloris.api.builder.MessageBuilder;
import de.slowloris.api.builder.ScoreboardBuilder;
import de.slowloris.example.main.Main;
import de.slowloris.api.player.CustomPlayer;
import net.md_5.bungee.api.chat.*;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;
import java.util.List;

public class JoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        CustomPlayer cp = new CustomPlayer(event.getPlayer());

        ScoreboardBuilder boardbuilder = Main.getApi().getNewScoreboardBuilder();
        boardbuilder.setTitle("§c§lExample Plugin");
        boardbuilder.emptyLine();
        boardbuilder.addLine("§eYour Name:");
        boardbuilder.addLine("§c" + cp.getPlayer().getName());
        boardbuilder.emptyLine();
        boardbuilder.addLine("§8§m---------------------");
        boardbuilder.emptyLine();
        boardbuilder.addLine("§ePlugin Version:");
        boardbuilder.addLine("§c" + Main.getApi().getPluginVersion());
        boardbuilder.emptyLine();
        boardbuilder.addLine("§eWebsite:");
        boardbuilder.addLine("§cwww.slowloris.de");
        boardbuilder.send(event.getPlayer());
        ItemBuilder builder = new ItemBuilder(Material.WOOD_AXE, "§c§lExample-Item", 128);
        builder.enchant(Enchantment.DAMAGE_ALL, 10);
        List<String> lore = new ArrayList<String>();
        lore.add(" ");
        lore.add("§cThis is the Example");
        lore.add("§cWooden Axe, built with");
        lore.add("§cItemBuilder");
        lore.add(" ");
        builder.setLore(lore);
        cp.clear();
        cp.giveItem(builder.build());

        cp.sendMessage("§8§m------------\n");
        ComponentBuilder componentBuilder = new ComponentBuilder("§cWelcome, " + cp.getName() + "!\n\nVisit my ");
        componentBuilder.append("§a§lSite").event(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://dev.slowloris.de")).event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§aClick to §eopen my site").create()));
        componentBuilder.append(" §r§cfor more!");
        cp.sendMessage(componentBuilder.create());
        cp.sendMessage("§8§m------------\n");
    }
}
