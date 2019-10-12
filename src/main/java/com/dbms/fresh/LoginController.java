package com.dbms.fresh;

import java.security.Principal;

import com.dbms.fresh.model.User;
import com.dbms.fresh.service.SecurityService;
import com.dbms.fresh.service.UserService;
import com.dbms.fresh.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping("")
    public ModelAndView home() {
        ModelAndView model = new ModelAndView("home");
        return model;
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());

        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return "register";
        }

        userService.save(user);

        securityService.autoLogin(user.getUsername(), user.getPasswordConfirm());
        return "redirect:/welcome";
    }

    // @GetMapping(value = { "/login", "/" })
    // public String login(Model model, String error, String logout) {
    // if (error != null)
    // model.addAttribute("error", "Your username and password is invalid.");

    // if (logout != null)
    // model.addAttribute("message", "You have been logged out successfully.");

    // return "redirect:/login";
    // }

    @GetMapping("/welcome")
    public String welcome(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        if (user.getRole().equals("customer"))
            return "redirect:/user";
        else
            return "redirect:/manager";
    }
}