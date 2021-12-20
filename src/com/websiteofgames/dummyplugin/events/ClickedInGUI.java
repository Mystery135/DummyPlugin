package com.websiteofgames.dummyplugin.events;

import com.websiteofgames.dummyplugin.gui.DeleteDummyGUI;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;


public class ClickedInGUI implements Listener {

@EventHandler
    public void onClick(InventoryClickEvent event){

    if (event.getClickedInventory() != null){

        if (event.getInventory().getHolder() instanceof DeleteDummyGUI){


            event.setCancelled(true);

            if (event.getCurrentItem() != null){
                Player player = (Player) event.getWhoClicked();

                if (event.getSlot()<4){
                    player.sendMessage("§aDummy was deleted!");
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);
                    player.closeInventory();
                    for (Entity e : player.getNearbyEntities(5, 5, 5))
                    {
          if (e instanceof Zombie){
              Zombie zombie = (Zombie) e;
              if (DummyAttackedEvent.playerselectdummy.get(player.getUniqueId()) == zombie.getUniqueId()){


                  zombie.remove();




              }



          }
                    }


                }
                else if (event.getSlot() == 4){
                    player.sendMessage("§c§lMake a decision!");
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);



                }
else if (event.getSlot() >4){

    player.sendMessage("§aDummy was not deleted!");
    player.closeInventory();
                    for (Entity e : player.getNearbyEntities(10, 10, 10))
                    {
                        if (e instanceof Zombie){
                            Zombie zombie = (Zombie) e;
                            if (zombie.getCustomName().contains("§4Last Hit:")){




                            }



                        }
                    }


                }





            }






        }





    }



}

@EventHandler
    public void onInventoryClose(InventoryCloseEvent event){

    if (event.getInventory().getHolder() instanceof DeleteDummyGUI){

Player player = (Player) event.getPlayer();


        for (Entity e : player.getNearbyEntities(5, 5, 5))
        {
            if (e instanceof Zombie){
                Zombie zombie = (Zombie) e;
                if (zombie.getCustomName().contains("§4Last Hit:")){




                }



            }
        }



    }

}
}
