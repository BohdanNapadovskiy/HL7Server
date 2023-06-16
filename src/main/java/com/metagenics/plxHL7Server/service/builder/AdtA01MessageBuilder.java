package com.metagenics.plxHL7Server.service.builder;


import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class AdtA01MessageBuilder {

    private static final char END_OF_BLOCK = '\u001c';
    private static final char START_OF_BLOCK = '\u000b';
    private static final char CARRIAGE_RETURN = 13;

    public static String getSimpleAcknowledgementMessage(String messageId) {
        if (messageId == null) {
            throw new RuntimeException("Invalid HL7 message for parsing operation. Please check your inputs");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss").withZone(ZoneId.of("UTC"));
        Instant instant = Instant.now();

        StringBuffer ackMessage = new StringBuffer();

        ackMessage = ackMessage.append(START_OF_BLOCK)
                .append("MSH|^~\\&|PLMX^PLMX.DEV.com^URI|AlisaVjeho|^riester.de^URI|Riester|" + formatter.format(instant) + "+0000||ACK^R01^ACK|" + formatter.format(instant) + "+0000|P|2.6")
                .append(CARRIAGE_RETURN)
                .append("MSA|AA|")
                .append(messageId)
                .append(CARRIAGE_RETURN)
                .append(END_OF_BLOCK)
                .append(CARRIAGE_RETURN);
        return ackMessage.toString();
    }

}
