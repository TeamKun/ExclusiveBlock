package lab.kunmc.net.exclusiveblock;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import dev.kotx.flylib.FlyLib;
import lab.kunmc.net.exclusiveblock.constant.command.Main;
import lab.kunmc.net.exclusiveblock.game.DisplayTask;
import lab.kunmc.net.exclusiveblock.game.EventListener;
import lab.kunmc.net.exclusiveblock.game.KillTask;
import net.kunmc.lab.configlib.command.ConfigCommandBuilder;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public final class ExclusiveBlock extends JavaPlugin {

  public static ExclusiveBlock plugin;
  public static Config config;
  public static ProtocolManager protocolManager;
  public static BukkitTask killTask;
  public static BukkitTask displayTask;

  @Override
  public void onEnable() {
    plugin = this;
    protocolManager = ProtocolLibrary.getProtocolManager();
    config = new Config(this);
    config.saveConfigIfAbsent();
    config.loadConfig();

    FlyLib.create(this, builder -> {
      builder.command(new Main(new ConfigCommandBuilder(config).build()));
    });

    getServer().getPluginManager().registerEvents(new EventListener(), this);
    new KillTask().runTaskTimerAsynchronously(this, 0, 1);
    new DisplayTask().runTaskTimerAsynchronously(this, 0, 1);
  }

  @Override
  public void onDisable() {
    // Plugin shutdown logic
  }
}
