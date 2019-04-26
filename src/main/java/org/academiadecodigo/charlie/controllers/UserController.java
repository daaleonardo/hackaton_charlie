package org.academiadecodigo.charlie.controllers;

import org.academiadecodigo.charlie.command.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class UserController {


    @RequestMapping(method = RequestMethod.GET, value = {"/", ""})
    public String mainAcess(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "redirect:/login";
    }



}