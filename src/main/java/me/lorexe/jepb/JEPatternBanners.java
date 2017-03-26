package me.lorexe.jepb;

import me.lorexe.jepb.proxy.CommonProxy;
import me.lorexe.jepb.utils.Constants;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=Constants.MODID, version=Constants.VERSION, dependencies=Constants.DEPENDENCIES, guiFactory="me.lorexe.jepb.config.GuiFactory")
public class JEPatternBanners {
    
    @SidedProxy(clientSide="me.lorexe.jepb.proxy.ClientProxy", serverSide="me.lorexe.jepb.proxy.CommonProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	this.proxy.preInit(event);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	this.proxy.postInit(event);
    }
}
