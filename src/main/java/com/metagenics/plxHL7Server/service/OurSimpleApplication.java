package com.metagenics.plxHL7Server.service;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.protocol.ReceivingApplication;
import ca.uhn.hl7v2.protocol.ReceivingApplicationException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class OurSimpleApplication implements ReceivingApplication {

    private static final HapiContext context = new DefaultHapiContext();


    @Override
    public Message processMessage(Message message, Map map) throws ReceivingApplicationException, HL7Exception {

        String receivedEncodedMessage = context.getPipeParser().encode(message);
        System.out.println("Incoming message:\n" + receivedEncodedMessage + "\n\n");
        try {
            return message.generateACK();
        } catch (IOException e) {
            throw new HL7Exception(e);
        }
    }

    @Override
    public boolean canProcess(Message message) {
        return true;
    }

}



