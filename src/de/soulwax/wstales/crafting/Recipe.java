// File: src/de/soulwax/wstales/crafting/Recipe.java

package de.soulwax.wstales.crafting;

import java.util.ArrayList;
import java.util.List;

import de.soulwax.wstales.entity.Player;
import de.soulwax.wstales.gfx.Color;
import de.soulwax.wstales.gfx.Font;
import de.soulwax.wstales.gfx.Screen;
import de.soulwax.wstales.item.Item;
import de.soulwax.wstales.item.ResourceItem;
import de.soulwax.wstales.item.resource.Resource;
import de.soulwax.wstales.screen.ListItem;

public abstract class Recipe implements ListItem {
	public List<Item> costs = new ArrayList<Item>();
	public boolean canCraft = false;
	public Item resultTemplate;

	public Recipe(Item resultTemplate) {
		this.resultTemplate = resultTemplate;
	}

	public Recipe addCost(Resource resource, int count) {
		costs.add(new ResourceItem(resource, count));
		return this;
	}

	public void checkCanCraft(Player player) {
		for (int i = 0; i < costs.size(); i++) {
			Item item = costs.get(i);
			if (item instanceof ResourceItem) {
				ResourceItem ri = (ResourceItem) item;
				if (!player.inventory.hasResources(ri.resource, ri.count)) {
					canCraft = false;
					return;
				}
			}
		}
		canCraft = true;
	}

	public void renderInventory(Screen screen, int x, int y) {
		screen.render(x, y, resultTemplate.getSprite(), resultTemplate.getColor(), 0);
		int textColor = canCraft ? Color.get(-1, 555, 555, 555) : Color.get(-1, 222, 222, 222);
		Font.draw(resultTemplate.getName(), screen, x + 8, y, textColor);
	}

	public abstract void craft(Player player);

	public void deductCost(Player player) {
		for (int i = 0; i < costs.size(); i++) {
			Item item = costs.get(i);
			if (item instanceof ResourceItem) {
				ResourceItem ri = (ResourceItem) item;
				player.inventory.removeResource(ri.resource, ri.count);
			}
		}
	}
}