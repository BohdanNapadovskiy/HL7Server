package com.metagenics.plxHL7Server.domain.acknowledgment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ACK_R01Message {

    private ACKMshSegment mshSegment;
    private MSAResponse msaResponse;


    public static ACK_R01Message buildACK_R01Message(String response, String respMessageId) {
        ACK_R01Message message = new ACK_R01Message();
        message.setMshSegment(ACKMshSegment.buildMessageSegment());
        message.setMsaResponse(MSAResponse.buildMSAResponse(response, respMessageId));
        return message;
    }

}
