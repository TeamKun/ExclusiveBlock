package lab.kunmc.net.exclusiveblock.game;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;

@FunctionalInterface
public interface PlacerJudge {

  boolean isSafe(Player player, Block block);
}
