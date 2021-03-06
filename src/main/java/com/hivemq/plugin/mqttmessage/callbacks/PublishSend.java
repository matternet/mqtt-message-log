/*
 * Copyright 2015 dc-square GmbH
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.hivemq.plugin.mqttmessage.callbacks;

import com.google.common.base.Charsets;
import com.hivemq.spi.callback.events.OnPublishSend;
import com.hivemq.spi.message.PUBLISH;
import com.hivemq.spi.security.ClientData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Max Marche
 */
public class PublishSend implements OnPublishSend {
    private static final Logger log = LoggerFactory.getLogger(PublishSend.class);

    @Override
    public void onPublishSend(PUBLISH publish, ClientData clientData) {

        final String clientID = clientData.getClientId();
        final String topic = publish.getTopic();
        final String payload = new String(publish.getPayload(), Charsets.UTF_8);

        log.info("Sent a message to clientId \"{}\" on topic \"{}\":\"{}\" (QoS: {}, retained: {})",
                clientID, topic, payload, publish.getQoS().getQosNumber(), publish.isRetain());
    }
}
