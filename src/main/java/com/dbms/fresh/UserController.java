package com.dbms.fresh;

import java.security.Principal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dbms.fresh.dao.Categorydao;
import com.dbms.fresh.dao.Employeedao;
import com.dbms.fresh.dao.Ordersdao;
import com.dbms.fresh.dao.Paymentdao;
import com.dbms.fresh.dao.Productdao;
import com.dbms.fresh.dao.Userdao;
import com.dbms.fresh.model.Cart;
import com.dbms.fresh.model.Category;
import com.dbms.fresh.model.Feedback;
import com.dbms.fresh.model.OrderItem;
import com.dbms.fresh.model.Orders;
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
    @Autowired
    Employeedao emp;
    @Autowired
    JdbcTemplate jt;

    @RequestMapping("")
    public ModelAndView admin(Principal principal) {
        ModelAndView model = new ModelAndView("userhome");
        User user = userdao.findByUsername(principal.getName());
        model.addObject("user", user);
        return model;
    }

    @RequestMapping(value = "/viewproducts", method = RequestMethod.GET)
    public ModelAndView showallproducts() {
        ModelAndView model = new ModelAndView("viewproducts");
        Map<Integer, String> category = new HashMap<Integer, String>();
        List<Product> allproducts = jt.query(
                "select product_id,p.name,selling_price,quantity_left,c.name,c.category_id from product p,category c where p.category_id=c.category_id",
                new ResultSetExtractor<List<Product>>() {

                    public List<Product> extractData(ResultSet row) throws SQLException, DataAccessException {
                        List<Product> allProduct = new ArrayList<Product>();
                        while (row.next()) {
                            Product u = new Product();
                            u.setProduct_id(row.getInt("product_id"));
                            u.setName(row.getString("name"));
                            u.setSelling_price(row.getDouble("selling_price"));
                            u.setQuantity_left(row.getInt("quantity_left"));
                            u.setCategory_id(row.getInt("category_id"));
                            allProduct.add(u);
                            category.put(row.getInt("category_id"),
                                    cat.getCategorybyId(row.getInt("category_id")).getName());
                        }
                        return allProduct;
                    }

                });
        model.addObject("category", category);
        model.addObject("allproducts", allproducts);
        return model;
    }

    @RequestMapping(value = "/viewcategories", method = RequestMethod.GET)
    public ModelAndView showallcategories() {
        ModelAndView model = new ModelAndView("viewcategories");
        Map<Integer, String> employee = new HashMap<Integer, String>();
        List<Category> allcategories = jt.query(
                "select category_id,c.name,e.name,e.employee_id from category c,employee e where c.employee_id=e.employee_id",
                new ResultSetExtractor<List<Category>>() {

                    public List<Category> extractData(ResultSet row) throws SQLException, DataAccessException {
                        List<Category> allCategory = new ArrayList<Category>();
                        while (row.next()) {
                            Category u = new Category();
                            u.setCategory_id(row.getInt("category_id"));
                            u.setName(row.getString("name"));
                            u.setEmployee_id(row.getInt("employee_id"));
                            allCategory.add(u);
                            employee.put(row.getInt("employee_id"),
                                    emp.getEmployeebyId(row.getInt("employee_id")).getName());
                        }
                        return allCategory;
                    }

                });
        model.addObject("employee", employee);
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
        return "redirect:/user/vieworders";
    }

    @RequestMapping(value = "/vieworders", method = RequestMethod.GET)
    public ModelAndView vieworders(Principal principal) {
        ModelAndView model = new ModelAndView("alluserorders");
        User user = userdao.findByUsername(principal.getName());
        String username = user.getUsername();
        Map<Integer, Payment> payments = new HashMap<Integer, Payment>();
        Map<Integer, Boolean> checkfeedback = new HashMap<Integer, Boolean>();
        List<Orders> allorders = jt.query(
                "select order_id,status,order_date,method,price from orders natural join payment where username='"
                        + username + "'",
                new ResultSetExtractor<List<Orders>>() {
                    public List<Orders> extractData(ResultSet row) throws SQLException, DataAccessException {
                        List<Orders> allOrders = new ArrayList<Orders>();
                        while (row.next()) {
                            Orders u = new Orders();
                            Payment p = new Payment();
                            u.setOrder_id(row.getInt("order_id"));
                            u.setStatus(row.getString("status"));
                            u.setOrder_date(row.getDate("order_date"));
                            p.setMethod(row.getString("method"));
                            p.setPrice(row.getDouble("price"));
                            allOrders.add(u);
                            payments.put(row.getInt("order_id"), p);
                            checkfeedback.put(row.getInt("order_id"), ord.feebackExist(row.getInt("order_id")));
                        }
                        return allOrders;
                    }
                });
        model.addObject("check", checkfeedback);
        model.addObject("payments", payments);
        model.addObject("username", username);
        model.addObject("allorders", allorders);
        return model;
    }

    @RequestMapping(value = "/viewdetails/{order_id}", method = RequestMethod.GET)
    public ModelAndView viewdetails(Principal principal, @PathVariable("order_id") int order_id) {
        ModelAndView model = new ModelAndView("orderdetails");
        Map<Integer, Product> products = new HashMap<Integer, Product>();
        List<OrderItem> allitems = jt
                .query("select name,quantity,ord_item_id from product natural join order_item where order_id='"
                        + order_id + "'", new ResultSetExtractor<List<OrderItem>>() {
                            public List<OrderItem> extractData(ResultSet row) throws SQLException, DataAccessException {
                                List<OrderItem> allOrderItem = new ArrayList<OrderItem>();
                                while (row.next()) {
                                    OrderItem u = new OrderItem();
                                    Product p = new Product();
                                    u.setOrd_item_id(row.getInt("ord_item_id"));
                                    u.setQuantity(row.getInt("quantity"));
                                    p.setName(row.getString("name"));
                                    allOrderItem.add(u);
                                    products.put(row.getInt("ord_item_id"), p);
                                }
                                return allOrderItem;
                            }
                        });
        model.addObject("allitems", allitems);
        model.addObject("products", products);
        return model;
    }

    @RequestMapping(value = "/addfeedback/{order_id}", method = RequestMethod.GET)
    public ModelAndView addfeedback(Principal principal, @PathVariable("order_id") int order_id) {
        ModelAndView model = new ModelAndView("feedback");
        Feedback feedback = new Feedback();
        feedback.setOrder_id(order_id);
        model.addObject("feedback", feedback);
        return model;
    }

    @RequestMapping(value = "/processfeedback", method = RequestMethod.POST)
    public String registeremployeeProcess(@Valid @ModelAttribute("feedback") Feedback f, BindingResult result) {
        ord.saveFeedback(f.getType(), f.getRating(), f.getComment(), f.getOrder_id());
        return "redirect:/user/vieworders";
    }

}
