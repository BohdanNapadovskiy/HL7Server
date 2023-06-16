package com.metagenics.plxHL7Server.domain;

import com.metagenics.plxHL7Server.service.StringMessageParser;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MSH {

    private String messageHeader;
    private String sendingApplication;
    private String sendingFacility;
    private String receivingApplication;
    private String receivingFacility;
    private String dateMessage;
    private String security;
    private HL7MessageType messageType;
    private String messageControlId;
    private String processingId;
    private String versionId;
    private String sequenceNumber;
    private String continuationPointer;
    private String acceptAcknowledgementType;
    private String applicationAcknowledgementType;
    private String countryCode;
    private String characterSet;
    private String principalLanguageMessage;
    private String alternateSchema;

    public static MSH build(String mshStr) {
        String messageTypeValues = StringMessageParser.getComponentValues(8, mshStr);
        return MSH.builder()
                .messageHeader(StringMessageParser.getValueFromStringById(0, mshStr, "\\|"))
                .sendingApplication(StringMessageParser.getValueFromStringById(2, mshStr, "\\|"))
                .sendingFacility(StringMessageParser.getValueFromStringById(3, mshStr, "\\|"))
                .receivingApplication(StringMessageParser.getValueFromStringById(4, mshStr, "\\|"))
                .receivingFacility(StringMessageParser.getValueFromStringById(5, mshStr, "\\|"))
                .dateMessage(StringMessageParser.getValueFromStringById(6, mshStr, "\\|"))
                .security("")
                .messageType(new HL7MessageType(messageTypeValues)) //8
                .messageControlId(StringMessageParser.getValueFromStringById(9, mshStr, "\\|"))
                .processingId(StringMessageParser.getValueFromStringById(10, mshStr, "\\|"))
                .versionId(StringMessageParser.getValueFromStringById(11, mshStr, "\\|"))
                .sequenceNumber(StringMessageParser.getValueFromStringById(12, mshStr, "\\|"))
                .continuationPointer("")
                .acceptAcknowledgementType("")
                .applicationAcknowledgementType("")
                .countryCode("")
                .characterSet("")
                .principalLanguageMessage("")
                .alternateSchema("")
                .build();
    }

    @Override
    public String toString() {
        return "MSH{" +
                "messageHeader='" + messageHeader + '\'' +
                ", sendingApplication='" + sendingApplication + '\'' +
                ", sendingFacility='" + sendingFacility + '\'' +
                ", receivingApplication='" + receivingApplication + '\'' +
                ", receivingFacility='" + receivingFacility + '\'' +
                ", dateMessage='" + dateMessage + '\'' +
                ", security='" + security + '\'' +
                ", messageType=" + messageType +
                ", messageControlId='" + messageControlId + '\'' +
                ", processingId='" + processingId + '\'' +
                ", versionId='" + versionId + '\'' +
                ", sequenceNumber='" + sequenceNumber + '\'' +
                ", continuationPointer='" + continuationPointer + '\'' +
                ", acceptAcknowledgementType='" + acceptAcknowledgementType + '\'' +
                ", applicationAcknowledgementType='" + applicationAcknowledgementType + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", characterSet='" + characterSet + '\'' +
                ", principalLanguageMessage='" + principalLanguageMessage + '\'' +
                ", alternateSchema='" + alternateSchema + '\'' +
                '}';
    }
}
