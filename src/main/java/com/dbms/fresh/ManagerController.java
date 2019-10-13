package com.dbms.fresh;

import java.security.Principal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.dbms.fresh.dao.Categorydao;
import com.dbms.fresh.dao.Employeedao;
import com.dbms.fresh.dao.Ordersdao;
import com.dbms.fresh.dao.Productdao;
import com.dbms.fresh.dao.Supplierdao;
import com.dbms.fresh.dao.Supplyorderdao;
import com.dbms.fresh.dao.Userdao;
import com.dbms.fresh.model.Category;
import com.dbms.fresh.model.Employee;
import com.dbms.fresh.model.Feedback;
import com.dbms.fresh.model.OrderItem;
import com.dbms.fresh.model.Orders;
import com.dbms.fresh.model.Payment;
import com.dbms.fresh.model.Product;
import com.dbms.fresh.model.Supplier;
import com.dbms.fresh.model.SupplyOrder;
import com.dbms.fresh.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/manager")
@Controller
public class ManagerController {
    @Autowired
    Employeedao emp;
    @Autowired
    Categorydao cat;
    @Autowired
    Productdao pro;
    @Autowired
    Supplierdao sup;
    @Autowired
    Supplyorderdao sod;
    @Autowired
    Ordersdao ord;
    @Autowired
    Userdao userdao;
    @Autowired
    JdbcTemplate jt;

    @RequestMapping("")
    public ModelAndView admin(Principal principal) {
        ModelAndView model = new ModelAndView("managerhome");
        User user = userdao.findByUsername(principal.getName());
        model.addObject("user", user);
        return model;
    }

    @RequestMapping(value = "/registeremployee", method = RequestMethod.GET)
    public ModelAndView registeremployee() {

        ModelAndView model = new ModelAndView("registeremployee");
        Employee employee = new Employee();
        model.addObject("employee", employee);
        return model;
    }

    @RequestMapping(value = "/registeremployee", method = RequestMethod.POST)
    public String registeremployeeProcess(@Valid @ModelAttribute("employee") Employee e, BindingResult result) {
        emp.save(e.getName(), e.getContact(), e.getEmail(), e.getHouse_no(), e.getStreet_name(), e.getCity(),
                e.getJoining_date(), e.getSalary(), e.getAccount_no());
        return "redirect:/manager/showallemployees";
    }

    @RequestMapping(value = "/showallemployees", method = RequestMethod.GET)
    public ModelAndView showallemployees() {
        ModelAndView model = new ModelAndView("adminallemployees");
        List<Employee> allemployees = emp.showAllEmployees();
        model.addObject("allemployees", allemployees);
        return model;
    }

    @RequestMapping(value = "/updateemployee/{employee_id}", method = RequestMethod.GET)
    public ModelAndView updateEmployee(@PathVariable(value = "employee_id") int emp_id) {
        ModelAndView model = new ModelAndView("updateemployee");
        Employee employee = new Employee();
        Employee em = emp.getEmployeebyId(emp_id);
        employee.setEmployee_id(emp_id);
        employee.setName(em.getName());
        employee.setJoining_date(em.getJoining_date());
        model.addObject("employee", employee);
        return model;
    }

    @RequestMapping(value = "/updateemployee", method = RequestMethod.POST)
    public String updateEmployeeProcess(@Valid @ModelAttribute("employee") Employee e, BindingResult result) {
        emp.updateEmployee(e.getEmployee_id(), e.getName(), e.getContact(), e.getEmail(), e.getHouse_no(),
                e.getStreet_name(), e.getCity(), e.getJoining_date(), e.getSalary(), e.getAccount_no());
        return "redirect:/manager/showallemployees";
    }

    @RequestMapping(value = "/removeemployee/{employee_id}")
    public String removeEmployee(@PathVariable(value = "employee_id") int emp_id) {
        emp.deleteEmployee(emp_id);
        return "redirect:/manager/showallemployees";
    }

    @RequestMapping(value = "/addcategory", method = RequestMethod.GET)
    public ModelAndView addCategory() {
        ModelAndView model = new ModelAndView("addcategory");
        Category category = new Category();
        model.addObject("category", category);
        List<Employee> e = emp.showAllEmployees();
        // System.out.println(e.getName());
        model.addObject("employees", e);
        return model;
    }

    @RequestMapping(value = "/addcategory", method = RequestMethod.POST)
    public String addCategoryProcess(@Valid @ModelAttribute("category") Category c, BindingResult result) {
        cat.save(c.getName(), c.getEmployee_id());
        return "redirect:/manager/showallcategories";
    }

    @RequestMapping(value = "/showallcategories", method = RequestMethod.GET)
    public ModelAndView showallcategories() {
        ModelAndView model = new ModelAndView("adminallcategories");
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

    @RequestMapping(value = "/updatecategory/{category_id}", method = RequestMethod.GET)
    public ModelAndView updateCategory(@PathVariable(value = "category_id") int cat_id) {
        ModelAndView model = new ModelAndView("updatecategory");
        Category category = new Category();
        Category ca = cat.getCategorybyId(cat_id);
        category.setCategory_id(cat_id);
        category.setName(ca.getName());
        model.addObject("category", category);
        return model;
    }

    @RequestMapping(value = "/updatecategory", method = RequestMethod.POST)
    public String updateCategoryProcess(@Valid @ModelAttribute("category") Category c, BindingResult result) {
        cat.updateCategory(c.getCategory_id(), c.getName(), c.getEmployee_id());
        return "redirect:/manager/showallcategories";
    }

    @RequestMapping(value = "/removecategory/{category_id}", method = RequestMethod.GET)
    public String removecategory(@PathVariable(value = "category_id") int cat_id) {
        cat.deleteCategory(cat_id);
        return "redirect:/manager/showallcategories";
    }

    @RequestMapping(value = "/addproduct", method = RequestMethod.GET)
    public ModelAndView addproduct() {
        ModelAndView model = new ModelAndView("addproduct");
        Product product = new Product();
        model.addObject("product", product);
        return model;
    }

    @RequestMapping(value = "/addproduct", method = RequestMethod.POST)
    public String addProductProcess(@Valid @ModelAttribute("product") Product p, BindingResult result) {
        pro.save(p.getName(), p.getSelling_price(), p.getQuantity_left(), p.getCategory_id());
        return "redirect:/manager/showallproducts";
    }

    @RequestMapping(value = "/showallproducts", method = RequestMethod.GET)
    public ModelAndView showallproducts() {
        ModelAndView model = new ModelAndView("adminallproducts");
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

    @RequestMapping(value = "/updateproduct/{product_id}", method = RequestMethod.GET)
    public ModelAndView updateproduct(@PathVariable(value = "product_id") int pro_id) {
        ModelAndView model = new ModelAndView("updateproduct");
        Product product = new Product();
        Product pr = pro.getproductbyId(pro_id);
        product.setProduct_id(pro_id);
        product.setName(pr.getName());
        model.addObject("product", product);
        return model;
    }

    @RequestMapping(value = "/updateproduct", method = RequestMethod.POST)
    public String updateproductProcess(@Valid @ModelAttribute("product") Product p, BindingResult result) {
        pro.updateproduct(p.getProduct_id(), p.getName(), p.getSelling_price(), p.getQuantity_left(),
                p.getCategory_id());
        return "redirect:/manager/showallproducts";
    }

    @RequestMapping(value = "/updatequantity/{product_id}", method = RequestMethod.GET)
    public ModelAndView updatequantity(@PathVariable("product_id") int id) {
        ModelAndView model = new ModelAndView("updatequantity");
        Product product = new Product();
        Product pr = pro.getproductbyId(id);
        product.setProduct_id(id);
        product.setName(pr.getName());
        product.setSelling_price(pr.getSelling_price());
        product.setCategory_id(pr.getCategory_id());
        model.addObject("product", product);
        return model;
    }

    @RequestMapping(value = "/updatequantity", method = RequestMethod.POST)
    public String updatequantityProcess(@Valid @ModelAttribute("product") Product p, BindingResult result, Model m) {
        Product pr = pro.getproductbyId(p.getProduct_id());
        int q = pr.getQuantity_left();
        if (q + p.getQuantity_left() >= 0)
            pro.updateProductquantity(p.getProduct_id(), q + p.getQuantity_left());
        else {
            Product product = new Product();
            product.setProduct_id(p.getProduct_id());
            product.setName(pr.getName());
            product.setSelling_price(pr.getSelling_price());
            product.setCategory_id(pr.getCategory_id());
            m.addAttribute("product", product);
            m.addAttribute("pr", pr);
            return "errorchange";
        }
        return "redirect:/manager/showallproducts";
    }

    @RequestMapping(value = "/removeproduct/{product_id}", method = RequestMethod.GET)
    public String removeproduct(@PathVariable(value = "product_id") int pro_id) {
        pro.deleteproduct(pro_id);
        return "redirect:/manager/showallproducts";
    }

    @RequestMapping(value = "/registersupplier", method = RequestMethod.GET)
    public ModelAndView registersupplier() {

        ModelAndView model = new ModelAndView("registersupplier");
        Supplier supplier = new Supplier();
        model.addObject("supplier", supplier);
        return model;
    }

    @RequestMapping(value = "/registersupplier", method = RequestMethod.POST)
    public String registersupplierProcess(@Valid @ModelAttribute("supplier") Supplier e, BindingResult result) {
        sup.save(e.getName(), e.getContact(), e.getEmail(), e.getHouse_no(), e.getStreet_name(), e.getCity(),
                e.getAccount_no());
        // System.out.print(e.getName());
        return "redirect:/manager/showallsuppliers";
    }

    @RequestMapping(value = "/showallsuppliers", method = RequestMethod.GET)
    public ModelAndView showallsuppliers() {
        ModelAndView model = new ModelAndView("adminallsuppliers");
        List<Supplier> allsuppliers = sup.showAllsuppliers();
        model.addObject("allsuppliers", allsuppliers);
        return model;
    }

    @RequestMapping(value = "/updatesupplier/{supplier_id}", method = RequestMethod.GET)
    public ModelAndView updatesupplier(@PathVariable(value = "supplier_id") int sup_id) {
        ModelAndView model = new ModelAndView("updatesupplier");
        Supplier supplier = new Supplier();
        Supplier sp = sup.getSupplierbyId(sup_id);
        supplier.setSupplier_id(sup_id);
        supplier.setName(sp.getName());
        model.addObject("supplier", supplier);
        return model;
    }

    @RequestMapping(value = "/updatesupplier", method = RequestMethod.POST)
    public String updatesupplierProcess(@Valid @ModelAttribute("supplier") Supplier e, BindingResult result) {
        sup.updateSupplier(e.getSupplier_id(), e.getName(), e.getContact(), e.getEmail(), e.getHouse_no(),
                e.getStreet_name(), e.getCity(), e.getAccount_no());
        return "redirect:/manager/showallsuppliers";
    }

    @RequestMapping(value = "/removesupplier/{supplier_id}")
    public String removesupplier(@PathVariable(value = "supplier_id") int sup_id) {
        sup.deleteSupplier(sup_id);
        return "redirect:/manager/showallsuppliers";
    }

    @RequestMapping(value = "/supplyorder/{supplier_id}", method = RequestMethod.GET)
    public ModelAndView placesupplyorder(@PathVariable(value = "supplier_id") int sup_id) {
        ModelAndView mod = new ModelAndView("supplyorder");
        SupplyOrder supply = new SupplyOrder();
        mod.addObject("supplyorder", supply);
        List<Product> p = pro.showAllProducts();
        mod.addObject("products", p);
        mod.addObject("supplier", sup_id);
        return mod;
    }

    @RequestMapping(value = "/supplyorder", method = RequestMethod.POST)
    public String placeSupplyOrderprocess(@Valid @ModelAttribute("supplyorder") SupplyOrder s, BindingResult result) {
        Product product = pro.getproductbyId(s.getProduct_id());
        Double price = product.getSelling_price() * s.getQuantity();
        Category category = cat.getCategorybyId(product.getCategory_id());
        Employee employee = emp.getEmployeebyId(category.getEmployee_id());
        int supplier_id = s.getSupplier_id();
        sod.save(s.getQuantity(), price, s.getProduct_id(), supplier_id, employee.getEmployee_id());
        pro.updateProductquantity(s.getProduct_id(), product.getQuantity_left() + s.getQuantity());
        return "redirect:/manager/showsupplyorders/" + supplier_id;
    }

    @RequestMapping(value = "/showsupplyorders/{supplier_id}")
    public ModelAndView showsupplyorders(@PathVariable("supplier_id") int supplier_id) {
        ModelAndView model = new ModelAndView("showsupplyorders");
        Map<Integer, String> employees = new HashMap<Integer, String>();
        Map<Integer, String> products = new HashMap<Integer, String>();
        List<SupplyOrder> s = jt.query(
                "select supply_order_id,supply_order_date,p.product_id,supplier_id,s.employee_id,supply_order_status,s.quantity,s.price,p.name,e.name from supply_order s,product p,employee e where p.product_id=s.product_id and e.employee_id=s.employee_id and supplier_id='"
                        + supplier_id + "'",
                new ResultSetExtractor<List<SupplyOrder>>() {
                    public List<SupplyOrder> extractData(ResultSet row) throws SQLException, DataAccessException {
                        List<SupplyOrder> allSupplyOrder = new ArrayList<SupplyOrder>();
                        while (row.next()) {
                            SupplyOrder s = new SupplyOrder();
                            s.setSupply_order_id(row.getInt("supply_order_id"));
                            s.setSupply_order_date(row.getDate("supply_order_date"));
                            s.setSupply_order_status(row.getString("supply_order_status"));
                            s.setQuantity(row.getInt("quantity"));
                            s.setPrice(row.getDouble("price"));
                            s.setProduct_id(row.getInt("product_id"));
                            s.setSupplier_id(row.getInt("supplier_id"));
                            s.setEmployee_id(row.getInt("employee_id"));
                            allSupplyOrder.add(s);
                            Employee e = emp.getEmployeebyId(row.getInt("employee_id"));
                            Product p = pro.getproductbyId(row.getInt("product_id"));
                            products.put(row.getInt("supply_order_id"), p.getName());
                            employees.put(row.getInt("supply_order_id"), e.getName());
                        }
                        return allSupplyOrder;
                    }
                });
        model.addObject("employees", employees);
        model.addObject("products", products);
        model.addObject("allorders", s);
        model.addObject("name", sup.getSupplierbyId(supplier_id).getName());
        return model;
    }

    @RequestMapping(value = "/showallusers", method = RequestMethod.GET)
    public ModelAndView showallusers() {
        ModelAndView model = new ModelAndView("adminallusers");
        List<User> users = userdao.getAllusers();
        model.addObject("users", users);
        return model;
    }

    @RequestMapping(value = "/viewuserorders/{username}", method = RequestMethod.GET)
    public ModelAndView viewuserorders(@PathVariable("username") String username) {
        ModelAndView model = new ModelAndView("adminuserorders");
        Map<Integer, Payment> payments = new HashMap<Integer, Payment>();
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
                        }
                        return allOrders;
                    }
                });
        model.addObject("payments", payments);
        model.addObject("allorders", allorders);
        model.addObject("username", username);
        return model;
    }

    @RequestMapping(value = "/viewuserorderdetails/{order_id}", method = RequestMethod.GET)
    public ModelAndView viewuserorderdetails(@PathVariable("order_id") int order_id) {
        ModelAndView model = new ModelAndView("viewuserorderdetails");
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

    @RequestMapping(value = "/viewfeedback/{order_id}")
    public ModelAndView viewfeedback(@PathVariable("order_id") int order_id) {
        ModelAndView model = new ModelAndView("viewfeedback");
        if (ord.feebackExist(order_id)) {
            Feedback feedback = ord.getFeedback(order_id);
            model.addObject("check", "true");
            model.addObject("feedback", feedback);
        } else {
            model.addObject("check", "false");
        }
        return model;
    }
}