package org.louhan.plausex.service;

import org.louhan.plausex.utils.StringUtils;
import org.louhan.plausex.xjc.InfosType;
import org.louhan.plausex.xjc.ShsIsProdType;
import org.springframework.stereotype.Service;

import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;

@Service
public class InfosTypeServiceImpl implements InfosTypeService {

    public InfosType createInfosType() {

        InfosType infosType = new InfosType();

        infosType.setExpInfos(new InfosType.ExpInfos());
        infosType.setFfsInfos(new InfosType.FfsInfos());

        return infosType;
    }


    @Override
    public void setAllVariables(InfosType infosType,
                                BigInteger ffsId,
                                String ffsVersion,
                                BigInteger supplierId,
                                XMLGregorianCalendar extractionDateTime,
                                XMLGregorianCalendar referenceDate,
                                ShsIsProdType isProd) {
        // Initialize FfsInfos and set values only if the parameters are valid
        if (ffsId != null) {
            infosType.getFfsInfos().setFfsId(ffsId);
        }
        if (StringUtils.isValidString(ffsVersion)) {
            infosType.getFfsInfos().setFfsVersion(ffsVersion);
        }

        // Initialize ExpInfos and set values only if the parameters are valid
        if (supplierId != null) {
            infosType.getExpInfos().setSupplierId(supplierId);
        }
        if (extractionDateTime != null) {
            infosType.getExpInfos().setExtractionDateTime(extractionDateTime);
        }
        if (referenceDate != null) {
            infosType.getExpInfos().setReferenceDate(referenceDate);
        }
        if (isProd != null) {
            infosType.getExpInfos().setIsProd(isProd);
        }
    }
}
