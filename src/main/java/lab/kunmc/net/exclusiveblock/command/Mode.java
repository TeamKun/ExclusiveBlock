package lab.kunmc.net.exclusiveblock.command;

import dev.kotx.flylib.command.CommandContext;
import java.util.Locale;
import lab.kunmc.net.exclusiveblock.constant.CommandEnum;
import lab.kunmc.net.exclusiveblock.controller.Facade;
import lab.kunmc.net.exclusiveblock.game.GameMode;
import org.jetbrains.annotations.NotNull;

public class Mode extends CommandBase {

  public Mode(@NotNull CommandEnum commandEnum) {
    super(commandEnum);
    usage(usageBuilder -> {
      usageBuilder.stringArgument("mode", suggestionBuilder -> {
        for (GameMode mode : GameMode.values()) {
          suggestionBuilder.suggest(mode.name().toLowerCase(Locale.ROOT));
        }
      }, null);
    });
  }

  @Override
  public void execute(@NotNull CommandContext ctx) {
    Facade.INSTANCE.execute(this.commandEnum, ctx);
  }
}