package org.louhan.plausex.service;

import org.louhan.plausex.xjc.AddressCorrespondenceType;
import org.springframework.stereotype.Service;

@Service
public class AddressCorrespondenceServiceImpl implements AddressCorrespondenceService {


    @Override
    public AddressCorrespondenceType createAddressCorrespondence() {
        AddressCorrespondenceType addressCorrespondence = new AddressCorrespondenceType();
        return addressCorrespondence;
    }
}
