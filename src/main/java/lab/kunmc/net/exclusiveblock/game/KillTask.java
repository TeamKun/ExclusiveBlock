package lab.kunmc.net.exclusiveblock.game;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class KillTask extends BukkitRunnable {

  @Override
  public void run() {
    if (!GameManager.isEnable()) {
      return;
    }

    for (Player player : Bukkit.getOnlinePlayers()) {
      Block steppingBlock = player.getLocation().add(0, -1, 0).getBlock();

      // 死亡判定
      if (!GameManager.currentMode().isSafe(player, steppingBlock)) {
        player.damage(1000);
        continue;
      }
    }
  }
}
