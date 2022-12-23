package com.dockerProject.data;

import com.dockerProject.dto.Person;

public interface PersonCustomRepository {

    public Person savePerson(Person person);
}
