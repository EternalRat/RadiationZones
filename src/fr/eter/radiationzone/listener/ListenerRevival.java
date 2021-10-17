package fr.eter.radiationzone.listener;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class ListenerRevival implements Listener {

	public ListenerRevival() {}
	
	@EventHandler
	public void onRevival(PlayerRespawnEvent e) {
		Location pLocation = e.getRespawnLocation();
		pLocation.setX(pLocation.getX() - 1);
		World world = e.getPlayer().getWorld();
		if (world.generateTree(pLocation, TreeType.TREE))
			System.out.println("Success");
		else
			System.out.println("Failure");
		//Location safeLocation = getSafeLocation(e.getPlayer().getWorld(), pLocation);
		//e.setRespawnLocation(safeLocation);
		//e.getPlayer().sendMessage("You've been teleported to the actual safest place we found");
	}

	/**
	 * TODO NEED TO BE FIX
	 * @deprecated Not working actually
	 * Return the safest place that could be find or the original one if there's no safe place
	 * @param world The actual world where the player is
	 * @param pLocation His actual new location where he'll spawn
	 * @return The new safe location
	 */
	@SuppressWarnings("unused")
	private Location getSafeLocation(World world, Location pLocation) {
		double xToRemove = (pLocation.getX() % 1 == 0 ? 40.50 : 40);
		double zToRemove = (pLocation.getZ() % 1 == 0 ? 40.50 : 40);
		for (double x = pLocation.getX() - xToRemove; (x < 0 ? x < pLocation.getX() + 40 : x > pLocation.getX() + 40); x++) {
			for (double y = pLocation.getY() - 5; y < pLocation.getY() + 5; y++) {
				for (double z = pLocation.getZ() - zToRemove; (z < 0 ? z < pLocation.getZ() + 40 : z > pLocation.getZ() + 40); z++) {
					Block block = world.getBlockAt((int)x, (int)y, (int)z);
					if (block.getType() == Material.AIR || block.isEmpty()) continue;
					Block[] aboveBlock = new Block[] {world.getBlockAt((int)x, (int)y + 1, (int)z), world.getBlockAt((int)x, (int)y + 2, (int)z)};
					Block highestBlock = getHighestBlockAt(world, x, y, z);
					Location highestLocation = highestBlock.getLocation();
					if (y < highestLocation.getY() && (aboveBlock[0].getType() == Material.AIR || aboveBlock[0].isEmpty()) &&
							(aboveBlock[1].getType() == Material.AIR || aboveBlock[1].isEmpty())) {
						System.out.println("ActualBlock: " + block);
						System.out.println("HighestBlock: " + highestBlock);
						System.out.println("Actual location: " + x + " " + y + " " + z);
						System.out.println("HighestLocation: " + highestLocation);
						System.out.println("Final pos find");
						return new Location(world, x, y + 1.f, z);
					}
				}
			}
		}
		return pLocation;
	}

	private Block getHighestBlockAt(World world, double x, double y, double z) {
		Block highestBlock = null;
		Block tmpBlock = null;
		for (double newY = y; newY < 256; newY++) {
			Block actualBlock = world.getBlockAt((int)x, (int)newY, (int)z);
			if (actualBlock.getType() == Material.AIR || actualBlock.isEmpty()) {
				highestBlock = tmpBlock;
				break;
			}
			tmpBlock = world.getBlockAt((int)x, (int)newY, (int)z);
		}
		return highestBlock;
	}
}
