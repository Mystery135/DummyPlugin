package com.websiteofgames.dummyplugin.commands;

import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;


public class SpawnDummyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command cmd, String s, String[] args) {
        if (commandSender instanceof Player){

Player player = (Player) commandSender;

if (cmd.getName().equalsIgnoreCase("spawndummy")){
    if (player.hasPermission("dummyplugin.spawndummy")){

        if (args.length == 1){
            double locx = player.getLocation().getX();
            double locy = player.getLocation().getY();
            double locz = player.getLocation().getZ();

            for(int i = 0; i< Integer.valueOf(args[0]); i++){

                locx++;
                locx++;

                Location location = new Location(player.getWorld(), locx, locy, locz);

                Zombie zombie = (Zombie) player.getWorld().spawnEntity(location, EntityType.ZOMBIE);
                zombie.setCanPickupItems(true);
                zombie.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(1024);
                zombie.setHealth(1024);
                zombie.getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS).setBaseValue(Integer.MAX_VALUE);
                zombie.setAI(false);
                zombie.setAge(100);

                zombie.setCustomName(	"§aLast Hit: §c ❤" + 0);
                zombie.setCustomNameVisible(true);
                zombie.setSilent(true);
            }




        }else if (args.length == 0){


            Zombie zombie = (Zombie) player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE);
            zombie.setCanPickupItems(true);
            zombie.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(1024);
            zombie.setHealth(1024);

            zombie.setAI(false);
            zombie.setAge(100);
            zombie.setSilent(true);  zombie.setCustomNameVisible(true);
            zombie.setCustomName(	"§aLast Hit: §c ❤" + 0);

        }else{

            player.sendMessage("§6[§bDummyPlugin§6]§r " + "§c/<command> <number of dummies you want to spawn>");



        }
        return true;



    }else {

        player.sendMessage("§cYou don't have the required permission! (dummyplugin.spawndummy)");
return true;
    }


}






        }else{


            commandSender.sendMessage("§6[§bDummyPlugin§6]§r " + "§cOnly players can execute this command!");
            return true;
        }




        return false;
    }
}
