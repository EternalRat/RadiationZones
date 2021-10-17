package fr.eter.radiationzone.utils.rain;

import java.util.Calendar;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import fr.eter.radiationzone.RadiationZone;

public class CheckTime extends BukkitRunnable {

	private RadiationZone main;

	public CheckTime(RadiationZone radiationZone) {
		this.main = radiationZone;
	}
	
	@Override
	public void run() {
		if (Calendar.getInstance().get(Calendar.MINUTE) == 22 && !this.main.toxicRain.isHalfTimePassed()) {
			for (Player player : main.Players)
				player.sendTitle("§c§lThe rain will fall under 10 minutes§r", "§6Protect yourself if you don't want to die", 10, 80, 20);
			this.main.toxicRain.setHalfTimePassed(true);
		}
		if (Calendar.getInstance().get(Calendar.MINUTE) == 28 && !this.main.toxicRain.isAQuarterMissing()) {
			for (Player player : main.Players)
				player.sendTitle("§c§lThe rain will fall under 5 minutes§r", "§6Protect yourself if you don't want to die", 10, 80, 20);
			this.main.toxicRain.setAQuarterMissing(true);
		}
		if (Calendar.getInstance().get(Calendar.MINUTE) == 29 && !this.main.toxicRain.isFiveMinuteMissing()) {
			for (Player player : main.Players)
				player.sendTitle("§c§lThe rain will fall under 2 minutes§r", "§6Protect yourself if you don't want to die", 10, 80, 20);
			this.main.toxicRain.setFiveMinuteMissing(true);
			this.main.toxicRain.setTimeToRain(true);
		}
		if (Calendar.getInstance().get(Calendar.MINUTE) == 30 && this.main.toxicRain.isTimeToRain()) {
			this.main.toxicRain.startToxicRain();
		}
	}

}
