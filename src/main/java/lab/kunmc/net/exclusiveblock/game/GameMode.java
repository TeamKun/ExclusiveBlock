package lab.kunmc.net.exclusiveblock.game;

import java.util.UUID;
import lab.kunmc.net.exclusiveblock.constant.Settings;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

public enum GameMode {
  SOLO(((player, block) -> {
    if (containsIgnoreBlocks(block)) {
      return true;
    }

    if (isMatchSoloPlacer(player, block)) {
      return true;
    }
    return false;
  })),
  TEAM(((player, block) -> {
    if (containsIgnoreBlocks(block)) {
      return true;
    }

    if (isMatchSoloPlacer(player, block)) {
      return true;
    }

    if (isMatchTeamPlacer(player, block)) {
      return true;
    }

    return false;
  }));

  private PlacerJudge placerJudge;

  GameMode(PlacerJudge placerJudge) {
    this.placerJudge = placerJudge;
  }

  public boolean isSafe(Player player, Block block) {
    return this.placerJudge.isSafe(player, block);
  }

  private static boolean containsIgnoreBlocks(Block block) {
    if (Settings.IGNORE_BLOCKS.contains(block.getType())) {
      return true;
    }

    return false;
  }

  private static boolean isMatchSoloPlacer(Player player, Block block) {
    if (block.getMetadata(Settings.PLACER_KEY).isEmpty()) {
      return false;
    }
    UUID meta = (UUID) block.getMetadata(Settings.PLACER_KEY).get(0).value();
    if (!meta.equals(player.getUniqueId())) {
      return false;
    }
    return true;
  }

  private static boolean isMatchTeamPlacer(Player player, Block block) {
    Team playerTeam = Teams.getAffiliatedTeam(player);
    if (playerTeam == null) {
      return false;
    }

    if (block.getMetadata(Settings.PLACER_TEAM_KEY).isEmpty()) {
      return false;
    }

    String blockTeamName = (String) block.getMetadata(Settings.PLACER_TEAM_KEY).get(0).value();
    if (!blockTeamName.equals(playerTeam.getName())) {
      return false;
    }
    return true;
  }
}
