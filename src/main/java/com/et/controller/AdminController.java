package com.et.controller;

import com.et.entity.User;
import com.et.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    // inject user service
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String listUsers(Model model) {
        // get users from service
        List<User> theUsers = userService.getUsers();
        model.addAttribute("users", theUsers);
        // add users into the model
        return "list-users";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        // create model attribute to bind data
        User theUser = new User();
        model.addAttribute("user", theUser);
        return "user-form";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User theUser) {
        userService.saveUser(theUser);
        return "redirect:/admin/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("userId") int id, Model model) {
        User theUser = userService.getUser(id);
        model.addAttribute("user", theUser);
        return "user-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("userId") int id) {
        // delete the user
        userService.deleteUser(id);
        return "redirect:/admin/list";
    }

    @GetMapping("/search")
    public String searchUsers(@RequestParam("theSearchName") String theSearchName, Model theModel) {

        // search users from the service
        List<User> theUsers = userService.searchUsers(theSearchName);

        // add the users to the model
        theModel.addAttribute("users", theUsers);

        return "list-users";
    }
}