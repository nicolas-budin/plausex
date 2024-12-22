package org.louhan.plausex.service;

import org.louhan.plausex.xjc.AddressCorrespondenceType;
import org.louhan.plausex.xjc.DossierType;
import org.louhan.plausex.xjc.PersonsType;
import org.springframework.stereotype.Service;

@Service
public class DossierServiceImpl implements DossierService {

    public DossierServiceImpl() {
    }

    @Override
    public DossierType createDossier() {

        DossierType dossier = new DossierType();

        dossier.setAddressCorrespondence(new AddressCorrespondenceType());
        dossier.setPersons(new PersonsType());

        return dossier;
    }
}
