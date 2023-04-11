package eu.maxpi.fiverr.hungerheads.utils;

import eu.maxpi.fiverr.hungerheads.HungerHeads;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class PluginLoader {

    public static HashMap<String, Integer> data = new HashMap<>();
    public static HashMap<String, String> headNames = new HashMap<>();

    public static void load(){
        HungerHeads.getInstance().saveResource("config.yml", false);

        YamlConfiguration config = YamlConfiguration.loadConfiguration(new File(HungerHeads.getInstance().getDataFolder() + "/config.yml"));
        config.getKeys(false).forEach(s -> {
            data.put(s, config.getInt(s + ".hunger"));
            headNames.put(s, config.getString(s + ".name"));
        });
    }

    public static void save(){
        YamlConfiguration storage = new YamlConfiguration();

        data.forEach((v, h) -> storage.set(v + ".hunger", h));
        headNames.forEach((v, h) -> storage.set(v + ".name", h));

        try{
            storage.save(new File(HungerHeads.getInstance().getDataFolder() + "/config.yml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
