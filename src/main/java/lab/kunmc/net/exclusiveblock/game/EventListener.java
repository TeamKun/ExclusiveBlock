package lab.kunmc.net.exclusiveblock.game;

import lab.kunmc.net.exclusiveblock.ExclusiveBlock;
import lab.kunmc.net.exclusiveblock.constant.Settings;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scoreboard.Team;

public class EventListener implements Listener {

  @EventHandler(ignoreCancelled = true)
  public void onBlockPlace(BlockPlaceEvent event) {
    if (!GameManager.isEnable()) {
      return;
    }

    Player placer = event.getPlayer();
    if (placer == null) {
      return;
    }

    Block block = event.getBlock();

    //プレイヤーデータをセット
    if (!block.getMetadata(Settings.PLACER_KEY).isEmpty()) {
      block.setMetadata(Settings.PLACER_KEY,
          new FixedMetadataValue(ExclusiveBlock.plugin, null));
    }
    block.setMetadata(Settings.PLACER_KEY,
        new FixedMetadataValue(ExclusiveBlock.plugin, placer.getUniqueId()));

    // チームデータをセット
    if (!block.getMetadata(Settings.PLACER_TEAM_KEY).isEmpty()) {
      block.setMetadata(Settings.PLACER_TEAM_KEY,
          new FixedMetadataValue(ExclusiveBlock.plugin, null));
    }

    Team team = Teams.getAffiliatedTeam(placer);
    if (team == null) {
      return;
    }

    block.setMetadata(Settings.PLACER_TEAM_KEY,
        new FixedMetadataValue(ExclusiveBlock.plugin, team.getName()));

  }
}
