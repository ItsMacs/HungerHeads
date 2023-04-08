package eu.maxpi.fiverr.hungerheads.events;

import de.tr7zw.nbtapi.NBTItem;
import eu.maxpi.fiverr.hungerheads.HungerHeads;
import eu.maxpi.fiverr.hungerheads.utils.PluginLoader;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Skull;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.util.Vector;

public class onHeadUsage implements Listener {

    @EventHandler
    public void headUsage(PlayerInteractEvent event){
        if(event.getPlayer().getFoodLevel() >= 20) return;

        if(event.getAction() != Action.RIGHT_CLICK_BLOCK) return;

        if(event.getClickedBlock() == null) return;
        if(!event.getClickedBlock().getType().name().contains("PLAYER")) return;

        Skull s = (Skull)event.getClickedBlock().getState();
        if(s.getOwnerProfile() == null) return;

        String value = s.getOwnerProfile().getUniqueId().toString();

        if(!PluginLoader.data.containsKey(value)) return;

        event.getClickedBlock().setType(Material.AIR);

        event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_PLAYER_BURP, 1, 1);
        event.getPlayer().getWorld().spawnParticle(Particle.VILLAGER_HAPPY, event.getClickedBlock().getLocation().add(Vector.getRandom().normalize().multiply(0.5)), 3);
        event.getPlayer().setFoodLevel(event.getPlayer().getFoodLevel() + PluginLoader.data.get(value));
    }

}
