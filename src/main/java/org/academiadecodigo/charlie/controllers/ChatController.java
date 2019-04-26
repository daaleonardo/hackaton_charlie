package org.academiadecodigo.charlie.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class ChatController {

    @RequestMapping(method = RequestMethod.GET, path = ("/chat"))
    public String chat() {
        return "chat/frontend";
    }


}
