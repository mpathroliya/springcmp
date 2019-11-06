package com.example1.demo1.controllers;

import java.util.List;

import com.example1.demo1.dao.Productdao;
import com.example1.demo1.dao.Supplierdao;
import com.example1.demo1.dao.Customerdao;
import com.example1.demo1.dao.Ordersdao;
import com.example1.demo1.models.Customer;
import com.example1.demo1.models.Exhibit;
import com.example1.demo1.models.Orders;
import com.example1.demo1.models.Product;
import com.example1.demo1.models.Supplier;

import com.example1.demo1.dao.Userdao;
import com.example1.demo1.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AdminController {

    @Autowired
    Productdao productdao;
    @Autowired
    Ordersdao ordersdao;
    @Autowired
    Userdao userdao;
    @Autowired
    Customerdao customerdao;


    @RequestMapping("/admin")
    public String index() {
        // model.addAttribute("greeting", message);
        return "Mhome";
    }

    @RequestMapping("/admin/viewUsers")
    public String viewUsers(Model m){
        List<Customer> list1=customerdao.getCustomer();
        m.addAttribute("list1",list1);
        // List<Exhibit> list2=exhibitdao.getExhibit();
        // m.addAttribute("list2",list2);
        return "viewAllUsers";
    }

    @RequestMapping("/admin/addProduct")
    public String save(Model m ){
        m.addAttribute( "command",new Product() );
        return "ProductForm";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("pro") Product pro) {
        productdao.addProduct(pro.getName(), pro.getPrice(), pro.getDescription(), pro.getSupplierId());
        
        return "redirect:/admin/viewProduct";
    }


    @RequestMapping("/admin/queryByUsername")
    public String queryForm(Model m){
        m.addAttribute("command", new User());
        return "QueryForm";
    }

    @PostMapping("/go")
    public String go(@ModelAttribute("uname") User u){
        String id = u.getUserName();
        return "redirect:/admin/uQuery/"+ id;
    }

    @RequestMapping("/admin/uQuery/{UserName}")
    public String queryByUsername(@PathVariable("UserName") String UserName, Model m){
        List <Orders> list = ordersdao.getOrdersByUser(UserName);
        m.addAttribute("list", list);
        return "viewOrderbyUser";
    }


    // @RequestMapping(value="/customer/orderProducts/{OrderId}")
    // public String orderProduct(@PathVariable("OrderId") int OrderId,Model m){
        
    //     List<Product> list = productdao.getProductWithOrderId(OrderId);
    //     m.addAttribute("list", list);
    //     return "orderProducts";

    // }

    @RequestMapping("/admin/viewProduct")
    public String viewProduct(Model m){
        List<Product> list=productdao.getProduct();
        m.addAttribute("list",list);
        return "viewProduct";  
    }

    @RequestMapping("/admin/viewAllOrders")
    public String viewAllOrders(Model m){
        List<Orders> list=ordersdao.getAllOrders();
        m.addAttribute("list",list);
        return "viewAllOrders";
    }
    @RequestMapping("/admin/viewCustomerOrders")
    public String viewCustomerOrders(Model m){
        List<Orders> list=ordersdao.getCustomerOrders();
        m.addAttribute("list",list);
        return "viewCustomerOrders";
    }

    @RequestMapping("/admin/viewExhibitOrders")
    public String viewExhibitOrders(Model m){
        List<Orders> list=ordersdao.getExhibitOrders();
        m.addAttribute("list",list);
        return "viewExhibitOrders";
    }
   
    @RequestMapping("/admin/viewDeliveredOrders")
    public String viewDeliveredOrders(Model m){
        List<Orders> list=ordersdao.getOrdersByStatus("delivered");
        m.addAttribute("list",list);
        return "viewStatusOrders";
    }

    @RequestMapping("/admin/viewPlacedOrders")
    public String viewPlacedOrders(Model m){
        List<Orders> list=ordersdao.getOrdersByStatus("placed");
        m.addAttribute("list",list);
        return "viewStatusOrders";
    }

    @RequestMapping("/admin/viewProcessingOrders")
    public String viewProcessingOrders(Model m){
        List<Orders> list=ordersdao.getOrdersByStatus("processing");
        m.addAttribute("list",list);
        return "viewStatusOrders";
    }

    @RequestMapping(value="/admin/orderProducts/{OrderId}")
    public String orderProduct(@PathVariable("OrderId") int OrderId,Model m){
        
        List<Product> list = productdao.getProductWithOrderId(OrderId);
        m.addAttribute("list", list);
        return "orderProductsM";

    }




    @RequestMapping(value="/admin/orderDelivered/{id}",method = RequestMethod.GET)  
    public String orderDelivered(@PathVariable int id){
        ordersdao.updateStatus("delivered",id);  
        return "redirect:/admin/viewAllOrders";
    }
    @RequestMapping(value="/admin/orderProcessing/{id}",method = RequestMethod.GET)  
    public String orderProcessing(@PathVariable int id){
        ordersdao.updateStatus("processing",id);  
        return "redirect:/admin/viewAllOrders";
    }

    
    @Autowired
    Supplierdao dao1;

    @RequestMapping("/admin/addSupplier")
    public String save1(Model m ){
        m.addAttribute( "command",new Supplier() );
        return "SupplierForm";
    }
    @PostMapping("/save1")
    public String save1(@ModelAttribute("pro") Supplier pro) {
        dao1.addSupplier(pro.getCompany(), pro.getAddress(), pro.getPhno());
        
        return "redirect:/admin/viewSupplier";
    }
    

    @RequestMapping("/admin/updateSupplier")
    public String upsup(Model m ){
        m.addAttribute( "command",new Supplier() );
        return "SupplierFormUp";
    }
    @PostMapping("/upsup")
    public String upsup1(@ModelAttribute("pro") Supplier pro) {
        dao1.updateSupplier(pro.getSupplierId(),pro.getCompany(), pro.getAddress(), pro.getPhno());
        
        return "redirect:/admin/viewSupplier";
    }
    
    @RequestMapping("/admin/updateProduct")
    public String uppro(Model m ){
        m.addAttribute( "command",new Product() );
        return "ProductFormUp";
    }
    @PostMapping("/uppro")
    public String uppro1(@ModelAttribute("pro") Product pro) {
        productdao.updateProduct(pro.getProductId(),pro.getName(), pro.getPrice(), pro.getDescription());
        
        return "redirect:/admin/viewProduct";
    }

    

    

    @RequestMapping("/admin/viewSupplier")
    public String viewSupplier(Model m){
        List<Supplier> list=dao1.getSupplier();
        m.addAttribute("list",list);
        return "viewSupplier";  
    }

    @RequestMapping(value="/admin/deleteSupplier/{id}",method = RequestMethod.GET)  
    public String deletes(@PathVariable int id){
        dao1.deleteSupplier(id);  
        return "redirect:/admin/viewSupplier";
    }


    // @Autowired
    // Ordersdao dao2;

    // @RequestMapping("/viewOrdersm")
    // public String viewExhibitOrders(Model m){
    //     List<Orders> list1=dao2.getExhibitOrders();
    //     m.addAttribute("list1",list1);
    //     List<Orders> list2=dao2.getCustomerOrders();
    //     m.addAttribute("list2",list2);
    //     List<Orders> list3=dao2.getStoreOrders();
    //     m.addAttribute("list3",list3);
    //     return "viewOrdersm";  
    // }




    // @RequestMapping("/viewCustomerOrders")
    // public String viewCustomerOrders(Model m){
    //     List<Orders> list2=dao2.getCustomerOrders();
    //     m.addAttribute("list2",list2);
    //     return "viewCustomerOrders";  
    // }

    // @RequestMapping("/viewStoreOrders")
    // public String viewStoreOrders(Model m){
    //     List<Orders> list3=dao2.getStoreOrders();
    //     m.addAttribute("list3",list3);
    //     return "viewStoreOrders";  
    // }


}