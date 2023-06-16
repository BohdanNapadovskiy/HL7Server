package com.metagenics.plxHL7Server.service.amazon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlxMessage {

    String source;
    String destination;
    String type;
    Map<String, Object> payloadMap = new HashMap<>();

}
