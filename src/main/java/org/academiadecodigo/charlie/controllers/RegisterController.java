package org.academiadecodigo.charlie.controllers;

import org.academiadecodigo.charlie.command.UserDto;
import org.academiadecodigo.charlie.converters.UserDtoToUserConverter;
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
public class RegisterController {

    private RegisterService registerService;
    private UserService userService;
    private UserDtoToUserConverter userDtoToUser;

    @Autowired
    public void setRegisterService(RegisterService registerService) {
        this.registerService = registerService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserDtoToUser(UserDtoToUserConverter userDtoToUser) {
        this.userDtoToUser = userDtoToUser;
    }

    @RequestMapping(method = RequestMethod.GET, value = ("/register"))
    public String register(Model model){
        model.addAttribute("userDto", new UserDto());
        return "login/register";
    }

    @RequestMapping(method = RequestMethod.POST, value = ("/register"))
    public String toRegister(@Valid @ModelAttribute("userDto") UserDto userDto, BindingResult bindingResult){

        if(bindingResult.hasErrors() || registerService.checkEmail(userDto.getEmail())) {
            return "redirect:register";
        }

        userService.save(userDtoToUser.convert(userDto));

        return "login/login";

    }

}
