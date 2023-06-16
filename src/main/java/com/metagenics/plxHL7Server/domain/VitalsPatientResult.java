package com.metagenics.plxHL7Server.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VitalsPatientResult {

    private String patientId;
    private String pulseRate;
    private String systolicPressure;
    private String diastolicPressure;
    private String meanPressure;
    private String bodyTemp;

    public VitalsPatientResult(ORUR01Message orur01Message) {
        this.patientId = orur01Message.getPid().getIDNumber().getIDNumber();
        List<OBR> obrList = orur01Message.getObrList();
        obrList.forEach(
                obr -> {
                    List<OBX> obxResult = obr.getObxList();
                    obxResult
                            .forEach(obx -> {
                                if (obx.getConceptId().getTextDescription().equalsIgnoreCase("MDC_PRESS_CUFF_SYS")) {
                                    this.systolicPressure = obx.getValue().getValue();
                                } else if (obx.getConceptId().getTextDescription().equalsIgnoreCase("MDC_PRESS_CUFF_DIA")) {
                                    this.diastolicPressure = obx.getValue().getValue();
                                } else if (obx.getConceptId().getTextDescription().equalsIgnoreCase("MDC_PRESS_CUFF_MEAN")) {
                                    this.meanPressure = obx.getValue().getValue();
                                } else if (obx.getConceptId().getTextDescription().equalsIgnoreCase("MDC_PULS_RATE")) {
                                    this.pulseRate = obx.getValue().getValue();
                                } else if (obx.getConceptId().getTextDescription().equalsIgnoreCase("MDC_TEMP_SKIN")) {
                                    this.bodyTemp = obx.getValue().getValue();
                                }
                            });
                });
    }
}
