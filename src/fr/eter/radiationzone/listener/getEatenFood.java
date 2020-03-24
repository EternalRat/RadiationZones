package fr.eter.radiationzone.listener;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import fr.eter.radiationzone.RadiationZone;

public class getEatenFood implements Listener {

	RadiationZone main;

	public getEatenFood(RadiationZone radiationZone) {
		this.main = radiationZone;
	}

	public void getFood(PlayerInteractEvent player) {
		
	}
}
