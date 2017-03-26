package me.lorexe.jepb.mods;

import com.google.common.collect.ImmutableList.Builder;

import me.lorexe.jepb.jei.banners.RecipeBanner;
import me.lorexe.jepb.jei.banners.shapes.RecipeShapesBanner;
import me.lorexe.jepb.jei.banners.symbols.RecipeSymbolsBanner;

public interface IModHandler {
	public void register(Builder<RecipeShapesBanner> builderShapes, Builder<RecipeSymbolsBanner> builderSymbols);
}