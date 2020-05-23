package com.et.controller;

import com.et.entity.User;
import com.et.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    // inject user service
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public String showHome(Model model) {
        SecurityContext ctx = SecurityContextHolder.getContext();
        Authentication auth = ctx.getAuthentication();
        String name = ((org.springframework.security.core.userdetails.User) auth.getPrincipal()).getUsername();
        User theUser = userService.findByUserName(name);
        model.addAttribute("user", theUser);
        System.out.println(theUser.getUserName());
        System.out.println(theUser.getPassword());
        return "home";
    }

}
