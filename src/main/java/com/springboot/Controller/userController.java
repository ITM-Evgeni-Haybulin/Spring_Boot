package com.springboot.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.springboot.model.User;
import com.springboot.service.userService;

@Controller
@RequestMapping(value = "/users")
public class userController {

    private final userService userService;

    public userController(userService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String listUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "listusers";
    }

    @GetMapping("/new")
    public String addUser(@ModelAttribute("user") User user) {
        return "add";
    }

    @PostMapping()
    public String saveNewUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.removeUser(id);
        return "redirect:/users";
    }

    @GetMapping(value = "/{id}/edit")
    public String editUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "update";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("users") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }
}
