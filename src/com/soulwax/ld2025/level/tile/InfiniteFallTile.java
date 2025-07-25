// File: src/com/soulwax/ld2025/level/tile/InfiniteFallTile.java

package com.soulwax.ld2025.level.tile;

import com.soulwax.ld2025.entity.AirWizard;
import com.soulwax.ld2025.entity.Entity;
import com.soulwax.ld2025.gfx.Screen;
import com.soulwax.ld2025.level.Level;

public class InfiniteFallTile extends Tile {
	public InfiniteFallTile(int id) {
		super(id);
	}

	public void render(Screen screen, Level level, int x, int y) {
	}

	public void tick(Level level, int xt, int yt) {
	}

	public boolean mayPass(Level level, int x, int y, Entity e) {
		if (e instanceof AirWizard) return true;
		return false;
	}
}
