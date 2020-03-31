package fr.eter.radiationzone;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTPA implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if (sender instanceof Player) {
			Player player = null;
			Player player_tpa = null;
			Location spawn = null;
			if (args.length == 3) {
				player = (Player)sender;
				spawn = new Location(player.getWorld(), Double.parseDouble(args[0]), Double.parseDouble(args[1]), Double.parseDouble(args[2]));
			} else if (args.length == 1) {
				player_tpa = Bukkit.getServer().getPlayer(args[0]);
				if (player_tpa != null)
					spawn = new Location(player_tpa.getWorld(), player_tpa.getLocation().getX(), player_tpa.getLocation().getY(), player_tpa.getLocation().getZ());
				else {
					player = (Player)sender;
					player.sendMessage("The player must exist and be online.");
					return true;
				}
			} else if (args.length == 2) {
				player = Bukkit.getServer().getPlayer(args[0]);
				player_tpa = Bukkit.getServer().getPlayer(args[1]);
				if (player_tpa != null && player != null)
					spawn = new Location(player_tpa.getWorld(), player_tpa.getLocation().getX(), player_tpa.getLocation().getY(), player_tpa.getLocation().getZ());
				else {
					player = (Player)sender;
					player.sendMessage("Those players must both be online.");
					return true;
				}
			} else {
				player = (Player)sender;
				player.sendMessage("You must send something, like a player, or coordinates.");
				return false;
			}
			player.teleport(spawn);
			return true;
		}
		return false;
	}
}
