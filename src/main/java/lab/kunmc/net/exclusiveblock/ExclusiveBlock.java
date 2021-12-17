package lab.kunmc.net.exclusiveblock;

import dev.kotx.flylib.FlyLib;
import lab.kunmc.net.exclusiveblock.command.Main;
import org.bukkit.plugin.java.JavaPlugin;

public final class ExclusiveBlock extends JavaPlugin {

  public static ExclusiveBlock plugin;

  @Override
  public void onEnable() {
    plugin = this;
    FlyLib.create(this, builder -> {
      builder.command(new Main());
    });
  }

  @Override
  public void onDisable() {
    // Plugin shutdown logic
  }
}
