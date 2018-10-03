package org.katharsis.restController;

import org.katharsis.persistence.dao.UserRepository;
import org.katharsis.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainRestController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/rest/users" )
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
