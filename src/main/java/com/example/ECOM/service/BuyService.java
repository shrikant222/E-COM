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

    private final BuyRepo buyRepo;

    @Autowired
    public BuyService(BuyRepo buyRepo) {
        this.buyRepo = buyRepo;
    }

    public void saveMessageDetails(BuyModel buyModel) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        buyModel.setStatus(Constants.OPEN);
        buyModel.setCreatedBy(authentication.getName());
        buyModel.setCreatedAt(LocalDateTime.now());
        buyRepo.save(buyModel);

    }

    public List<BuyModel> findBuyers() {
        return buyRepo.findByStatus(Constants.OPEN);
    }

    public void closeMsg(int id, String name) {
        buyRepo.updateMessageStatus(id, name, Constants.CLOSE, LocalDateTime.now());
    }
}
