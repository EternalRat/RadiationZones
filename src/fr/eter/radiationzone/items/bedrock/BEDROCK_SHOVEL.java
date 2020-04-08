package fr.eter.radiationzone.items.bedrock;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;

import com.chrismin13.additionsapi.items.textured.CustomTexturedTool;
import com.chrismin13.additionsapi.recipes.CustomShapedRecipe;

import net.md_5.bungee.api.ChatColor;
import us.fihgu.toolbox.item.DamageableItem;

public class BEDROCK_SHOVEL extends CustomTexturedTool {

	public BEDROCK_SHOVEL() {
		super(DamageableItem.DIAMOND_SHOVEL, "radiationzone:bedrock_shovel", "bedrock_shovel");

		setDisplayName(ChatColor.BLACK + "Bedrock Sword");
		
		List <String> lore = new ArrayList<>();
		lore.add("");
		lore.add(ChatColor.BLACK + "This showel was forged by a demon with Bedrocks block.");
		lore.add("");
		setLore(lore);
	
		setUnbreakable(true);
		setUnbreakableVisibility(false);
		setToolLikeAttributes(true);
		setFakeDurability(9999);

		addAttackDamage(7d);
		addAttackSpeed(2d);

		List<CustomShapedRecipe> recipes = new ArrayList<CustomShapedRecipe>();
		
		CustomShapedRecipe itemRecipe = new CustomShapedRecipe();
		itemRecipe.setIngredient('3', Material.AIR);
		itemRecipe.setIngredient('1', Material.BEDROCK);
		itemRecipe.setIngredient('2', Material.STICK);
		recipes.add(new CustomShapedRecipe(itemRecipe).setShape("313", "323", "323"));
		
		addAllCustomRecipes(recipes);
		
	}

	
	
}
