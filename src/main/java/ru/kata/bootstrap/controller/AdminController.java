package ru.kata.bootstrap.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kata.bootstrap.model.User;
import ru.kata.bootstrap.service.UserService;

import java.security.Principal;

@Controller
public class AdminController {
    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/users")
    public String getUsers(ModelMap model, Principal principal) {
        model.addAttribute("users", userService.getUsers());
        model.addAttribute("principal", userService.findUserByUsername(principal.getName()));
        model.addAttribute("roles", userService.getUsersRoles());
        model.addAttribute("newUser", new User());
        return "admin_panel";
    }

    @PostMapping("/admin/save")
    public String saveUser(@ModelAttribute("newUser") User user) {
        userService.save(user);
        return "redirect:/admin/users";
    }

    @PatchMapping("/admin/update")
    public String updateUser(@RequestParam("id") long id, @ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/admin/users";
    }

    @PostMapping("/admin/delete")
    public String deleteUser(@RequestParam("id") long id) {
        userService.deleteUserById(id);
        return "redirect:/admin/users";
    }
}