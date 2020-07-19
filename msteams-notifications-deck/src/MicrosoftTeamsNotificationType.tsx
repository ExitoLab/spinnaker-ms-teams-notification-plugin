import React from 'react';

import {
  FormikFormField,
  INotificationTypeCustomConfig,
  IStageTypeConfig,
  TextInput,
} from '@spinnaker/core';

export const MicrosoftTeamsNotificationType = (props: INotificationTypeCustomConfig) => {
  const { fieldName } = props;
  return (
    <FormikFormField
      label="URL Path"
      name="path"
      input={props => (
        <TextInput
          inputClassName="form-control input-sm"
          {...props}
          placeholder="URL path"
        />
      )}
      required={false}
    />
  );
}

