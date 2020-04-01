package fr.eter.radiationzone.tp;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import fr.eter.radiationzone.RadiationZone;

public class CommandTPY extends JavaPlugin implements CommandExecutor {
	private RadiationZone main;
	
	public CommandTPY(RadiationZone main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if (sender instanceof Player && args.length == 1) {
			Player player = (Player) sender;
			if (main.TPPlayers.containsKey(player)) {
				Location loc = player.getLocation();
				Player firstplayer = main.TPPlayers.get(player);
				firstplayer.teleport(loc);
				firstplayer.sendMessage("Vous venez d'être tp à " + player.getName());
				main.TPPlayers.remove(player);
			}
			return true;
		}
		return false;
	}
}
