package org.katharsis.persistence.dao;

import org.katharsis.persistence.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {

}
