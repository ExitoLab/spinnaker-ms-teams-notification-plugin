import { IDeckPlugin, Registry } from '@spinnaker/core';
import { MicrosoftTeamsNotificationType } from './MicrosoftTeamsNotificationType';

export const plugin: IDeckPlugin = {
  initialize: () => {
    Registry.pipeline.registerNotification({
      component: MicrosoftTeamsNotificationType,
      key: 'microsoftteams',
      label: 'MicroSoftTeams',
    });
  },
};
