package com.dockerProject.data;

import com.dockerProject.dto.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String>, PersonCustomRepository {
}
