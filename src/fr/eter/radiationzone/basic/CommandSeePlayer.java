package fr.eter.radiationzone.basic;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.eter.radiationzone.RadiationZone;

public class CommandSeePlayer implements CommandExecutor {

	private RadiationZone main;
	
	public CommandSeePlayer(RadiationZone radiationZone) {
		this.main = radiationZone;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if (sender instanceof Player) {
			Player play = (Player)sender;
			for (Player player : main.Players)
				play.sendMessage("§4" + player.getName());
			return true;
		}
		return false;
	}

}
