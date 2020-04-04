package fr.eter.radiationzone;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class CommandInventory implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if (sender instanceof Player) {
			Player send = (Player)sender;
			if (args.length == 1) {
				if (Bukkit.getServer().getPlayer(args[0]) instanceof Player) {
					Player player = Bukkit.getServer().getPlayer(args[0]);
					Inventory inv = player.getInventory();
					StringBuilder items_names = new StringBuilder();
					for (int i = 0; i < inv.getSize(); i++)
						if (inv.getItem(i) != null)
							items_names.append("§4" + inv.getItem(i).getItemMeta().getLocalizedName() + "\n");
					send.sendMessage(items_names.toString());
				}
			}
		}
		return false;
	}

}
