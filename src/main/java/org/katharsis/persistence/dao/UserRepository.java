package org.katharsis.persistence.dao;

import org.katharsis.persistence.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
