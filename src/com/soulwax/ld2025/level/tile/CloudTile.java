// File: src/com/soulwax/ld2025/level/tile/CloudTile.java

package com.soulwax.ld2025.level.tile;

import com.soulwax.ld2025.entity.Entity;
import com.soulwax.ld2025.entity.ItemEntity;
import com.soulwax.ld2025.entity.Player;
import com.soulwax.ld2025.gfx.Color;
import com.soulwax.ld2025.gfx.Screen;
import com.soulwax.ld2025.item.Item;
import com.soulwax.ld2025.item.ResourceItem;
import com.soulwax.ld2025.item.ToolItem;
import com.soulwax.ld2025.item.ToolType;
import com.soulwax.ld2025.item.resource.Resource;
import com.soulwax.ld2025.level.Level;

public class CloudTile extends Tile {
	public CloudTile(int id) {
		super(id);
	}

	public void render(Screen screen, Level level, int x, int y) {
		int col = Color.get(444, 444, 555, 555);
		int transitionColor = Color.get(333, 444, 555, -1);

		boolean u = level.getTile(x, y - 1) == Tile.infiniteFall;
		boolean d = level.getTile(x, y + 1) == Tile.infiniteFall;
		boolean l = level.getTile(x - 1, y) == Tile.infiniteFall;
		boolean r = level.getTile(x + 1, y) == Tile.infiniteFall;

		boolean ul = level.getTile(x - 1, y - 1) == Tile.infiniteFall;
		boolean dl = level.getTile(x - 1, y + 1) == Tile.infiniteFall;
		boolean ur = level.getTile(x + 1, y - 1) == Tile.infiniteFall;
		boolean dr = level.getTile(x + 1, y + 1) == Tile.infiniteFall;

		if (!u && !l) {
			if (!ul)
				screen.render(x * 16 + 0, y * 16 + 0, 17, col, 0);
			else
				screen.render(x * 16 + 0, y * 16 + 0, 7 + 0 * 32, transitionColor, 3);
		} else
			screen.render(x * 16 + 0, y * 16 + 0, (l ? 6 : 5) + (u ? 2 : 1) * 32, transitionColor, 3);

		if (!u && !r) {
			if (!ur)
				screen.render(x * 16 + 8, y * 16 + 0, 18, col, 0);
			else
				screen.render(x * 16 + 8, y * 16 + 0, 8 + 0 * 32, transitionColor, 3);
		} else
			screen.render(x * 16 + 8, y * 16 + 0, (r ? 4 : 5) + (u ? 2 : 1) * 32, transitionColor, 3);

		if (!d && !l) {
			if (!dl)
				screen.render(x * 16 + 0, y * 16 + 8, 20, col, 0);
			else
				screen.render(x * 16 + 0, y * 16 + 8, 7 + 1 * 32, transitionColor, 3);
		} else
			screen.render(x * 16 + 0, y * 16 + 8, (l ? 6 : 5) + (d ? 0 : 1) * 32, transitionColor, 3);
		if (!d && !r) {
			if (!dr)
				screen.render(x * 16 + 8, y * 16 + 8, 19, col, 0);
			else
				screen.render(x * 16 + 8, y * 16 + 8, 8 + 1 * 32, transitionColor, 3);
		} else
			screen.render(x * 16 + 8, y * 16 + 8, (r ? 4 : 5) + (d ? 0 : 1) * 32, transitionColor, 3);
	}

	public boolean mayPass(Level level, int x, int y, Entity e) {
		return true;
	}

	public boolean interact(Level level, int xt, int yt, Player player, Item item, int attackDir) {
		if (item instanceof ToolItem) {
			ToolItem tool = (ToolItem) item;
			if (tool.type == ToolType.shovel) {
				if (player.payStamina(5)) {
					// level.setTile(xt, yt, Tile.infiniteFall, 0);
					int count = random.nextInt(2) + 1;
					for (int i = 0; i < count; i++) {
						level.add(new ItemEntity(new ResourceItem(Resource.cloud), xt * 16 + random.nextInt(10) + 3, yt * 16 + random.nextInt(10) + 3));
					}
					return true;
				}
			}
		}
		return false;
	}

	/*
	 * public boolean interact(Level level, int xt, int yt, Player player, Item item, int attackDir) { if (item instanceof ToolItem) { ToolItem tool = (ToolItem) item; if (tool.type == ToolType.pickaxe) { if (player.payStamina(4 - tool.level)) { hurt(level, xt, yt, random.nextInt(10) + (tool.level) * 5 + 10); return true; } } } return false; }
	 */
}
