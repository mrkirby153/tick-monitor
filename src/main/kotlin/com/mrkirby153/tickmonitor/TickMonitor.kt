package com.mrkirby153.tickmonitor

import com.mrkirby153.tickmonitor.proxy.CommonProxy
import me.mrkirby153.kcutils.timeMS
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.SidedProxy
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

@Mod(modid = Constants.MOD_ID, version = Constants.VERSION, name = Constants.MOD_NAME, acceptableRemoteVersions = Constants.REMOTE_VERSIONS)
class TickMonitor {

    val logger: Logger = LogManager.getLogger(Constants.MOD_ID)

    val ignoredWorlds = mutableListOf<Int>()

    @Mod.EventHandler
    fun preInit(event: FMLPreInitializationEvent) {
        logger.info("Running pre-init...")
        val timeTaken = timeMS {
            proxy.preInit(event)
        }
        logger.info("Pre-init ran in ${timeTaken}ms")
    }

    @Mod.EventHandler
    fun init(event: FMLInitializationEvent) {
        logger.info("Running init...")
        val timeTaken = timeMS {
            proxy.init(event)
        }
        logger.info("Init ran in ${timeTaken}ms")
    }

    @Mod.EventHandler
    fun postInit(event: FMLPostInitializationEvent) {
        logger.info("Running post-init...")
        val timeTaken = timeMS {
            proxy.postInit(event)
        }
        logger.info("Post-init ran in ${timeTaken}ms")
    }

    companion object {
        @Mod.Instance(Constants.MOD_ID)
        lateinit var instance: TickMonitor

        @SidedProxy(clientSide = Constants.CLIENT_PROXY, serverSide = Constants.COMMON_PROXY)
        lateinit var proxy: CommonProxy
    }
}