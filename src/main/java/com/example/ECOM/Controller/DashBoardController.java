package com.example.ECOM.Controller;
import com.example.ECOM.Repository.PersonRepo;
import com.example.ECOM.model.Person;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class DashBoardController {

    PersonRepo  personRepo;

    @Autowired
    DashBoardController( PersonRepo personRepo) {

        this.personRepo = personRepo;
    }

    @RequestMapping("/dashboard")
    public String displayDashboard(Model model, Authentication authentication, HttpSession session) {
        Person person = personRepo.readByEmail(authentication.getName());

        model.addAttribute("username", person.getName());
        model.addAttribute("roles", authentication.getAuthorities().toString());

        session.setAttribute("logInPerson", person);
        return "dashboard";
    }
}
