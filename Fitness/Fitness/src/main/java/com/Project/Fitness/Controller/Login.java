package com.Project.Fitness.Controller;

import com.Project.Fitness.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("login")
public class Login {

    @Autowired
    LoginService loginService;

    @PostMapping("old")
    public ResponseEntity<String> loginVerify(@RequestParam String username, @RequestParam String password) {
        return loginService.loginVerify(username,password);
    }

    @PutMapping("new")
    public ResponseEntity<String> registerNewUser(@RequestParam String username, @RequestParam String password) {
        return  loginService.registerNewUser(username,password);
    }

    @PostMapping("delete")
    public ResponseEntity<String> deleteUser(@RequestParam String username) {
        return loginService.deleteUser(username);
    }

    @PutMapping("update")
    public ResponseEntity<String> updatePassword(@RequestParam String username, @RequestParam String oldPassword, @RequestParam String newPassword) {
       return loginService.updatePassword(username,oldPassword,newPassword);
    }

    @GetMapping("get")
    public  ResponseEntity<String> findPassword(@RequestParam String username) {
        return loginService.findPassword(username);
    }

}
