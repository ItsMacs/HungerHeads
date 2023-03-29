package eu.maxpi.fiverr.hungerheads;

import eu.maxpi.fiverr.hungerheads.events.onHeadUsage;
import eu.maxpi.fiverr.hungerheads.utils.PluginLoader;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class HungerHeads extends JavaPlugin {

    private static HungerHeads instance = null;
    public static HungerHeads getInstance() { return HungerHeads.instance; }
    private static void setInstance(HungerHeads in) { HungerHeads.instance = in; }

    @Override
    public void onEnable() {
        setInstance(this);

        PluginLoader.load();

        loadEvents();

        Bukkit.getLogger().info("HungerHeads by fiverr.com/macslolz was enabled successfully!");
    }

    private void loadEvents(){
        Bukkit.getPluginManager().registerEvents(new onHeadUsage(), this);
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("HungerHeads by fiverr.com/macslolz was enabled successfully!");
    }
}
