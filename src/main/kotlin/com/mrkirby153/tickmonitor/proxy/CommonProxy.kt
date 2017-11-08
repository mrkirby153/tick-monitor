package com.mrkirby153.tickmonitor.proxy

import com.mrkirby153.tickmonitor.config.ModConfig
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent

open class CommonProxy {


    fun preInit(event: FMLPreInitializationEvent){
        ModConfig.load(event.suggestedConfigurationFile)
    }

    fun init(event: FMLInitializationEvent){

    }

    fun postInit(event: FMLPostInitializationEvent){

    }
}