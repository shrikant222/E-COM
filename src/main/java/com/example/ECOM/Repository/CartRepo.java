package com.example.ECOM.Repository;

import com.example.ECOM.model.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepo extends CrudRepository<Cart, Integer> {

    // Sort the results by a specific field, such as 'id' in descending order.
    List<Cart> findAllByOrderByItemIdDesc();

    // Finds a Cart by its ID
    Cart findById(int id);

}

