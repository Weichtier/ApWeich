/*
 *     Copyright (c) 2018 Slowloris.de
 *     Development: Weichtier
 *
 *     Ändern für den privaten nutzen erlaubt. Reuploaded verboten!
 */

package de.slowloris.api.builder;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ItemBuilder {
    private ItemStack itemStack;
    private ItemMeta itemMeta;

    public ItemBuilder(Material material, String itemname, int amount, byte shortcode){
        itemStack = new ItemStack(material, amount, shortcode);
        itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(itemname);
    }

    public ItemBuilder(Material material, String itemname, int amount){
        itemStack = new ItemStack(material, amount);
        itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(itemname);
    }

    public void setLore(List<String> list){
        itemMeta.setLore(list);
    }

    public void enchant(Enchantment enchantment, int lvl){
        itemMeta.addEnchant(enchantment, lvl, true);
    }

    public ItemStack build(){
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
