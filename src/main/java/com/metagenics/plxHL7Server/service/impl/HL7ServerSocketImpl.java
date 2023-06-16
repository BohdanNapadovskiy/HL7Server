package com.metagenics.plxHL7Server.service.impl;


import com.metagenics.plxHL7Server.service.HL7ServerSocket;
import com.metagenics.plxHL7Server.service.amazon.MessageSourceBean;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.ServerSocket;


@Service
@RequiredArgsConstructor
public class HL7ServerSocketImpl implements HL7ServerSocket {

    private static final Logger logger = LoggerFactory.getLogger(HL7ServerSocketImpl.class);
    private final MessageSourceBean messageSource;

    @Override
    public void startServer() {
        int port = 8093;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info("Application run on  port {}", port);
            while (true) {
                new RVSClientHandler(serverSocket.accept(), messageSource).start();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
