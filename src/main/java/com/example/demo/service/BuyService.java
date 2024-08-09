package com.example.demo.service;

import com.example.demo.Repository.BuyRepo;
import com.example.demo.constants.Constants;

import com.example.demo.model.BuyModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class BuyService {

    @Autowired
    private BuyRepo BuyRepo;

    public boolean saveMessageDetails(BuyModel buyModel) {
    boolean saves = false;
    buyModel.setStatus(Constants.OPEN);
    buyModel.setCreatedBy(Constants.ANONYMOUS);
    buyModel.setCreatedAt(LocalDateTime.now());
    int result= BuyRepo.saveBuyer(buyModel);
    if(result>0){
        saves = true;
    }
    return saves;


    }
}
