package eu.maxpi.fiverr.hungerheads.utils;

import eu.maxpi.fiverr.hungerheads.HungerHeads;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.HashMap;

public class PluginLoader {

    public static HashMap<String, Integer> data = new HashMap<>();

    public static void load(){
        HungerHeads.getInstance().saveResource("config.yml", false);

        YamlConfiguration config = YamlConfiguration.loadConfiguration(new File(HungerHeads.getInstance().getDataFolder() + "/config.yml"));
        config.getKeys(false).forEach(s -> data.put(s, config.getInt(s)));
    }

}
