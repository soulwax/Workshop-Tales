// File: src/de/soulwax/wstales/entity/Chest.java

package de.soulwax.wstales.entity;

import de.soulwax.wstales.gfx.Color;
import de.soulwax.wstales.screen.ContainerMenu;

public class Chest extends Furniture {
	public Inventory inventory = new Inventory();

	public Chest() {
		super("Chest");
		col = Color.get(-1, 110, 331, 552);
		sprite = 1;
	}

	public boolean use(Player player, int attackDir) {
		player.game.setMenu(new ContainerMenu(player, "Chest", inventory));
		return true;
	}
}