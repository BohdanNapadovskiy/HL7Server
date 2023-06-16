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
public class HL7ConceptId {

    private String conceptId;
    private String textDescription;
    private String nameOfCodingSystem;

    public HL7ConceptId(String conceptId) {
        this.conceptId = StringMessageParser.getValueFromStringById(0, conceptId, "\\^");
        this.textDescription = StringMessageParser.getValueFromStringById(1, conceptId, "\\^");
        this.nameOfCodingSystem = StringMessageParser.getValueFromStringById(2, conceptId, "\\^");
    }

    @Override
    public String toString() {
        return "HL7ConceptId{" +
                "conceptId='" + conceptId + '\'' +
                ", textDescription='" + textDescription + '\'' +
                ", nameOfCodingSystem='" + nameOfCodingSystem + '\'' +
                '}';
    }
}
