// File: src/de/soulwax/wstales/level/tile/CactusTile.java

package de.soulwax.wstales.level.tile;

import de.soulwax.wstales.entity.Entity;
import de.soulwax.wstales.entity.ItemEntity;
import de.soulwax.wstales.entity.Mob;
import de.soulwax.wstales.entity.particle.SmashParticle;
import de.soulwax.wstales.entity.particle.TextParticle;
import de.soulwax.wstales.gfx.Color;
import de.soulwax.wstales.gfx.Screen;
import de.soulwax.wstales.item.ResourceItem;
import de.soulwax.wstales.item.resource.Resource;
import de.soulwax.wstales.level.Level;

public class CactusTile extends Tile {
	public CactusTile(int id) {
		super(id);
		connectsToSand = true;
	}

	public void render(Screen screen, Level level, int x, int y) {
		int col = Color.get(20, 40, 50, level.sandColor);
		screen.render(x * 16 + 0, y * 16 + 0, 8 + 2 * 32, col, 0);
		screen.render(x * 16 + 8, y * 16 + 0, 9 + 2 * 32, col, 0);
		screen.render(x * 16 + 0, y * 16 + 8, 8 + 3 * 32, col, 0);
		screen.render(x * 16 + 8, y * 16 + 8, 9 + 3 * 32, col, 0);
	}

	public boolean mayPass(Level level, int x, int y, Entity e) {
		return false;
	}

	public void hurt(Level level, int x, int y, Mob source, int dmg, int attackDir) {
		int damage = level.getData(x, y) + dmg;
		level.add(new SmashParticle(x * 16 + 8, y * 16 + 8));
		level.add(new TextParticle("" + dmg, x * 16 + 8, y * 16 + 8, Color.get(-1, 500, 500, 500)));
		if (damage >= 10) {
			int count = random.nextInt(2) + 1;
			for (int i = 0; i < count; i++) {
				level.add(new ItemEntity(new ResourceItem(Resource.cactusFlower), x * 16 + random.nextInt(10) + 3,
						y * 16 + random.nextInt(10) + 3));
			}
			level.setTile(x, y, Tile.sand, 0);
		} else {
			level.setData(x, y, damage);
		}
	}

	public void bumpedInto(Level level, int x, int y, Entity entity) {
		entity.hurt(this, x, y, 1);
	}

	public void tick(Level level, int xt, int yt) {
		int damage = level.getData(xt, yt);
		if (damage > 0)
			level.setData(xt, yt, damage - 1);
	}
}