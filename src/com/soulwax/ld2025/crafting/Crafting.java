// File: src/com/soulwax/ld2025/crafting/Crafting.java

package com.soulwax.ld2025.crafting;

import java.util.ArrayList;
import java.util.List;

import com.soulwax.ld2025.entity.Anvil;
import com.soulwax.ld2025.entity.Chest;
import com.soulwax.ld2025.entity.Furnace;
import com.soulwax.ld2025.entity.Lantern;
import com.soulwax.ld2025.entity.Oven;
import com.soulwax.ld2025.entity.Workbench;
import com.soulwax.ld2025.item.ToolType;
import com.soulwax.ld2025.item.resource.Resource;

public class Crafting {
	public static final List<Recipe> anvilRecipes = new ArrayList<Recipe>();
	public static final List<Recipe> ovenRecipes = new ArrayList<Recipe>();
	public static final List<Recipe> furnaceRecipes = new ArrayList<Recipe>();
	public static final List<Recipe> workbenchRecipes = new ArrayList<Recipe>();

	static {
		try {
			workbenchRecipes.add(new FurnitureRecipe(Lantern.class).addCost(Resource.wood, 5).addCost(Resource.slime, 10).addCost(Resource.glass, 4));

			workbenchRecipes.add(new FurnitureRecipe(Oven.class).addCost(Resource.stone, 15));
			workbenchRecipes.add(new FurnitureRecipe(Furnace.class).addCost(Resource.stone, 20));
			workbenchRecipes.add(new FurnitureRecipe(Workbench.class).addCost(Resource.wood, 20));
			workbenchRecipes.add(new FurnitureRecipe(Chest.class).addCost(Resource.wood, 20));
			workbenchRecipes.add(new FurnitureRecipe(Anvil.class).addCost(Resource.ironIngot, 5));

			workbenchRecipes.add(new ToolRecipe(ToolType.sword, 0).addCost(Resource.wood, 5));
			workbenchRecipes.add(new ToolRecipe(ToolType.axe, 0).addCost(Resource.wood, 5));
			workbenchRecipes.add(new ToolRecipe(ToolType.hoe, 0).addCost(Resource.wood, 5));
			workbenchRecipes.add(new ToolRecipe(ToolType.pickaxe, 0).addCost(Resource.wood, 5));
			workbenchRecipes.add(new ToolRecipe(ToolType.shovel, 0).addCost(Resource.wood, 5));
			workbenchRecipes.add(new ToolRecipe(ToolType.sword, 1).addCost(Resource.wood, 5).addCost(Resource.stone, 5));
			workbenchRecipes.add(new ToolRecipe(ToolType.axe, 1).addCost(Resource.wood, 5).addCost(Resource.stone, 5));
			workbenchRecipes.add(new ToolRecipe(ToolType.hoe, 1).addCost(Resource.wood, 5).addCost(Resource.stone, 5));
			workbenchRecipes.add(new ToolRecipe(ToolType.pickaxe, 1).addCost(Resource.wood, 5).addCost(Resource.stone, 5));
			workbenchRecipes.add(new ToolRecipe(ToolType.shovel, 1).addCost(Resource.wood, 5).addCost(Resource.stone, 5));

			anvilRecipes.add(new ToolRecipe(ToolType.sword, 2).addCost(Resource.wood, 5).addCost(Resource.ironIngot, 5));
			anvilRecipes.add(new ToolRecipe(ToolType.axe, 2).addCost(Resource.wood, 5).addCost(Resource.ironIngot, 5));
			anvilRecipes.add(new ToolRecipe(ToolType.hoe, 2).addCost(Resource.wood, 5).addCost(Resource.ironIngot, 5));
			anvilRecipes.add(new ToolRecipe(ToolType.pickaxe, 2).addCost(Resource.wood, 5).addCost(Resource.ironIngot, 5));
			anvilRecipes.add(new ToolRecipe(ToolType.shovel, 2).addCost(Resource.wood, 5).addCost(Resource.ironIngot, 5));

			anvilRecipes.add(new ToolRecipe(ToolType.sword, 3).addCost(Resource.wood, 5).addCost(Resource.goldIngot, 5));
			anvilRecipes.add(new ToolRecipe(ToolType.axe, 3).addCost(Resource.wood, 5).addCost(Resource.goldIngot, 5));
			anvilRecipes.add(new ToolRecipe(ToolType.hoe, 3).addCost(Resource.wood, 5).addCost(Resource.goldIngot, 5));
			anvilRecipes.add(new ToolRecipe(ToolType.pickaxe, 3).addCost(Resource.wood, 5).addCost(Resource.goldIngot, 5));
			anvilRecipes.add(new ToolRecipe(ToolType.shovel, 3).addCost(Resource.wood, 5).addCost(Resource.goldIngot, 5));

			anvilRecipes.add(new ToolRecipe(ToolType.sword, 4).addCost(Resource.wood, 5).addCost(Resource.gem, 50));
			anvilRecipes.add(new ToolRecipe(ToolType.axe, 4).addCost(Resource.wood, 5).addCost(Resource.gem, 50));
			anvilRecipes.add(new ToolRecipe(ToolType.hoe, 4).addCost(Resource.wood, 5).addCost(Resource.gem, 50));
			anvilRecipes.add(new ToolRecipe(ToolType.pickaxe, 4).addCost(Resource.wood, 5).addCost(Resource.gem, 50));
			anvilRecipes.add(new ToolRecipe(ToolType.shovel, 4).addCost(Resource.wood, 5).addCost(Resource.gem, 50));

			furnaceRecipes.add(new ResourceRecipe(Resource.ironIngot).addCost(Resource.ironOre, 4).addCost(Resource.coal, 1));
			furnaceRecipes.add(new ResourceRecipe(Resource.goldIngot).addCost(Resource.goldOre, 4).addCost(Resource.coal, 1));
			furnaceRecipes.add(new ResourceRecipe(Resource.glass).addCost(Resource.sand, 4).addCost(Resource.coal, 1));

			ovenRecipes.add(new ResourceRecipe(Resource.bread).addCost(Resource.wheat, 4));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}