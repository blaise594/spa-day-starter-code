package org.launchcode.spaday.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//Add the @Controller annotation,
@Controller
//along with @RequestMapping("user") to configure routes into the controller.
@RequestMapping("user")
public class UserController {
    //create a handler method displayAddUserForm() to render the form.
    @GetMapping("/add")
    public String displayAddUserForm(){
        //This handler should correspond to the path /user/add, and for now,
        // it can just return the path to the add.html template.
        return "user/add";
    }
}
