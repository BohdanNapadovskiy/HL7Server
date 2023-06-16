package com.metagenics.plxHL7Server;

import com.metagenics.plxHL7Server.service.impl.HL7ServerSocketImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PlxHl7ServerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(PlxHl7ServerApplication.class, args);
        HL7ServerSocketImpl serverSocket = context.getBean(HL7ServerSocketImpl.class);
        serverSocket.startServer();
    }

}

