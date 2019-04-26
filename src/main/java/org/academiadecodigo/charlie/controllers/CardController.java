package org.academiadecodigo.charlie.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class CardController {

     @RequestMapping(method = RequestMethod.GET, path = ("/cards"))
    public String cardMenu( Model model){

        return  null;
    }
}
