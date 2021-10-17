package fr.eter.radiationzone;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.eter.radiationzone.commands.homemanagement.CommandDelHome;
import fr.eter.radiationzone.commands.homemanagement.CommandHome;
import fr.eter.radiationzone.commands.homemanagement.CommandSetHome;
import fr.eter.radiationzone.commands.tp.CommandTPA;
import fr.eter.radiationzone.commands.tp.CommandTPN;
import fr.eter.radiationzone.commands.tp.CommandTPY;
import fr.eter.radiationzone.customs.Items;
import fr.eter.radiationzone.listener.ListenerDamage;
import fr.eter.radiationzone.listener.ListenerJoin;
import fr.eter.radiationzone.listener.ListenerLeave;
import fr.eter.radiationzone.listener.ListenerMove;
import fr.eter.radiationzone.listener.ListenerRevival;
import fr.eter.radiationzone.utils.rain.CheckTime;
import fr.eter.radiationzone.utils.rain.ToxicRain;

public class RadiationZone extends JavaPlugin {
	
	public static JavaPlugin instance;
	public final ToxicRain toxicRain = new ToxicRain(this);
	
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
		CheckTime check = new CheckTime(this);
		check.runTaskTimer(this, 0, 20);
	}

	private void ListenerList() {
		instance = this;
		Listener listenj = new ListenerJoin(this);
		Listener listenl = new ListenerLeave(this);
		Listener getDamage = new ListenerDamage();
		Listener checkMove = new ListenerMove(this);
		Listener revival = new ListenerRevival();
		PluginManager pm = getServer().getPluginManager();
		
		pm.registerEvents(listenj, this);
		pm.registerEvents(getDamage, this);
		pm.registerEvents(revival, this);
		pm.registerEvents(checkMove, this);
		pm.registerEvents(listenl, this);
		pm.registerEvents(new Items(), this);
	}
	
	public List<Player> getPlayers() {
		return Players;
	}
	
}
