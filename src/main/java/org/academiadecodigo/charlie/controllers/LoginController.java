package org.academiadecodigo.charlie.controllers;

import org.academiadecodigo.charlie.command.UserLoginForm;
import org.academiadecodigo.charlie.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class LoginController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET, path = ("/login"))
    public String login(Model model){
        model.addAttribute("user", new UserLoginForm());
        return "login/login";
    }

    @RequestMapping(method = RequestMethod.POST, path = ("/login"))
    public String loggingIn(@Valid @ModelAttribute("user") UserLoginForm userLoginForm, BindingResult bindingResult){


        if (bindingResult.hasErrors() || !userService.userExist(userLoginForm)){
            return "redirect:login";
        }

        return "redirect:cardMenu";

    }

}
