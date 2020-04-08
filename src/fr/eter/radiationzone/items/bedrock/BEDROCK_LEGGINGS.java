package fr.eter.radiationzone.items.bedrock;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;

import com.chrismin13.additionsapi.items.textured.CustomTexturedArmor;
import com.chrismin13.additionsapi.recipes.CustomShapedRecipe;

import net.md_5.bungee.api.ChatColor;
import us.fihgu.toolbox.item.DamageableItem;

public class BEDROCK_LEGGINGS extends CustomTexturedArmor {

	public BEDROCK_LEGGINGS() {
		super(DamageableItem.DIAMOND_LEGGINGS, "radiationzone:bedrock_leggings", "bedrock_leggings");

		setDisplayName(ChatColor.BLACK + "Bedrock Sword");
		
		List <String> lore = new ArrayList<>();
		lore.add("");
		lore.add(ChatColor.BLACK + "This leggings was forged by a demon with Bedrocks block.");
		lore.add("");
		setLore(lore);
	
		setUnbreakable(true);
		setUnbreakableVisibility(false);
		setFakeDurability(9999);

		addArmor(10d);
		addArmorToughness(5d);

		List<CustomShapedRecipe> recipes = new ArrayList<CustomShapedRecipe>();
		
		CustomShapedRecipe itemRecipe = new CustomShapedRecipe();
		itemRecipe.setIngredient('2', Material.AIR);
		itemRecipe.setIngredient('1', Material.BEDROCK);
		recipes.add(new CustomShapedRecipe(itemRecipe).setShape("111", "121", "121"));
		
		addAllCustomRecipes(recipes);
		
	}

	
	
}
