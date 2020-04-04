package fr.eter.radiationzone;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandInventory implements CommandExecutor {

	private RadiationZone main;

	public CommandInventory(RadiationZone radiationZone) {
		this.main = radiationZone;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		// TODO Auto-generated method stub
		return false;
	}

}
