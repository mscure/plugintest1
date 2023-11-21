package org.test.plugintest1.command;

import org.test.plugintest1.inventory.testGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GUIopen implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            testGUI inv = new testGUI();
            inv.open(player);
        }
        return false;
    }
}