package org.launchcode.controllers;

import jakarta.validation.Valid;
import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")
    public String displayAddUserForm(Model model) {
        model.addAttribute(new User());
        return "/user/add";
    }

    @PostMapping("")
    public String processAddUserForm(Model model, @Valid @ModelAttribute User user, Errors errors, @RequestParam String verify) {
// add form submission handling code here

        model.addAttribute(user);
        if (errors.hasErrors()) {
            return "/user/add";
        }
        if (user.getPassword().equals(verify)) {

            model.addAttribute("password", user.getPassword());
            return "/user/index";
        } else {
            model.addAttribute("error", 1);
            return "/user/add";
        }
    }
}
