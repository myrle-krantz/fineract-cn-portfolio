/*
 * Copyright 2017 Kuelap, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.mifos.portfolio.listener;

import io.mifos.core.lang.config.TenantHeaderFilter;
import io.mifos.core.test.listener.EventRecorder;
import io.mifos.individuallending.api.v1.events.IndividualLoanEventConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

/**
 * @author Myrle Krantz
 */
@SuppressWarnings("unused")
@Component
public class LossProvisionStepsEventListener {
  private final EventRecorder eventRecorder;

  @Autowired
  public LossProvisionStepsEventListener(final EventRecorder eventRecorder) {
    super();
    this.eventRecorder = eventRecorder;
  }

  @JmsListener(
      subscription = IndividualLoanEventConstants.DESTINATION,
      destination = IndividualLoanEventConstants.DESTINATION,
      selector = IndividualLoanEventConstants.SELECTOR_PUT_LOSS_PROVISION_STEPS
  )
  public void onChangeLossProvisionSteps(
      @Header(TenantHeaderFilter.TENANT_HEADER) final String tenant,
      final String payload)
  {
    this.eventRecorder.event(tenant, IndividualLoanEventConstants.PUT_LOSS_PROVISION_STEPS, payload, String.class);
  }
}