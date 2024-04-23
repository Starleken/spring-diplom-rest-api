package com.example.DiplomRestApi.core.utils.entity;

import com.example.DiplomRestApi.core.utils.FakerUtils;
import com.example.DiplomRestApi.entity.PersonEntity;

import static com.example.DiplomRestApi.core.utils.FakerUtils.FAKER;

public abstract class PersonEntityUtils {

    public static PersonEntity generatePerson() {
        var person = new PersonEntity();
        person.setName(FAKER.name().name());
        person.setSurname(FAKER.name().lastName());
        person.setPatronymic(FAKER.name().suffix());

        return person;
    }
}
