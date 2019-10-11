package com.dbms.fresh;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dbms.fresh.dao.Categorydao;
import com.dbms.fresh.dao.Ordersdao;
import com.dbms.fresh.dao.Productdao;
import com.dbms.fresh.dao.Userdao;
import com.dbms.fresh.model.Cart;
import com.dbms.fresh.model.Category;
import com.dbms.fresh.model.Orders;
import com.dbms.fresh.model.Product;
import com.dbms.fresh.model.User;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    Userdao userdao;
    @Autowired
    Productdao pro;
    @Autowired
    Categorydao cat;
    @Autowired
    Ordersdao ord;

    @RequestMapping("")
    public ModelAndView admin(Principal principal) {
        ModelAndView model = new ModelAndView("userhome");
        User user = userdao.findByUsername(principal.getName());
        model.addObject("mess", "hi" + user.getName());
        return model;
    }

    @RequestMapping(value = "/viewproducts", method = RequestMethod.GET)
    public ModelAndView showallproducts() {
        ModelAndView model = new ModelAndView("viewproducts");
        List<Product> allproducts = pro.showAllProducts();
        model.addObject("allproducts", allproducts);
        return model;
    }

    @RequestMapping(value = "/viewcategories", method = RequestMethod.GET)
    public ModelAndView showallcategories() {
        ModelAndView model = new ModelAndView("viewcategories");
        List<Category> allcategories = cat.showAllCategories();
        model.addObject("allcategories", allcategories);
        return model;
    }

    @RequestMapping(value = "/placeorder")
    public ModelAndView placeOrder(Principal principal) {
        ModelAndView model = new ModelAndView("placeorder");
        Cart cart = new Cart();
        User user = userdao.findByUsername(principal.getName());
        String username = user.getUsername();
        model.addObject("cart", cart);
        List<Product> allproducts = pro.showAllProducts();
        Map<String, String> products = new HashMap<String, String>();
        for (Product p : allproducts) {
            products.put(Integer.toString(p.getProduct_id()), p.getName());
        }
        model.addObject("username", username);
        model.addObject("products", products);
        return model;
    }

    @RequestMapping(value = "/processorder", method = RequestMethod.POST)
    public ModelAndView processorder(@Valid @ModelAttribute("cart") Cart c, BindingResult result, Principal principal) {
        ModelAndView model = new ModelAndView("processorder");
        User user = userdao.findByUsername(principal.getName());
        String username = user.getUsername();
        int order_id = ord.save(username);
        List<String> s = c.getProduct_ids();
        List<Product> products = new ArrayList<Product>();
        for (String st : s) {
            products.add(pro.getproductbyId(Integer.parseInt(st)));
        }
        if (products.isEmpty())
            ord.deleteorder(order_id);
        model.addObject("products", products);
        model.addObject("username", username);
        model.addObject("order_id", order_id);
        return model;
    }

    @RequestMapping(value = "/finalprocessorder", method = RequestMethod.POST)
    public ModelAndView finalorder() {
        ModelAndView model = new ModelAndView("finalorder");
        return model;
    }

}
