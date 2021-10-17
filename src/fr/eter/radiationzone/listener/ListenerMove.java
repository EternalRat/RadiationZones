package fr.eter.radiationzone.listener;

import java.util.Calendar;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import fr.eter.radiationzone.RadiationZone;

public class ListenerMove implements Listener {

	RadiationZone main;
	public ListenerMove(RadiationZone radiationZone) {
		this.main = radiationZone;
	}
	
	@EventHandler
	public void onMovement(PlayerMoveEvent pm) {
		if (Calendar.getInstance().get(Calendar.MINUTE) >= 0 && Calendar.getInstance().get(Calendar.MINUTE) < 20) {
			Player p = pm.getPlayer();
			Location pLocation = p.getLocation();
			Block highestBlock = p.getWorld().getHighestBlockAt((int)pLocation.getX(), (int)pLocation.getZ());
			if (highestBlock.getLocation().subtract(pLocation).getY() <= 0) {
				p.setHealth(0);
			}
		}
	}
}
