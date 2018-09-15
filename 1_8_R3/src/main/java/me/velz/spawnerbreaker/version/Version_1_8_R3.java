package me.velz.spawnerbreaker.version;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Version_1_8_R3 implements Version {

    @Override
    public ItemStack getItemInMainHand(Player player) {
        return player.getInventory().getItemInHand();
    }

    @Override
    public Material getSpawnerMaterial() {
        return Material.valueOf("MOB_SPAWNER");
    }
    
}
