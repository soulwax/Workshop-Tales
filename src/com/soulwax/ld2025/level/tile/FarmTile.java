// File: src/com/soulwax/ld2025/level/tile/FarmTile.java

package com.soulwax.ld2025.level.tile;

import com.soulwax.ld2025.entity.Entity;
import com.soulwax.ld2025.entity.Player;
import com.soulwax.ld2025.gfx.Color;
import com.soulwax.ld2025.gfx.Screen;
import com.soulwax.ld2025.item.Item;
import com.soulwax.ld2025.item.ToolItem;
import com.soulwax.ld2025.item.ToolType;
import com.soulwax.ld2025.level.Level;

public class FarmTile extends Tile {
	public FarmTile(int id) {
		super(id);
	}

	public void render(Screen screen, Level level, int x, int y) {
		int col = Color.get(level.dirtColor - 121, level.dirtColor - 11, level.dirtColor, level.dirtColor + 111);
		screen.render(x * 16 + 0, y * 16 + 0, 2 + 32, col, 1);
		screen.render(x * 16 + 8, y * 16 + 0, 2 + 32, col, 0);
		screen.render(x * 16 + 0, y * 16 + 8, 2 + 32, col, 0);
		screen.render(x * 16 + 8, y * 16 + 8, 2 + 32, col, 1);
	}

	public boolean interact(Level level, int xt, int yt, Player player, Item item, int attackDir) {
		if (item instanceof ToolItem) {
			ToolItem tool = (ToolItem) item;
			if (tool.type == ToolType.shovel) {
				if (player.payStamina(4 - tool.level)) {
					level.setTile(xt, yt, Tile.dirt, 0);
					return true;
				}
			}
		}
		return false;
	}

	public void tick(Level level, int xt, int yt) {
		int age = level.getData(xt, yt);
		if (age < 5) level.setData(xt, yt, age + 1);
	}

	public void steppedOn(Level level, int xt, int yt, Entity entity) {
		if (random.nextInt(60) != 0) return;
		if (level.getData(xt, yt) < 5) return;
		level.setTile(xt, yt, Tile.dirt, 0);
	}
}
