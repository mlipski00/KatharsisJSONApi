package org.katharsis.persistence.katharsis;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryV2;
import io.katharsis.resource.list.ResourceList;

import org.katharsis.persistence.dao.UserRepository;
import org.katharsis.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserResourceRepository implements ResourceRepositoryV2<User, Long> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findOne(Long id, QuerySpec querySpec) {
        return userRepository.getOne(id);
    }

    @Override
    public ResourceList<User> findAll(QuerySpec querySpec) {
        return querySpec.apply(userRepository.findAll());
    }

    @Override
    public ResourceList<User> findAll(Iterable<Long> ids, QuerySpec querySpec) {
        return querySpec.apply(userRepository.findAllById(ids));
    }

    @Override
    public <S extends User> S save(S entity) {
        return userRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(userRepository.getOne(id));
    }

    @Override
    public Class<User> getResourceClass() {
        return User.class;
    }

    @Override
    public <S extends User> S create(S entity) {
        return save(entity);
    }

}
