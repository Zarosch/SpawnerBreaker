package me.velz.spawnerbreaker.version;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface Version {
    
    public ItemStack getItemInMainHand(Player player);
    
    public Material getSpawnerMaterial();
    
}
