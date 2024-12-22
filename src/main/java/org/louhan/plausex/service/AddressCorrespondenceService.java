package org.louhan.plausex.service;

import org.louhan.plausex.xjc.AddressCorrespondenceType;

public interface AddressCorrespondenceService {

    AddressCorrespondenceType createAddressCorrespondence();

    AddressCorrespondenceType  createAddressCorrespondence(
            String organisationName,
            String firstName,
            String lastName,
            String street,
            String houseNumber,
            String postOfficeBox,
            String swissZipCode,
            String town);
}
