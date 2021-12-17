package lab.kunmc.net.exclusiveblock.command;

import lab.kunmc.net.exclusiveblock.constant.CommandEnum;

public class Main extends CommandBase {

  public Main() {
    super(CommandEnum.EXCLUSIVEBLOCK);
    children(
        new Mode(CommandEnum.MODE),
        new Enable(CommandEnum.ENABLE),
        new Disable(CommandEnum.DISABLE)
    );
  }
}
