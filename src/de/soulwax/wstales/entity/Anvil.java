// File: src/de/soulwax/wstales/entity/Anvil.java

package de.soulwax.wstales.entity;

import de.soulwax.wstales.crafting.Crafting;
import de.soulwax.wstales.gfx.Color;
import de.soulwax.wstales.screen.CraftingMenu;

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