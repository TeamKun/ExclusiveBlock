package lab.kunmc.net.exclusiveblock.constant;

import java.util.Arrays;
import java.util.List;
import org.bukkit.Material;


public class Settings {

  public static final String PLACER_KEY = "placer";
  public static final String PLACER_TEAM_KEY = "placerTeam";

  public static final List<Material> IGNORE_BLOCKS = Arrays.asList(
      Material.BEDROCK, Material.AIR, Material.CAVE_AIR);
}
