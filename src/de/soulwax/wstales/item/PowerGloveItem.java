// File: src/de/soulwax/wstales/item/PowerGloveItem.java

package de.soulwax.wstales.item;

import de.soulwax.wstales.entity.Entity;
import de.soulwax.wstales.entity.Furniture;
import de.soulwax.wstales.entity.Player;
import de.soulwax.wstales.gfx.Color;
import de.soulwax.wstales.gfx.Font;
import de.soulwax.wstales.gfx.Screen;

public class PowerGloveItem extends Item {
	public int getColor() {
		return Color.get(-1, 100, 320, 430);
	}

	public int getSprite() {
		return 7 + 4 * 32;
	}

	public void renderIcon(Screen screen, int x, int y) {
		screen.render(x, y, getSprite(), getColor(), 0);
	}

	public void renderInventory(Screen screen, int x, int y) {
		screen.render(x, y, getSprite(), getColor(), 0);
		Font.draw(getName(), screen, x + 8, y, Color.get(-1, 555, 555, 555));
	}

	public String getName() {
		return "Pow glove";
	}

	public boolean interact(Player player, Entity entity, int attackDir) {
		if (entity instanceof Furniture) {
			Furniture f = (Furniture) entity;
			f.take(player);
			return true;
		}
		return false;
	}
}