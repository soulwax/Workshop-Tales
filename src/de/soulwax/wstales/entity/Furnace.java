// File: src/de/soulwax/wstales/entity/Furnace.java

package de.soulwax.wstales.entity;

import de.soulwax.wstales.crafting.Crafting;
import de.soulwax.wstales.gfx.Color;
import de.soulwax.wstales.screen.CraftingMenu;

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