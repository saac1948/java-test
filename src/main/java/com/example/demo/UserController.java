package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/demo")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping(value = "/findUserID", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<UserResponseBody> findUserID(@RequestParam String id1, @RequestParam String id2) {
    String userId = userService.findUserId(id1, id2);
    UserResponseBody response = new UserResponseBody();
    response.setUserID(userId);
    return ResponseEntity.ok().body(response);
  }
}