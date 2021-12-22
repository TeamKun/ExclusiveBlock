package lab.kunmc.net.exclusiveblock.game;

import java.util.Set;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

public class Teams {

  private static Set<Team> teams = Bukkit.getScoreboardManager().getMainScoreboard().getTeams();

  public static void clear() {
    teams = Bukkit.getScoreboardManager().getMainScoreboard().getTeams();
  }

  public static Team getAffiliatedTeam(Player player) {
    if (teams.size() == 0) {
      return null;
    }

    for (Team team : teams) {
      for (OfflinePlayer teamPlayer : team.getPlayers()) {
        if (!teamPlayer.isOnline()) {
          continue;
        }

        if (teamPlayer.getUniqueId().equals(player.getUniqueId())) {
          return team;
        }
      }
    }

    return null;
  }
}
