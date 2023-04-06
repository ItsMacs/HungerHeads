package eu.maxpi.fiverr.hungerheads.commands;

import eu.maxpi.fiverr.hungerheads.utils.PluginLoader;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadHeadsCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("hungerheads.reload")) {
            sender.sendMessage("§cYou don't have permission!");
            return true;
        }

        PluginLoader.data.clear();
        PluginLoader.load();

        sender.sendMessage("§aData reloaded!");
        return true;
    }

}
