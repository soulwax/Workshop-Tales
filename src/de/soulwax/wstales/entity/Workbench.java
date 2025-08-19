// File: src/de/soulwax/wstales/entity/Workbench.java

package de.soulwax.wstales.entity;

import de.soulwax.wstales.crafting.Crafting;
import de.soulwax.wstales.gfx.Color;
import de.soulwax.wstales.screen.CraftingMenu;

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