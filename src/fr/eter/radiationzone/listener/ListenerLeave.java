package fr.eter.radiationzone.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.eter.radiationzone.RadiationZone;

public class ListenerLeave implements Listener {
	private RadiationZone main;
	
	public ListenerLeave(RadiationZone main) {
		this.main = main;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		
		if (main.getPlayers().contains(player)) {
			System.out.println("Test");
			main.getPlayers().remove(player);
		}
	}
}
