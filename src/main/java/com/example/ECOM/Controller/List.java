package com.example.ECOM.Controller;

import com.example.ECOM.model.ListModel;
import com.example.ECOM.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.stream.Collectors;

@Controller
public class List {
    ListService listService;

    @Autowired
    List(ListService listService){
        this.listService = listService;
    }


// older code without DB

//   @GetMapping("/list")
//    public String listPost(    @RequestParam(required = false,defaultValue = "false")boolean runningShoes,
//                               @RequestParam(required = false,defaultValue = "false")boolean CasualShoes,
//                               @RequestParam(required = false,defaultValue = "false")boolean BasketballShoes, Model model){
//      model.addAttribute("runningShoes1",runningShoes);
//      model.addAttribute("CasualShoes",CasualShoes);
//      model.addAttribute("BasketballShoes",BasketballShoes);
//       ArrayList<ListModel> data = new ArrayList<>();
//       data.add(new ListModel("Nike Air Zoom Pegasus",1200, Running_Shoes));
//       data.add(new ListModel("Adidas Ultraboost",1200, Running_Shoes));
//       data.add(new ListModel("New Balance Fresh Foam",1200, Running_Shoes));
//       data.add(new ListModel("Nike LeBron",1300, Basketball_Shoes));
//       data.add(new ListModel("Adidas Hardens",1300, Basketball_Shoes));
//       data.add(new ListModel("Under Armour Curry",1300, Basketball_Shoes));
//       data.add(new ListModel("Vans Old Skool",1400, Casual_Shoes));
//       data.add(new ListModel("Converse Chuck Taylo",1400, Casual_Shoes));
//       data.add(new ListModel("Adidas Stan Smith",1400, Casual_Shoes));
//
//       for(ListModel.Type loop: ListModel.Type.values()){
//           model.addAttribute(loop.toString(),
//           (data.stream().filter(holiday -> holiday.getType().equals(loop)).collect(Collectors.toList())));
//       }
//       return "list";
//
//    }


    @GetMapping("/list")
    public ModelAndView listPost(
            @RequestParam(required = false, defaultValue = "false") boolean runningShoes,
            @RequestParam(required = false, defaultValue = "false") boolean CasualShoes,
            @RequestParam(required = false, defaultValue = "false") boolean BasketballShoes,
            @RequestParam(required = false, defaultValue = "false") boolean LifestyleShoes)
    {

        ModelAndView mav = new ModelAndView("list");

        // Fetch all shoes
        java.util.List<ListModel> allShoes = listService.findshoes();

        java.util.List<ListModel> lifestyleShoeList = allShoes.stream()
                .filter(shoe -> shoe.getType() == ListModel.Type.Lifestyle_Shoes)
                .collect(Collectors.toList());
        // Filter shoes by category
        java.util.List<ListModel> runningShoeList = allShoes.stream()
                .filter(shoe -> shoe.getType() == ListModel.Type.Running_Shoes)
                .collect(Collectors.toList());

        java.util.List<ListModel> basketballShoeList = allShoes.stream()
                .filter(shoe -> shoe.getType() == ListModel.Type.Basketball_Shoes)
                .collect(Collectors.toList());

        java.util.List<ListModel> casualShoeList = allShoes.stream()
                .filter(shoe -> shoe.getType() == ListModel.Type.Casual_Shoes)
                .collect(Collectors.toList());

        // Add attributes to the ModelAndView
        mav.addObject("Running_Shoes", runningShoeList);
        mav.addObject("Basketball_Shoes", basketballShoeList);
        mav.addObject("Casual_Shoes", casualShoeList);

        mav.addObject("runningShoes", runningShoes);
        mav.addObject("CasualShoes", CasualShoes);
        mav.addObject("BasketballShoes", BasketballShoes);

        mav.addObject("Lifestyle_Shoes", lifestyleShoeList);
        mav.addObject("LifestyleShoes", LifestyleShoes);
        return mav;
    }




}
