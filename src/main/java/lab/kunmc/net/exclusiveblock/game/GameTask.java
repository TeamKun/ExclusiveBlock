package lab.kunmc.net.exclusiveblock.game;

import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedParticle;
import lab.kunmc.net.exclusiveblock.ExclusiveBlock;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.RayTraceResult;

public class GameTask extends BukkitRunnable {

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

      // パーティクル表示
      RayTraceResult rayTraceResult = player.rayTraceBlocks(8);
      if (rayTraceResult == null) {
        return;
      }

      Block rayTraceBlock = rayTraceResult.getHitBlock();

      if (!GameManager.currentMode().isSafe(player, rayTraceBlock)) {
        Location loc = rayTraceBlock.getLocation();
        PacketContainer packetContainer = ExclusiveBlock.protocolManager.createPacket(
            Server.WORLD_PARTICLES);
        packetContainer.getDoubles()
            .write(0, loc.getX() + 0.5)
            .write(1, loc.getY() + 1.5)
            .write(2, loc.getZ() + 0.5);
        packetContainer.getNewParticles().write(0, WrappedParticle.create(Particle.BARRIER, null));

        try {
          ExclusiveBlock.protocolManager.sendServerPacket(player, packetContainer);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }
}
