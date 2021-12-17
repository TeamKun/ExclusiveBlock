package lab.kunmc.net.exclusiveblock.controller;

import dev.kotx.flylib.command.CommandContext;

public abstract class BassController implements Controller {

  protected void sendResult(CommandContext ctx, boolean isSucceed, String message) {
    if (isSucceed) {
      ctx.success(message);
      return;
    }

    ctx.fail(message);
    return;
  }
}
