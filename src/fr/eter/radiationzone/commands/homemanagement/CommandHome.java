package fr.eter.radiationzone.commands.homemanagement;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
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

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player)sender;
			if (args.length == 1) {
				if (!main.getConfig().contains("config.home." + player.getName()))
					main.getConfig().addDefault("config.home", player.getName());
				if (main.getConfig().contains("config.home." + player.getName() + "." + args[0])) {
					//main.getConfig().addDefault("config.home." + player.getName(), args[0]);
					World world = Bukkit.getWorld(main.getConfig().getString("config.home."  + player.getName() + "." + args[0] + ".world"));
					double posX = main.getConfig().getDouble("config.home."  + player.getName() + "." + args[0] + ".x");
					double posY = main.getConfig().getDouble("config.home."  + player.getName() + "." + args[0] + ".y");
					double posZ = main.getConfig().getDouble("config.home."  + player.getName() + "." + args[0] + ".z");
					Location loc = new Location(world, posX, posY, posZ);
					loc.setPitch((float) main.getConfig().getDouble("config.home."  + player.getName() + "." + args[0] + ".y"));
					loc.setYaw((float) main.getConfig().getDouble("config.home."  + player.getName() + "." + args[0] + ".z"));
					player.teleport(loc);
					return true;
				}
				player.sendMessage("This home doesn't exist");
			} else if (args.length == 0){
				StringBuilder home = new StringBuilder();
				for (Object part : main.getConfig().getList("config.home."  + player.getName() + ".list"))
					home.append(part.toString() + " ");
				player.sendMessage("Voici votre liste de home : " + home.toString().trim().replaceAll(" ", ", "));
			}
		}
		return false;
	}
}
