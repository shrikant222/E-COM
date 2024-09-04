package com.example.ECOM.Controller;

import com.example.ECOM.model.BuyModel;
import com.example.ECOM.service.BuyService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
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

    @PostMapping(value = "/saveMsg")
    public String buycontrooler(@Valid @ModelAttribute("buyModel") BuyModel buyModel,  Errors errors) {
        if(errors.hasErrors()){
            log.error("Contact form validation failed due to : {}", errors);
            return "Buy";
        }
        buyService.saveMessageDetails(buyModel);

        return "shrikant";
    }

    @RequestMapping("/displayMessages")
    public ModelAndView displaycontrooler(Model model) {
        ModelAndView mav = new ModelAndView("messages");
        List<BuyModel> buyers=buyService.findBuyers();
        mav.addObject("buyers", buyers);
        return mav;

    }





}
