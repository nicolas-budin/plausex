package org.louhan.plausex.service;

import org.louhan.plausex.xjc.DossierType;
import org.louhan.plausex.xjc.PersonType;

public interface DossierService {

    DossierType createDossier();

    PersonType createPerson(DossierType dossierType, String vn, String officialName, String firstName, String dateOfBirth, String sex, String maritalStatus, String separation, String countryId, String education, String educationLevel, String employmentSituation, String employmentRate, String relationshipToApplicant, String foreignerCategoryId, String foreignerCategoryDesc, String datEntry, String personId, String personProfId);

    PersonType createPerson(DossierType dossierType);

}
