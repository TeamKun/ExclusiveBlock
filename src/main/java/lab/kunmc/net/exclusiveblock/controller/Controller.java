package lab.kunmc.net.exclusiveblock.controller;

import dev.kotx.flylib.command.CommandContext;
import lab.kunmc.net.exclusiveblock.constant.CommandEnum;

public interface Controller {

  void execute(CommandContext ctx);

  CommandEnum commandEnum();
}
