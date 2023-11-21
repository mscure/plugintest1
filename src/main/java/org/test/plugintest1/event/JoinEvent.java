package org.test.plugintest1.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.test.plugintest1.Main;

public class JoinEvent implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        Main plugin = Main.getPlugin();
        if(!plugin.getConfig().getBoolean("display-message"))
            return;
        player.sendMessage(Main.prefix + plugin.getConfig().getString("message"));
    }
}