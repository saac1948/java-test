package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@CacheConfig(cacheNames = "userService")
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Cacheable(value="redis", key ="#p0+','+#p1")
    public String findUserId(String id1, String id2) {
        User user = userRepository.findByUserPkId1AndUserPkId2(id1, id2);

        if (user != null) {
            return user.getUserId();
        } else {
            UserPk userKey = new UserPk(id1, id2);
            User newUser = new User(userKey, UUID.randomUUID().toString());
            userRepository.save(newUser);
            return newUser.getUserId();
        }
    }
}
