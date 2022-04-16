package yzdwhitelist.yzdwhitelist;

import org.bukkit.plugin.java.JavaPlugin;
import yzdwhitelist.yzdwhitelist.command.*;

import java.util.Objects;

public final class YzdWihteList extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Objects.requireNonNull(getCommand("ywl")).setExecutor(new maincommand());
        getServer().getPluginManager().registerEvents(new yzdwhitelist.yzdwhitelist.event.kick(),this);
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
