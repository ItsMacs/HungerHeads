package eu.maxpi.fiverr.hungerheads.events;

import de.tr7zw.nbtapi.NBTItem;
import eu.maxpi.fiverr.hungerheads.utils.PluginLoader;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class onHeadUsage implements Listener {

    @EventHandler
    public void headUsage(PlayerInteractEvent event){
        if(event.getItem() == null) return;
        if(event.getItem().getType() != Material.PLAYER_HEAD) return;

        NBTItem i = new NBTItem(event.getItem());
        String value = i.getCompound("SkullOwner").getCompound("Properties").getCompoundList("textures").get(0).getString("Value");
        if(!PluginLoader.data.containsKey(value)) return;

        event.getItem().setAmount(event.getItem().getAmount() - 1);
        event.getPlayer().setFoodLevel(event.getPlayer().getFoodLevel() + PluginLoader.data.get(value));
    }

}
