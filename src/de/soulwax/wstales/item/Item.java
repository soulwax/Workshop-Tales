// File: src/de/soulwax/wstales/item/Item.java

package de.soulwax.wstales.item;

import de.soulwax.wstales.entity.Entity;
import de.soulwax.wstales.entity.ItemEntity;
import de.soulwax.wstales.entity.Player;
import de.soulwax.wstales.gfx.Screen;
import de.soulwax.wstales.level.Level;
import de.soulwax.wstales.level.tile.Tile;
import de.soulwax.wstales.screen.ListItem;

public class Item implements ListItem {
	public int getColor() {
		return 0;
	}

	public int getSprite() {
		return 0;
	}

	public void onTake(ItemEntity itemEntity) {
	}

	public void renderInventory(Screen screen, int x, int y) {
	}

	public boolean interact(Player player, Entity entity, int attackDir) {
		return false;
	}

	public void renderIcon(Screen screen, int x, int y) {
	}

	public boolean interactOn(Tile tile, Level level, int xt, int yt, Player player, int attackDir) {
		return false;
	}

	public boolean isDepleted() {
		return false;
	}

	public boolean canAttack() {
		return false;
	}

	public int getAttackDamageBonus(Entity e) {
		return 0;
	}

	public String getName() {
		return "";
	}

	public boolean matches(Item item) {
		return item.getClass() == getClass();
	}
}