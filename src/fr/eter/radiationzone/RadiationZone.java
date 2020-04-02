package fr.eter.radiationzone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.eter.radiationzone.homemanagement.CommandDelHome;
import fr.eter.radiationzone.homemanagement.CommandHome;
import fr.eter.radiationzone.homemanagement.CommandSetHome;
import fr.eter.radiationzone.listener.ListenerDamage;
import fr.eter.radiationzone.listener.ListenerJoin;
import fr.eter.radiationzone.listener.ListenerLeave;
import fr.eter.radiationzone.listener.getMovePlayer;
import fr.eter.radiationzone.tp.CommandTPA;
import fr.eter.radiationzone.tp.CommandTPN;
import fr.eter.radiationzone.tp.CommandTPY;

public class RadiationZone extends JavaPlugin {
	
	public long time_world = 0;
	private List<Player> Players = new ArrayList<Player>();
	public Map<Player, Player> TPPlayers = new HashMap<>();
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		
		getCommand("tpa").setExecutor(new CommandTPA(this));
		getCommand("tpaccept").setExecutor(new CommandTPY(this));
		getCommand("tpdecline").setExecutor(new CommandTPN(this));
		getCommand("home").setExecutor(new CommandHome(this));
		getCommand("sethome").setExecutor(new CommandSetHome(this));
		getCommand("delhome").setExecutor(new CommandDelHome(this));
		
		GetTimeListener();
		Bukkit.getPlayer("Rz_RazZer").sendMessage("Tick : " + time_world);
		ListenerList();
		Check_time_and_made_rain();
	}

	private void Check_time_and_made_rain() {
		if (time_world >= 30000) {
			String toSend = "The rain will fall under 30 minutes";
			for (Player player : Players)
				player.sendTitle(toSend, "Protect yourself if you don't want to die", 10, 80, 20);
		}
		if (time_world >= 54000)
			for (Player player : Players)
				player.sendTitle("The rain will fall under 15 minutes", "Protect yourself if you don't want to die", 10, 80, 20);
		if (time_world >= 66000)
			for (Player player : Players)
				player.sendTitle("The rain will fall under 5 minutes", "Protect yourself if you don't want to die", 10, 80, 20);
		if (time_world >= 72000) {
			Bukkit.getServer().getWorld("world").setThundering(true);
			Bukkit.getServer().getWorld("world").setStorm(true);
			Bukkit.getServer().getWorld("world").setWeatherDuration(6000);
			for (Player player : Players)
				player.sendTitle("The rain started to fall", "Protect yourself if you don't want to die", 10, 80, 20);
			Bukkit.getServer().getWorld("world").setThunderDuration(6000);
		}
	}

	private void ListenerList() {
		Listener listenj = new ListenerJoin(this);
		PluginManager pmj = getServer().getPluginManager();
		pmj.registerEvents(listenj, this);
		Listener listenl = new ListenerLeave(this);
		PluginManager pml = getServer().getPluginManager();
		pml.registerEvents(listenl, this);
		Listener getDamage = new ListenerDamage();
		getServer().getPluginManager().registerEvents(getDamage, this);
		Listener checkMove = new getMovePlayer(this);
		PluginManager checkMove2 = getServer().getPluginManager();
		checkMove2.registerEvents(checkMove, this);
	}

	private void GetTimeListener() {
		World world = Bukkit.getServer().getWorld("world");
		if (time_world >= 72000)
			time_world = 0;
		time_world = world.getFullTime();
		return;
	}
	
	public List<Player> getPlayers() {
		return Players;
	}
	
}
