package com.example.demo.Controller;

import com.example.demo.model.BuyModel;
import com.example.demo.service.BuyService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class Buycontrooler {
    private final BuyService buyService;
   @Autowired
   public Buycontrooler(BuyService buyService){
      this.buyService = buyService;
    }


    @RequestMapping("/buy")
    public String buyview(Model model) {
       model.addAttribute("buyModel", new BuyModel());
        return "Buy";
    }

/*@RequestMapping(value = "/saveMsg",method = POST)
    public ModelAndView saveMessage(@RequestParam String name, @RequestParam String mobileNum,
                                    @RequestParam String email, @RequestParam String subject, @RequestParam String message) {
        log.info("Name : " + name);
        log.info("Mobile Number : " + mobileNum);
        log.info("Email Address : " + email);
        log.info("Subject : " + subject);
        log.info("Message : " + message);
        return new ModelAndView("redirect:/contact");
    }*/


    @PostMapping(value = "/saveMsg")
    public String buycontrooler(@Valid @ModelAttribute("buyModel") BuyModel buyModel,  Errors errors) {
        if(errors.hasErrors()){
            log.error("Contact form validation failed due to : {}", errors);
            return "Buy";
        }
        buyService.saveMessageDetails(buyModel);

        return "shrikant";
    }





}
