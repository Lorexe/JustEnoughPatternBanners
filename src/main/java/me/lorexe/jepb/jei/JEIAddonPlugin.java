package me.lorexe.jepb.jei;

import me.lorexe.jepb.JEPatternBanners;
import me.lorexe.jepb.jei.banners.shapes.BannerShapesCategory;
import me.lorexe.jepb.jei.banners.shapes.BannerShapesWrapper;
import me.lorexe.jepb.jei.banners.shapes.RecipeShapesBanner;
import me.lorexe.jepb.jei.banners.symbols.BannerSymbolsCategory;
import me.lorexe.jepb.jei.banners.symbols.BannerSymbolsWrapper;
import me.lorexe.jepb.jei.banners.symbols.RecipeSymbolsBanner;
import me.lorexe.jepb.utils.BannerUtil;
import me.lorexe.jepb.utils.Constants;
import mezz.jei.api.BlankModPlugin;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.IRecipeWrapperFactory;

@JEIPlugin
public class JEIAddonPlugin extends BlankModPlugin {
	@Override
	public void register(IModRegistry registry) {
		IJeiHelpers jeiHelpers = registry.getJeiHelpers();
		
		registry.addRecipeCatalyst(BannerUtil.makeBanner("lud", 15, 0), Constants.bannerShapesCategoryUID);
		registry.addRecipeCatalyst(BannerUtil.makeBanner("cre", 15, 0), Constants.bannerSymbolsCategoryUID);
		
		for(int i=15; i>=0; i--) {
			registry.addRecipeCatalyst(BannerUtil.makeBlank(i), Constants.bannerShapesCategoryUID);
			registry.addRecipeCatalyst(BannerUtil.makeBlank(i), Constants.bannerSymbolsCategoryUID);
		}
		
		registry.handleRecipes(RecipeShapesBanner.class, new IRecipeWrapperFactory<RecipeShapesBanner>() {
			@Override
			public IRecipeWrapper getRecipeWrapper(RecipeShapesBanner recipe) {
				return new BannerShapesWrapper(recipe);
			}
		}, Constants.bannerShapesCategoryUID);
		
		registry.handleRecipes(RecipeSymbolsBanner.class, new IRecipeWrapperFactory<RecipeSymbolsBanner>() {
			@Override
			public IRecipeWrapper getRecipeWrapper(RecipeSymbolsBanner recipe) {
				return new BannerSymbolsWrapper(recipe);
			}
		}, Constants.bannerSymbolsCategoryUID);
		
		registry.addRecipes(JEPatternBanners.proxy.shapesBannerRecipe, Constants.bannerShapesCategoryUID);
		registry.addRecipes(JEPatternBanners.proxy.symbolsBannerRecipe, Constants.bannerSymbolsCategoryUID);
	}
	
	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
		final IJeiHelpers jeiHelpers = registry.getJeiHelpers();
		final IGuiHelper guiHelper = jeiHelpers.getGuiHelper();
		registry.addRecipeCategories(
				new BannerShapesCategory(guiHelper),
				new BannerSymbolsCategory(guiHelper)
		);
	}
}
