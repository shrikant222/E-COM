package com.example.demo.service;

import com.example.demo.model.BuyModel;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Slf4j
@Service
@SessionScope
public class BuyService {

    public void saveMessageDetails(BuyModel buyModel) {
    log.info(buyModel.toString());
    }
}
