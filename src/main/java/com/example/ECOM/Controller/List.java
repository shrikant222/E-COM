package com.example.ECOM.Controller;
import com.example.ECOM.Repository.ListRepo;
import com.example.ECOM.model.ListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class List {

    private final ListRepo listRepo;
    @Autowired
    List(ListRepo listRepo) {
        this.listRepo = listRepo;
    }

    @GetMapping("/list")
    public ModelAndView listPost(
            @RequestParam(required = false, defaultValue = "false") boolean runningShoes,
            @RequestParam(required = false, defaultValue = "false") boolean casualShoes,
            @RequestParam(required = false, defaultValue = "false") boolean basketballShoes,
            @RequestParam(required = false, defaultValue = "false") boolean lifestyleShoes
    ) {
        ModelAndView mav = new ModelAndView("list");

        if (runningShoes) {
            java.util.List<ListModel> runningShoeList = listRepo.findByType(ListModel.Type.Running_Shoes);
            mav.addObject("Running_Shoes", runningShoeList);
        }

        if (casualShoes) {
            java.util.List<ListModel> casualShoeList = listRepo.findByType(ListModel.Type.Casual_Shoes);
            mav.addObject("Casual_Shoes", casualShoeList);
        }

        if (basketballShoes) {
            java.util.List<ListModel> basketballShoeList = listRepo.findByType(ListModel.Type.Basketball_Shoes);
            mav.addObject("Basketball_Shoes", basketballShoeList);
        }

        if (lifestyleShoes) {
            java.util.List<ListModel> lifestyleShoeList = listRepo.findByType(ListModel.Type.Lifestyle_Shoes);
            mav.addObject("Lifestyle_Shoes", lifestyleShoeList);
        }

        mav.addObject("runningShoes", runningShoes);
        mav.addObject("casualShoes", casualShoes);
        mav.addObject("basketballShoes", basketballShoes);
        mav.addObject("lifestyleShoes", lifestyleShoes);

        return mav;
    }





}
