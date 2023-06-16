package com.metagenics.plxHL7Server.domain;

import com.metagenics.plxHL7Server.service.StringMessageParser;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OBR {
    private String messageType;
    private String setId;
    private String placerOrderNumber;
    private String fillerOrderNumber;
    private MedicalObservation medicalObservation;
    private String priority;
    private String requestedDateTime;
    private String observationDateTime;
    private List<OBX> obxList = new ArrayList<>();

    public static List<OBR> build(List<String> stringList) {
        List<OBR> obrList = new ArrayList<>();
        stringList.stream()
                .filter(str -> str.contains("OBR|") || str.contains("OBX|"))
                .forEach(str -> {
                    if (str.contains("OBR|")) {
                        OBR obr = new OBR();
                        obr.updateFromMessage(str);
                        obrList.add(obr);
                    } else addOBX(obrList.get(obrList.size() - 1), str);
                });
        return obrList;
    }

    private static void addOBX(OBR obr, String str) {
        List<OBX> obxList = obr.getObxList();
        OBX obx = new OBX(str);
        obxList.add(obx);


    }

    private void updateFromMessage(String str) {
        String medicalObservation = StringMessageParser.getValueFromStringById(4, str, "\\|");
        this.messageType = StringMessageParser.getValueFromStringById(0, str, "\\|");
        this.setId = StringMessageParser.getValueFromStringById(1, str, "\\|");
        this.placerOrderNumber = StringMessageParser.getValueFromStringById(2, str, "\\|");
        this.fillerOrderNumber = StringMessageParser.getValueFromStringById(3, str, "\\|");
        this.medicalObservation = new MedicalObservation(medicalObservation);
        this.priority = StringMessageParser.getValueFromStringById(5, str, "\\|");
        this.requestedDateTime = StringMessageParser.getValueFromStringById(6, str, "\\|");
        this.observationDateTime = StringMessageParser.getValueFromStringById(7, str, "\\|");
    }

    @Override
    public String toString() {
        return "OBR{" +
                "messageType='" + messageType + '\'' +
                ", setId='" + setId + '\'' +
                ", placerOrderNumber='" + placerOrderNumber + '\'' +
                ", fillerOrderNumber='" + fillerOrderNumber + '\'' +
                ", medicalObservation=" + medicalObservation +
                ", priority='" + priority + '\'' +
                ", requestedDateTime='" + requestedDateTime + '\'' +
                ", observationDateTime='" + observationDateTime + '\'' +
                ", obxList=" + obxList +
                '}';
    }
}
