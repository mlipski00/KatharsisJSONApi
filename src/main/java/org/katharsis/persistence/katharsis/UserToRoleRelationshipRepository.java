package org.katharsis.persistence.katharsis;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.RelationshipRepositoryV2;
import io.katharsis.resource.list.ResourceList;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.katharsis.persistence.dao.RoleRepository;
import org.katharsis.persistence.dao.UserRepository;
import org.katharsis.persistence.model.Role;
import org.katharsis.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserToRoleRelationshipRepository implements RelationshipRepositoryV2<User, String, Role, String> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void setRelation(User User, String roleId, String fieldName) {
        // not for many-to-many
    }

    @Override
    public void setRelations(User user, Iterable<String> roleIds, String fieldName) {
        final Set<Role> roles = new HashSet<Role>();
        roles.addAll((Collection<? extends Role>) roleRepository.findAllById(roleIds));
        user.setRoles(roles);
        userRepository.save(user);
    }

    @Override
    public void addRelations(User user, Iterable<String> roleIds, String fieldName) {
        final Set<Role> roles = user.getRoles();
        roles.addAll((Collection<? extends Role>) roleRepository.findAllById(roleIds));
        user.setRoles(roles);
        userRepository.save(user);
    }

    @Override
    public void removeRelations(User user, Iterable<String> roleIds, String fieldName) {
        final Set<Role> roles = user.getRoles();
        roles.removeAll((Collection<?>) roleRepository.findAllById(roleIds));
        user.setRoles(roles);
        userRepository.save(user);
    }

    @Override
    public Role findOneTarget(String sourceId, String fieldName, QuerySpec querySpec) {
        // not for many-to-many
        return null;
    }


    @Override
    public ResourceList<Role> findManyTargets(String sourceId, String fieldName, QuerySpec querySpec) {
        if (userRepository.findById(sourceId).isPresent()){
            final User user = userRepository.findById(sourceId).get();
            return  querySpec.apply(user.getRoles());
        }

        return querySpec.apply(userRepository.findById(sourceId).get().getRoles());
    }

    @Override
    public Class<User> getSourceResourceClass() {
        return User.class;
    }

    @Override
    public Class<Role> getTargetResourceClass() {
        return Role.class;
    }

}
