// File: src/de/soulwax/wstales/level/tile/InfiniteFallTile.java

package de.soulwax.wstales.level.tile;

import de.soulwax.wstales.entity.AirWizard;
import de.soulwax.wstales.entity.Entity;
import de.soulwax.wstales.gfx.Screen;
import de.soulwax.wstales.level.Level;

public class InfiniteFallTile extends Tile {
	public InfiniteFallTile(int id) {
		super(id);
	}

	public void render(Screen screen, Level level, int x, int y) {
	}

	public void tick(Level level, int xt, int yt) {
	}

	public boolean mayPass(Level level, int x, int y, Entity e) {
		if (e instanceof AirWizard)
			return true;
		return false;
	}
}