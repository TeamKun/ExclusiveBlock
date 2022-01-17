package lab.kunmc.net.exclusiveblock.command;

import dev.kotx.flylib.command.CommandContext;
import lab.kunmc.net.exclusiveblock.Config;
import lab.kunmc.net.exclusiveblock.ExclusiveBlock;
import lab.kunmc.net.exclusiveblock.constant.CommandEnum;
import lab.kunmc.net.exclusiveblock.controller.Facade;
import lab.kunmc.net.exclusiveblock.game.DisplayTask;
import lab.kunmc.net.exclusiveblock.game.KillTask;
import org.jetbrains.annotations.NotNull;

public class Enable extends CommandBase {

  public Enable(CommandEnum commandEnum) {
    super(commandEnum);
  }

  @Override
  public void execute(@NotNull CommandContext ctx) {
    Facade.INSTANCE.execute(this.commandEnum, ctx);

    ExclusiveBlock plugin = ExclusiveBlock.plugin;
    Config config = ExclusiveBlock.config;

    ExclusiveBlock.killTask = new KillTask().runTaskTimer(plugin, 0, config.killTaskTick.value());
    ExclusiveBlock.displayTask = new DisplayTask().runTaskTimerAsynchronously(plugin, 0,
        config.displayTaskTick.value());
  }
}
