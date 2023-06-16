package com.metagenics.plxHL7Server.service.amazon;


import com.amazonaws.services.sns.AmazonSNS;
import org.springframework.cloud.aws.core.env.ResourceIdResolver;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.cloud.aws.messaging.core.TopicMessageChannel;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class SNSMessageTemplate extends NotificationMessagingTemplate {

    public SNSMessageTemplate(AmazonSNS amazonSns, ResourceIdResolver resourceIdResolver) {
        super(amazonSns, resourceIdResolver);
    }


    public void sendMessage(Object message, final String attributeType) {
        String topic = "PLX-META-TOPIC-dev";
        final HashMap<String, Object> messageMap = new HashMap<>();
        messageMap.put("SOURCE", "PORTAL_APP");
        messageMap.put("DESTINATION", "INBODY_APP");
        messageMap.put("TYPE", attributeType);
        messageMap.put(TopicMessageChannel.NOTIFICATION_SUBJECT_HEADER, "topic");
        this.convertAndSend(topic, message, messageMap);
    }
}

