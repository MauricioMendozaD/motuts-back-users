package com.motuts.usersProfiles.controller;

import com.motuts.usersProfiles.entity.UserProfile;
import com.motuts.usersProfiles.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class UserProfileController {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @PostMapping
    public UserProfile save(@RequestBody UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    @GetMapping("/{id}")
    public UserProfile findById(@PathVariable(value = "id") String id) {
        return userProfileRepository.findById(id);
    }

    @GetMapping("")
    public List<UserProfile> findAll() {
        return userProfileRepository.findAll();
    }

    @PutMapping("/{id}")
    public UserProfile update(@PathVariable(value = "id") String id, @RequestBody UserProfile userProfile) {

        return userProfileRepository.update(id, userProfile);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable(value = "id") String id) {
        return userProfileRepository.delete(id);
    }
}
