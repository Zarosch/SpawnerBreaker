package me.velz.spawnerbreaker.listeners;

import me.velz.spawnerbreaker.SpawnerBreaker;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BlockBreakListener implements Listener {

    private final SpawnerBreaker plugin;

    public BlockBreakListener(SpawnerBreaker plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        if ((event.getBlock().getType() == plugin.getVersion().getSpawnerMaterial())
                && (plugin.getVersion().getItemInMainHand(player) != null)
                && (plugin.getVersion().getItemInMainHand(player).getType() == Material.DIAMOND_PICKAXE)
                && (plugin.getVersion().getItemInMainHand(player).containsEnchantment(Enchantment.SILK_TOUCH))) {
            CreatureSpawner spawner = (CreatureSpawner) block.getState();
            ItemStack stack = new ItemStack(plugin.getVersion().getSpawnerMaterial());
            ItemMeta meta = stack.getItemMeta();
            meta.setDisplayName("§a" + spawner.getSpawnedType().toString());
            stack.setItemMeta(meta);
            player.getWorld().dropItemNaturally(spawner.getLocation(), stack);
        }
    }

}
