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
public class HL7Patient {
    private String familyName;
    private String givenName;
    private String middleName;
    private String suffix;
    private String prefix;

    public HL7Patient(String strPatient) {
        this.familyName = StringMessageParser.getValueFromStringById(0, strPatient, "\\^");
        this.givenName = StringMessageParser.getValueFromStringById(1, strPatient, "\\^");
        this.middleName = StringMessageParser.getValueFromStringById(2, strPatient, "\\^");
        this.suffix = StringMessageParser.getValueFromStringById(3, strPatient, "\\^");
        this.prefix = StringMessageParser.getValueFromStringById(4, strPatient, "\\^");
    }

    @Override
    public String toString() {
        return "HL7Patient{" +
                "familyName='" + familyName + '\'' +
                ", givenName='" + givenName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", suffix='" + suffix + '\'' +
                ", prefix='" + prefix + '\'' +
                '}';
    }
}
