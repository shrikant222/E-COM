package com.example.ECOM.service;

import com.example.ECOM.Repository.BuyRepo;
import com.example.ECOM.constants.Constants;

import com.example.ECOM.model.BuyModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class BuyService {

    @Autowired
    private BuyRepo BuyRepo;

    public boolean saveMessageDetails(BuyModel buyModel) {
    boolean saves = false;
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    buyModel.setStatus(Constants.OPEN);
    buyModel.setCreatedBy(authentication.getName());
    buyModel.setCreatedAt(LocalDateTime.now());
    int result= BuyRepo.saveBuyer(buyModel);
    if(result>0){
        saves = true;
    }
    return saves;


    }
    public List<BuyModel> findBuyers(){
        return BuyRepo.findmsgWithOpenStatus(Constants.OPEN);
    }
   public void closeMsg(int id, String name){
       BuyRepo.closeMsg(id,name,Constants.CLOSE);
   }
}
