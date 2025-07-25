// File: src/com/soulwax/ld2025/entity/Anvil.java

package com.soulwax.ld2025.entity;

import com.soulwax.ld2025.crafting.Crafting;
import com.soulwax.ld2025.gfx.Color;
import com.soulwax.ld2025.screen.CraftingMenu;

public class Anvil extends Furniture {
	public Anvil() {
		super("Anvil");
		col = Color.get(-1, 000, 111, 222);
		sprite = 0;
		xr = 3;
		yr = 2;
	}

	public boolean use(Player player, int attackDir) {
		player.game.setMenu(new CraftingMenu(Crafting.anvilRecipes, player));
		return true;
	}
}