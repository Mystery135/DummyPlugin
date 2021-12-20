package com.websiteofgames.dummyplugin.events;


import com.websiteofgames.dummyplugin.gui.DeleteDummyGUI;


import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;

import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.entity.EntityCombustEvent;

import org.bukkit.event.entity.EntityDamageEvent;

import org.bukkit.event.player.PlayerInteractEntityEvent;

import org.bukkit.inventory.EquipmentSlot;

import java.util.HashMap;
import java.util.UUID;


public class DummyAttackedEvent implements Listener {
    public static boolean yesorno;
    //double totaldamage = 0;
    double lasthit = 0;

    static HashMap<UUID, UUID> playerselectdummy = new HashMap<>();

    @EventHandler
    public void onDummyCombust(EntityCombustEvent event) {

        if (event.getEntity() instanceof Zombie) {

            Zombie zombie = (Zombie) event.getEntity();


            if (zombie.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue() == 1024) {


                event.setCancelled(true);


            }


        }


    }



    @EventHandler
    public void onDummyDamagedByUnknown(EntityDamageEvent event) {

        if (event.getEntity() instanceof Zombie) {
            Zombie zombie = (Zombie) event.getEntity();
            if (zombie.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue() == 1024) {
//             totaldamage = Math.round((totaldamage + event.getFinalDamage())*100/100);
                lasthit =
                        round(event.getFinalDamage(), 2);


                zombie.setCustomName("§aLast Hit:§c ❤" + lasthit);

                zombie.setCustomNameVisible(true);
                zombie.setHealth(1024);

            }
        }


    }


    public static double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    @EventHandler
    public void onDummyRightClicked(PlayerInteractEntityEvent event){
        if (event.getRightClicked() instanceof Zombie){

            if (event.getHand().equals(EquipmentSlot.HAND)){




                Zombie zombie = (Zombie) event.getRightClicked();
                if (zombie.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue() == 1024){


                    if (zombie.getCustomName().contains("Last Hit")){


                        Player player = event.getPlayer();

                        if (player.hasPermission("dummyplugin.deletedummy")){


                            DeleteDummyGUI DeleteDummyGUI = new DeleteDummyGUI();

                            player.openInventory(DeleteDummyGUI.getInventory());
                            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);
                            playerselectdummy.put(player.getUniqueId(), zombie.getUniqueId());

                        }else{

                            player.sendMessage("§cYou don't have the required permission! (dummyplugin.deletedummy)");

                        }




                    }



                }

            }


        }


    }



}
