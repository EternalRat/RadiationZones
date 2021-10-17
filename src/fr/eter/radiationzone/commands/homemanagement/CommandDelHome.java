package fr.eter.radiationzone.commands.homemanagement;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.eter.radiationzone.RadiationZone;

public class CommandDelHome implements CommandExecutor {

	private RadiationZone main;
	
	public CommandDelHome(RadiationZone main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if (sender instanceof Player && args.length == 1) {
			Player player = (Player)sender;
			if (!main.getConfig().contains("config.home." + player.getName()))
				return false;
			if (main.getConfig().contains("config.home." + player.getName() + "." + args[0])) {
				main.getConfig().set("config.home."  + player.getName() + "." + args[0], null);
				main.saveConfig();
				player.sendMessage("The home " + args[0] + " has been deleted");
				return true;
			}	
		}
		return false;
	}
}
