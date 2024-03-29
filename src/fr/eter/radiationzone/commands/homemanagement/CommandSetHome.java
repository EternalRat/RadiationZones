package fr.eter.radiationzone.commands.homemanagement;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.eter.radiationzone.RadiationZone;

public class CommandSetHome implements CommandExecutor {

	private RadiationZone main;
	
	public CommandSetHome(RadiationZone main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player)sender;
			if (args.length == 1) {
				if (!main.getConfig().contains("config.home." + player.getName()))
					main.getConfig().addDefault("config.home", player.getName());
				if (main.getConfig().contains("config.home." + player.getName() + "." + args[0])) {
					player.sendMessage("This home already exist, delete him before !");
					return true;
				}
				main.getConfig().addDefault("config.home." + player.getName(), args[0]);
				Location loc = player.getLocation();
				main.getConfig().set("config.home."  + player.getName() + "." + args[0] + ".world", loc.getWorld().getName());
				main.getConfig().set("config.home."  + player.getName() + "." + args[0] + ".x", loc.getX());
				main.getConfig().set("config.home."  + player.getName() + "." + args[0] + ".y", loc.getY());
				main.getConfig().set("config.home."  + player.getName() + "." + args[0] + ".z", loc.getZ());
				main.getConfig().set("config.home."  + player.getName() + "." + args[0] + ".pitch", loc.getPitch());
				main.getConfig().set("config.home."  + player.getName() + "." + args[0] + ".yaw", loc.getYaw());
				main.saveConfig();
				player.sendMessage("The home " + args[0] + " has been created");
				return true;
			}
			player.sendMessage("You must give a name.");
		}
		return false;
	}

}
