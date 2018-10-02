package org.katharsis.persistence.katharsis;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.RelationshipRepositoryV2;
import io.katharsis.resource.list.ResourceList;
import org.katharsis.persistence.dao.RoleRepository;
import org.katharsis.persistence.dao.UserRepository;
import org.katharsis.persistence.model.Role;
import org.katharsis.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class RoleToUserRelationshipRepository implements RelationshipRepositoryV2<Role, Long, User, Long> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Class<Role> getSourceResourceClass() {
        return Role.class;
    }

    @Override
    public Class<User> getTargetResourceClass() {
        return User.class;
    }

    @Override
    public void setRelation(Role role, Long aLong, String s) {

    }

    @Override
    public void setRelations(Role role, Iterable<Long> userIds, String s) {
        final Set<User> users = new HashSet<>();
        users.addAll(userRepository.findAllById(userIds));
        role.setUsers(users);
        roleRepository.save(role);
    }

    @Override
    public void addRelations(Role role, Iterable<Long> userIds, String s) {
        final Set<User> users = role.getUsers();
        users.addAll(userRepository.findAllById(userIds));
        role.setUsers(users);
        roleRepository.save(role);

    }

    @Override
    public void removeRelations(Role role, Iterable<Long> userIds, String s) {
        final Set<User> users = role.getUsers();
        users.removeAll(userRepository.findAllById(userIds));
        role.setUsers(users);
        roleRepository.save(role);
    }

    @Override
    public User findOneTarget(Long aLong, String s, QuerySpec querySpec) {
        return null;
    }

    @Override
    public ResourceList<User> findManyTargets(Long sourceId, String s, QuerySpec querySpec) {
        final Role role = roleRepository.getOne(sourceId);
        return querySpec.apply(role.getUsers());
    }
}
