package com.metagenics.plxHL7Server.service.amazon;

import com.metagenics.plxHL7Server.domain.VitalsPatientResult;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageSourceBean {

    private final SNSMessageTemplate messagingTemplate;
    private static final Logger logger = LoggerFactory.getLogger(MessageSourceBean.class);


    public void publishMessageToSNS(VitalsPatientResult result) {
        logger.info("Sending message to AWS");
        PlxMessage message = createPlxMessageToDashBoard(result);
        sendMessage(message);
    }


    private PlxMessage createPlxMessageToDashBoard(VitalsPatientResult encounter) {
        PlxMessage message = new PlxMessage();

        message.setSource("INBODY_APP");
        message.setDestination("INBODY_APP");
        message.setType("VITALS_MESSAGE");
        message.getPayloadMap().put("VITALS_RESULT", encounter);
        return message;

    }


    private void sendMessage(PlxMessage message) {
        try {
            messagingTemplate.sendMessage(
                    message,
                    message.getType());
        } catch (Exception e) {
            logger.error("Transaction is Roll back , Reason is {}", e.getCause());
            throw e;
        }
    }


}
