package lab.kunmc.net.exclusiveblock.controller;

import dev.kotx.flylib.command.CommandContext;
import java.util.Locale;
import lab.kunmc.net.exclusiveblock.constant.CommandEnum;
import lab.kunmc.net.exclusiveblock.game.GameManager;
import lab.kunmc.net.exclusiveblock.game.GameMode;

class Mode extends BassController {

  private final CommandEnum commandEnum = CommandEnum.MODE;

  @Override
  public void execute(CommandContext ctx) {
    CommandResult result = null;
    try {
      GameMode mode = GameMode.valueOf(ctx.getArgs().get(0).toUpperCase(Locale.ROOT));
      result = GameManager.setMode(mode);
    } catch (IllegalArgumentException e) {
      result = new CommandResult(false, "存在しないモードです");
    } finally {
      result.sendResult(ctx);
    }
  }

  @Override
  public CommandEnum commandEnum() {
    return this.commandEnum;
  }
}
