package fr.eter.radiationzone.utils.rain;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.eter.radiationzone.RadiationZone;

public class ToxicRain {

	private RadiationZone main;
	private boolean isHalfTimePassed = false;
	private boolean isAQuarterMissing = false;
	private boolean isFiveMinuteMissing = false;
	private boolean isTimeToRain = false;
	
	public ToxicRain(RadiationZone radiationZone) {
		this.main = radiationZone;
	}

	public boolean isHalfTimePassed() {
		return isHalfTimePassed;
	}

	public void setHalfTimePassed(boolean isHalfTimePassed) {
		this.isHalfTimePassed = isHalfTimePassed;
	}

	public boolean isAQuarterMissing() {
		return isAQuarterMissing;
	}

	public void setAQuarterMissing(boolean isAQuarterMissing) {
		this.isAQuarterMissing = isAQuarterMissing;
	}

	public boolean isFiveMinuteMissing() {
		return isFiveMinuteMissing;
	}

	public void setFiveMinuteMissing(boolean isFiveMinuteMissing) {
		this.isFiveMinuteMissing = isFiveMinuteMissing;
	}

	public boolean isTimeToRain() {
		return isTimeToRain;
	}

	public void setTimeToRain(boolean isTimeToRain) {
		this.isTimeToRain = isTimeToRain;
	}
	
	public void startToxicRain() {
		this.resetValues();
		Bukkit.getServer().getWorld("world").setThundering(true);
		Bukkit.getServer().getWorld("world").setStorm(true);
		Bukkit.getServer().getWorld("world").setWeatherDuration(600000);
		Bukkit.getServer().getWorld("world").setThunderDuration(600000);
		this.sendMessageToAll();
	}
	
	private void resetValues() {
		this.isAQuarterMissing = false;
		this.isFiveMinuteMissing = false;
		this.isHalfTimePassed = false;
		this.isTimeToRain = false;
	}
	
	private void sendMessageToAll() {
		for (Player player : this.main.Players)
			player.sendTitle("§c§lThe rain started to fall§r", "§6Protect yourself if you don't want to die", 10, 80, 20);
	}

}
