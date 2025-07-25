// File: src/com/soulwax/ld2025/crafting/FurnitureRecipe.java

package com.soulwax.ld2025.crafting;

import com.soulwax.ld2025.entity.Furniture;
import com.soulwax.ld2025.entity.Player;
import com.soulwax.ld2025.item.FurnitureItem;

public class FurnitureRecipe extends Recipe {
	private Class<? extends Furniture> clazz;

	public FurnitureRecipe(Class<? extends Furniture> clazz) throws InstantiationException, IllegalAccessException {
		super(new FurnitureItem(clazz.newInstance()));
		this.clazz = clazz;
	}

	public void craft(Player player) {
		try {
			player.inventory.add(0, new FurnitureItem(clazz.newInstance()));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
