package org.louhan.plausex.service;

import org.louhan.plausex.xjc.PersonType;

public interface PersonService {

    PersonType createPerson();

    PersonType createPerson(
            String vn,
            String officialName,
            String firstName,
            String dateOfBirth,
            String sex,
            String maritalStatus,
            String separation,
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
