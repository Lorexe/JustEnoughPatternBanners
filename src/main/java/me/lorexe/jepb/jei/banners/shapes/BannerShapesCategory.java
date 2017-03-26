package me.lorexe.jepb.jei.banners.shapes;

import me.lorexe.jepb.utils.Constants;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class BannerShapesCategory extends BlankRecipeCategory {
	private final String localizedName;
	private final IDrawable background;
	
	public BannerShapesCategory(IGuiHelper helper) {
		localizedName = I18n.format(Constants.langBannerShapesCategory);

		background = helper.createDrawable(new ResourceLocation(Constants.MODID, "textures/gui/bannerShapesBackground.png"), 0, 0, 140, 100);
	}
	
	@Override
	public String getUid() {
		return Constants.bannerShapesCategoryUID;
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
		if(!(wrapper instanceof BannerShapesWrapper)) return;
		
		IGuiItemStackGroup guiItemStacks = layout.getItemStacks();
		
		for(int y = 0; y < 3; y++) {
			for(int x = 0; x < 3; ++x) {
				int index = x + (y * 3);
				guiItemStacks.init(index, true, 4 + x * 18, 4 + y * 18);
				guiItemStacks.set(index, ingr.getInputs(ItemStack.class).get(index));
			}
		}
		
		//layout.getItemStacks().init(0, true, 4, 4);
		//layout.getItemStacks().set(0, ingr.getInputs(ItemStack.class).get(0));
	}
	
}
