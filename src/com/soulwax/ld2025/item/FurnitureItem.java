// File: src/com/soulwax/ld2025/item/FurnitureItem.java

package com.soulwax.ld2025.item;

import com.soulwax.ld2025.entity.Furniture;
import com.soulwax.ld2025.entity.ItemEntity;
import com.soulwax.ld2025.entity.Player;
import com.soulwax.ld2025.gfx.Color;
import com.soulwax.ld2025.gfx.Font;
import com.soulwax.ld2025.gfx.Screen;
import com.soulwax.ld2025.level.Level;
import com.soulwax.ld2025.level.tile.Tile;

public class FurnitureItem extends Item {
	public Furniture furniture;
	public boolean placed = false;

	public FurnitureItem(Furniture furniture) {
		this.furniture = furniture;
	}

	public int getColor() {
		return furniture.col;
	}

	public int getSprite() {
		return furniture.sprite + 10 * 32;
	}

	public void renderIcon(Screen screen, int x, int y) {
		screen.render(x, y, getSprite(), getColor(), 0);
	}

	public void renderInventory(Screen screen, int x, int y) {
		screen.render(x, y, getSprite(), getColor(), 0);
		Font.draw(furniture.name, screen, x + 8, y, Color.get(-1, 555, 555, 555));
	}

	public void onTake(ItemEntity itemEntity) {
	}

	public boolean canAttack() {
		return false;
	}

	public boolean interactOn(Tile tile, Level level, int xt, int yt, Player player, int attackDir) {
		if (tile.mayPass(level, xt, yt, furniture)) {
			furniture.x = xt * 16 + 8;
			furniture.y = yt * 16 + 8;
			level.add(furniture);
			placed = true;
			return true;
		}
		return false;
	}

	public boolean isDepleted() {
		return placed;
	}
	
	public String getName() {
		return furniture.name;
	}
}