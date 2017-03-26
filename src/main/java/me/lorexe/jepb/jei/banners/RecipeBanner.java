package me.lorexe.jepb.jei.banners;

import net.minecraft.item.ItemStack;

public class RecipeBanner {
	private ItemStack patternCraftingStack;
	private final String patternID;
	private final String[] craftingLayers;
	
	public RecipeBanner(String id) {
		this.patternID = id;
		this.craftingLayers = new String[3];
	}
	
	public RecipeBanner(String id, ItemStack crafting) {
		this(id);
		this.patternCraftingStack = crafting;
	}
	
	public RecipeBanner(String id, String craftingTop, String craftingMid, String craftingBot) {
		this(id);
		this.craftingLayers[0] = craftingTop;
		this.craftingLayers[1] = craftingMid;
		this.craftingLayers[2] = craftingBot;
	}
	
	public RecipeBanner(String id, String[] crafting) {
		this(id, crafting[0], crafting[1], crafting[2]);
	}
	
	public ItemStack getCraftingStack() {
		return this.patternCraftingStack;
	}
	
	public String getPatternID() {
		return this.patternID;
	}
	
	public String[] getCraftingLayers() {
        return this.craftingLayers;
    }
	
	public boolean hasCraftingLayers() {
		return this.craftingLayers[0] != null;
	}
	
	public boolean hasCraftingStack() {
		return this.patternCraftingStack != null;
	}
}
