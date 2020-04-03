package fr.eter.radiationzone;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public List<Player> Players = new ArrayList<>();
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
		
		ListenerList();
		Check_time_and_made_rain check = new Check_time_and_made_rain(this);
		check.runTaskTimer(this, 0, 20);
	}

	private void ListenerList() {
		Listener listenj = new ListenerJoin(this);
		PluginManager pmj = getServer().getPluginManager();
		pmj.registerEvents(listenj, this);
		Listener getDamage = new ListenerDamage();
		getServer().getPluginManager().registerEvents(getDamage, this);
		Listener checkMove = new getMovePlayer(this);
		PluginManager checkMove2 = getServer().getPluginManager();
		checkMove2.registerEvents(checkMove, this);
		Listener listenl = new ListenerLeave(this);
		PluginManager pml = getServer().getPluginManager();
		pml.registerEvents(listenl, this);
	}
	
	public List<Player> getPlayers() {
		return Players;
	}
	
}
