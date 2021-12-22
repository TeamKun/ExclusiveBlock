package lab.kunmc.net.exclusiveblock.game;

import lab.kunmc.net.exclusiveblock.controller.CommandResult;

public class GameManager {

  private static GameMode currentMode = GameMode.SOLO;
  private static boolean isEnable;

  public static CommandResult setMode(GameMode mode) {
    boolean isSucceed = currentMode != mode;

    if (!isSucceed) {
      return new CommandResult(false, "すでに" + mode.name().toLowerCase() + "モードです");
    }

    currentMode = mode;
    return new CommandResult(true, mode.name().toLowerCase() + "モードに切り替えました");
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

  public static GameMode currentMode() {
    return currentMode;
  }

  private static void toggleState() {
    isEnable = !isEnable;
  }
  
  public static boolean isEnable() {
    return isEnable;
  }
}
