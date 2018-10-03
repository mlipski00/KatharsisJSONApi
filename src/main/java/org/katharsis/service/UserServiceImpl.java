package org.katharsis.service;

import com.google.common.util.concurrent.AbstractService;
import org.katharsis.persistence.dao.UserRepository;
import org.katharsis.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import java.io.Serializable;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;



    @Override
    public Serializable findOne(long id) {
        return null;
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Page findPaginated(int page, int size) {
        return userRepository.findAll(new PageRequest(page, size));
    }

    @Override
    public Serializable create(Serializable entity) {
        return null;
    }

    @Override
    public Serializable update(Serializable entity) {
        return null;
    }

    @Override
    public void delete(Serializable entity) {

    }

    @Override
    public void deleteById(long entityId) {

    }
    public Page<User> findPaginated(Pageable pageable) {

        return userRepository.findAll(pageable);
    }
}
