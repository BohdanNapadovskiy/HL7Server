package com.metagenics.plxHL7Server.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringMessageParser {


    public static String getStringByMessageType(String type, List<String> stringList) {
        return stringList.stream()
                .filter(str -> str.startsWith(type))
                .findAny()
                .orElse("");
    }

    public static String getValueFromStringById(int i, String mshStr, String separator) {
        List<String> splittedString = Arrays.stream(mshStr.split(separator)).collect(Collectors.toList());
        String result = "";
        if (splittedString.size() > i) {
            result = splittedString.get(i);
        }
        return result;
    }

    public static String getComponentValues(int i, String mshStr) {
        return getValueFromStringById(i, mshStr, "\\|");
    }


}
