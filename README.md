![CI](https://github.com/spinnaker-plugin-examples/notificationPlugin/workflows/CI/badge.svg)
![Latest Kork](https://github.com/spinnaker-plugin-examples/notificationPlugin/workflows/Latest%20Kork/badge.svg?branch=master)
![Latest Echo](https://github.com/spinnaker-plugin-examples/notificationPlugin/workflows/Latest%20Echo/badge.svg)

## Notification Agent Plugin

Spinnaker has a set of built-in types (e.g., Slack, email, SMS)
for pipeline notifications.

This plugin adds a new HTTP notification type as an example for plugin 
developers to modify and extend as they create integrations with their own 
notification systems. It's not meant for production use. It's meant for you
to copy as a starting point for creating your own notification plugin!

## Configuration

```
spinnaker:
  extensibility:
    plugins:
      Armory.NotificationAgent:
        enabled: true
        extensions:
          armory.httpNotificationService:
            enabled: true
            config:
              url: <fill-me-in>
```

## Known bugs

This plugin allows a developer to extend the `NotificationAgent` interface in
`Echo`. This interface handles most pipeline notifications. However, it does not handle notifications 
configured in Manual Judgment stages.

## Future work

We're planning on adding a method to the `NotificationAgent` interface that
would allow developers to define a set of parameters needed for the plugin
(e.g., the Slack channel where the notification should be sent). Form fields
for defining these parameters would be automatically generated in Spinnaker's UI.
