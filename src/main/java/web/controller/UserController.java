package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping()
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String allUsers(Model model) {
        model.addAttribute("usersList", userService.allUser());
        return "users";
    }

    @GetMapping("users/add")
    public String addForm() {
        return "/user_form";
    }

    @PostMapping("users/add")
    public String addUser(User user) {
        userService.add(user);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("user") int id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "/editPage";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute User user) {
        userService.edit(user);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("user") int id) {
        userService.delete(id);
        return "redirect:/";
    }
}
