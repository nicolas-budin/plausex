package org.louhan.plausex.service;

import org.louhan.plausex.xjc.InfosType;
import org.springframework.stereotype.Service;

@Service
public class InfosTypeServiceImpl implements InfosTypeService {

    public InfosType createInfosType() {

        InfosType infosType = new InfosType();

        infosType.setExpInfos(new InfosType.ExpInfos());
        infosType.setFfsInfos(new InfosType.FfsInfos());

        return infosType;
    }
}
