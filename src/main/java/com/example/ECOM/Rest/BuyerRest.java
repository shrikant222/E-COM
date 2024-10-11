package com.example.ECOM.Rest;

import com.example.ECOM.Repository.BuyRepo;
import com.example.ECOM.model.BuyModel;
import com.example.ECOM.service.BuyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("api/b")

public class BuyerRest {
    BuyService buyService;
    BuyRepo buyRepo;
    public BuyerRest(BuyRepo buyRepo) {
        this.buyRepo = buyRepo;
    }

    @GetMapping("/getinfo")
    @ResponseBody
    public List<BuyModel> getinfo(@RequestParam(name ="status")String  status){
        return buyRepo.findByStatus(status);
    }

}
