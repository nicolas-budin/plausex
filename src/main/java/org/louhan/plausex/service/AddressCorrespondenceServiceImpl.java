package org.louhan.plausex.service;

import org.louhan.plausex.utils.StringUtils;
import org.louhan.plausex.xjc.AddressCorrespondenceType;
import org.springframework.stereotype.Service;

@Service
public class AddressCorrespondenceServiceImpl implements AddressCorrespondenceService {


    @Override
    public AddressCorrespondenceType createAddressCorrespondence() {
        AddressCorrespondenceType addressCorrespondence = new AddressCorrespondenceType();
        return addressCorrespondence;
    }

    @Override
    public AddressCorrespondenceType  createAddressCorrespondence(
            String organisationName,
            String firstName,
            String lastName,
            String street,
            String houseNumber,
            String postOfficeBox,
            String swissZipCode,
            String town) {

        AddressCorrespondenceType addressCorrespondence = new AddressCorrespondenceType();

        if (StringUtils.isValidString(organisationName)) {
            addressCorrespondence.setOrganisationName(organisationName);
        }
        if (StringUtils.isValidString(firstName)) {
            addressCorrespondence.setFirstName(firstName);
        }
        if (StringUtils.isValidString(lastName)) {
            addressCorrespondence.setLastName(lastName);
        }
        if (StringUtils.isValidString(street)) {
            addressCorrespondence.setStreet(street);
        }
        if (StringUtils.isValidString(houseNumber)) {
            addressCorrespondence.setHouseNumber(houseNumber);
        }
        if (StringUtils.isValidString(postOfficeBox)) {
            addressCorrespondence.setPostOfficeBox(postOfficeBox);
        }
        if (StringUtils.isValidString(swissZipCode)) {
            addressCorrespondence.setSwissZipCode(swissZipCode);
        }
        if (StringUtils.isValidString(town)) {
            addressCorrespondence.setTown(town);
        }

        return addressCorrespondence;
    }
}
