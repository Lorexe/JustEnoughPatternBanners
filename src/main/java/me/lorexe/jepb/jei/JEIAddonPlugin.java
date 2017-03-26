package me.lorexe.jepb.jei;

import me.lorexe.jepb.JEPatternBanners;
import me.lorexe.jepb.jei.banners.shapes.BannerShapesCategory;
import me.lorexe.jepb.jei.banners.shapes.BannerShapesHandler;
import me.lorexe.jepb.jei.banners.symbols.BannerSymbolsCategory;
import me.lorexe.jepb.jei.banners.symbols.BannerSymbolsHandler;
import me.lorexe.jepb.utils.BannerUtil;
import me.lorexe.jepb.utils.Constants;
import mezz.jei.api.BlankModPlugin;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;

@JEIPlugin
public class JEIAddonPlugin extends BlankModPlugin {
	@Override
	public void register(IModRegistry registry) {
		IJeiHelpers jeiHelpers = registry.getJeiHelpers();
		
		registry.addRecipeCategoryCraftingItem(BannerUtil.makeBanner("lud", 15, 0), Constants.bannerShapesCategoryUID);
		registry.addRecipeCategoryCraftingItem(BannerUtil.makeBanner("cre", 15, 0), Constants.bannerSymbolsCategoryUID);
		
		for(int i=15; i>=0; i--) {
			registry.addRecipeCategoryCraftingItem(BannerUtil.makeBlank(i), Constants.bannerShapesCategoryUID);
			registry.addRecipeCategoryCraftingItem(BannerUtil.makeBlank(i), Constants.bannerSymbolsCategoryUID);
		}
		
		registry.addRecipeCategories(
				new BannerShapesCategory(jeiHelpers.getGuiHelper()),
				new BannerSymbolsCategory(jeiHelpers.getGuiHelper())
			);
		
		registry.addRecipeHandlers(
				new BannerShapesHandler(),
				new BannerSymbolsHandler()
			);
		
		registry.addRecipes(JEPatternBanners.proxy.shapesBannerRecipe);
		registry.addRecipes(JEPatternBanners.proxy.symbolsBannerRecipe);
	}
}
