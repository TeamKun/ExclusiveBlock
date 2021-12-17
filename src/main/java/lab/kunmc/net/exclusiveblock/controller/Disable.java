package lab.kunmc.net.exclusiveblock.controller;

import dev.kotx.flylib.command.CommandContext;
import lab.kunmc.net.exclusiveblock.constant.CommandEnum;
import lab.kunmc.net.exclusiveblock.game.GameManager;

class Disable extends BassController {

  private final CommandEnum commandEnum = CommandEnum.DISABLE;

  @Override
  public void execute(CommandContext ctx) {
    CommandResult result = GameManager.disable();
    result.sendResult(ctx);
  }

  @Override
  public CommandEnum commandEnum() {
    return this.commandEnum;
  }
}
