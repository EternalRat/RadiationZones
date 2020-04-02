package fr.eter.radiationzone.listener;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class ListenerDamage implements Listener {

	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		Entity ent = e.getEntity();
		Location loc = ent.getLocation();
		
		ent.getWorld().playEffect(loc, Effect.STEP_SOUND, Material.REDSTONE_BLOCK);
	}
	
}
