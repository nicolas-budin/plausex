package org.louhan.plausex.service;

import org.louhan.plausex.utils.StringUtils;
import org.louhan.plausex.xjc.PersonType;
import org.louhan.plausex.xjc.ShsMaritalStatusType;
import org.louhan.plausex.xjc.ShsSeparationType;
import org.louhan.plausex.xjc.ShsSexType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    private static final Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);

    public PersonServiceImpl() {
    }

    public PersonType createPerson() {

        PersonType personType = new PersonType();
        return personType;
    }

    @Override
    public PersonType createPerson(
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
            String personProfId) {

        PersonType personType = this.createPerson();

        // Perform validation to ensure fields are not empty or null before setting them
        if (StringUtils.isValidString(vn)) personType.setVn(vn);
        if (StringUtils.isValidString(officialName)) personType.setOfficialName(officialName);
        if (StringUtils.isValidString(firstName)) personType.setFirstName(firstName);
        if (StringUtils.isValidString(dateOfBirth)) personType.setDateOfBirth(dateOfBirth);
        personType.setSex(sex);
        personType.setMaritalStatus(maritalStatus);
        personType.setSeparation(separation);
        if (StringUtils.isValidString(countryId)) personType.setCountryId(countryId);
        if (StringUtils.isValidString(education)) personType.setEducation(education);
        if (StringUtils.isValidString(educationLevel)) personType.setEducationLevel(educationLevel);
        if (StringUtils.isValidString(employmentSituation)) personType.setEmploymentSituation(employmentSituation);
        if (StringUtils.isValidString(employmentRate)) personType.setEmploymentRate(employmentRate);
        if (StringUtils.isValidString(relationshipToApplicant)) personType.setRelationshipToApplicant(relationshipToApplicant);
        if (StringUtils.isValidString(foreignerCategoryId)) personType.setForeignerCategoryId(foreignerCategoryId);
        if (StringUtils.isValidString(foreignerCategoryDesc)) personType.setForeignerCategoryDesc(foreignerCategoryDesc);
        if (StringUtils.isValidString(datEntry)) personType.setDatEntry(datEntry);
        if (StringUtils.isValidString(personId)) personType.setPersonId(personId);
        if (StringUtils.isValidString(personProfId)) personType.setPersonProfId(personProfId);

        logger.debug(this.toString(personType));

        return personType;
    }

    @Override
    public String toString(PersonType person) {
        if (person == null) {
            return "PersonType is null";
        }

        return "PersonType {" +
                "vn='" + person.getVn() + '\'' +
                ", officialName='" + person.getOfficialName() + '\'' +
                ", firstName='" + person.getFirstName() + '\'' +
                ", dateOfBirth='" + person.getDateOfBirth() + '\'' +
                ", sex='" + person.getSex() + '\'' +
                ", maritalStatus='" + person.getMaritalStatus() + '\'' +
                ", separation='" + person.getSeparation() + '\'' +
                ", countryId='" + person.getCountryId() + '\'' +
                ", education='" + person.getEducation() + '\'' +
                ", educationLevel='" + person.getEducationLevel() + '\'' +
                ", employmentSituation='" + person.getEmploymentSituation() + '\'' +
                ", employmentRate='" + person.getEmploymentRate() + '\'' +
                ", relationshipToApplicant='" + person.getRelationshipToApplicant() + '\'' +
                ", foreignerCategoryId='" + person.getForeignerCategoryId() + '\'' +
                ", foreignerCategoryDesc='" + person.getForeignerCategoryDesc() + '\'' +
                ", datEntry='" + person.getDatEntry() + '\'' +
                ", personId='" + person.getPersonId() + '\'' +
                ", personProfId='" + person.getPersonProfId() + '\'' +
                '}';
    }


}


