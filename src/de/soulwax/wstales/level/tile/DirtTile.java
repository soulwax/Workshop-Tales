// File: src/de/soulwax/wstales/level/tile/DirtTile.java

package de.soulwax.wstales.level.tile;

import de.soulwax.wstales.entity.ItemEntity;
import de.soulwax.wstales.entity.Player;
import de.soulwax.wstales.gfx.Color;
import de.soulwax.wstales.gfx.Screen;
import de.soulwax.wstales.item.Item;
import de.soulwax.wstales.item.ResourceItem;
import de.soulwax.wstales.item.ToolItem;
import de.soulwax.wstales.item.ToolType;
import de.soulwax.wstales.item.resource.Resource;
import de.soulwax.wstales.level.Level;
import de.soulwax.wstales.sound.Sound;

public class DirtTile extends Tile {
	public DirtTile(int id) {
		super(id);
	}

	public void render(Screen screen, Level level, int x, int y) {
		int col = Color.get(level.dirtColor, level.dirtColor, level.dirtColor - 111, level.dirtColor - 111);
		screen.render(x * 16 + 0, y * 16 + 0, 0, col, 0);
		screen.render(x * 16 + 8, y * 16 + 0, 1, col, 0);
		screen.render(x * 16 + 0, y * 16 + 8, 2, col, 0);
		screen.render(x * 16 + 8, y * 16 + 8, 3, col, 0);
	}

	public boolean interact(Level level, int xt, int yt, Player player, Item item, int attackDir) {
		if (item instanceof ToolItem) {
			ToolItem tool = (ToolItem) item;
			if (tool.type == ToolType.shovel) {
				if (player.payStamina(4 - tool.level)) {
					level.setTile(xt, yt, Tile.hole, 0);
					level.add(new ItemEntity(new ResourceItem(Resource.dirt), xt * 16 + random.nextInt(10) + 3,
							yt * 16 + random.nextInt(10) + 3));
					Sound.monsterHurt.play();
					return true;
				}
			}
			if (tool.type == ToolType.hoe) {
				if (player.payStamina(4 - tool.level)) {
					level.setTile(xt, yt, Tile.farmland, 0);
					Sound.monsterHurt.play();
					return true;
				}
			}
		}
		return false;
	}
}