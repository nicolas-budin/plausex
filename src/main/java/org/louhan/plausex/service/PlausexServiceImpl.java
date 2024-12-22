package org.louhan.plausex.service;


import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import org.louhan.plausex.xjc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;


@Service
public class PlausexServiceImpl implements PlausexService {

    private static final Logger logger = LoggerFactory.getLogger(PlausexServiceImpl.class);



    protected DossierService dossierService;
    protected AccountingEntryService accountingEntryService;
    protected InfosTypeService infosTypeService;

    @Autowired
    public PlausexServiceImpl(DossierService dossierService,
                              AccountingEntryService accountingEntryService,
                              InfosTypeService infosTypeService) {

        this.dossierService = dossierService;
        this.accountingEntryService = accountingEntryService;
        this.infosTypeService = infosTypeService;
    }

    @Override
    public Delivery createDelivery() {

        Delivery delivery = new Delivery();

        // info stuff
        delivery.setInfos(this.infosTypeService.createInfosType());

        // dossier stuff
        delivery.setDossiers(new DossiersType());

        // accounting
        delivery.setAccountingEntries(new AccountingEntriesType());

        return delivery;
    }

    @Override
    public InfosTypeService getInfosTypeService() {
        return infosTypeService;
    }

    @Override
    public DossierType addDossier(Delivery delivery, String dossierId, String dossierProfId, String serviceId, String serviceDescription, String socialBenefitCode, String socialBenefitDesc, int municipalityId, String residentialStatus, String rentFullApartment, String rentShare, String apartmentSize, String hhMembers, String closingReason, String dossierRespPersonId, String dossierRespPersonName, String dateStartEntitlement, AddressCorrespondenceType addressCorrespondence, PersonsType persons) {

        DossierType dossierType =  dossierService.createDossierType(dossierId, dossierProfId, serviceId, serviceDescription, socialBenefitCode, socialBenefitDesc, municipalityId, residentialStatus, rentFullApartment, rentShare, apartmentSize, hhMembers, closingReason, dossierRespPersonId, dossierRespPersonName, dateStartEntitlement, addressCorrespondence, persons);
        delivery.getDossiers().getDossier().add(dossierType);
        return dossierType;
    }

    @Override
    public DossierType addDossier(Delivery delivery) {

        DossierType dossierType =   dossierService.createDossier();
        delivery.getDossiers().getDossier().add(dossierType);
        return dossierType;
    }

    @Override
    public AccountingEntryType addAccountingEntry(Delivery delivery) {

        AccountingEntryType accountingEntryType =  this.accountingEntryService.createAccountingEntry();
        delivery.getAccountingEntries().getAccountingEntry().add(accountingEntryType);
        return accountingEntryType;
    }

    @Override
    public AccountingEntryType addAccountingEntry(Delivery delivery, String accountingEntryCode, String accountingEntryCodeDesc, String amount, XMLGregorianCalendar datRegistration, String datAccountingEntry, String datSubjectFrom, String datSubjectTo, String accountingEntryId, String accountingEntryProfId, String dossierIdRef, String personIdRef) {

        AccountingEntryType accountingEntryType =   this.accountingEntryService.createAccountingEntryType(accountingEntryCode, accountingEntryCodeDesc, amount, datRegistration, datAccountingEntry, datSubjectFrom, datSubjectTo, accountingEntryId, accountingEntryProfId, dossierIdRef, personIdRef);
        delivery.getAccountingEntries().getAccountingEntry().add(accountingEntryType);
        return accountingEntryType;
    }


    @Override
    public PersonType addPerson(DossierType dossierType, String vn, String officialName, String firstName, String dateOfBirth, String sex, String maritalStatus, String separation, String countryId, String education, String educationLevel, String employmentSituation, String employmentRate, String relationshipToApplicant, String foreignerCategoryId, String foreignerCategoryDesc, String datEntry, String personId, String personProfId) {
        PersonType personType = this.dossierService.addPerson(dossierType, vn, officialName, firstName, dateOfBirth, sex, maritalStatus, separation, countryId, education, educationLevel, employmentSituation, employmentRate, relationshipToApplicant, foreignerCategoryId, foreignerCategoryDesc, datEntry, personId, personProfId);
        dossierType.getPersons().getPerson().add(personType);
        return personType;

    }

    @Override
    public PersonType addPerson(DossierType dossierType) {
        PersonType personType =  this.dossierService.addPerson(dossierType);
        dossierType.getPersons().getPerson().add(personType);
        return personType;
    }

    @Override
    public AddressCorrespondenceType addAddressCorrespondence(DossierType dossierType) {
        AddressCorrespondenceType addressCorrespondenceType = this.dossierService.addAddressCorrespondence(dossierType);
        dossierType.setAddressCorrespondence(addressCorrespondenceType);
        return addressCorrespondenceType;
    }

    @Override
    public AddressCorrespondenceType addAddressCorrespondence(DossierType dossierType, String organisationName, String firstName, String lastName, String street, String houseNumber, String postOfficeBox, String swissZipCode, String town) {
        AddressCorrespondenceType addressCorrespondenceType =  this.dossierService.addAddressCorrespondence(dossierType, organisationName, firstName, lastName, street, houseNumber, postOfficeBox, swissZipCode, town);
        dossierType.setAddressCorrespondence(addressCorrespondenceType);
        return addressCorrespondenceType;
    }


    @Override
    public File delivery2XML(Delivery delivery, String path) throws Exception {

        try {

            if (path == null || path.isEmpty()) {
                throw new Exception("arguments cannot be null : " );
            }

            JAXBContext context = JAXBContext.newInstance(Delivery.class);
            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            // Add schema location to add `xmlns:xsi` and `xsi:schemaLocation`
            marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://bfs.ch/shs/delivery/validation xsd/do-b-13.05-SHS-07.xsd");

            File file = new File(path);
            marshaller.marshal(delivery, file);

            logger.info("XML generated in file" + path);

            return file;

        } catch (Exception e) {
            logger.error("Failed to generate XML in file " + path, e);
            throw e;
        }
    }


    @Override
    public boolean validateXMLSchema(String xsdPath, String xmlPath) {
        try {
            // Create a SchemaFactory for W3C XML Schema
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            // Load the XSD file as a schema
            Schema schema = factory.newSchema(new File(xsdPath));

            // Create a Validator from the schema
            Validator validator = schema.newValidator();

            // Validate the XML file against the schema
            validator.validate(new StreamSource(new File(xmlPath)));
            return true;
        } catch (SAXException e) {
            logger.error("Validation SAXException: " + e.getMessage());
            return false;
        } catch (Exception e) {
            logger.error("Validation Error: " + e.getMessage());
            return false;
        }
    }
}
