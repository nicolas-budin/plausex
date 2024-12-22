package org.louhan.plausex.service;

import org.louhan.plausex.xjc.PersonType;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    public PersonServiceImpl() {
    }

    public PersonType createPerson() {

        PersonType personType = new PersonType();
        return personType;
    }
}
