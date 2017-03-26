package me.lorexe.jepb.mods;

import java.util.LinkedHashMap;

import com.google.common.collect.ImmutableList.Builder;

import blusunrize.immersiveengineering.api.ApiUtils;
import blusunrize.immersiveengineering.api.tool.BulletHandler;
import blusunrize.immersiveengineering.common.crafting.RecipeBannerAdvanced;
import blusunrize.immersiveengineering.common.crafting.RecipeBannerAdvanced.*;
import me.lorexe.jepb.jei.banners.RecipeBanner;
import me.lorexe.jepb.jei.banners.shapes.RecipeShapesBanner;
import me.lorexe.jepb.jei.banners.symbols.RecipeSymbolsBanner;
import me.lorexe.jepb.proxy.CommonProxy;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityBanner.EnumBannerPattern;
import net.minecraftforge.fml.common.registry.GameRegistry.ItemStackHolder;

public class IEHandler implements IModHandler {
	
	@ItemStackHolder(value="immersiveengineering:woodenDevice1", meta=1)
	public static final ItemStack windMill = null;
	@ItemStackHolder(value="immersiveengineering:woodenDevice1", meta=2)
	public static final ItemStack windMillAdv = null;
	
	public void register(Builder<RecipeShapesBanner> builderShapes, Builder<RecipeSymbolsBanner> builderSymbols) {
		builderSymbols.add(new RecipeSymbolsBanner("ie_wnd", windMill));
		builderSymbols.add(new RecipeSymbolsBanner("ie_wnd", windMillAdv));
		builderSymbols.add(new RecipeSymbolsBanner("ie_twd", ApiUtils.createIngredientStack("plankTreatedWood").getExampleStack()));
		builderSymbols.add(new RecipeSymbolsBanner("ie_bvl", ApiUtils.createIngredientStack("plateIron").getExampleStack()));
		builderSymbols.add(new RecipeSymbolsBanner("ie_orn", ApiUtils.createIngredientStack("dustSilver").getExampleStack()));
		
		if(!BulletHandler.homingCartridges.isEmpty()) {
			ItemStack wolfpackCartridge = BulletHandler.getBulletStack("wolfpack");
			builderSymbols.add(new RecipeSymbolsBanner("ie_wlfr", wolfpackCartridge));
			builderSymbols.add(new RecipeSymbolsBanner("ie_wlfl", wolfpackCartridge));
			builderSymbols.add(new RecipeSymbolsBanner("ie_wlf", wolfpackCartridge));
		}
	}
}
