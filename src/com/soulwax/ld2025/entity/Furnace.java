// File: src/com/soulwax/ld2025/entity/Furnace.java

package com.soulwax.ld2025.entity;

import com.soulwax.ld2025.crafting.Crafting;
import com.soulwax.ld2025.gfx.Color;
import com.soulwax.ld2025.screen.CraftingMenu;

public class Furnace extends Furniture {
	public Furnace() {
		super("Furnace");
		col = Color.get(-1, 000, 222, 333);
		sprite = 3;
		xr = 3;
		yr = 2;
	}

	public boolean use(Player player, int attackDir) {
		player.game.setMenu(new CraftingMenu(Crafting.furnaceRecipes, player));
		return true;
	}
}