package com.ati.iaservices.helpers

import com.ati.iaservices.recipes.LauncherPluginUtil
import com.protegra_ati.agentservices.core.platformagents.AgentHostStorePlatformAgent
import com.protegra_ati.agentservices.core.util.ConfigurationManager

class CreateStoreHelper {
  final val STORE_CONFIG = "init_store.conf"
  final val DB_STORE_CONFIG = "db_store.conf"
  final val DB_STORE_DB_CONFIG = "db_store_db.conf"
  final val DB_STORE_PUBLIC_CONFIG = "db_store_public.conf"
  final val LOG_KVDB_CONFIG = "log.conf"
  final val LOG_KVDB_PROPERTIES = "log.properties"
  final val LOG_AGENTSERVICES_CONFIG = "log_agentservices.conf"
  final val LOG_AGENTSERVICES_PROPERTIES = "log_agentservices.properties"

  def checkAllStoreConfigFiles() {
    LauncherPluginUtil.configFileExists(STORE_CONFIG)
    LauncherPluginUtil.configFileExists(DB_STORE_CONFIG)
    LauncherPluginUtil.configFileExists(DB_STORE_DB_CONFIG)
    LauncherPluginUtil.configFileExists(DB_STORE_PUBLIC_CONFIG)
    LauncherPluginUtil.configFileExists(LOG_KVDB_CONFIG)
    LauncherPluginUtil.configFileExists(LOG_KVDB_PROPERTIES)
    LauncherPluginUtil.configFileExists(LOG_AGENTSERVICES_CONFIG)
    LauncherPluginUtil.configFileExists(LOG_AGENTSERVICES_PROPERTIES)
  }

  def createStore(): AgentHostStorePlatformAgent = {
    val store = new AgentHostStorePlatformAgent()
    checkAllStoreConfigFiles()
    val config = new ConfigurationManager(STORE_CONFIG)
    store.initFromConfig(config)
    store
  }
}