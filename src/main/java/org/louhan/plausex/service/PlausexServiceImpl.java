package org.louhan.plausex.service;


import org.louhan.plausex.xjc.AccountingEntriesType;
import org.louhan.plausex.xjc.Delivery;
import org.louhan.plausex.xjc.DossiersType;
import org.louhan.plausex.xjc.InfosType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PlausexServiceImpl implements PlausexService {

    protected DossierService dossierService;
    protected AccountingEntryService accountingEntryService;
    protected PersonService personService;

    @Autowired
    public PlausexServiceImpl(DossierService dossierService,
                              AccountingEntryService accountingEntryService,
                              PersonService personService) {
        this.dossierService = dossierService;
        this.accountingEntryService = accountingEntryService;
        this.personService = personService;
    }

    @Override
    public Delivery createDelivery() {

        Delivery delivery = new Delivery();

        // info stuff
        delivery.setInfos(new InfosType());
        InfosType infosType = delivery.getInfos();

        infosType.setExpInfos(new InfosType.ExpInfos());
        infosType.setFfsInfos(new InfosType.FfsInfos());

        // dossier stuff
        delivery.setDossiers(new DossiersType());

        // accounting
        delivery.setAccountingEntries(new AccountingEntriesType());

        return delivery;
    }


}
