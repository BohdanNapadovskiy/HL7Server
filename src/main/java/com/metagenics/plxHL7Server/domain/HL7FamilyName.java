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
public class HL7FamilyName {

    private String motherMaidenFamilyName;
    private String givenName;
    private String secondMiddleName;
    private String suffix;
    private String prefix;


    public HL7FamilyName(String familyName) {
        this.motherMaidenFamilyName = StringMessageParser.getValueFromStringById(0, familyName, "\\^");
        this.givenName = StringMessageParser.getValueFromStringById(1, familyName, "\\^");
        this.secondMiddleName = StringMessageParser.getValueFromStringById(2, familyName, "\\^");
        this.suffix = StringMessageParser.getValueFromStringById(3, familyName, "\\^");
        this.prefix = StringMessageParser.getValueFromStringById(4, familyName, "\\^");
    }

    @Override
    public String toString() {
        return "HL7FamilyName{" +
                "motherMaidenFamilyName='" + motherMaidenFamilyName + '\'' +
                ", givenName='" + givenName + '\'' +
                ", secondMiddleName='" + secondMiddleName + '\'' +
                ", suffix='" + suffix + '\'' +
                ", prefix='" + prefix + '\'' +
                '}';
    }
}
