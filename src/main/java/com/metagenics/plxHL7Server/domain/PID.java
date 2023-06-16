package com.metagenics.plxHL7Server.domain;


import com.metagenics.plxHL7Server.service.StringMessageParser;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PID {
    private String messageType;
    private String id;
    private String patientId;
    private HL7IdNumber iDNumber;
    private String alternatePatientId;
    private HL7Patient patient;
    private HL7FamilyName familyName;
    private String dateOfBirth;
    private String sex;
    private String alias;
    private String race;
    private HL7Address streetAddress;
    private String countryCode;
    private String homePhoneNumber;
    private String businessPhoneNumber;
    private String primaryLanguage;
    private String maritalStatus;
    private String religion;
    private String SSN;


    public static PID build(String pidString) {
        String stringIdNumber = StringMessageParser.getValueFromStringById(3, pidString, "\\|");
        String strPatient = StringMessageParser.getValueFromStringById(5, pidString, "\\|");
        String familyName = StringMessageParser.getValueFromStringById(6, pidString, "\\|");
        String address = StringMessageParser.getValueFromStringById(11, pidString, "\\|");
        return PID.builder()
                .messageType(StringMessageParser.getValueFromStringById(0, pidString, "\\|"))
                .id(StringMessageParser.getValueFromStringById(1, pidString, "\\|"))
                .patientId(StringMessageParser.getValueFromStringById(2, pidString, "\\|"))
                .iDNumber(new HL7IdNumber(stringIdNumber))
                .alternatePatientId(StringMessageParser.getValueFromStringById(4, pidString, "\\|"))
                .patient(new HL7Patient(strPatient))
                .familyName(new HL7FamilyName(familyName))
                .dateOfBirth(StringMessageParser.getValueFromStringById(7, pidString, "\\|"))
                .sex(StringMessageParser.getValueFromStringById(8, pidString, "\\|"))
                .alias(StringMessageParser.getValueFromStringById(9, pidString, "\\|"))
                .race(StringMessageParser.getValueFromStringById(10, pidString, "\\|"))
                .streetAddress(new HL7Address(address))
                .countryCode(StringMessageParser.getValueFromStringById(12, pidString, "\\|"))
                .homePhoneNumber(StringMessageParser.getValueFromStringById(13, pidString, "\\|"))
                .businessPhoneNumber(StringMessageParser.getValueFromStringById(14, pidString, "\\|"))
                .primaryLanguage(StringMessageParser.getValueFromStringById(15, pidString, "\\|"))
                .maritalStatus(StringMessageParser.getValueFromStringById(16, pidString, "\\|"))
                .religion(StringMessageParser.getValueFromStringById(17, pidString, "\\|"))
                .SSN(StringMessageParser.getValueFromStringById(18, pidString, "\\|"))
                .build();
    }

    @Override
    public String toString() {
        return "PID{" +
                "messageType='" + messageType + '\'' +
                ", id='" + id + '\'' +
                ", patientId='" + patientId + '\'' +
                ", iDNumber=" + iDNumber +
                ", alternatePatientId='" + alternatePatientId + '\'' +
                ", patient=" + patient +
                ", familyName=" + familyName +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", sex='" + sex + '\'' +
                ", alias='" + alias + '\'' +
                ", race='" + race + '\'' +
                ", streetAddress=" + streetAddress +
                ", countryCode='" + countryCode + '\'' +
                ", homePhoneNumber='" + homePhoneNumber + '\'' +
                ", businessPhoneNumber='" + businessPhoneNumber + '\'' +
                ", primaryLanguage='" + primaryLanguage + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", religion='" + religion + '\'' +
                ", SSN='" + SSN + '\'' +
                '}';
    }
}
