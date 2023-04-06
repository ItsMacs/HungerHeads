package eu.maxpi.fiverr.hungerheads.events;

import de.tr7zw.nbtapi.NBTItem;
import eu.maxpi.fiverr.hungerheads.HungerHeads;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Skull;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.persistence.PersistentDataType;

public class onHeadPlace implements Listener {

    @EventHandler
    public void headPlace(BlockPlaceEvent event){
        if(!event.getItemInHand().getType().name().contains("PLAYER")) return;

        NBTItem i = new NBTItem(event.getItemInHand());
        String value = i.getCompound("SkullOwner").getCompound("Properties").getCompoundList("textures").get(0).getString("Value");

        Skull s = (Skull)event.getBlockPlaced().getState();
        s.getPersistentDataContainer().set(new NamespacedKey(HungerHeads.getInstance(), "headhunger"), PersistentDataType.STRING, value);
    }

}
