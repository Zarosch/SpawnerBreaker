package me.velz.spawnerbreaker;

import lombok.Getter;
import me.velz.spawnerbreaker.listeners.BlockBreakListener;
import me.velz.spawnerbreaker.listeners.BlockPlaceListener;
import me.velz.spawnerbreaker.version.Version;
import me.velz.spawnerbreaker.version.VersionMatcher;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class SpawnerBreaker extends JavaPlugin implements Listener {

    private final VersionMatcher versionMatcher = new VersionMatcher();
    
    @Getter
    private Version version;
    
    @Override
    public void onEnable() {
        this.version = this.versionMatcher.match();
        Bukkit.getPluginManager().registerEvents(new BlockBreakListener(this), this);
        Bukkit.getPluginManager().registerEvents(new BlockPlaceListener(this), this);
    }


}
