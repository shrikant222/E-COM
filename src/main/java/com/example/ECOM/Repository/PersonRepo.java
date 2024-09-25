package com.example.ECOM.Repository;


import com.example.ECOM.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepo extends CrudRepository<Person, Integer> {

}
