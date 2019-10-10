package com.dbms.fresh;

import java.util.List;

import javax.validation.Valid;

import com.dbms.fresh.dao.Categorydao;
import com.dbms.fresh.dao.Employeedao;
import com.dbms.fresh.dao.Productdao;
import com.dbms.fresh.dao.Supplierdao;
import com.dbms.fresh.dao.Supplyorderdao;
import com.dbms.fresh.model.Category;
import com.dbms.fresh.model.Employee;
import com.dbms.fresh.model.Product;
import com.dbms.fresh.model.Supplier;
import com.dbms.fresh.model.SupplyOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping("")
    public ModelAndView admin(ModelAndView model) {

        model.addObject("mess", "hi");
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
        List<Category> allcategories = cat.showAllCategories();
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
        List<Product> allproducts = pro.showAllProducts();
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
    public String updatequantityProcess(@Valid @ModelAttribute("product") Product p, BindingResult result) {
        Product pr = pro.getproductbyId(p.getProduct_id());
        int q = pr.getQuantity_left();
        if (q + p.getQuantity_left() >= 0)
            pro.updateProductquantity(p.getProduct_id(), q + p.getQuantity_left());
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
        // List<Supplier> s = sup.showAllsuppliers();
        // mod.addObject("suppliers", s);
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
        List<SupplyOrder> s = sod.getSupplyOrdersbySupplierId(supplier_id);
        model.addObject("allorders", s);
        model.addObject("name", sup.getSupplierbyId(supplier_id).getName());
        return model;
    }
}