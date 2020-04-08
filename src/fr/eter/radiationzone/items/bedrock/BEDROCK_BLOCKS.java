package fr.eter.radiationzone.items.bedrock;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;

import com.chrismin13.additionsapi.items.CustomTool;
import com.chrismin13.additionsapi.recipes.CustomShapedRecipe;

import net.md_5.bungee.api.ChatColor;

public class BEDROCK_BLOCKS extends CustomTool {

	public BEDROCK_BLOCKS() {
		super(Material.BEDROCK, 1, (short)0, "radiationzone:new_bedrock");
		setDisplayName(ChatColor.BLACK + "Bedrock");
		setMaterial(Material.BEDROCK);
		
		setUnbreakable(true);
		
		List<CustomShapedRecipe> recipes = new ArrayList<CustomShapedRecipe>();
		
		CustomShapedRecipe itemRecipe = new CustomShapedRecipe();
		itemRecipe.setIngredient('1', Material.OBSIDIAN);
		itemRecipe.setIngredient('2', Material.FLINT);
		recipes.add(new CustomShapedRecipe(itemRecipe).setShape("121", "212", "121"));
		
		addAllCustomRecipes(recipes);
	}

}
