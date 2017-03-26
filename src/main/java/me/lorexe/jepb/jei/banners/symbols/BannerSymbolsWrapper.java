package me.lorexe.jepb.jei.banners.symbols;

import org.lwjgl.opengl.GL11;

import me.lorexe.jepb.jei.banners.RecipeBanner;
import me.lorexe.jepb.utils.BannerUtil;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeWrapper;
import net.minecraft.block.BlockBanner;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBanner;
import net.minecraft.client.renderer.BannerTextures;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityBanner;
import net.minecraft.util.ResourceLocation;

public class BannerSymbolsWrapper extends BlankRecipeWrapper {
	
	private final ItemStack input;
	private final String patternID;
	private final ModelBanner bannerModel = new ModelBanner();
	
	public BannerSymbolsWrapper(RecipeBanner recipe) {
		this.input = recipe.getCraftingStack();
		this.patternID = recipe.getPatternID();
		
		this.bannerModel.bannerStand.showModel = true;
	}

	@Override
	public void getIngredients(IIngredients ingredients) {
		ingredients.setInput(ItemStack.class, input);
	}
	
	@Override
	public void drawInfo(Minecraft mc, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
		TileEntityBanner teBanner = (TileEntityBanner) ((BlockBanner)Blocks.STANDING_BANNER).createTileEntity(null, Blocks.STANDING_BANNER.getDefaultState());
		teBanner.setItemValues(BannerUtil.makeBanner(patternID));
		ResourceLocation bannerTexture = BannerTextures.BANNER_DESIGNS.getResourceLocation(teBanner.getPatternResourceLocation(), teBanner.getPatternList(), teBanner.getColorList());
		if(bannerTexture != null) {
			mc.renderEngine.bindTexture(bannerTexture);
			drawTexturedModalRect(50, 0, 0, 2, 2, 39, 78, 0.008f, 0.008f);
		}
	}
	
	public void drawTexturedModalRect(int x, int y, float z, int u, int v, int w, int h, float f, float f1) {
		Tessellator tessellator = Tessellator.getInstance();
		tessellator.getBuffer().begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
		tessellator.getBuffer().pos(x, y + h, z).tex(u * f, (v + h) * f1).endVertex();
		tessellator.getBuffer().pos(x + w, y + h, z).tex((u + w) * f, (v + h) * f1).endVertex();
		tessellator.getBuffer().pos(x + w, y, z).tex((u + w) * f, v * f1).endVertex();
		tessellator.getBuffer().pos(x, y, z).tex(u * f, v * f1).endVertex();
		tessellator.draw();
}
}
