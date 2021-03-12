package ru.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.example.model.User;
import ru.example.service.UserService;
import ru.example.utils.InputChecker;

import java.util.Calendar;
import java.util.Date;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/users")
    public ResponseEntity<?> create(@RequestBody User user) {
        if(InputChecker.checkUsername(user.getUsername()) &&
           InputChecker.checkEmail(user.getEmail()) &&
           InputChecker.checkPhone(user.getPhoneNumber())) {

            return new ResponseEntity<>(userService.create(user), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<User> read(@PathVariable(name = "id") int id) {
        final User user = userService.read(id);

        if(user != null) {
            Date current = Calendar.getInstance().getTime();
            long elapsedSec = (current.getTime() - user.getLastActivity().getTime())/(1000);

            if(user.getStatus().equals(User.Status.Online) && elapsedSec > 10) {
                user.setStatus(User.Status.Away);
            }

            return new ResponseEntity<>(user, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/users/")
    public ResponseEntity<?> readEmpty() {
       return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping(value = "/users/{id}")
    public  ResponseEntity<String> updateStatus(@PathVariable(name = "id") int id, @RequestBody String newStatus) {
        if(InputChecker.checkStatus(newStatus)) {
            final User user = userService.read(id);

            if(user != null) {
                String response = "{ \"id\" : %d, \"oldStatus\" : \"%s\", \"newStatus\" : \"%s\" }";
                final User.Status oldStatus = user.getStatus();

                user.setStatus(User.Status.valueOf(newStatus));

                if(User.Status.valueOf(newStatus).equals(User.Status.Online)) {
                    user.setLastActivity(Calendar.getInstance().getTime());
                }

                return new ResponseEntity<>(String.format(response, user.getId(), oldStatus, newStatus), HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping(value = "/users/")
    public  ResponseEntity<String> updateStatusEmpty() {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
