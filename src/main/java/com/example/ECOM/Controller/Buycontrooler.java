package com.example.ECOM.Controller;

import com.example.ECOM.Repository.BuyRepo;
import com.example.ECOM.model.BuyModel;
import com.example.ECOM.service.BuyService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;


@Slf4j
@Controller
public class Buycontrooler {
    private final BuyService buyService;
    private final BuyRepo buyRepo;
   @Autowired
   public Buycontrooler(BuyService buyService, BuyRepo buyRepo){
      this.buyService = buyService;
      this.buyRepo = buyRepo;
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

//    @RequestMapping("/displayMessages")
//    public ModelAndView displaycontrooler(Model model) {
//        ModelAndView mav = new ModelAndView("messages");
//        List<BuyModel> buyers=buyService.findBuyers();
//        mav.addObject("buyers", buyers);
//        return mav;
//
//    }
    @RequestMapping("/displayMessages/page/{pageNum}")
    public ModelAndView displayMessages(Model model,
                                        @PathVariable(name = "pageNum") int pageNum,@RequestParam("sortField") String sortField,
                                        @RequestParam("sortDir") String sortDir) {
        Page<BuyModel> msgPage = buyService.findBuyers(pageNum,sortField,sortDir);
        List<BuyModel> buyers = msgPage.getContent();
        ModelAndView modelAndView = new ModelAndView("messages");
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", msgPage.getTotalPages());
        model.addAttribute("totalMsgs", msgPage.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        modelAndView.addObject("buyers",buyers);
        return modelAndView;
    }

    @GetMapping("/closeMsg")
    public String closeController(@RequestParam int id) {
        buyService.closeMsg(id);
        return "redirect:/displayMessages/page/1?sortField=name&sortDir=desc";
    }






}
