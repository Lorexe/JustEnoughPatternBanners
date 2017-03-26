package me.lorexe.jepb.jei.banners.shapes;

import me.lorexe.jepb.jei.banners.RecipeBanner;

public class RecipeShapesBanner extends RecipeBanner {

	public RecipeShapesBanner(String id, String craftingTop, String craftingMid, String craftingBot) {
		super(id, craftingTop, craftingMid, craftingBot);
	}

	public RecipeShapesBanner(String id, String[] crafting) {
		super(id, crafting[0], crafting[1], crafting[2]);
	}
}
