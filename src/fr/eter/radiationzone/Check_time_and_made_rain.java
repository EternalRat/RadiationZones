package fr.eter.radiationzone;

import java.util.Calendar;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Check_time_and_made_rain extends BukkitRunnable {

	private RadiationZone main;
	private int demi = 0, quart = 0, last = 0, rain = 0;

	public Check_time_and_made_rain(RadiationZone radiationZone) {
		this.main = radiationZone;
	}
	
	@Override
	public void run() {
		Bukkit.getServer().getPlayer("Rz_RazZer").sendMessage("§4" + Calendar.getInstance().get(Calendar.MINUTE) + " §aVoici le nombre de minutes");
		for (Player player : main.Players)
			Bukkit.getServer().getPlayer("Rz_RazZer").sendMessage("Voici les personnes dans la liste &4" + player.getName());
		if (Calendar.getInstance().get(Calendar.MINUTE) == 30 && demi == 0) {
			rain = 0;
			String toSend = "The rain will fall under 30 minutes";
			for (Player player : main.Players)
				player.sendTitle(toSend, "Protect yourself if you don't want to die", 10, 80, 20);
			demi += 1;
		}
		if (Calendar.getInstance().get(Calendar.MINUTE) == 45 && quart == 0) {
			for (Player player : main.Players)
				player.sendTitle("The rain will fall under 15 minutes", "Protect yourself if you don't want to die", 10, 80, 20);
			quart += 1;
		}
		if (Calendar.getInstance().get(Calendar.MINUTE) == 55 && last == 0) {
			for (Player player : main.Players)
				player.sendTitle("The rain will fall under 5 minutes", "Protect yourself if you don't want to die", 10, 80, 20);
			last += 1;
		}
		if (Calendar.getInstance().get(Calendar.MINUTE) == 0 && rain == 0) {
			rain += 1;
			Bukkit.getServer().getWorld("world").setThundering(true);
			Bukkit.getServer().getWorld("world").setStorm(true);
			Bukkit.getServer().getWorld("world").setWeatherDuration(6000);
			for (Player player : main.Players)
				player.sendTitle("The rain started to fall", "Protect yourself if you don't want to die", 10, 80, 20);
			Bukkit.getServer().getWorld("world").setThunderDuration(6000);
		}
	}

}
