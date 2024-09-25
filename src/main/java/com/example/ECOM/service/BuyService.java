package com.example.ECOM.service;

import com.example.ECOM.Repository.BuyRepo;
import com.example.ECOM.constants.Constants;
import com.example.ECOM.model.BuyModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;




@Slf4j
@Service
public class BuyService {

    private final BuyRepo buyRepo;

    @Autowired
    public BuyService(BuyRepo buyRepo) {
        this.buyRepo = buyRepo;
    }



    public void saveMessageDetails(BuyModel buyModel) {
        buyModel.setStatus(Constants.OPEN);
        buyRepo.save(buyModel);

    }



    public List<BuyModel> findBuyers() {
        return buyRepo.findByStatus(Constants.OPEN);
    }



    public void closeMsg(int id) {
        Optional<BuyModel> buymodel = buyRepo.findById(id);
        if (buymodel.isPresent()) {
            BuyModel model = buymodel.get();
            model.setStatus(Constants.CLOSE);
            // Save the entity, which will trigger auditing
            buyRepo.save(model);
        }
    }

}
