// File: src/de/soulwax/wstales/level/tile/CloudCactusTile.java

package de.soulwax.wstales.level.tile;

import de.soulwax.wstales.entity.AirWizard;
import de.soulwax.wstales.entity.Entity;
import de.soulwax.wstales.entity.ItemEntity;
import de.soulwax.wstales.entity.Mob;
import de.soulwax.wstales.entity.Player;
import de.soulwax.wstales.entity.particle.SmashParticle;
import de.soulwax.wstales.entity.particle.TextParticle;
import de.soulwax.wstales.gfx.Color;
import de.soulwax.wstales.gfx.Screen;
import de.soulwax.wstales.item.Item;
import de.soulwax.wstales.item.ResourceItem;
import de.soulwax.wstales.item.ToolItem;
import de.soulwax.wstales.item.ToolType;
import de.soulwax.wstales.level.Level;

public class CloudCactusTile extends Tile {
	public CloudCactusTile(int id) {
		super(id);
	}

	public void render(Screen screen, Level level, int x, int y) {
		int color = Color.get(444, 111, 333, 555);
		screen.render(x * 16 + 0, y * 16 + 0, 17 + 1 * 32, color, 0);
		screen.render(x * 16 + 8, y * 16 + 0, 18 + 1 * 32, color, 0);
		screen.render(x * 16 + 0, y * 16 + 8, 17 + 2 * 32, color, 0);
		screen.render(x * 16 + 8, y * 16 + 8, 18 + 2 * 32, color, 0);
	}

	public boolean mayPass(Level level, int x, int y, Entity e) {
		if (e instanceof AirWizard)
			return true;
		return false;
	}

	public void hurt(Level level, int x, int y, Mob source, int dmg, int attackDir) {
		hurt(level, x, y, 0);
	}

	public boolean interact(Level level, int xt, int yt, Player player, Item item, int attackDir) {
		if (item instanceof ToolItem) {
			ToolItem tool = (ToolItem) item;
			if (tool.type == ToolType.pickaxe) {
				if (player.payStamina(6 - tool.level)) {
					hurt(level, xt, yt, 1);
					return true;
				}
			}
		}
		return false;
	}

	public void hurt(Level level, int x, int y, int dmg) {
		int damage = level.getData(x, y) + 1;
		level.add(new SmashParticle(x * 16 + 8, y * 16 + 8));
		level.add(new TextParticle("" + dmg, x * 16 + 8, y * 16 + 8, Color.get(-1, 500, 500, 500)));
		if (dmg > 0) {
			if (damage >= 10) {
				level.setTile(x, y, Tile.cloud, 0);
			} else {
				level.setData(x, y, damage);
			}
		}
	}

	public void bumpedInto(Level level, int x, int y, Entity entity) {
		if (entity instanceof AirWizard)
			return;
		entity.hurt(this, x, y, 3);
	}
}