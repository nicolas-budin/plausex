package org.louhan.plausex.service;

import org.louhan.plausex.xjc.*;

import javax.xml.datatype.XMLGregorianCalendar;
import java.io.File;
import java.util.List;

public interface PlausexService {

    Delivery createDelivery();

    InfosTypeService getInfosTypeService();

    // Dossiers
    DossierType addDossier(Delivery delivery);
    DossierType addDossier(Delivery delivery, String dossierId, String dossierProfId, String serviceId, String serviceDescription, String socialBenefitCode, String socialBenefitDesc, int municipalityId, String residentialStatus, String rentFullApartment, String rentShare, String apartmentSize, String hhMembers, String closingReason, String dossierRespPersonId, String dossierRespPersonName, String dateStartEntitlement, AddressCorrespondenceType addressCorrespondence, PersonsType persons);

    // Accounting
    AccountingEntryType addAccountingEntry(Delivery delivery);
    AccountingEntryType addAccountingEntry(Delivery delivery, String accountingEntryCode, String accountingEntryCodeDesc, String amount, XMLGregorianCalendar datRegistration, String datAccountingEntry, String datSubjectFrom, String datSubjectTo, String accountingEntryId, String accountingEntryProfId, String dossierIdRef, String personIdRef);

    // Person
    PersonType addPerson(DossierType dossierType, String vn, String officialName, String firstName, String dateOfBirth, ShsSexType sex, ShsMaritalStatusType maritalStatus, ShsSeparationType separation, String countryId, String education, String educationLevel, String employmentSituation, String employmentRate, String relationshipToApplicant, String foreignerCategoryId, String foreignerCategoryDesc, String datEntry, String personId, String personProfId);
    PersonType addPerson(DossierType dossierType);

    // AddressCorrespondence
    AddressCorrespondenceType addAddressCorrespondence(DossierType dossierType);
    AddressCorrespondenceType addAddressCorrespondence(DossierType dossierType, String organisationName, String firstName, String lastName, String street, String houseNumber, String postOfficeBox, String swissZipCode, String town);


    File delivery2XML(Delivery delivery, String path) throws Exception;

    boolean isValidXMLSchema(String xsdPath, String xmlPath);

    List<String> validateXMLSchema(String xsdPath, String xmlPath);
}
