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
public class MedicalObservation {
    private String identifier;
    private String text;
    private String nameOfCodingSystem;

    public MedicalObservation(String medicalObservation) {
        this.identifier = StringMessageParser.getValueFromStringById(0, medicalObservation, "\\^");
        this.text = StringMessageParser.getValueFromStringById(1, medicalObservation, "\\^");
        this.nameOfCodingSystem = StringMessageParser.getValueFromStringById(2, medicalObservation, "\\^");
    }

    @Override
    public String toString() {
        return "MedicalObservation{" +
                "identifier='" + identifier + '\'' +
                ", text='" + text + '\'' +
                ", nameOfCodingSystem='" + nameOfCodingSystem + '\'' +
                '}';
    }
}
