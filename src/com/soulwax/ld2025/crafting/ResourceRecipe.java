// File: src/com/soulwax/ld2025/crafting/ResourceRecipe.java

package com.soulwax.ld2025.crafting;

import com.soulwax.ld2025.entity.Player;
import com.soulwax.ld2025.gfx.Color;
import com.soulwax.ld2025.gfx.Font;
import com.soulwax.ld2025.gfx.Screen;
import com.soulwax.ld2025.item.ResourceItem;
import com.soulwax.ld2025.item.resource.Resource;

public class ResourceRecipe extends Recipe {
	private Resource resource;

	public ResourceRecipe(Resource resource) {
		super(new ResourceItem(resource, 1));
		this.resource = resource;
	}

	public void craft(Player player) {
		player.inventory.add(0, new ResourceItem(resource, 1));
	}
}
