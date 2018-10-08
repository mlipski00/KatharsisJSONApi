package org.katharsis;

import java.util.Arrays;
import java.util.HashSet;

import javax.annotation.PostConstruct;

//import org.katharsis.persistence.dao.RoleRepository;
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
        for (int i = 1; i < 101; i++) {
            Role roleUser = new Role("ROLE_USER");

            Role roleAdmin = new Role("ROLE_ADMIN");

            final User user1= new User("bjohn"+i, "john@test.com"+i);
            user1.setEmail("balessandrelli0@uol.com.br");
            user1.setGender("Male");
            user1.setIpaddress("144.215.240.61");
            user1.setField1("brand front-end e-services");
            user1.setField2("brand front-end e-services");
            user1.setField3("brand front-end e-services");
            user1.setField4("brand front-end e-services");
            user1.setField5("brand front-end e-services");
            user1.setField7("brand front-end e-services");
            user1.setField8("brand front-end e-services");
            user1.setField9("brand front-end e-services");
            user1.setField10("brand front-end e-services");
            user1.setField11("brand front-end e-services");
            user1.setField12("brand front-end e-services");
            user1.setField13("brand front-end e-services");
            user1.setField14("brand front-end e-services");
            user1.setRoles(new HashSet<Role>());
            userRepository.save(user1);

            final User user2 = new User("atom"+i, "tom@test.com"+i);
            user2.setEmail("balessandrelli0@uol.com.br");
            user2.setGender("Male");
            user2.setIpaddress("144.215.240.61");
            user2.setField1("brand front-end e-services");
            user2.setField2("brand front-end e-services");
            user2.setField3("brand front-end e-services");
            user2.setField4("brand front-end e-services");
            user2.setField5("brand front-end e-services");
            user2.setField7("brand front-end e-services");
            user2.setField8("brand front-end e-services");
            user2.setField9("brand front-end e-services");
            user2.setField10("brand front-end e-services");
            user2.setField11("brand front-end e-services");
            user2.setField12("brand front-end e-services");
            user2.setField13("brand front-end e-services");
            user2.setField14("brand front-end e-services");
            user2.setRoles(new HashSet<Role>());
            userRepository.save(user2);
        }

    }

}