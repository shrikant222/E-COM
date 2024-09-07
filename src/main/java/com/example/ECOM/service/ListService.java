package com.example.ECOM.service;

import com.example.ECOM.Repository.ListRepo;
import com.example.ECOM.model.ListModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ListService {

    ListRepo listRepo;
    @Autowired
    ListService(ListRepo listRepo) {
        this.listRepo = listRepo;
    }

    public List<ListModel> findshoes(){
        return listRepo.viewshoes();
    }

}
