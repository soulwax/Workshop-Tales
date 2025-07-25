// File: src/com/soulwax/ld2025/entity/Workbench.java

package com.soulwax.ld2025.entity;

import com.soulwax.ld2025.crafting.Crafting;
import com.soulwax.ld2025.gfx.Color;
import com.soulwax.ld2025.screen.CraftingMenu;

public class Workbench extends Furniture {
	public Workbench() {
		super("Workbench");
		col = Color.get(-1, 100, 321, 431);
		sprite = 4;
		xr = 3;
		yr = 2;
	}

	public boolean use(Player player, int attackDir) {
		player.game.setMenu(new CraftingMenu(Crafting.workbenchRecipes, player));
		return true;
	}
}