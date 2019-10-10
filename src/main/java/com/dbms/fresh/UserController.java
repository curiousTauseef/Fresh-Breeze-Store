package com.dbms.fresh;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dbms.fresh.dao.Categorydao;
import com.dbms.fresh.dao.Productdao;
import com.dbms.fresh.dao.Userdao;
import com.dbms.fresh.model.Category;
import com.dbms.fresh.model.Product;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    Userdao userdao;
    @Autowired
    Productdao pro;
    @Autowired
    Categorydao cat;

    @RequestMapping("")
    public ModelAndView user() {

        ModelAndView model = new ModelAndView("user");
        model.addObject("user", "hi");
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
}
