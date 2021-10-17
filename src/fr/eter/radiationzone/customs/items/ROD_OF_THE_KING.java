package fr.eter.radiationzone.customs.items;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;

import com.chrismin13.additionsapi.items.CustomItem;
import com.chrismin13.additionsapi.recipes.CustomShapedRecipe;
import com.comphenix.attribute.Attributes.AttributeType;
import com.comphenix.attribute.Attributes.Operation;

import net.md_5.bungee.api.ChatColor;

public class ROD_OF_THE_KING extends CustomItem {

	public ROD_OF_THE_KING() {
		super(Material.BLAZE_ROD, 1, (short) 0, "radiationzone:rod_of_the_king");
		
		setDisplayName(ChatColor.DARK_PURPLE + "Rod Of The King");
		
		List <String> lore = new ArrayList<>();
		lore.add("");
		lore.add(ChatColor.DARK_PURPLE + "This rod has been forged after killing\nthe famous demon Herobrine.");
		lore.add(ChatColor.DARK_PURPLE + "His power were such dreaded that they\nscealed this rod in the middle of a\nvolcano for a long time.");
		lore.add(ChatColor.DARK_PURPLE + "Now, his power are in your hand, be\ncareful, it can be really helpful, but\nit can also devore your spirit and your soul.");
		lore.add("");
		setLore(lore);
		
		addEnchantment(Enchantment.DAMAGE_ALL, 20);
		addEnchantment(Enchantment.KNOCKBACK, 15);
		addEnchantment(Enchantment.LOOT_BONUS_MOBS, 5);
		addEnchantment(Enchantment.FIRE_ASPECT, 2);
		
		addAttribute(AttributeType.GENERIC_ATTACK_DAMAGE, 20d, EquipmentSlot.HAND, Operation.ADD_NUMBER);
		addAttribute(AttributeType.GENERIC_ATTACK_SPEED, 10d, EquipmentSlot.HAND, Operation.ADD_NUMBER);
		
		List<CustomShapedRecipe> recipes = new ArrayList<CustomShapedRecipe>();
		
		CustomShapedRecipe itemRecipe = new CustomShapedRecipe();
		itemRecipe.setIngredient('1', Material.EMERALD);
		itemRecipe.setIngredient('2', Material.BLAZE_ROD);
		recipes.add(new CustomShapedRecipe(itemRecipe).setShape("111", "121", "111"));
		
		addAllCustomRecipes(recipes);
	}
	
}
