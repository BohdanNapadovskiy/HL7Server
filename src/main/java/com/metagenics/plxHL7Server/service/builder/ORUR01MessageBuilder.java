package com.metagenics.plxHL7Server.service.builder;

import com.metagenics.plxHL7Server.domain.MSH;
import com.metagenics.plxHL7Server.domain.OBR;
import com.metagenics.plxHL7Server.domain.ORUR01Message;
import com.metagenics.plxHL7Server.domain.PID;
import com.metagenics.plxHL7Server.service.StringMessageParser;

import java.util.Arrays;
import java.util.List;

public class ORUR01MessageBuilder {


    public synchronized static ORUR01Message buildOruMessage(String strMessage) {
        ORUR01Message message = new ORUR01Message();
        List<String> stringList = Arrays.asList(strMessage.split(System.lineSeparator()));
        String mshStr = StringMessageParser.getStringByMessageType("MSH|", stringList);
        if (!mshStr.isEmpty()) {
            message.setMsh(MSH.build(mshStr));
            message.setPid(PID.build(StringMessageParser.getStringByMessageType("PID|", stringList)));
            message.setObrList(OBR.build(stringList));
        }
        return message;
    }


}
