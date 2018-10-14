/*
 *     Copyright (c) 2018 Slowloris.de
 *     Development: Weichtier
 *
 *     Ändern für den privaten nutzen erlaubt. Reuploaded verboten!
 */

package de.slowloris.api.player;

import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.Location;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.awt.*;

public class CustomPlayer {

    private Player player;


    public CustomPlayer(Player player){
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void enchantItemInHand(Enchantment enchantment, int lvl){
        ItemStack item = player.getItemInHand();
        ItemMeta meta = item.getItemMeta();
        meta.addEnchant(enchantment, lvl, true);
        item.setItemMeta(meta);
    }

    public void giveItem(ItemStack item){
        player.getInventory().addItem(item);
    }
    public void clear(){
        player.getInventory().clear();
    }
    public void sendMessage(String message){
        player.sendMessage(message);
    }
    public void sendMessage(BaseComponent[] component){
        player.spigot().sendMessage(component);
    }
    public void kill(){
        player.setHealth(0);
    }
    public void tp(Location loc){
        player.teleport(loc);
    }
    public void tp(Player t){
        player.teleport(t.getLocation());
    }
    public String getName(){
        return player.getName();
    }

}
