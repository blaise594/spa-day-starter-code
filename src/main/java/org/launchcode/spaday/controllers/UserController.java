package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
    //This will use model binding to create a new user object, user, and pass it into your handler method.
    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        // add form submission handling code here
        model.addAttribute("user", user);
        model.addAttribute("verify", verify);
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        if(user.getPassword().equals(verify)){
            return  "user/index";
        }
        else {
            model.addAttribute("error", "Invalid password");
            return "user/add";
        }
    }
}
