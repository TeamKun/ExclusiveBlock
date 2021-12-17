package lab.kunmc.net.exclusiveblock.game;

import lab.kunmc.net.exclusiveblock.constant.GameMode;
import lab.kunmc.net.exclusiveblock.controller.CommandResult;

public class GameManager {

  private static GameMode currentMode = GameMode.SOLO;
  private static boolean isEnable;

  public static boolean setMode(GameMode mode) {
    boolean isSucceed = currentMode == mode;

    if (isSucceed) {
      currentMode = mode;
    }

    return isSucceed;
  }

  public static CommandResult enable() {
    if (isEnable) {
      return new CommandResult(false, "プラグインはすでに有効化されています");
    }
    toggleState();
    return new CommandResult(true, "プラグインを有効化しました");
  }

  public static CommandResult disable() {
    if (!isEnable) {
      return new CommandResult(false, "プラグインは有効化されていません");
    }
    toggleState();
    return new CommandResult(true, "プラグインを無効化しました");
  }

  private static void toggleState() {
    isEnable = !isEnable;
  }
}
