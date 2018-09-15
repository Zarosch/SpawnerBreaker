package me.velz.spawnerbreaker.listeners;

import me.velz.spawnerbreaker.SpawnerBreaker;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener {

    private final SpawnerBreaker plugin;

    public BlockPlaceListener(SpawnerBreaker plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        if (event.getBlockPlaced().getType() == plugin.getVersion().getSpawnerMaterial()) {
            if (event.getItemInHand().hasItemMeta()) {
                if (EntityType.valueOf(((String) event.getItemInHand().getItemMeta().getDisplayName()).replaceAll("§a", "")) != null) {
                    EntityType type = EntityType.valueOf(((String) event.getItemInHand().getItemMeta().getDisplayName()).replaceAll("§a", ""));
                    CreatureSpawner spawner = (CreatureSpawner) event.getBlock().getState();
                    spawner.setSpawnedType(type);
                    spawner.update();
                }
            }
        }
    }

}
