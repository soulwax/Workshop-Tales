// File: src/com/soulwax/ld2025/entity/Oven.java

package com.soulwax.ld2025.entity;

import com.soulwax.ld2025.crafting.Crafting;
import com.soulwax.ld2025.gfx.Color;
import com.soulwax.ld2025.screen.CraftingMenu;

public class Oven extends Furniture {
	public Oven() {
		super("Oven");
		col = Color.get(-1, 000, 332, 442);
		sprite = 2;
		xr = 3;
		yr = 2;
	}

	public boolean use(Player player, int attackDir) {
		player.game.setMenu(new CraftingMenu(Crafting.ovenRecipes, player));
		return true;
	}
}