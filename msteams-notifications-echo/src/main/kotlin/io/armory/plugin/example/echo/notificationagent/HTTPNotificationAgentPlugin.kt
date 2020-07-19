package io.armory.plugin.example.echo.notificationagent

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.convertValue
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.netflix.spinnaker.echo.api.events.Event
import com.netflix.spinnaker.echo.api.events.NotificationAgent
import com.netflix.spinnaker.kork.plugins.api.PluginSdks
import com.netflix.spinnaker.kork.plugins.api.httpclient.HttpClient
import com.netflix.spinnaker.kork.plugins.api.httpclient.HttpClientConfig
import com.netflix.spinnaker.kork.plugins.api.httpclient.Request
import org.pf4j.Extension
import org.pf4j.Plugin
import org.pf4j.PluginWrapper

class HTTPNotificationAgentPlugin(wrapper: PluginWrapper) : Plugin(wrapper)

@Extension
class HTTPNotificationAgent(config: HTTPNotificationConfig, pluginSdks: PluginSdks) : NotificationAgent {
  private val client: HttpClient
  private val AGENT_NAME = "http-notification-agent"
  private val mapper = jacksonObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

  init {
    pluginSdks.http().configure(AGENT_NAME, config.url, HttpClientConfig())
    client = pluginSdks.http().get(AGENT_NAME)
  }

  override fun getNotificationType() = "http"

  override fun sendNotifications(notification: MutableMap<String, Any>, application: String, event: Event, status: String) {
    val nc = notification.asNotificationConfig()
    client.post(Request(AGENT_NAME, nc.path ?: "").setBody(event))
  }

  private fun MutableMap<String, Any>.asNotificationConfig() = mapper.convertValue<NotificationConfig>(this)
}

data class NotificationConfig(val path: String?)
