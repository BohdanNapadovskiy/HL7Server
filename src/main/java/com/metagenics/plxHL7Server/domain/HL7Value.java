package com.metagenics.plxHL7Server.domain;

import com.metagenics.plxHL7Server.service.StringMessageParser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HL7Value {

    private String comparator;
    private String value;

    public HL7Value(String strValues, String codedType) {
        if (codedType.equalsIgnoreCase("SN")) {
            this.comparator = StringMessageParser.getValueFromStringById(0, strValues, "\\^");
            this.value = StringMessageParser.getValueFromStringById(1, strValues, "\\^");
        } else this.value = strValues;
    }

    @Override
    public String toString() {
        return "HL7Value{" +
                "comparator='" + comparator + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
