// File: src/com/soulwax/ld2025/entity/Chest.java

package com.soulwax.ld2025.entity;

import com.soulwax.ld2025.gfx.Color;
import com.soulwax.ld2025.screen.ContainerMenu;

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