package com.example.ECOM.Repository;
import com.example.ECOM.model.ListModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;





public interface ListRepo extends JpaRepository<ListModel, Long> {

    // Custom query method to find shoes by their type
    List<ListModel> findByType(ListModel.Type type);
}







