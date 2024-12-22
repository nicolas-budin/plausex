package org.louhan.plausex.service;

import org.louhan.plausex.utils.StringUtils;
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
    public PersonType addPerson(DossierType dossierType, String vn, String officialName, String firstName, String dateOfBirth, String sex, String maritalStatus, String separation, String countryId, String education, String educationLevel, String employmentSituation, String employmentRate, String relationshipToApplicant, String foreignerCategoryId, String foreignerCategoryDesc, String datEntry, String personId, String personProfId) {

        PersonType personType =  personService.createPerson(vn, officialName, firstName, dateOfBirth, sex, maritalStatus, separation, countryId, education, educationLevel, employmentSituation, employmentRate, relationshipToApplicant, foreignerCategoryId, foreignerCategoryDesc, datEntry, personId, personProfId);
        dossierType.getPersons().getPerson().add(personType);

        return personType;
    }

    @Override
    public PersonType addPerson(DossierType dossierType) {
        PersonType personType =   personService.createPerson();
        dossierType.getPersons().getPerson().add(personType);

        return personType;
    }


    @Override
    public AddressCorrespondenceType addAddressCorrespondence(DossierType dossierType) {
        AddressCorrespondenceType addressCorrespondenceType =  addressCorrespondenceService.createAddressCorrespondence();
        dossierType.setAddressCorrespondence(addressCorrespondenceType);
        return addressCorrespondenceType;
    }

    @Override
    public AddressCorrespondenceType addAddressCorrespondence(DossierType dossierType, String organisationName, String firstName, String lastName, String street, String houseNumber, String postOfficeBox, String swissZipCode, String town) {
        AddressCorrespondenceType addressCorrespondenceType =   addressCorrespondenceService.createAddressCorrespondence(organisationName, firstName, lastName, street, houseNumber, postOfficeBox, swissZipCode, town);
        dossierType.setAddressCorrespondence(addressCorrespondenceType);
        return addressCorrespondenceType;
    }

    @Override
    public DossierType createDossierType(
            String dossierId,
            String dossierProfId,
            String serviceId,
            String serviceDescription,
            String socialBenefitCode,
            String socialBenefitDesc,
            int municipalityId,
            String residentialStatus,
            String rentFullApartment,
            String rentShare,
            String apartmentSize,
            String hhMembers,
            String closingReason,
            String dossierRespPersonId,
            String dossierRespPersonName,
            String dateStartEntitlement,
            AddressCorrespondenceType addressCorrespondence,
            PersonsType persons) {

        DossierType dossier = this.createDossier();

        // Validate and set string attributes
        if (StringUtils.isValidString(dossierId)) {
            dossier.setDossierId(dossierId);
        }
        if (StringUtils.isValidString(dossierProfId)) {
            dossier.setDossierProfId(dossierProfId);
        }

        // Set other fields based on validation
        if (StringUtils.isValidString(serviceId)) {
            dossier.setServiceId(serviceId);
        }
        if (StringUtils.isValidString(serviceDescription)) {
            dossier.setServiceDescription(serviceDescription);
        }
        if (StringUtils.isValidString(socialBenefitCode)) {
            dossier.setSocialBenefitCode(socialBenefitCode);
        }
        if (StringUtils.isValidString(socialBenefitDesc)) {
            dossier.setSocialBenefitDesc(socialBenefitDesc);
        }
        dossier.setMunicipalityId(municipalityId); // Integer, no validation for it.

        if (StringUtils.isValidString(residentialStatus)) {
            dossier.setResidentialStatus(residentialStatus);
        }
        if (StringUtils.isValidString(rentFullApartment)) {
            dossier.setRentFullApartment(rentFullApartment);
        }
        if (StringUtils.isValidString(rentShare)) {
            dossier.setRentShare(rentShare);
        }
        if (StringUtils.isValidString(apartmentSize)) {
            dossier.setApartmentSize(apartmentSize);
        }
        if (StringUtils.isValidString(hhMembers)) {
            dossier.setHhMembers(hhMembers);
        }
        if (StringUtils.isValidString(closingReason)) {
            dossier.setClosingReason(closingReason);
        }
        if (StringUtils.isValidString(dossierRespPersonId)) {
            dossier.setDossierRespPersonId(dossierRespPersonId);
        }
        if (StringUtils.isValidString(dossierRespPersonName)) {
            dossier.setDossierRespPersonName(dossierRespPersonName);
        }
        if (StringUtils.isValidString(dateStartEntitlement)) {
            dossier.setDateStartEntitlement(dateStartEntitlement);
        }

        // Validate and set object attributes
        if (addressCorrespondence != null) {
            dossier.setAddressCorrespondence(addressCorrespondence);
        }
        if (persons != null) {
            dossier.setPersons(persons);
        }

        return dossier;
    }

}
