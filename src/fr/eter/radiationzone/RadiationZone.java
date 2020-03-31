package fr.eter.radiationzone;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.eter.radiationzone.listener.getMovePlayer;
import fr.eter.radiationzone.homemanagement.CommandDelHome;
import fr.eter.radiationzone.homemanagement.CommandHome;
import fr.eter.radiationzone.homemanagement.CommandSetHome;
import fr.eter.radiationzone.listener.ListenerDamage;
import fr.eter.radiationzone.listener.ListenerJoin;
import fr.eter.radiationzone.listener.ListenerLeave;

public class RadiationZone extends JavaPlugin {
	
	public long time_world = 0;
	private List<Player> Players = new ArrayList<Player>();
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		GetTimeListener(this);
		Listener listenj = new ListenerJoin(this);
		PluginManager pmj = getServer().getPluginManager();
		pmj.registerEvents(listenj, this);
		Listener listenl = new ListenerLeave(this);
		PluginManager pml = getServer().getPluginManager();
		pml.registerEvents(listenl, this);
		Listener getDamage = new ListenerDamage();
		getServer().getPluginManager().registerEvents(getDamage, this);

		if (time_world == 36000)
			for (Player player : Players)
				player.sendTitle("The rain will fall in 30 minutes", "Protect yourself if you don't want to die", 10, 80, 20);
		if (time_world == 54000)
			for (Player player : Players)
				player.sendTitle("The rain will fall in 15 minutes", "Protect yourself if you don't want to die", 10, 80, 20);
		if (time_world == 66000)
			for (Player player : Players)
				player.sendTitle("The rain will fall in 5 minutes", "Protect yourself if you don't want to die", 10, 80, 20);
		if (time_world == 72000) {
			Bukkit.getServer().getWorld(getName()).setThundering(true);
			Bukkit.getServer().getWorld(getName()).setStorm(true);
			Bukkit.getServer().getWorld(getName()).setWeatherDuration(6000);
			for (Player player : Players)
				player.sendTitle("The rain started to fall", "Protect yourself if you don't want to die", 10, 80, 20);
			Bukkit.getServer().getWorld("Survival").setThunderDuration(6000);
		}

		Listener checkMove = new getMovePlayer(this);
		PluginManager checkMove2 = getServer().getPluginManager();
		checkMove2.registerEvents(checkMove, this);
		
		getCommand("home").setExecutor(new CommandHome(this));
		getCommand("sethome").setExecutor(new CommandSetHome(this));
		getCommand("delhome").setExecutor(new CommandDelHome(this));
		getCommand("tpa").setExecutor(new CommandTPA());
	}

	private void GetTimeListener(RadiationZone radiationZone) {
		World world = Bukkit.getServer().getWorld(getName());
		time_world = world.getTime();
		return;
	}
	
	public List<Player> getPlayers() {
		return Players;
	}
	
}
