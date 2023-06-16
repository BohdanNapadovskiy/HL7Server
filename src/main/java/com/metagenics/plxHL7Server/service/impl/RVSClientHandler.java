package com.metagenics.plxHL7Server.service.impl;

import com.metagenics.plxHL7Server.domain.ORUR01Message;
import com.metagenics.plxHL7Server.domain.VitalsPatientResult;
import com.metagenics.plxHL7Server.service.amazon.MessageSourceBean;
import com.metagenics.plxHL7Server.service.builder.AdtA01MessageBuilder;
import com.metagenics.plxHL7Server.service.builder.ORUR01MessageBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class RVSClientHandler extends Thread {

    private final Socket clientSocket;
    private final MessageSourceBean messageSource;
    private static final Logger logger = LoggerFactory.getLogger(RVSClientHandler.class);

    public RVSClientHandler(Socket socket, MessageSourceBean messageSource) {
        this.clientSocket = socket;
        this.messageSource = messageSource;

    }

    public void run() {
        try {
            OutputStream out = clientSocket.getOutputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            StringBuilder strMessage = new StringBuilder();
            String str;
            while ((str = in.readLine()) != null) {
                strMessage.append(str.trim());
                System.out.println("Getting row from rvs-100: " + str);
                strMessage.append(System.lineSeparator());
                if (str.equals(System.lineSeparator()) || str.equals("") || (toHex(str).equals(Integer.toHexString(0x1C)))) {
                    logger.info("PARSING MESSAGE");
                    if (strMessage.toString().contains("ORU^R01^ORU_R01"))
                        handleOruMessage(strMessage.toString(), out);
                    else if (strMessage.toString().contains("QBP^Q22^QBP_Q21"))
                        handleQBPMessage(strMessage.toString(), out);
                }
            }
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private synchronized void handleQBPMessage(String strMessage, OutputStream out) {
        ORUR01Message orur01Message = ORUR01MessageBuilder.buildOruMessage(strMessage.toString());
//        logger.info("Message parsed {}", orur01Message.toString());
        VitalsPatientResult result = new VitalsPatientResult(orur01Message);
//        messageSource.publishMessageToSNS(result);
    }

    public String toHex(String arg) {
        return String.format("%x", new BigInteger(1, arg.getBytes(StandardCharsets.US_ASCII)));
    }

    private synchronized void handleOruMessage(String strMessage, OutputStream out) {
        ORUR01Message orur01Message = ORUR01MessageBuilder.buildOruMessage(strMessage);
        logger.info("Message parsed {}", orur01Message);
        VitalsPatientResult result = new VitalsPatientResult(orur01Message);
        sendingMessageToClient(orur01Message, out);
//        messageSource.publishMessageToSNS(result);
    }

    private void sendingMessageToClient(ORUR01Message orur01Message, OutputStream out) {
        logger.info("SENDING RESPONSE");
        String responseMessage = AdtA01MessageBuilder.getSimpleAcknowledgementMessage(orur01Message.getMsh().getMessageControlId());
        try {
            out.write(responseMessage.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

