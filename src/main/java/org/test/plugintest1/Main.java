package org.test.plugintest1;

import org.bukkit.plugin.java.JavaPlugin;
import org.test.plugintest1.command.GUIopen;
import org.test.plugintest1.command.givedia;
import org.test.plugintest1.command.help;
import org.test.plugintest1.event.breakevent;
import org.test.plugintest1.event.InvClickEvent;
import org.test.plugintest1.event.JoinEvent;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;


public final class Main extends JavaPlugin {
    public static String prefix = ChatColor.GRAY+"["+ChatColor.YELLOW+"테스트"+ChatColor.GRAY+"]";
    FileConfiguration config = this.getConfig();
    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("플러그인 활성화");
        getServer().getPluginManager().registerEvents(new breakevent(), this);
        getServer().getPluginManager().registerEvents(new InvClickEvent(), this);
        getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        getServer().getPluginCommand("thelp").setExecutor(new help());
        getServer().getPluginCommand("tgivedia").setExecutor(new givedia());
        getServer().getPluginCommand("topeninv").setExecutor(new GUIopen());

        config.addDefault("display-message", true);
        config.addDefault("message", "안녕하세요!");
        config.options().copyDefaults(true);
        saveConfig();


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("플러그인 비활성화");
    }

    public static Main getPlugin() {
        return plugin;
    }
}

