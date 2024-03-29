package fr.eter.radiationzone.commands.tp;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.eter.radiationzone.RadiationZone;

public class CommandTPA implements CommandExecutor {

	private RadiationZone main;
	
	public CommandTPA(RadiationZone main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player)sender;
			if (args.length == 1) {
				Player player_tpa = Bukkit.getServer().getPlayer(args[0]);
				if (player_tpa != null && player != null) {
					player_tpa.sendMessage(player.getName() + "veut se tp à vous. Faites /tpaccept ou /tpdecline.");
					player.sendMessage("Vous venez de faire une demande de tp à " + player_tpa.getName());
					player.sendMessage("En attente d'une réponse...");
					main.TPPlayers.put(player, player_tpa);
				} else {
					player.sendMessage("This player must be online.");
					return true;
				}
			} else {
				player.sendMessage("You must send something, like a player, or coordinates.");
				return false;
			}
			return true;
		}
		return false;
	}
}
