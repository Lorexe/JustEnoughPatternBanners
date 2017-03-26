package me.lorexe.jepb.jei.banners.symbols;

import me.lorexe.jepb.utils.Constants;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class BannerSymbolsCategory extends BlankRecipeCategory {
	private final String localizedName;
	private final IDrawable background;
	
	public BannerSymbolsCategory(IGuiHelper helper) {
		localizedName = I18n.format(Constants.langBannerSymbolsCategory);

		background = helper.createDrawable(new ResourceLocation(Constants.MODID, "textures/gui/bannerSymbolsBackground.png"), 0, 0, 100, 100);
	}
	
	@Override
	public String getUid() {
		return Constants.bannerSymbolsCategoryUID;
	}

	@Override
	public String getTitle() {
		return this.localizedName;
	}

	@Override
	public IDrawable getBackground() {
		return this.background;
	}

	@Override
	public void setRecipe(IRecipeLayout layout, IRecipeWrapper wrapper, IIngredients ingr) {
		if(!(wrapper instanceof BannerSymbolsWrapper)) return;
		
		layout.getItemStacks().init(0, true, 4, 4);
		layout.getItemStacks().set(0, ingr.getInputs(ItemStack.class).get(0));
	}
	
}
