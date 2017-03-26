package me.lorexe.jepb.jei.banners.shapes;

import me.lorexe.jepb.jei.banners.RecipeBanner;
import me.lorexe.jepb.utils.Constants;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

public class BannerShapesHandler implements IRecipeHandler<RecipeShapesBanner> {

	@Override
	public Class<RecipeShapesBanner> getRecipeClass() {
		return RecipeShapesBanner.class;
	}

	@Override
	public String getRecipeCategoryUid() {
		return Constants.bannerShapesCategoryUID;
	}

	@Override
	public String getRecipeCategoryUid(RecipeShapesBanner recipe) {
		return Constants.bannerShapesCategoryUID;
	}

	@Override
	public IRecipeWrapper getRecipeWrapper(RecipeShapesBanner recipe) {
		return new BannerShapesWrapper(recipe);
	}

	@Override
	public boolean isRecipeValid(RecipeShapesBanner recipe) {
		return true;
	}

}
