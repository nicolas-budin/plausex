package org.louhan.plausex.service;

import org.louhan.plausex.xjc.InfosType;
import org.louhan.plausex.xjc.ShsIsProdType;

import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;

public interface InfosTypeService {

    InfosType createInfosType();

    void setAllVariables(InfosType infosType,
                         BigInteger ffsId,
                         String ffsVersion,
                         BigInteger supplierId,
                         XMLGregorianCalendar extractionDateTime,
                         XMLGregorianCalendar referenceDate,
                         ShsIsProdType isProd);
}
