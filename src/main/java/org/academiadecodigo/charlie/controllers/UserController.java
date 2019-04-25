package org.academiadecodigo.charlie.controllers;

import org.academiadecodigo.charlie.command.UserDto;
import org.academiadecodigo.charlie.converters.UserDtoToUserConverter;
import org.academiadecodigo.charlie.converters.UserToUserDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    private UserDtoToUserConverter userDtoToUser;
    private UserToUserDtoConverter userToUserDto;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserDtoToUser(UserDtoToUserConverter userDtoToUser) {
        this.userDtoToUser = userDtoToUser;
    }

    @Autowired
    public void setUserToUserDto(UserToUserDtoConverter userToUserDto) {
        this.userToUserDto = userToUserDto;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = ("/Registering")
    )
    public String register(Model model){
        model.addAttribute("userDto", new UserDto());
        return "login-registerForm";
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = ("/registering")
    )
    public String toRegister(@Valid @ModelAttribute("user") UserDto userDto, BindingResult bindingResult){

        if(bindingResult.hasErrors(), registerService.checkEmail(userDto.getEmail)){
            return "redirect:register";
        }

        userService.save(userDtoToUser.conver(userDto));

        return "redirect:mainMenu";

    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = ("/login")
    )
    public String login(Model model){
        model.addAttribute("userLoginForm", new UserLoginForm());
        return "login-registerForm";
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = ("/login")
    )
    public String loggingIn(@Valid @ModelAttribute("user") UserLoginForm userLoginForm, BindingResult bindingResult){


        if (bindingResult.hasErrors() || !userService.exist(userLoginForm)){
            return "redirect:login";

        }
        return "redirect:cardMenu";

    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = ("/cards")
    )
    public String cardMenu( Model model){

    }


}