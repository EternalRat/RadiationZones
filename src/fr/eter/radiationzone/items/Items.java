package fr.eter.radiationzone.items;

import org.bukkit.event.Listener;

import com.chrismin13.additionsapi.events.AdditionsAPIInitializationEvent;

import fr.eter.radiationzone.items.bedrock.BEDROCK_AXE;
import fr.eter.radiationzone.items.bedrock.BEDROCK_BLOCKS;
//import fr.eter.radiationzone.items.bedrock.BEDROCK_BOOTS;
//import fr.eter.radiationzone.items.bedrock.BEDROCK_CHESTPLATE;
//import fr.eter.radiationzone.items.bedrock.BEDROCK_HELMET;
//import fr.eter.radiationzone.items.bedrock.BEDROCK_LEGGINGS;
import fr.eter.radiationzone.items.bedrock.BEDROCK_PICKAXE;
import fr.eter.radiationzone.items.bedrock.BEDROCK_SHOVEL;
import fr.eter.radiationzone.items.bedrock.BEDROCK_SWORD;
import fr.eter.radiationzone.items.customs.ROD_OF_THE_KING;

import org.bukkit.event.EventHandler;

import fr.eter.radiationzone.RadiationZone;

public class Items implements Listener {

	@EventHandler
	public void onIni(AdditionsAPIInitializationEvent e) {
		
		e.addResourcePackFromPlugin(RadiationZone.instance, "tex.zip");
		
		e.addCustomItem(new BEDROCK_SWORD());
		e.addCustomItem(new BEDROCK_SHOVEL());
		e.addCustomItem(new BEDROCK_PICKAXE());
		e.addCustomItem(new BEDROCK_AXE());
		e.addCustomItem(new BEDROCK_BLOCKS());
		e.addCustomItem(new ROD_OF_THE_KING());
		//e.addCustomItem(new BEDROCK_BOOTS());
		//e.addCustomItem(new BEDROCK_HELMET());
		//e.addCustomItem(new BEDROCK_CHESTPLATE());
		//e.addCustomItem(new BEDROCK_LEGGINGS());
	}
	
}
