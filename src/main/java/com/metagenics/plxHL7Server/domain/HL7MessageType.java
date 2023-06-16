package com.metagenics.plxHL7Server.domain;

import com.metagenics.plxHL7Server.service.StringMessageParser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HL7MessageType {
    private String messageType;
    private String eventType;


    public HL7MessageType(String messageTypeValues) {
        this.messageType = StringMessageParser.getValueFromStringById(0, messageTypeValues, "\\^");
        this.messageType = StringMessageParser.getValueFromStringById(1, messageTypeValues, "\\^");
    }

    @Override
    public String toString() {
        return "HL7MessageType{" +
                "messageType='" + messageType + '\'' +
                ", eventType='" + eventType + '\'' +
                '}';
    }
}
