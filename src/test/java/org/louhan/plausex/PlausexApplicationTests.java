package org.louhan.plausex;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import org.junit.jupiter.api.Test;
import org.louhan.xjc.Delivery;
import org.louhan.xjc.InfosType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
class PlausexApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(PlausexApplicationTests.class);

    @Test
    void contextLoads() {
    }


    @Test
    void createHelloWorldXML() throws Exception {


        try {

            Delivery delivery = new Delivery();

            delivery.setInfos(new InfosType());

            InfosType infosType = delivery.getInfos();

            infosType.setExpInfos(new InfosType.ExpInfos());
            infosType.setFfsInfos(new InfosType.FfsInfos());

            infosType.getFfsInfos().setFfsVersion("1234567890");


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
