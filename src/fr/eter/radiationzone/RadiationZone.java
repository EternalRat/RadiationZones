package fr.eter.radiationzone;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.eter.radiationzone.basic.CommandInventory;
import fr.eter.radiationzone.basic.CommandSeePlayer;
import fr.eter.radiationzone.homemanagement.CommandDelHome;
import fr.eter.radiationzone.homemanagement.CommandHome;
import fr.eter.radiationzone.homemanagement.CommandSetHome;
import fr.eter.radiationzone.items.Items;
import fr.eter.radiationzone.listener.ListenerDamage;
import fr.eter.radiationzone.listener.ListenerJoin;
import fr.eter.radiationzone.listener.ListenerLeave;
import fr.eter.radiationzone.listener.getMovePlayer;
import fr.eter.radiationzone.rain.Check_time_and_made_rain;
import fr.eter.radiationzone.tp.CommandTPA;
import fr.eter.radiationzone.tp.CommandTPN;
import fr.eter.radiationzone.tp.CommandTPY;

public class RadiationZone extends JavaPlugin {
	
	public static JavaPlugin instance;
	
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
		getCommand("seeplayers").setExecutor(new CommandSeePlayer(this));
		getCommand("seeinventory").setExecutor(new CommandInventory());
		
		ListenerList();
		Check_time_and_made_rain check = new Check_time_and_made_rain(this);
		check.runTaskTimer(this, 0, 20);
	}

	private void ListenerList() {
		instance = this;
		Listener listenj = new ListenerJoin(this);
		Listener listenl = new ListenerLeave(this);
		Listener getDamage = new ListenerDamage();
		Listener checkMove = new getMovePlayer(this);
		PluginManager pm = getServer().getPluginManager();
		
		pm.registerEvents(listenj, this);
		pm.registerEvents(getDamage, this);
		pm.registerEvents(checkMove, this);
		pm.registerEvents(listenl, this);
		pm.registerEvents(new Items(), this);
	}
	
	public List<Player> getPlayers() {
		return Players;
	}
	
}
