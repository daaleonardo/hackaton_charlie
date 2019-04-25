package org.academiadecodigo.charlie.controllers;

import org.academiadecodigo.charlie.command.UserDto;
import org.academiadecodigo.charlie.command.UserLoginForm;
import org.academiadecodigo.charlie.converters.UserDtoToUserConverter;
import org.academiadecodigo.charlie.converters.UserToUserDtoConverter;
import org.academiadecodigo.charlie.services.RegisterService;
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
public class UserController {

    private UserService userService;
    private UserDtoToUserConverter userDtoToUser;
    private UserToUserDtoConverter userToUserDto;
    private RegisterService registerService;

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

    @Autowired
    public void setRegisterService(RegisterService registerService) {

        this.registerService = registerService;
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/", ""})
    public String mainAcess(Model model){
        model.addAttribute("userDto", new UserDto());
        return "redirect:/login";
    }

    @RequestMapping(method = RequestMethod.GET, value = ("/register"))
    public String register(Model model){
        model.addAttribute("userDto", new UserDto());
        return "user/register-view";
    }

    @RequestMapping(method = RequestMethod.POST, value = ("/register"))
    public String toRegister(@Valid @ModelAttribute("user") UserDto userDto, BindingResult bindingResult){

        if(bindingResult.hasErrors() || registerService.checkEmail(userDto.getEmail())) {
            return "redirect:register";
        }

        userService.save(userDtoToUser.convert(userDto));

        return "redirect:mainMenu";

    }

    @RequestMapping(method = RequestMethod.GET, path = ("/login"))
    public String login(Model model){
        model.addAttribute("user", new UserLoginForm());
        return "user/login-view";
    }

    @RequestMapping(method = RequestMethod.POST, path = ("/login"))
    public String loggingIn(@Valid @ModelAttribute("user") UserLoginForm userLoginForm, BindingResult bindingResult){


        if (bindingResult.hasErrors() || !userService.userExist(userLoginForm)){
            return "redirect:login";

        }
        return "redirect:cardMenu";

    }

    @RequestMapping(method = RequestMethod.GET, path = ("/cards"))
    public String cardMenu( Model model){

        return  null;
    }




}