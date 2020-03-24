package fr.eter.radiationzone;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.eter.radiationzone.listener.GetTimeListener;
import fr.eter.radiationzone.listener.getEatenFood;
import fr.eter.radiationzone.listener.getMovePlayer;

public class RadiationZone extends JavaPlugin {
	
	public long time_world = 0;
	
	@Override
	public void onEnable() {
		GetTimeListener(this);
		Listener checkFood = new getEatenFood(this);
		PluginManager checkFoodman = getServer().getPluginManager();
		checkFoodman.registerEvents(checkFood, this);
		if (time_world == 17500)
			Bukkit.broadcastMessage("The rain will fall in 30 minutes. Go under something and protect yourself !");
		if (time_world == 18000) {
			Bukkit.getServer().getWorld("Survival").setThundering(true);
			Bukkit.getServer().getWorld("Survival").setThunderDuration(11000);
		}
		Listener checkMove = new getMovePlayer(this);
		PluginManager checkMove2 = getServer().getPluginManager();
		checkMove2.registerEvents(checkMove, this);
	}

	private void GetTimeListener(RadiationZone radiationZone) {
		World world = Bukkit.getServer().getWorld(getName());
		time_world = world.getTime();
		return;
	}
	
}
