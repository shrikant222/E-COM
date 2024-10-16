package com.example.ECOM.Repository;
import com.example.ECOM.model.BuyModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface BuyRepo extends JpaRepository<BuyModel, Integer> {

    List<BuyModel> findByStatus(String status);



    Page<BuyModel> findByStatus(String status,Pageable pageable);




    @Transactional
    @Modifying
    @Query("UPDATE BuyModel c SET c.status = ?1 WHERE c.buyer_id = ?2")
    int updateStatusById(String status, int id);




/*  External Query (Now using Spring Auditing)  */


//    @Transactional
//    @Modifying
//    @Query("UPDATE BuyModel b SET b.updatedBy = :name, b.updatedAt = :updatedAt, b.status = :status WHERE b.buyer_id = :id")
//    void updateMessageStatus(int id, String name, String status, LocalDateTime updatedAt);
}
