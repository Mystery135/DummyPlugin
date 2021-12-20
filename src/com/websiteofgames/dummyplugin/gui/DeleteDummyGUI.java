package com.websiteofgames.dummyplugin.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;



public class DeleteDummyGUI implements InventoryHolder {
    private Inventory inv;

    public DeleteDummyGUI(){


        inv = Bukkit.createInventory(this, 9, "§c§lDelete this dummy?");


        init();
    }

    public void init(){
        ItemStack itemStack;
        for(int i = 0; i<4; i++){

            itemStack = createItem(Material.GREEN_WOOL, 1, "§a§lYes");
            inv.setItem(inv.firstEmpty(), itemStack);


        }



        itemStack = createItem(Material.GRAY_WOOL, 1, "§7Delete Dummy?");

        inv.setItem(inv.firstEmpty(), itemStack);



        for(int i = 0; i<4; i++){


            itemStack = createItem(Material.RED_WOOL, 1, "§c§lNo");

            inv.setItem(inv.firstEmpty(), itemStack);

        }



    }
    public ItemStack createItem(Material mat, int i, String name){

        ItemStack itemStack = new ItemStack(mat, i);
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(name);
        itemStack.setItemMeta(meta);
        return itemStack;



    }


    @Override
    public Inventory getInventory() {
        return inv;
    }
}
