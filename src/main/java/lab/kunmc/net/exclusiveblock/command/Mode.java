package lab.kunmc.net.exclusiveblock.command;

import dev.kotx.flylib.command.CommandContext;
import lab.kunmc.net.exclusiveblock.constant.CommandEnum;
import lab.kunmc.net.exclusiveblock.controller.Facade;
import org.jetbrains.annotations.NotNull;

public class Mode extends CommandBase {

  public Mode(@NotNull CommandEnum commandEnum) {
    super(commandEnum);
  }

  @Override
  public void execute(@NotNull CommandContext ctx) {
    Facade.INSTANCE.execute(this.commandEnum, ctx);
  }
}