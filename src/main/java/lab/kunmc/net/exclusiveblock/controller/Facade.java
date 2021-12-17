package lab.kunmc.net.exclusiveblock.controller;

import dev.kotx.flylib.command.CommandContext;
import java.util.ArrayList;
import java.util.List;
import lab.kunmc.net.exclusiveblock.constant.CommandEnum;

public class Facade {

  public static final Facade INSTANCE = new Facade();

  private List<Controller> controllers = new ArrayList<>();

  private Facade() {
    this.controllers.add(new Enable());
    this.controllers.add(new Disable());
    this.controllers.add(new Mode());
  }

  public void execute(CommandEnum commandEnum, CommandContext ctx) {
    for (Controller controller : this.controllers) {
      if (commandEnum == controller.commandEnum()) {
        controller.execute(ctx);
        return;
      }
    }
    ctx.fail("予期せぬエラーが発生しました");
  }
}
