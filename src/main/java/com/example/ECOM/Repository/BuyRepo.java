package com.example.ECOM.Repository;
import com.example.ECOM.model.BuyModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


@Repository
public interface BuyRepo extends JpaRepository<BuyModel, Integer> {

    List<BuyModel> findByStatus(String status);

    @Transactional
    @Modifying
    @Query("UPDATE BuyModel b SET b.updatedBy = :name, b.updatedAt = :updatedAt, b.status = :status WHERE b.buyer_id = :id")
    void updateMessageStatus(int id, String name, String status, LocalDateTime updatedAt);
}
