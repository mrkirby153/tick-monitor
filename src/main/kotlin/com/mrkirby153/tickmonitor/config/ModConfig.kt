package com.mrkirby153.tickmonitor.config

import net.minecraftforge.common.config.Configuration
import java.io.File

object ModConfig {

    val ignoredWorlds = mutableListOf<Int>()

    var lowThreshold = 18
    var criticalThreshold = 5

    var broadcastToOpsOnly = false

    fun load(file: File) {
        val config = Configuration(file)
        config.load()

        val categoryGeneral = Configuration.CATEGORY_GENERAL
        val categoryTPSSettings = "tps-settings"
        config.addCustomCategoryComment(categoryTPSSettings, "Settings related to TPS format")

        config.getStringList("ignoredWorlds", categoryGeneral, emptyArray<String>(), "Dimension IDs to ignore").filter { !it.isBlank() }.forEach {
            try {
                ignoredWorlds.add(it.toInt())
            } catch (e: NumberFormatException) {
                // Ignore
            }
        }

        lowThreshold = config.getInt("lowThreshold", categoryTPSSettings, lowThreshold, 0, 20, "The TPS to broadcast a \"low\" message")
        criticalThreshold = config.getInt("criticalThreshold", categoryTPSSettings, criticalThreshold, 0, 20, "The TPS to broadcast a \"critical\" message")

        broadcastToOpsOnly = config.getBoolean("opsOnly", categoryTPSSettings, broadcastToOpsOnly, "Broadcast TPS messages to OPs only")
        if (config.hasChanged())
            config.save()
    }
}