package org.katharsis.restController;

import io.katharsis.errorhandling.exception.ResourceNotFoundException;
import org.katharsis.persistence.dao.UserRepository;
import org.katharsis.persistence.model.User;
import org.katharsis.service.IUserService;
import org.katharsis.webService.PaginatedResultsRetrievedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class MainRestController {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IUserService iUserService;

    @GetMapping("/rest/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/rest/users", params = {"page", "size"}, method = GET)
    @ResponseBody
    public List<User> findPaginated(
            @RequestParam("page") int page, @RequestParam("size") int size,
            UriComponentsBuilder uriBuilder, HttpServletResponse response) {

        Page<User> resultPage = iUserService.findPaginated(page, size);
        if (page > resultPage.getTotalPages()) {
            throw new ResourceNotFoundException("ResourceNotFoundException");
        }
        eventPublisher.publishEvent(new PaginatedResultsRetrievedEvent<User>
                (User.class, uriBuilder, response, page, resultPage.getTotalPages(), size));

        return resultPage.getContent();
    }
}
