package fr.eter.radiationzone.homemanagement;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.eter.radiationzone.RadiationZone;

public class CommandHome implements CommandExecutor {

	private RadiationZone main;
	
	public CommandHome(RadiationZone main) {
		this.main = main;
	}

	@SuppressWarnings("null")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player)sender;
			if (args.length == 1) {
				if (!main.getConfig().contains("config.home." + player.getName()))
					main.getConfig().addDefault("config.home", player.getName());
				if (main.getConfig().contains("config.home." + player.getName() + "." + args[0])) {
					main.getConfig().addDefault("config.home." + player.getName(), args[0]);
					Location loc = null;
					loc.setWorld(player.getServer().getWorld(main.getConfig().getString("config.home."  + player.getName() + "." + args[0] + ".world")));
					loc.setX(main.getConfig().getDouble("config.home."  + player.getName() + "." + args[0] + ".x"));
					loc.setY(main.getConfig().getDouble("config.home."  + player.getName() + "." + args[0] + ".y"));
					loc.setZ(main.getConfig().getDouble("config.home."  + player.getName() + "." + args[0] + ".z"));
					player.teleport(loc);
					return true;
				}
				player.sendMessage("This home doesn't exist");
			} else if (args.length == 0){
				StringBuilder home = new StringBuilder();
				for (String part : main.getConfig().getStringList("config.home."  + player.getName()))
					home.append(part + " ");
				player.sendMessage("Voici votre liste de home : " + home.toString());
			}
		}
		return false;
	}
}
