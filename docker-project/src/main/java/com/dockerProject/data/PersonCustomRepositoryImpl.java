package com.dockerProject.data;

import com.dockerProject.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class PersonCustomRepositoryImpl implements PersonCustomRepository{

    private final MongoTemplate mongoTemplate;

    @Autowired
    public PersonCustomRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Person savePerson(Person person) {
        return mongoTemplate.save(person);
    }
}
