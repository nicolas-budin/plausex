package org.louhan.plausex.service;


import org.louhan.plausex.xjc.AccountingEntriesType;
import org.louhan.plausex.xjc.Delivery;
import org.louhan.plausex.xjc.DossiersType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PlausexServiceImpl implements PlausexService {

    protected DossierService dossierService;
    protected AccountingEntryService accountingEntryService;
    protected InfosTypeService infosTypeService;

    @Autowired
    public PlausexServiceImpl(DossierService dossierService,
                              AccountingEntryService accountingEntryService,
                              InfosTypeService infosTypeService) {

        this.dossierService = dossierService;
        this.accountingEntryService = accountingEntryService;
        this.infosTypeService = infosTypeService;
    }

    @Override
    public Delivery createDelivery() {

        Delivery delivery = new Delivery();

        // info stuff
        delivery.setInfos(this.infosTypeService.createInfosType());

        // dossier stuff
        delivery.setDossiers(new DossiersType());

        // accounting
        delivery.setAccountingEntries(new AccountingEntriesType());

        return delivery;
    }


    @Override
    public DossierService getDossierService() {
        return dossierService;
    }

    @Override
    public AccountingEntryService getAccountingEntryService() {
        return accountingEntryService;
    }

    @Override
    public InfosTypeService getInfosTypeService() {
        return infosTypeService;
    }
}
