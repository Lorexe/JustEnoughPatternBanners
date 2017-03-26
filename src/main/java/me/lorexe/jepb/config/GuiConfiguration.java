package me.lorexe.jepb.config;

import me.lorexe.jepb.JEPatternBanners;
import me.lorexe.jepb.utils.Constants;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;

public class GuiConfiguration extends GuiConfig {
	public GuiConfiguration(GuiScreen parent) {
		super(parent, new ConfigElement(JEPatternBanners.proxy.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
				Constants.MODID,
				false,
				false,
				"");
		
		titleLine2 = JEPatternBanners.proxy.config.getConfigFile().getAbsolutePath();
	}
}
