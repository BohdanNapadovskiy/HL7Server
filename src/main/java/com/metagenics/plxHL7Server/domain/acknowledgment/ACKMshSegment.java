package com.metagenics.plxHL7Server.domain.acknowledgment;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
public class ACKMshSegment {

    private String messageType = "MSH";
    private String encodingCharacters = "^~\\&";
    private String sendingApplication = "PLMX^PLMX.DEV.com^URI";
    private String hospitalName = "AlisaVjeho";
    private String receivingName = "^riester.de^URI";
    private String receivingFacility = "Riester";
    private String dateTimeOfMessage;
    private String ackMessageType = "ACK^R01^ACK";
    private String dateTime;
    private String messageControlId = "P";
    private String versionID = "2.6";


    public static ACKMshSegment buildMessageSegment() {
        ACKMshSegment segment = new ACKMshSegment();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss").withZone(ZoneId.of("UTC"));
        Instant instant = Instant.now();
        segment.setDateTimeOfMessage(formatter.format(instant) + "+0000");
        segment.setDateTime(formatter.format(instant) + "+0000");
        return segment;
    }

    public String getMessageString() {
        return messageType + "|" + encodingCharacters + "|" + sendingApplication + "|" + hospitalName + "|" +
                receivingName + "|" + receivingFacility + "|" + dateTimeOfMessage + "||" + ackMessageType + "|" + dateTime + "|" +
                messageControlId + "|" + versionID + "\r";
    }

}
