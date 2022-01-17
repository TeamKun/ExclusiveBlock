package lab.kunmc.net.exclusiveblock;

import dev.kotx.flylib.FlyLib;
import lab.kunmc.net.exclusiveblock.command.Main;
import lab.kunmc.net.exclusiveblock.game.EventListener;
import net.kunmc.lab.configlib.command.ConfigCommandBuilder;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class ExclusiveBlock extends JavaPlugin {

  public static ExclusiveBlock plugin;
  public static Config config;

  public static BukkitRunnable killTask;
  public static BukkitRunnable displayTask;

  @Override
  public void onEnable() {
    plugin = this;

    config = new Config(this);
    config.saveConfigIfAbsent();
    config.loadConfig();

    FlyLib.create(this, builder -> {
      builder.command(new Main(new ConfigCommandBuilder(config).build()));
    });

    getServer().getPluginManager().registerEvents(new EventListener(), this);
  }

  @Override
  public void onDisable() {
    // Plugin shutdown logic
  }
}
