package com.example.ECOM.Controller;

import com.example.ECOM.Repository.CartRepo;
import com.example.ECOM.Repository.PersonRepo;
import com.example.ECOM.model.Cart;
import com.example.ECOM.model.Person;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
import java.util.Set;

@Controller
public class CartController {
    CartRepo cartRepo;
    PersonRepo personRepo;

    @Autowired
    public CartController(CartRepo cartRepo, PersonRepo personRepo) {
        this.cartRepo = cartRepo;
        this.personRepo=personRepo;
    }




@RequestMapping("/addtocart")
    public ModelAndView addToCart(@RequestParam(value="Id", required = false, defaultValue = "0") int Id, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        Person personEntity = (Person) session.getAttribute("logInPerson");
        Cart cart = cartRepo.findById(Id);

        if(personEntity==null || !(personEntity.getPersonId()>0)){
            modelAndView.setViewName("redirect:/admin/viewBuyer?id="+cart.getItemId()
                    +"&error=true");
            return modelAndView;
        }

    personEntity.getCarts().add(cart);
    cart.getPersons().add(personEntity);
    personRepo.save(personEntity);
    session.setAttribute("carts", cart);
    modelAndView.setViewName("redirect:/cart?id="+cart.getItemId());
    return modelAndView;




    }






@RequestMapping("/cart")
    public ModelAndView viewCart(HttpSession session, @RequestParam int id, @RequestParam(required = false) String error) {
        String errorMessage=null;
        ModelAndView mv = new ModelAndView();
    ModelAndView modelAndView = new ModelAndView("CartDisplay");
    Cart carts = cartRepo.findById(id);
    modelAndView.addObject("carts",carts);
    session.setAttribute("carts",carts);
    if(error != null) {
        errorMessage = "Invalid Email entered!!";
        modelAndView.addObject("errorMessage", errorMessage);
    }
    return modelAndView;
    }







}
