package com.example.ECOM.service;

import com.example.ECOM.Repository.PersonRepo;
import com.example.ECOM.Repository.RolesRepo;
import com.example.ECOM.constants.Constants;
import com.example.ECOM.model.Person;
import com.example.ECOM.model.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepo personRepo;
    private final RolesRepo rolesRepo;
    private final PasswordEncoder passwordEncoder;

    // Constructor-based dependency injection for both repositories
    @Autowired
    public PersonService(PersonRepo personRepo, RolesRepo rolesRepo, PasswordEncoder passwordEncoder) {
        this.personRepo = personRepo;
        this.rolesRepo = rolesRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean createNewPerson(Person person) {

        Roles role = rolesRepo.findByRoleName(Constants.USER);
        person.setRoles(role);
        person.setPwd(passwordEncoder.encode(person.getPwd()));//password Hashing

        person = personRepo.save(person);

        return (person != null && person.getPersonId() > 0); // Check if person was successfully saved
    }
}
