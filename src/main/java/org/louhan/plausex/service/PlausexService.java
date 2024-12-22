package org.louhan.plausex.service;

import org.louhan.plausex.xjc.Delivery;

public interface PlausexService {

    Delivery createDelivery();


    DossierService getDossierService();
    AccountingEntryService getAccountingEntryService();
    InfosTypeService getInfosTypeService();
}
