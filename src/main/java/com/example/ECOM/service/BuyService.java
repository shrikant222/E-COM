package com.example.ECOM.service;

import com.example.ECOM.Repository.BuyRepo;
import com.example.ECOM.constants.Constants;
import com.example.ECOM.model.BuyModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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



    public Page<BuyModel> findBuyers(int pageNum, String sortField, String sortDir){
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize,
                sortDir.equals("asc") ? Sort.by(sortField).ascending()
                        : Sort.by(sortField).descending());
        Page<BuyModel> buy = buyRepo.findByStatus(Constants.OPEN,pageable);
        return buy;
    }



//    public void closeMsg(int id) {
//        Optional<BuyModel> buymodel = buyRepo.findById(id);
//
//        if (buymodel.isPresent()) {
//            BuyModel model = buymodel.get();
//            model.setStatus(Constants.CLOSE);
//            // Save the entity, which will trigger auditing
//            buyRepo.save(model);
//        }
//    }
public void closeMsg(int id) {
   buyRepo.updateStatusById(Constants.CLOSE, id);

}

}
