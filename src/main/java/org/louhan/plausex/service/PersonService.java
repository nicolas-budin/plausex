package org.louhan.plausex.service;

import org.louhan.plausex.xjc.PersonType;
import org.louhan.plausex.xjc.ShsMaritalStatusType;
import org.louhan.plausex.xjc.ShsSeparationType;
import org.louhan.plausex.xjc.ShsSexType;

public interface PersonService {

    PersonType createPerson();

    PersonType createPerson(
            String vn,
            String officialName,
            String firstName,
            String dateOfBirth,
            ShsSexType sex,
            ShsMaritalStatusType maritalStatus,
            ShsSeparationType separation,
            String countryId,
            String education,
            String educationLevel,
            String employmentSituation,
            String employmentRate,
            String relationshipToApplicant,
            String foreignerCategoryId,
            String foreignerCategoryDesc,
            String datEntry,
            String personId,
            String personProfId);


    String toString(PersonType person);
}
