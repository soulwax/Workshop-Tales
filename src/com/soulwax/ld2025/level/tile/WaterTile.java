// File: src/com/soulwax/ld2025/level/tile/WaterTile.java

package com.soulwax.ld2025.level.tile;

import java.util.Random;

import com.soulwax.ld2025.entity.Entity;
import com.soulwax.ld2025.gfx.Color;
import com.soulwax.ld2025.gfx.Screen;
import com.soulwax.ld2025.level.Level;

public class WaterTile extends Tile {
	public WaterTile(int id) {
		super(id);
		connectsToSand = true;
		connectsToWater = true;
	}

	private Random wRandom = new Random();

	public void render(Screen screen, Level level, int x, int y) {
		wRandom.setSeed((tickCount + (x / 2 - y) * 4311) / 10 * 54687121l + x * 3271612l + y * 3412987161l);
		int col = Color.get(005, 005, 115, 115);
		int transitionColor1 = Color.get(3, 005, level.dirtColor - 111, level.dirtColor);
		int transitionColor2 = Color.get(3, 005, level.sandColor - 110, level.sandColor);

		boolean u = !level.getTile(x, y - 1).connectsToWater;
		boolean d = !level.getTile(x, y + 1).connectsToWater;
		boolean l = !level.getTile(x - 1, y).connectsToWater;
		boolean r = !level.getTile(x + 1, y).connectsToWater;

		boolean su = u && level.getTile(x, y - 1).connectsToSand;
		boolean sd = d && level.getTile(x, y + 1).connectsToSand;
		boolean sl = l && level.getTile(x - 1, y).connectsToSand;
		boolean sr = r && level.getTile(x + 1, y).connectsToSand;

		if (!u && !l) {
			screen.render(x * 16 + 0, y * 16 + 0, wRandom.nextInt(4), col, wRandom.nextInt(4));
		} else
			screen.render(x * 16 + 0, y * 16 + 0, (l ? 14 : 15) + (u ? 0 : 1) * 32, (su || sl) ? transitionColor2 : transitionColor1, 0);

		if (!u && !r) {
			screen.render(x * 16 + 8, y * 16 + 0, wRandom.nextInt(4), col, wRandom.nextInt(4));
		} else
			screen.render(x * 16 + 8, y * 16 + 0, (r ? 16 : 15) + (u ? 0 : 1) * 32, (su || sr) ? transitionColor2 : transitionColor1, 0);

		if (!d && !l) {
			screen.render(x * 16 + 0, y * 16 + 8, wRandom.nextInt(4), col, wRandom.nextInt(4));
		} else
			screen.render(x * 16 + 0, y * 16 + 8, (l ? 14 : 15) + (d ? 2 : 1) * 32, (sd || sl) ? transitionColor2 : transitionColor1, 0);
		if (!d && !r) {
			screen.render(x * 16 + 8, y * 16 + 8, wRandom.nextInt(4), col, wRandom.nextInt(4));
		} else
			screen.render(x * 16 + 8, y * 16 + 8, (r ? 16 : 15) + (d ? 2 : 1) * 32, (sd || sr) ? transitionColor2 : transitionColor1, 0);
	}

	public boolean mayPass(Level level, int x, int y, Entity e) {
		return e.canSwim();
	}

	public void tick(Level level, int xt, int yt) {
		int xn = xt;
		int yn = yt;

		if (random.nextBoolean())
			xn += random.nextInt(2) * 2 - 1;
		else
			yn += random.nextInt(2) * 2 - 1;

		if (level.getTile(xn, yn) == Tile.hole) {
			level.setTile(xn, yn, this, 0);
		}
	}
}
