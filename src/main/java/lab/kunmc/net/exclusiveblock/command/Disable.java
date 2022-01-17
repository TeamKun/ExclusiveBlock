package lab.kunmc.net.exclusiveblock.command;

import dev.kotx.flylib.command.CommandContext;
import lab.kunmc.net.exclusiveblock.ExclusiveBlock;
import lab.kunmc.net.exclusiveblock.constant.CommandEnum;
import lab.kunmc.net.exclusiveblock.controller.Facade;
import org.jetbrains.annotations.NotNull;

public class Disable extends CommandBase {

  public Disable(CommandEnum commandEnum) {
    super(commandEnum);
  }

  @Override
  public void execute(@NotNull CommandContext ctx) {
    Facade.INSTANCE.execute(this.commandEnum, ctx);

    ExclusiveBlock.displayTask.cancel();
    ExclusiveBlock.killTask.cancel();
  }
}
