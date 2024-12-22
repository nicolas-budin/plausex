package org.louhan.plausex;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import org.junit.jupiter.api.Test;
import org.louhan.plausex.service.PlausexService;
import org.louhan.plausex.xjc.Delivery;
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

            JAXBContext context = JAXBContext.newInstance(Delivery.class);
            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(delivery, new File("tmp/generated-output.xml"));

            logger.info("XML generated successfully!"); // Replaced System.out.println

        } catch (Exception e) {
            logger.error("Error occurred while generating XML", e); // Log error details
        }


    }

}
