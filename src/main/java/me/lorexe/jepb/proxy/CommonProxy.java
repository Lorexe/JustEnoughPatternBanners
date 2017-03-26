package me.lorexe.jepb.proxy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.ImmutableList;

import me.lorexe.jepb.jei.banners.RecipeBanner;
import me.lorexe.jepb.jei.banners.shapes.RecipeShapesBanner;
import me.lorexe.jepb.jei.banners.symbols.RecipeSymbolsBanner;
import me.lorexe.jepb.mods.IEHandler;
import me.lorexe.jepb.mods.IModHandler;
import me.lorexe.jepb.utils.Constants;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityBanner.EnumBannerPattern;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ItemStackHolder;

public class CommonProxy {
	
	public List<RecipeShapesBanner> shapesBannerRecipe;
	public List<RecipeSymbolsBanner> symbolsBannerRecipe;
	
	public Configuration config;
    
    public int baseColor;
    public int patternColor;
    
    public Map<String, IModHandler> modHandlers;
    
	public void preInit(FMLPreInitializationEvent event) {
		config = new Configuration(event.getSuggestedConfigurationFile());
    	config.load();
    	
    	loadConfig();
    	
    	MinecraftForge.EVENT_BUS.register(this);
	}
	
	public void postInit(FMLPostInitializationEvent event) {
		// Declare external special mods
		modHandlers = new HashMap<String, IModHandler>();
		modHandlers.put("immersiveengineering", new IEHandler());
		
		
		// Classic pattern minecraft
		ImmutableList.Builder<RecipeShapesBanner> builderShapes = ImmutableList.builder();
		ImmutableList.Builder<RecipeSymbolsBanner> builderSymbols = ImmutableList.builder();
		for(EnumBannerPattern p : EnumBannerPattern.values()) {
			if(p.hasValidCrafting() && !p.hasCraftingStack()) {
				builderShapes.add(new RecipeShapesBanner(p.getPatternID(), p.getCraftingLayers()));
			} else if(p.hasCraftingStack())
				builderSymbols.add(new RecipeSymbolsBanner(p.getPatternID(), p.getCraftingStack()));
		}
		
		
		// Manage custom mods pattern...
		for(Entry<String, IModHandler> entry : modHandlers.entrySet()) {
		    String modID = entry.getKey();
		    IModHandler handler = entry.getValue();
		    
		    if(Loader.isModLoaded(modID)) {
		    	handler.register(builderShapes, builderSymbols);
		    }
		}
		
		shapesBannerRecipe = builderShapes.build();
		symbolsBannerRecipe = builderSymbols.build();
	}
	
	public void loadConfig() {
		String desc = "Base color of the banner in JEI [range: 0 ~ 15, default: 0]";
		baseColor = config.get(Configuration.CATEGORY_GENERAL, "baseColor", Constants.defaultBaseColor, desc, 0, 15).getInt();
		
		desc = "Pattern color on the banner in JEI [range: 0 ~ 15, default: 0]";
    	patternColor = config.get(Configuration.CATEGORY_GENERAL, "patternColor", Constants.defaultPatternColor, desc, 0, 15).getInt();
    	
		if(config.hasChanged())
			config.save();
	}

	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent e) {
		if(e.getModID().equals(Constants.MODID))
			loadConfig();
	}
}
