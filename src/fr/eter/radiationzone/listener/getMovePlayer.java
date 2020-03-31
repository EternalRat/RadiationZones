package fr.eter.radiationzone.listener;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import fr.eter.radiationzone.RadiationZone;

public class getMovePlayer implements Listener {

	RadiationZone main;
	public getMovePlayer(RadiationZone radiationZone) {
		this.main = radiationZone;
	}

	
	public void checkWhereWalk(PlayerMoveEvent pm) {
		if (main.time_world >= 0 && main.time_world <= 6000) {
			Player p = pm.getPlayer();
			Location loc = p.getLocation();
			loc.setY(loc.getY() - 1);
			Block bloc = loc.getBlock();
			if (bloc.getLightLevel() == 15)
				p.kickPlayer(p.getName());
		}
	}
}
