// File: src/com/soulwax/ld2025/crafting/ToolRecipe.java

package com.soulwax.ld2025.crafting;

import com.soulwax.ld2025.entity.Player;
import com.soulwax.ld2025.item.ToolItem;
import com.soulwax.ld2025.item.ToolType;

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
