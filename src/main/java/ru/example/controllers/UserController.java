package ru.example.controllers;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.example.model.User;
import ru.example.service.UserService;
import ru.example.utils.InputChecker;

import java.util.Calendar;
import java.util.Date;

@RestController
@SuppressWarnings("unused")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @Value("${autoChangeStatusDelaySec}")
    int autoChangeDelaySec;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/users")
    public ResponseEntity<?> create(@RequestBody User user) {
        ResponseEntity<?> response;

        if(isCorrectUser(user)) {
            int id = userService.create(user);
            response = new ResponseEntity<>(id, HttpStatus.CREATED);
            logger.info("User created with id = " + id);
        } else {
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return response;
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<User> read(@PathVariable(name = "id") int id) {
        return userService.read(id).map(user -> {
                                                  statusAutoChange(user);
                                                  return new ResponseEntity<>(user, HttpStatus.OK);
                                                })
                                   .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/users/")
    public ResponseEntity<?> readEmpty() {
       return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping(value = "/users/{id}")
    public  ResponseEntity<String> updateStatus(@PathVariable(name = "id") int id, @RequestBody User.Status newStatus) {
            return userService.read(id).map(user -> getSuccessChangedStatusResponce(user, newStatus))
                                       .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping(value = "/users/")
    public  ResponseEntity<String> updateStatusEmpty() {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    private boolean isCorrectUser(User user) {
        return InputChecker.isUsername(user.getUsername()) &&
               InputChecker.isEmail(user.getEmail()) &&
               InputChecker.isPhoneNumber(user.getPhoneNumber());
    } // log

    private void statusAutoChange(User user) {
        Date current = Calendar.getInstance().getTime();
        long elapsedSec = (current.getTime() - user.getLastActivity().getTime())/(1000);

        if(user.getStatus() == User.Status.Online && elapsedSec > autoChangeDelaySec) {
            user.setStatus(User.Status.Away);
        }
    }

    private ResponseEntity<String> getSuccessChangedStatusResponce(User user, User.Status newStatus) {
        User.Status oldStatus = user.getStatus();

        user.setStatus(newStatus);
        if(newStatus == User.Status.Online) {
            user.setLastActivity(Calendar.getInstance().getTime());
        }


        userService.update(user, user.getId());

        String response = new JSONObject().append("id", user.getId())
                                          .append("oldStatus", oldStatus)
                                          .append("newStatus", newStatus)
                                          .toString();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
