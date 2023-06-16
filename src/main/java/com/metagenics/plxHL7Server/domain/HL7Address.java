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
public class HL7Address {

    private String streetAddress;
    private String otherDesignation;
    private String city;
    private String state;
    private String zip;

    public HL7Address(String address) {
        this.streetAddress = StringMessageParser.getValueFromStringById(0, address, "\\^");
        this.otherDesignation = StringMessageParser.getValueFromStringById(1, address, "\\^");
        this.city = StringMessageParser.getValueFromStringById(2, address, "\\^");
        this.state = StringMessageParser.getValueFromStringById(3, address, "\\^");
        this.zip = StringMessageParser.getValueFromStringById(4, address, "\\^");
    }

    @Override
    public String toString() {
        return "HL7Address{" +
                "streetAddress='" + streetAddress + '\'' +
                ", otherDesignation='" + otherDesignation + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
