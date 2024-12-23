package org.louhan.plausex.service;

import org.louhan.plausex.xjc.*;

public interface DossierService {

    DossierType createDossier();

    // Person
    PersonType addPerson(DossierType dossierType, String vn, String officialName, String firstName, String dateOfBirth, ShsSexType sex, ShsMaritalStatusType maritalStatus, ShsSeparationType separation, String countryId, String education, String educationLevel, String employmentSituation, String employmentRate, String relationshipToApplicant, String foreignerCategoryId, String foreignerCategoryDesc, String datEntry, String personId, String personProfId);
    PersonType addPerson(DossierType dossierType);

    // AddressCorrespondence
    AddressCorrespondenceType addAddressCorrespondence(DossierType dossierType);
    AddressCorrespondenceType addAddressCorrespondence(DossierType dossierType, String organisationName, String firstName, String lastName, String street, String houseNumber, String postOfficeBox, String swissZipCode, String town);

    DossierType createDossierType(
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
            PersonsType persons);

}
