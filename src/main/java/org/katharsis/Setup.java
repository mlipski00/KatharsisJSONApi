package org.katharsis;

import java.util.Arrays;
import java.util.HashSet;

import javax.annotation.PostConstruct;

import org.katharsis.persistence.dao.RoleRepository;
import org.katharsis.persistence.dao.UserRepository;
import org.katharsis.persistence.model.Role;
import org.katharsis.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class Setup implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        setupData();
    }

    private void setupData() {
        Role roleUser = new Role("ROLE_USER");

        Role roleAdmin = new Role("ROLE_ADMIN");

        final User userJohn = new User("bjohn", "john@test.com");
        userJohn.setRoles(new HashSet<Role>(Arrays.asList(roleUser, roleAdmin)));
        userRepository.save(userJohn);

        final User userTom = new User("atom", "tom@test.com");
        userTom.setRoles(new HashSet<Role>(Arrays.asList(roleUser)));
        userRepository.save(userTom);
    }

}