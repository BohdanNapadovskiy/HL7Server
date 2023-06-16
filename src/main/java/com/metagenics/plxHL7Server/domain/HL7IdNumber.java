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
public class HL7IdNumber {
    private String iDNumber;
    private String checkDigit;
    private String checkDigitScheme;

    public HL7IdNumber(String stringIdNumber) {
        this.iDNumber = StringMessageParser.getValueFromStringById(0, stringIdNumber, "\\^");
        this.checkDigit = StringMessageParser.getValueFromStringById(1, stringIdNumber, "\\^");
        this.checkDigitScheme = StringMessageParser.getValueFromStringById(2, stringIdNumber, "\\^");
    }

    @Override
    public String toString() {
        return "HL7IdNumber{" +
                "iDNumber='" + iDNumber + '\'' +
                ", checkDigit='" + checkDigit + '\'' +
                ", checkDigitScheme='" + checkDigitScheme + '\'' +
                '}';
    }
}
