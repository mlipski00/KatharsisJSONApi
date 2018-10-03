package org.katharsis.service;

import org.katharsis.persistence.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService extends IOperations {

    Page<User> findPaginated(Pageable pageable);
}
