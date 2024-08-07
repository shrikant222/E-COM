package com.example.demo.Controller;

import com.example.demo.model.ListModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.stream.Collectors;

import static com.example.demo.model.ListModel.Type.*;

@Controller
public class List {
//    @GetMapping("/list/{show}")
//    public String listPost(@PathVariable String show, Model model){
//        if(show==null || show.equals("all")){
//            model.addAttribute("runningShoes1",true);
//            model.addAttribute("CasualShoes",true);
//            model.addAttribute("BasketballShoes",true);
//        } else if (show.equals("runningShoes")) {
//            model.addAttribute("runningShoes1",true);
//        }
//        else if (show.equals("BasketballShoes")) {
//            model.addAttribute("BasketballShoes",true);
//        }
//        else if (show.equals("casualShoes")) {
//            model.addAttribute("CasualShoes",true);
//        }

   @GetMapping("/list")
    public String listPost(    @RequestParam(required = false,defaultValue = "false")boolean runningShoes,
                               @RequestParam(required = false,defaultValue = "false")boolean CasualShoes,
                               @RequestParam(required = false,defaultValue = "false")boolean BasketballShoes, Model model){
      model.addAttribute("runningShoes1",runningShoes);
      model.addAttribute("CasualShoes",CasualShoes);
      model.addAttribute("BasketballShoes",BasketballShoes);
       ArrayList<ListModel> data = new ArrayList<>();
       data.add(new ListModel("Nike Air Zoom Pegasus",1200, Running_Shoes));
       data.add(new ListModel("Adidas Ultraboost",1200, Running_Shoes));
       data.add(new ListModel("New Balance Fresh Foam",1200, Running_Shoes));
       data.add(new ListModel("Nike LeBron",1300, Basketball_Shoes));
       data.add(new ListModel("Adidas Hardens",1300, Basketball_Shoes));
       data.add(new ListModel("Under Armour Curry",1300, Basketball_Shoes));
       data.add(new ListModel("Vans Old Skool",1400, Casual_Shoes));
       data.add(new ListModel("Converse Chuck Taylo",1400, Casual_Shoes));
       data.add(new ListModel("Adidas Stan Smith",1400, Casual_Shoes));

       for(ListModel.Type loop: ListModel.Type.values()){
           model.addAttribute(loop.toString(),
           (data.stream().filter(holiday -> holiday.getType().equals(loop)).collect(Collectors.toList())));
       }
       return "list";

    }
}
