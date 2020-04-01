package fr.eter.radiationzone.tp;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import fr.eter.radiationzone.RadiationZone;

public class CommandTPN extends JavaPlugin implements CommandExecutor {

	private RadiationZone main;
	
	public CommandTPN(RadiationZone main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if (sender instanceof Player && args.length == 1) {
			Player player = (Player) sender;
			if (main.TPPlayers.containsKey(player)) {
				Player firstplayer = main.TPPlayers.get(player);
				firstplayer.sendMessage(player.getName() + " a refusé la téléportation");
				main.TPPlayers.remove(player);
			}
			return true;
		}
		return false;
	}
}
