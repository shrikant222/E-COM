package com.example.ECOM.Controller;

import ch.qos.logback.core.model.Model;
import com.example.ECOM.Repository.PersonRepo;
import com.example.ECOM.model.Person;
import com.example.ECOM.model.Address;
import com.example.ECOM.model.Profile;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class ProfileController {

    PersonRepo personRepo;

    @Autowired
    ProfileController(PersonRepo personRepo){
        this.personRepo = personRepo;
    }

    @GetMapping("/displayprofile")
    public ModelAndView displayprofile(HttpSession session) {
        Person person = (Person) session.getAttribute("logInPerson");

        Profile profile = new Profile();

        profile.setName(person.getName());
        profile.setMobileNumber(person.getMobileNumber());
        profile.setEmail(person.getEmail());

        if(person.getAddress() !=null && person.getAddress().getAddress_id()>0){
            profile.setAddress1(person.getAddress().getAddress1());
            profile.setAddress2(person.getAddress().getAddress2());
            profile.setCity(person.getAddress().getCity());
            profile.setState(person.getAddress().getState());
            profile.setZipCode(person.getAddress().getZip_code());
        }

        ModelAndView modelAndView = new ModelAndView("profile");
        modelAndView.addObject("profile",profile);
        return modelAndView;
    }


    @PostMapping( "/updateProfile")
    public String updateProfile(@Valid @ModelAttribute("profile") Profile profile, Errors errors,
                                HttpSession session)
    {

        if(errors.hasErrors()){
            return "profile";
        }

        Person person = (Person) session.getAttribute("logInPerson");
        person.setName(profile.getName());
        person.setEmail(profile.getEmail());
        person.setMobileNumber(profile.getMobileNumber());

        if(person.getAddress() ==null || !(person.getAddress().getAddress_id()>0)){
            person.setAddress(new Address());
        }

        person.getAddress().setAddress1(profile.getAddress1());
        person.getAddress().setAddress2(profile.getAddress2());
        person.getAddress().setCity(profile.getCity());
        person.getAddress().setState(profile.getState());
        person.getAddress().setZip_code(profile.getZipCode());
        Person savedPerson = personRepo.save(person);
        session.setAttribute("logInPerson", savedPerson);
        return "redirect:/displayprofile";
    }
}
