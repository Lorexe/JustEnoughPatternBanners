package me.lorexe.jepb.jei.banners.symbols;

import me.lorexe.jepb.jei.banners.RecipeBanner;
import me.lorexe.jepb.utils.Constants;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

public class BannerSymbolsHandler implements IRecipeHandler<RecipeSymbolsBanner> {

	@Override
	public Class<RecipeSymbolsBanner> getRecipeClass() {
		return RecipeSymbolsBanner.class;
	}

	@Override
	public String getRecipeCategoryUid() {
		return Constants.bannerSymbolsCategoryUID;
	}

	@Override
	public String getRecipeCategoryUid(RecipeSymbolsBanner recipe) {
		return Constants.bannerSymbolsCategoryUID;
	}

	@Override
	public IRecipeWrapper getRecipeWrapper(RecipeSymbolsBanner recipe) {
		return new BannerSymbolsWrapper(recipe);
	}

	@Override
	public boolean isRecipeValid(RecipeSymbolsBanner recipe) {
		return true;
	}

}
