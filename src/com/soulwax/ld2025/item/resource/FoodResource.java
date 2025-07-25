// File: src/com/soulwax/ld2025/item/resource/FoodResource.java

package com.soulwax.ld2025.item.resource;

import com.soulwax.ld2025.entity.Player;
import com.soulwax.ld2025.level.Level;
import com.soulwax.ld2025.level.tile.Tile;

public class FoodResource extends Resource {
	private int heal;
	private int staminaCost;

	public FoodResource(String name, int sprite, int color, int heal, int staminaCost) {
		super(name, sprite, color);
		this.heal = heal;
		this.staminaCost = staminaCost;
	}

	public boolean interactOn(Tile tile, Level level, int xt, int yt, Player player, int attackDir) {
		if (player.health < player.maxHealth && player.payStamina(staminaCost)) {
			player.heal(heal);
			return true;
		}
		return false;
	}
}
