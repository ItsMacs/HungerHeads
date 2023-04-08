package eu.maxpi.fiverr.hungerheads.commands;

import de.tr7zw.nbtapi.NBTItem;
import eu.maxpi.fiverr.hungerheads.utils.PluginLoader;
import org.bukkit.block.Skull;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class AddHeadCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player p)) return true;

        if(!p.hasPermission("hungerheads.add")){
            sender.sendMessage("§cYou don't have permission!");
            return true;
        }

        if(args.length != 1){
            sender.sendMessage("§eUsage: &b/addhead <hunger>");
            return true;
        }

        ItemStack item = p.getInventory().getItemInMainHand().clone();
        if(!item.getType().name().contains("PLAYER")){
            sender.sendMessage("§cYou need to keep a valid item in your main hand");
            return true;
        }

        int it;
        try{
            it = Integer.parseInt(args[0]);
        }catch (Exception e){
            sender.sendMessage("§cYou need to keep a valid item in your main hand");
            return true;
        }


        if(!(item.getItemMeta() instanceof SkullMeta meta)){
            sender.sendMessage("§cYou need to keep a valid item in your main hand");
            return true;
        }

        NBTItem i = new NBTItem(item);
        String value = i.getCompound("SkullOwner").getUUID("Id").toString();

        System.out.println(value);
        PluginLoader.data.put(value, it);
        p.sendMessage("§eHead added!");
        return true;
    }
}
