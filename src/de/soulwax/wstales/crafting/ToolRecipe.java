// File: src/de/soulwax/wstales/crafting/ToolRecipe.java

package de.soulwax.wstales.crafting;

import de.soulwax.wstales.entity.Player;
import de.soulwax.wstales.item.ToolItem;
import de.soulwax.wstales.item.ToolType;

public class ToolRecipe extends Recipe {
	private ToolType type;
	private int level;

	public ToolRecipe(ToolType type, int level) {
		super(new ToolItem(type, level));
		this.type = type;
		this.level = level;
	}

	public void craft(Player player) {
		player.inventory.add(0, new ToolItem(type, level));
	}
}