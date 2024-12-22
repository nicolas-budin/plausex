package org.louhan.plausex;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import org.junit.jupiter.api.Test;
import org.louhan.plausex.service.DossierService;
import org.louhan.plausex.service.PlausexService;
import org.louhan.plausex.xjc.Delivery;
import org.louhan.plausex.xjc.DossierType;
import org.louhan.plausex.xjc.PersonType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
class PlausexServiceTests {

    private static final Logger logger = LoggerFactory.getLogger(PlausexServiceTests.class);

    @Autowired
    protected PlausexService plausexService;

    @Test
    void createHelloWorldXML() throws Exception {

        try {

            Delivery delivery = this.plausexService.createDelivery();

            // dossier
            DossierType dossier = this.plausexService.getDossierService().createDossier();
            delivery.getDossiers().getDossier().add(dossier);
            this.addPerson(this.plausexService.getDossierService(), dossier);

            JAXBContext context = JAXBContext.newInstance(Delivery.class);
            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(delivery, new File("tmp/generated-output.xml"));

            logger.info("XML generated successfully!"); // Replaced System.out.println

        } catch (Exception e) {
            logger.error("Error occurred while generating XML", e); // Log error details
        }


    }


    private void addPerson(DossierService dossierService, DossierType dossierType) {

        PersonType person = dossierService.createPerson(dossierType,
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

}
