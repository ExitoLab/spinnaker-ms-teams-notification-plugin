package io.armory.plugin.example.echo.notificationagent

import com.netflix.spinnaker.kork.plugins.api.PluginConfiguration

@PluginConfiguration("ms-teams.notifications")
data class HTTPNotificationConfig(val url: String)
