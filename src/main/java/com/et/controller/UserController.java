package com.et.controller;

import com.et.entity.User;
import com.et.service.UserService;
import com.et.user.ActionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    // inject user service
    @Autowired
    private UserService userService;

    @GetMapping("/")
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

    @GetMapping("/deposit")
    public String deposit(@RequestParam("userId") int id, Model model) {
        ActionUser delta = new ActionUser(id);
        model.addAttribute("delta", delta);
        return "deposit";
    }

    @PostMapping("/processDeposit")
    public String processDeposit(@ModelAttribute("delta") ActionUser actionUser, Model model) {
        User theUser = userService.getUser( actionUser.getUserId());
        double balance = theUser.getValue();
        if (actionUser.getDeltaVal() < 0) {
            model.addAttribute("error", "Failed. You can't deposit negative amount! ");
        } else {
            model.addAttribute("success", "Successful deposit!");
            theUser.setValue(balance + actionUser.getDeltaVal());
            userService.saveUser(theUser);
        }
        model.addAttribute("user", theUser);
        return "home";
    }

    @GetMapping("/withdraw")
    public String withdraw(@RequestParam("userId") int id, Model model) {
        ActionUser delta = new ActionUser(id);
        model.addAttribute("delta", delta);
        return "withdraw";
    }

    @PostMapping("/processWithdraw")
    public String processWithdraw(@ModelAttribute("delta") ActionUser actionUser, Model model) {
        User theUser = userService.getUser( actionUser.getUserId());
        double balance = theUser.getValue();
        if (actionUser.getDeltaVal() < 0) {
            model.addAttribute("error", "Failed. You can't withdraw negative amount! ");
        } else if (balance <= actionUser.getDeltaVal()) {
            model.addAttribute("error", "Failed. You don't have enough money! ");
        } else {
            model.addAttribute("success", "Successful withdrawal!");
            theUser.setValue(balance - actionUser.getDeltaVal());
            userService.saveUser(theUser);
        }
        model.addAttribute("user", theUser);
        return "home";
    }

}
