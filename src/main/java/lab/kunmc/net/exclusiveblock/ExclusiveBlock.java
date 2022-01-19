package lab.kunmc.net.exclusiveblock;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import dev.kotx.flylib.FlyLib;
import lab.kunmc.net.exclusiveblock.command.Main;
import lab.kunmc.net.exclusiveblock.game.DisplayTask;
import lab.kunmc.net.exclusiveblock.game.EventListener;
import lab.kunmc.net.exclusiveblock.game.KillTask;
import org.bukkit.plugin.java.JavaPlugin;

public final class ExclusiveBlock extends JavaPlugin {

  public static ExclusiveBlock plugin;
  public static ProtocolManager protocolManager;


  @Override
  public void onEnable() {
    plugin = this;
    protocolManager = ProtocolLibrary.getProtocolManager();
    FlyLib.create(this, builder -> {
      builder.command(new Main());
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
