package com.metagenics.plxHL7Server.domain.acknowledgment;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MSAResponse {

    private String messageType = "MSA";
    private String response;
    private String respMessageId;


    public MSAResponse(String response, String respMessageId) {
        this.response = response;
        this.respMessageId = respMessageId;
    }


    public static MSAResponse buildMSAResponse(String response, String respMessageId) {
        return new MSAResponse(response, respMessageId);
    }

    public String getMessageString() {
        return messageType + "|" + response + "|" + respMessageId;
    }


}
