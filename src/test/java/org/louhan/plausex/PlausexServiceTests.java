package org.louhan.plausex;

import org.junit.jupiter.api.Test;
import org.louhan.plausex.service.PlausexService;
import org.louhan.plausex.xjc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class PlausexServiceTests {

    private static final Logger logger = LoggerFactory.getLogger(PlausexServiceTests.class);

    @Autowired
    protected PlausexService plausexService;

    @Test
    void createXML() throws Exception {

        try {

            Delivery delivery = this.plausexService.createDelivery();

            // dossier
            for( int i = 0; i < 5; i++ ) {

                DossierType dossier = this.addDossier(delivery);
                this.addAddressCorrespondence(dossier);

                // person
                int personsCount = (int) (Math.random() * 3);
                for( int j = 0; j < personsCount; j++ ) {
                    this.addPerson(dossier);
                }
            }

            // accounting entries
            this.addAccountingEntry(delivery);
            this.addAccountingEntry(delivery);
            this.addAccountingEntry(delivery);

            // creates XML
            File file = this.plausexService.delivery2XML(delivery, "tmp/generated-output-" + System.currentTimeMillis() + ".xml");

            // test against XSD
            String xsdPath = getClass().getClassLoader().getResource("xsd/do-b-13.05-SHS-07.xsd").getPath();
            // Assert.isTrue(this.plausexService.isValidXMLSchema(xsdPath , file.getAbsolutePath()), "XML is NOT validated");

            this.plausexService.validateXMLSchema(xsdPath, file.getAbsolutePath()).forEach(logger::warn);


        } catch (Exception e) {
            logger.error("Error occurred while generating XML", e);
            // Mark the test as failed
            fail("Test failed due to exception: " + e.getMessage(), e);
        }

    }

    /**
     * *************************************************************
     *              helpers
     * *************************************************************
     */

    private DossierType addDossier(Delivery delivery) {

        DossierType dossier = this.plausexService.addDossier(delivery,
                "12345",                   // dossierId (valid)
                "67890",                   // dossierProfId (valid)
                "Service123",              // serviceId (valid)
                "Service Description",     // serviceDescription (valid)
                null,                      // socialBenefitCode (invalid: null)
                "Valid Benefit Desc",      // socialBenefitDesc (valid)
                123,                       // municipalityId (valid)
                "Residential Status",      // residentialStatus (valid)
                null,                      // rentFullApartment (invalid: null)
                "1200",                    // rentShare (valid)
                "Large",                   // apartmentSize (valid)
                "4",                       // hhMembers (valid)
                "Closing because reason",  // closingReason (valid)
                "RESP123",                 // dossierRespPersonId (valid)
                "John Doe",                // dossierRespPersonName (valid)
                "2024-01-01",              // dateStartEntitlement (valid)
                null,        // addressCorrespondence (non-null object)
                null                    // persons (non-null object)
        );

        return dossier;

    }


    private AddressCorrespondenceType addAddressCorrespondence(DossierType dossierType) {

        AddressCorrespondenceType address = this.plausexService.addAddressCorrespondence(dossierType,
                "My Organisation",   // organisationName (valide)
                "John",              // firstName (valide)
                null,                // lastName (invalide - null)
                "Main Street",       // street (valide)
                "",                  // houseNumber (invalide - vide)
                "PO Box 123",        // postOfficeBox (valide)
                "12345",             // swissZipCode (valide)
                "Zurich"             // town (valide)
        );

        return address;

    }

    private void addPerson(DossierType dossierType) {

        PersonType person = this.plausexService.addPerson(dossierType,
                "12345",                 // vn
                "Smith",                 // officialName
                "John",                  // firstName
                "1990-01-01",            // dateOfBirth
                "M",                     // sex
                "Single",                // maritalStatus
                "No",                    // separation
                "US",                    // countryId
                "Computer Science",      // education
                "Bachelor's",            // educationLevel
                "Employed",              // employmentSituation
                "",                      // employmentRate (empty string, will not be set)
                "Self",                  // relationshipToApplicant
                null,                    // foreignerCategoryId (null, will not be set)
                "Category A1",           // foreignerCategoryDesc
                "2024-12-01",            // datEntry
                "P1001",                 // personId
                "Prof123"                // personProfId
        );
    }

    private AccountingEntryType addAccountingEntry(Delivery delivery) {

        AccountingEntryType accountingEntryType = this.plausexService.addAccountingEntry(delivery,
                "CODE123",   // Chaîne valide
                "",          // Chaîne invalide (vide)
                "1000.00",   // Chaîne valide
                null, // Date valide
                "2024-12-23", // Chaîne valide
                null,         // Chaîne invalide (nulle)
                "2024-12-31", // Chaîne valide
                "EntryID123", // Chaîne valide
                null,         // Chaîne invalide (nulle)
                "DossierID789", // Chaîne valide
                " "           // Chaîne invalide (espaces seulement)
        );

        return accountingEntryType;
    }

}
