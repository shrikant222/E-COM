package com.example.ECOM.Controller;

import com.example.ECOM.Repository.CartRepo;
import com.example.ECOM.model.Cart;
import com.example.ECOM.model.Person;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    CartRepo cartRepo;

    @Autowired
    public AdminController(CartRepo cartRepo) {
        this.cartRepo = cartRepo;
    }


    @GetMapping("/displaycart")
    public ModelAndView displayCart(Model model) {
        List<Cart> carts= cartRepo.findAllByOrderByItemIdDesc();
        ModelAndView modelAndView = new ModelAndView("courses_secure");
        modelAndView.addObject("carts", carts);
        modelAndView.addObject("cart", new Cart());
        modelAndView.addObject("person", new Person());
        return modelAndView;
    }
    @PostMapping("/additems")
    public ModelAndView addNewItem(@ModelAttribute("cart") Cart cart) {
        ModelAndView modelAndView = new ModelAndView();
        cartRepo.save(cart);
        modelAndView.setViewName("redirect:/admin/displaycart");
        return modelAndView;
    }

    @GetMapping("/viewBuyer")
    public ModelAndView viewStudents(Model model, @RequestParam int id
            , HttpSession session, @RequestParam(required = false) String error) {
        String errorMessage = null;
        ModelAndView modelAndView = new ModelAndView("CartDisplay");
        Cart carts = cartRepo.findById(id);
        modelAndView.addObject("carts",carts);
        modelAndView.addObject("person",new Person());
        session.setAttribute("carts",carts);
        if(error != null) {
            errorMessage = "Invalid Email entered!!";
            modelAndView.addObject("errorMessage", errorMessage);
        }
        return modelAndView;
    }


}
