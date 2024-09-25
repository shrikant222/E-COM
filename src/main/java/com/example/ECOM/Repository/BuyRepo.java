package com.example.ECOM.Repository;
import com.example.ECOM.model.BuyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface BuyRepo extends JpaRepository<BuyModel, Integer> {

    List<BuyModel> findByStatus(String status);


/*  External Query (Now using Spring Auditing)  */


//    @Transactional
//    @Modifying
//    @Query("UPDATE BuyModel b SET b.updatedBy = :name, b.updatedAt = :updatedAt, b.status = :status WHERE b.buyer_id = :id")
//    void updateMessageStatus(int id, String name, String status, LocalDateTime updatedAt);
}
