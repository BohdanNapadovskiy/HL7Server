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
public class OBX {
    private String messageType;
    private String setId;
    private String codedDatatype;
    private HL7ConceptId conceptId;
    private String subId;
    private HL7Value value;
    private String units;
    private String referencesRange;
    private String abnormalFlags;
    private String probability;
    private String natureOfAbnormalTest;
    private String observationResultStatus;
    private String effectiveDate;
    private String userDefinedAccessChecks;
    private String dateTimeOfObservation;


    public OBX(String str) {
        String conceptId = StringMessageParser.getValueFromStringById(3, str, "\\|");
        String values = StringMessageParser.getValueFromStringById(5, str, "\\|");
        this.messageType = StringMessageParser.getValueFromStringById(0, str, "\\|");
        this.setId = StringMessageParser.getValueFromStringById(1, str, "\\|");
        this.codedDatatype = StringMessageParser.getValueFromStringById(2, str, "\\|");
        this.conceptId = new HL7ConceptId(conceptId);
        this.subId = StringMessageParser.getValueFromStringById(4, str, "\\|");
        this.value = new HL7Value(values, codedDatatype);
        this.units = StringMessageParser.getValueFromStringById(6, str, "\\|");
        this.referencesRange = StringMessageParser.getValueFromStringById(7, str, "\\|");
        this.abnormalFlags = StringMessageParser.getValueFromStringById(8, str, "\\|");
        this.probability = StringMessageParser.getValueFromStringById(9, str, "\\|");
        this.natureOfAbnormalTest = StringMessageParser.getValueFromStringById(10, str, "\\|");
        this.observationResultStatus = StringMessageParser.getValueFromStringById(11, str, "\\|");
        this.effectiveDate = StringMessageParser.getValueFromStringById(12, str, "\\|");
        this.userDefinedAccessChecks = StringMessageParser.getValueFromStringById(13, str, "\\|");
        this.dateTimeOfObservation = StringMessageParser.getValueFromStringById(14, str, "\\|");

    }

    @Override
    public String toString() {
        return "OBX{" +
                "messageType='" + messageType + '\'' +
                ", setId='" + setId + '\'' +
                ", codedDatatype='" + codedDatatype + '\'' +
                ", conceptId=" + conceptId +
                ", subId='" + subId + '\'' +
                ", value=" + value +
                ", units='" + units + '\'' +
                ", referencesRange='" + referencesRange + '\'' +
                ", abnormalFlags='" + abnormalFlags + '\'' +
                ", probability='" + probability + '\'' +
                ", natureOfAbnormalTest='" + natureOfAbnormalTest + '\'' +
                ", observationResultStatus='" + observationResultStatus + '\'' +
                ", effectiveDate='" + effectiveDate + '\'' +
                ", userDefinedAccessChecks='" + userDefinedAccessChecks + '\'' +
                ", dateTimeOfObservation='" + dateTimeOfObservation + '\'' +
                '}';
    }
}
