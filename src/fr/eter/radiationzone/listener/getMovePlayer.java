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
		if (main.time_world >= 18000 && main.time_world <= 7000) {
			Location loc = pm.getTo();
			Block bloc = loc.getBlock();
			Player player = pm.getPlayer();
			if (bloc.getLightLevel() == 15)
				player.kickPlayer(player.getName());
		}
	}
}
