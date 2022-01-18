package lab.kunmc.net.exclusiveblock.constant.command;

import dev.kotx.flylib.command.Command;
import lab.kunmc.net.exclusiveblock.constant.CommandEnum;

public class CommandBase extends Command {

  protected CommandEnum commandEnum;

  CommandBase(CommandEnum commandEnum) {
    super(commandEnum.commandName());
    this.commandEnum = commandEnum;
  }
}
