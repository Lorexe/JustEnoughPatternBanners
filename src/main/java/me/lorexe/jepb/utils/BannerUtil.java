package me.lorexe.jepb.utils;

import me.lorexe.jepb.JEPatternBanners;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class BannerUtil {

	public static ItemStack makeBanner(String patternID) {
		return makeBanner(patternID, JEPatternBanners.proxy.baseColor, JEPatternBanners.proxy.patternColor);
	}
	
	// {BlockEntityTag:{Base:15,Patterns:[0:{Pattern:"patternID",Color:0}]}}
	public static ItemStack makeBanner(String patternID, int baseColor, int patternColor) {
		
		if(baseColor < 0 || baseColor > 15) baseColor = JEPatternBanners.proxy.baseColor;
		if(patternColor < 0 || patternColor > 15) patternColor = JEPatternBanners.proxy.patternColor;
		
		ItemStack banner = new ItemStack(Items.BANNER, 1, baseColor);
		
		NBTTagCompound tags = banner.getTagCompound();
		if(tags == null) {
			tags = new NBTTagCompound();
			banner.setTagCompound(tags);
		}
		
		NBTTagCompound blockTag = new NBTTagCompound();
		tags.setTag("BlockEntityTag", blockTag);
		//blockTag.setInteger("Base", baseColor);
		
		NBTTagList patternList = new NBTTagList();
		blockTag.setTag("Patterns", patternList);
		
		NBTTagCompound pattern = new NBTTagCompound();
		pattern.setString("Pattern", patternID);
		pattern.setInteger("Color", patternColor);
		
		patternList.appendTag(pattern);
		
		
		return banner;
	}
	
	public static ItemStack makeBlank(int baseColor) {
		if(baseColor < 0 || baseColor > 15) baseColor = JEPatternBanners.proxy.baseColor;
		
		ItemStack banner = new ItemStack(Items.BANNER, 1, baseColor);
		
		/*
		NBTTagCompound tags = banner.getTagCompound();
		if(tags == null) {
			tags = new NBTTagCompound();
			banner.setTagCompound(tags);
		}
		
		NBTTagCompound blockTag = new NBTTagCompound();
		tags.setTag("BlockEntityTag", blockTag);
		blockTag.setInteger("Base", baseColor);
		*/
		
		return banner;
	}
}
