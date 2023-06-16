package com.metagenics.plxHL7Server.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ORUR01Message {

    private MSH msh;
    private PID pid;
    private List<OBR> obrList;

    @Override
    public String toString() {
        return "ORUR01Message{" +
                "msh=" + msh +
                ", pid=" + pid +
                ", obrList=" + obrList +
                '}';
    }
}
