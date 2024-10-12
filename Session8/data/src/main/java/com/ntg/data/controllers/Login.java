package com.ntg.data.controllers;


import jakarta.websocket.server.PathParam;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class Login {

    // URL >> /v1/login/ali/1 or /v1/login/ali
    /**
     *     @RequestMapping(
     *             value = {"/login/{username}/{id}", "/login/{username}"},
     *             method = RequestMethod.GET,
     *             consumes = MediaType.APPLICATION_JSON_VALUE,
     *             produces = MediaType.APPLICATION_JSON_VALUE
     *     )
     * */
    @GetMapping(
            value = {"/login/{username}/{id}", "/login/{username}"},
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String login1(@PathVariable(name = "username") String user,
                        @PathVariable(name= "id", required = false) Optional<Long> userId) {
        return "Hello World " + user + " with ID: " + userId.orElse(0L);
    }

    // URL >> /v1/login2?username=ali&id=1 or /v1/login2?username=ali
    @GetMapping("/login2")
    public String login2(@RequestParam("username") String user, @RequestParam(value = "id", defaultValue = "10") Long userId) {
        return "Hello " + user + " with ID: " + userId;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World2";
    }

    /**
     * RequestBody:
     * {
     *     "username" : "Ola",
     *     "id" : 12,
     *     "age" : 23
     * }
     * */

    @PostMapping("/addUser")
    public String postUserInfo(@RequestBody Map<String, String> userInfo) {
        return "user added successfully";
    }

    @PutMapping("/updateUser")
    public String updateUserInfo(@RequestBody Map<String, String> userInfo) {
        return "user updated successfully";
    }

}
