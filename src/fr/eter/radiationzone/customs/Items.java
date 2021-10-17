package fr.eter.radiationzone.customs;

import org.bukkit.event.Listener;

import com.chrismin13.additionsapi.events.AdditionsAPIInitializationEvent;

import org.bukkit.event.EventHandler;

import fr.eter.radiationzone.RadiationZone;
import fr.eter.radiationzone.customs.items.ROD_OF_THE_KING;
import fr.eter.radiationzone.customs.tools.bedrock.BEDROCK_AXE;
import fr.eter.radiationzone.customs.tools.bedrock.BEDROCK_BLOCKS;
import fr.eter.radiationzone.customs.tools.bedrock.BEDROCK_BOOTS;
import fr.eter.radiationzone.customs.tools.bedrock.BEDROCK_CHESTPLATE;
import fr.eter.radiationzone.customs.tools.bedrock.BEDROCK_HELMET;
import fr.eter.radiationzone.customs.tools.bedrock.BEDROCK_LEGGINGS;
import fr.eter.radiationzone.customs.tools.bedrock.BEDROCK_PICKAXE;
import fr.eter.radiationzone.customs.tools.bedrock.BEDROCK_SHOVEL;
import fr.eter.radiationzone.customs.tools.bedrock.BEDROCK_SWORD;

public class Items implements Listener {

	@EventHandler
	public void onIni(AdditionsAPIInitializationEvent e) {
		
		e.addResourcePackFromPlugin(RadiationZone.instance, "tex.zip");
		
		e.addCustomItem(new BEDROCK_SWORD());
		e.addCustomItem(new BEDROCK_SHOVEL());
		e.addCustomItem(new BEDROCK_PICKAXE());
		e.addCustomItem(new BEDROCK_AXE());
		e.addCustomItem(new BEDROCK_BOOTS());
		e.addCustomItem(new BEDROCK_HELMET());
		e.addCustomItem(new BEDROCK_CHESTPLATE());
		e.addCustomItem(new BEDROCK_LEGGINGS());
		e.addCustomItem(new BEDROCK_BLOCKS());
		e.addCustomItem(new ROD_OF_THE_KING());
	}
	
}
