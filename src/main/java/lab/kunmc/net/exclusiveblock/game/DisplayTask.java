package lab.kunmc.net.exclusiveblock.game;

import lab.kunmc.net.exclusiveblock.util.DecorationConst;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.RayTraceResult;

public class DisplayTask extends BukkitRunnable {

  @Override
  public void run() {
    if (!GameManager.isEnable()) {
      return;
    }

    for (Player player : Bukkit.getOnlinePlayers()) {

      // パーティクル表示
      RayTraceResult rayTraceResult = player.rayTraceBlocks(8);
      if (rayTraceResult == null) {
        return;
      }

      Block rayTraceBlock = rayTraceResult.getHitBlock();

      if (!GameManager.currentMode().isSafe(player, rayTraceBlock)) {
        player.sendActionBar(DecorationConst.RED + "DANGER!!");
      } else {
        player.sendActionBar(DecorationConst.GREEN + "SAFE");
      }
    }
  }
}
