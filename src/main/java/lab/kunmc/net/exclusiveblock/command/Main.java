package lab.kunmc.net.exclusiveblock.command;

import lab.kunmc.net.exclusiveblock.constant.CommandEnum;
import net.kunmc.lab.configlib.command.ConfigCommand;

public class Main extends CommandBase {

  public Main(ConfigCommand command) {
    super(CommandEnum.EXCLUSIVEBLOCK);
    children(
        new Mode(CommandEnum.MODE),
        new Enable(CommandEnum.ENABLE),
        new Disable(CommandEnum.DISABLE),
        command
    );
  }
}
