package org.louhan.plausex.service;

import org.louhan.plausex.xjc.AddressCorrespondenceType;
import org.louhan.plausex.xjc.DossierType;
import org.louhan.plausex.xjc.PersonType;
import org.louhan.plausex.xjc.PersonsType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DossierServiceImpl implements DossierService {

    private static final Logger logger = LoggerFactory.getLogger(DossierServiceImpl.class);

    protected PersonService personService;
    protected AddressCorrespondenceService addressCorrespondenceService;

    @Autowired
    public DossierServiceImpl(PersonService personService,
                              AddressCorrespondenceService addressCorrespondenceService) {
        this.personService = personService;
        this.addressCorrespondenceService = addressCorrespondenceService;
    }

    @Override
    public DossierType createDossier() {

        DossierType dossier = new DossierType();

        dossier.setAddressCorrespondence(new AddressCorrespondenceType());
        dossier.setPersons(new PersonsType());

        return dossier;
    }

    @Override
    public PersonType createPerson(DossierType dossierType, String vn, String officialName, String firstName, String dateOfBirth, String sex, String maritalStatus, String separation, String countryId, String education, String educationLevel, String employmentSituation, String employmentRate, String relationshipToApplicant, String foreignerCategoryId, String foreignerCategoryDesc, String datEntry, String personId, String personProfId) {

        PersonType personType =  personService.createPerson(vn, officialName, firstName, dateOfBirth, sex, maritalStatus, separation, countryId, education, educationLevel, employmentSituation, employmentRate, relationshipToApplicant, foreignerCategoryId, foreignerCategoryDesc, datEntry, personId, personProfId);
        dossierType.getPersons().getPerson().add(personType);

        return personType;
    }

    @Override
    public PersonType createPerson(DossierType dossierType) {
        PersonType personType =   personService.createPerson();
        dossierType.getPersons().getPerson().add(personType);

        return personType;
    }
}
