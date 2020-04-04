package fr.eter.radiationzone.listener;

import org.bukkit.GameMode;
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
		player.setFoodLevel(20);
		player.setHealth(20);
		
		Player p = e.getPlayer();
	    p.sendMessage(ChatColor.RED + "Bienvenue sur le serveur " + ChatColor.BLUE + e.getPlayer().getName() + ChatColor.RED + " !");
		if (!main.getPlayers().contains(player)) main.getPlayers().add(player);
		player.setGameMode(GameMode.ADVENTURE);
	}
}
