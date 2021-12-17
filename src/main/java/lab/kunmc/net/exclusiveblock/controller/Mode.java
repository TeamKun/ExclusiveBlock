package lab.kunmc.net.exclusiveblock.controller;

import dev.kotx.flylib.command.CommandContext;
import lab.kunmc.net.exclusiveblock.constant.CommandEnum;

class Mode extends BassController {

  private final CommandEnum commandEnum = CommandEnum.MODE;

  @Override
  public void execute(CommandContext ctx) {

  }

  @Override
  public CommandEnum commandEnum() {
    return this.commandEnum;
  }
}
