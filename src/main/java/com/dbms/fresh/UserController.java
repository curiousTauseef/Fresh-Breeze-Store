package com.dbms.fresh;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dbms.fresh.dao.Categorydao;
import com.dbms.fresh.dao.Ordersdao;
import com.dbms.fresh.dao.Paymentdao;
import com.dbms.fresh.dao.Productdao;
import com.dbms.fresh.dao.Userdao;
import com.dbms.fresh.model.Cart;
import com.dbms.fresh.model.Category;
import com.dbms.fresh.model.Payment;
import com.dbms.fresh.model.Product;
import com.dbms.fresh.model.Quantity;
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
    @Autowired
    Paymentdao pay;

    @RequestMapping("")
    public ModelAndView admin(Principal principal) {
        ModelAndView model = new ModelAndView("userhome");
        User user = userdao.findByUsername(principal.getName());
        model.addObject("mess", "hi " + user.getName());
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
        List<String> s = c.getProduct_ids();
        List<Product> products = new ArrayList<Product>();
        for (String st : s) {
            products.add(pro.getproductbyId(Integer.parseInt(st)));
        }
        model.addObject("products", products);
        model.addObject("username", username);
        return model;
    }

    @RequestMapping(value = "/finalprocessorder", method = RequestMethod.POST)
    public ModelAndView finalorder(@RequestBody MultiValueMap<String, String> formdata, Principal principal) {
        List<Product> err_products = new ArrayList<Product>();
        List<Product> products = new ArrayList<Product>();
        User user = userdao.findByUsername(principal.getName());
        String username = user.getUsername();
        for (Map.Entry<String, List<String>> s : formdata.entrySet()) {
            if (s.getKey().compareTo("product_id") == 0) {
                for (String x : s.getValue()) {
                    int product_id = Integer.parseInt(x);
                    int quantity = Integer.parseInt(formdata.getFirst("quantity" + x));
                    Product p = pro.getproductbyId(product_id);
                    int available = p.getQuantity_left();
                    if (available < quantity) {
                        err_products.add(p);
                    }
                    products.add(p);
                }
            }
        }
        if (err_products.size() != 0) {
            ModelAndView model = new ModelAndView("producterror");
            model.addObject("error", err_products);
            model.addObject("products", products);
            model.addObject("username", username);
            return model;
        }

        Double price = 0.0;
        List<Quantity> items = new ArrayList<Quantity>();
        for (Map.Entry<String, List<String>> s : formdata.entrySet()) {
            if (s.getKey().compareTo("product_id") == 0) {
                for (String x : s.getValue()) {
                    int product_id = Integer.parseInt(x);
                    int quantity = Integer.parseInt(formdata.getFirst("quantity" + x));
                    Quantity q = new Quantity();
                    q.setProduct_id(product_id);
                    q.setQuantity(quantity);
                    items.add(q);
                    price = price + quantity * (pro.getproductbyId(product_id).getSelling_price());
                }
            }
        }

        ModelAndView model = new ModelAndView("payment");
        Payment payment = new Payment();
        payment.setPrice(price);
        payment.setOrder_id(0);
        model.addObject("items", items);
        model.addObject("payment", payment);
        model.addObject("username", username);
        return model;
    }

    @RequestMapping(value = "/processpayment", method = RequestMethod.POST)
    public String processpayment(@RequestBody MultiValueMap<String, String> formdata,
            @Valid @ModelAttribute("payment") Payment payment, BindingResult result, Principal principal) {
        List<Quantity> items = new ArrayList<Quantity>();
        for (Map.Entry<String, List<String>> s : formdata.entrySet()) {
            if (s.getKey().compareTo("product_id") == 0) {
                for (String x : s.getValue()) {
                    int product_id = Integer.parseInt(x);
                    int quantity = Integer.parseInt(formdata.getFirst("quantity" + x));
                    Quantity q = new Quantity();
                    q.setProduct_id(product_id);
                    q.setQuantity(quantity);
                    items.add(q);
                }
            }
        }
        User user = userdao.findByUsername(principal.getName());
        String username = user.getUsername();
        int order_id = ord.save(username);
        Double price = payment.getPrice();
        for (Quantity q : items) {
            ord.createOrderItem(order_id, q.getProduct_id(), q.getQuantity());
            Product p = pro.getproductbyId(q.getProduct_id());
            pro.updateProductquantity(q.getProduct_id(), p.getQuantity_left() - q.getQuantity());
        }
        pay.save(payment.getMethod(), price, order_id);
        return "redirect:/user";
    }

}
