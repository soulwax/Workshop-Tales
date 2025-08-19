// File: src/de/soulwax/wstales/crafting/ResourceRecipe.java

package de.soulwax.wstales.crafting;

import de.soulwax.wstales.entity.Player;
import de.soulwax.wstales.gfx.Color;
import de.soulwax.wstales.gfx.Font;
import de.soulwax.wstales.gfx.Screen;
import de.soulwax.wstales.item.ResourceItem;
import de.soulwax.wstales.item.resource.Resource;

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