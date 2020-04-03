package fr.eter.radiationzone.listener;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.eter.radiationzone.RadiationZone;
import net.md_5.bungee.api.ChatColor;


public class ListenerJoin implements Listener {
	private RadiationZone main;
	
	public ListenerJoin(RadiationZone main) {
		this.main = main;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		Location spawn = new Location(player.getWorld(), 91.815, 4, -37.031, 90f, -0.9f);
		player.teleport(spawn);
		player.getInventory().clear();
		player.setFoodLevel(20);
		player.setHealth(20);
		
		Player p = e.getPlayer();
	    p.sendMessage(ChatColor.RED + "Bienvenue sur le serveur " + ChatColor.BLUE + e.getPlayer().getName() + ChatColor.RED + " !");
		if (!main.getPlayers().contains(player)) {
			System.out.println("Test");
			main.Players.add(player);
		}
		player.setGameMode(GameMode.ADVENTURE);
	}
}
