package org.katharsis.persistence.katharsis;


import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryV2;
import io.katharsis.resource.list.ResourceList;

import org.katharsis.persistence.dao.RoleRepository;
import org.katharsis.persistence.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class RoleResourceRepository implements ResourceRepositoryV2<Role, String> {

    @Autowired private RoleRepository roleRepository;

    @Override
    public Role findOne(String id, QuerySpec querySpec) {
        return roleRepository.findById(id).get();
    }

    @Override
    public ResourceList<Role> findAll(QuerySpec querySpec) {
        return querySpec.apply(roleRepository.findAll());
    }

    @Override
    public ResourceList<Role> findAll(Iterable<String> ids, QuerySpec querySpec) {
        return querySpec.apply(roleRepository.findAllById(ids));
    }

    @Override
    public <S extends Role> S save(S entity) {
        return roleRepository.save(entity);
    }

    @Override
    public void delete(String id) {
        roleRepository.delete(roleRepository.findById(id).get());
    }

    @Override
    public Class<Role> getResourceClass() {
        return Role.class;
    }

    @Override
    public <S extends Role> S create(S entity) {
        return save(entity);
    }

}
