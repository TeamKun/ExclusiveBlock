package lab.kunmc.net.exclusiveblock;

import net.kunmc.lab.configlib.config.BaseConfig;
import net.kunmc.lab.configlib.value.IntegerValue;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class Config extends BaseConfig {

  public IntegerValue killTaskTick = new IntegerValue(1, 1, 1000);
  public IntegerValue displayTaskTick = new IntegerValue(2, 1, 1000);

  public Config(@NotNull Plugin plugin) {
    super(plugin);
  }
}
