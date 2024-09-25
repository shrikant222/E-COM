package com.example.ECOM.Controller;

import com.example.ECOM.model.Person;
import com.example.ECOM.service.PersonService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/public")
public class PublicController {


    PersonService personService;
    @Autowired
    public PublicController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping("/register")
    public String displayRegisterPage(Model model) {
        model.addAttribute("person", new Person());
        return "register";
    }

    @PostMapping("/createUser")
    public String createUser(@Valid @ModelAttribute("person") Person person, Errors errors) {
        if(errors.hasErrors())   return "register";

        boolean isSaved = personService.createNewPerson(person);

        if(isSaved)return "redirect:/login?register=true";

        else   return "register";
    }

}
