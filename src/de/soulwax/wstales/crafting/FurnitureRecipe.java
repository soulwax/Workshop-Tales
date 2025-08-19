// File: src/de/soulwax/wstales/crafting/FurnitureRecipe.java

package de.soulwax.wstales.crafting;

import de.soulwax.wstales.entity.Furniture;
import de.soulwax.wstales.entity.Player;
import de.soulwax.wstales.item.FurnitureItem;

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