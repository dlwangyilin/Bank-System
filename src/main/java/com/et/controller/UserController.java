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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
        return "home";
    }

    @PostMapping("/deposit")
    public String deposit(@ModelAttribute("user") User theUser, Model model) {
        int id = theUser.getId();
        ActionUser delta = new ActionUser(id);
        model.addAttribute("delta", delta);
        return "deposit";
    }

    @PostMapping("/processDeposit")
    public String processDeposit(@Valid @ModelAttribute("delta") ActionUser actionUser, BindingResult theBindingResult, Model model) {
        if (theBindingResult.hasErrors()) {
            return "deposit";
        }
        User theUser = userService.getUser( actionUser.getUserId());
        double balance = theUser.getValue();
        double deltaVal = Double.parseDouble(actionUser.getDeltaVal());
        if (deltaVal < 0) {
            model.addAttribute("error", "Failed. You can't deposit negative amount! ");
        } else {
            model.addAttribute("success", "Successful deposit!");
            theUser.setValue(balance + deltaVal);
            userService.saveUser(theUser);
        }
        model.addAttribute("user", theUser);
        return "home";
    }

    @PostMapping("/withdraw")
    public String withdraw(@ModelAttribute("user") User theUser, Model model) {
        int id = theUser.getId();
        ActionUser delta = new ActionUser(id);
        model.addAttribute("delta", delta);
        return "withdraw";
    }

    @PostMapping("/processWithdraw")
    public String processWithdraw(@Valid @ModelAttribute("delta") ActionUser actionUser, BindingResult theBindingResult, Model model) {
        if (theBindingResult.hasErrors()) {
            return "withdraw";
        }
        User theUser = userService.getUser( actionUser.getUserId());
        double balance = theUser.getValue();
        double deltaVal = Double.parseDouble(actionUser.getDeltaVal());
        if (deltaVal < 0) {
            model.addAttribute("error", "Failed. You can't withdraw negative amount! ");
        } else if (balance <= deltaVal) {
            model.addAttribute("error", "Failed. You don't have enough money! ");
        } else {
            model.addAttribute("success", "Successful withdrawal!");
            theUser.setValue(balance - deltaVal);
            userService.saveUser(theUser);
        }
        model.addAttribute("user", theUser);
        return "home";
    }

}
