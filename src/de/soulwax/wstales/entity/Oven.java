// File: src/de/soulwax/wstales/entity/Oven.java

package de.soulwax.wstales.entity;

import de.soulwax.wstales.crafting.Crafting;
import de.soulwax.wstales.gfx.Color;
import de.soulwax.wstales.screen.CraftingMenu;

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