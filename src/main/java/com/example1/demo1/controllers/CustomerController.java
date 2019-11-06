package com.example1.demo1.controllers;

import java.security.Principal;
import java.util.List;

import com.example1.demo1.dao.Customerdao;
import com.example1.demo1.dao.Ordersdao;
import com.example1.demo1.dao.ProductOrderdao;
import com.example1.demo1.dao.Productdao;
import com.example1.demo1.models.Customer;
import com.example1.demo1.models.Orders;
import com.example1.demo1.models.Product;
import com.example1.demo1.models.ProductOrder;
import com.example1.demo1.models.User;
import com.example1.demo1.service.UserService;
import com.example1.demo1.models.Reviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;



@Controller
public class CustomerController {

    @Autowired
    Customerdao customerdao;
    @Autowired
    Productdao productdao;
    @Autowired
    ProductOrderdao productorderdao;
    @Autowired
    Ordersdao  odao;
    @Autowired
    private UserService userService;

    @RequestMapping("/customer")
    public String index() {
        // model.addAttribute("greeting", message);
        return "Chome";
    }

        // customer views the products
    @RequestMapping("/customer/viewProduct")
    public String viewProduct(Model m){
        List<Product> list=productdao.getProduct();
        m.addAttribute("list",list);
        return "viewProductUser";  
    }
    @RequestMapping("/customer/done")
    public String doneWithOrder(){
        return "orderSuccess";
    }



    // // Review
    // @RequestMapping(value="/customer/productReview/${pro.getProductId()}")
    // public String addReview(@PathVariable("ProductId") int ProductId,Model m){
        
    //     Reviews rev=new Reviews();
    //     rev.setProductId(ProductId);
    //     m.addAttribute("Pid",rev);
    //     return  "reviewForm";
    // }
    // @PostMapping("/customer/ReviewinDB")
    // public String ReviewinDB(@ModelAttribute("command") Reviews pro){
    //     // System.out.println(pro.getProductId());
    //     // System.out.println(pro.getOrderId());
    //     // System.out.println(pro.getQuantity());
    //     productdao.addReview(pro.getReview(),pro.getProductId());
        
    //     return "redirect:/customer/viewProduct";
    // }


    //gets delivery Address from the map

    @RequestMapping(value = "/customer/orderPage", method = RequestMethod.GET)
    public ModelAndView addaddr(){
        ModelAndView m =new ModelAndView("orderPage");
        m.addObject("addr", new Orders() );
        return m;
    }

    @PostMapping("/customer/addaddr")
    public String addadr(@ModelAttribute("addr") Orders o,Principal principal){
        
        o.setStatus("placed");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date dateobj = new Date();
        o.setDate(dateobj);

        int order_id = odao.addOrder(df.format(o.getDate()),o.getDeliveryaddr(), o.getStatus(),principal.getName());
        o.setOrderId(order_id);

        
        return "redirect:/customer/OrdersForm/" + o.getOrderId();
    }


    // Adding Product from OrderForm
    @RequestMapping(value="/customer/OrdersForm/{OrderId}")
    public String addpo(@PathVariable("OrderId") int OrderId, Model m){
        ProductOrder po=new ProductOrder();
        po.setOrderId(OrderId);
        m.addAttribute("command",po);



        List<Product> list1 = productdao.getProductNoOrderId(OrderId);
        m.addAttribute("list1", list1);
        m.addAttribute("OrderId",OrderId);

        List<Product> list2 = productdao.getProductWithOrderId(OrderId);
        m.addAttribute("list2", list2);
        m.addAttribute("OrderId",OrderId);

        return "OrdersForm";
    }
    @PostMapping("/customer/addpo")
    public String addpo(@ModelAttribute("command") ProductOrder pro){
        System.out.println(pro.getProductId());
        System.out.println(pro.getOrderId());
        System.out.println(pro.getQuantity());
        productorderdao.addProductOrder(pro.getProductId(),pro.getOrderId(),pro.getQuantity());
        
        return "redirect:/customer/OrdersForm/"+pro.getOrderId();
    }


    @RequestMapping(value="/customer/viewPreviousOrders")
    public String viewExhibitOrders(Principal principal ,Model m){
        List<Orders> list1=odao.getOrdersByStatusUser("placed", principal.getName());
        m.addAttribute("list1",list1);
        List<Orders> list2=odao.getOrdersByStatusUser("processing", principal.getName());
        m.addAttribute("list2",list2);
        List<Orders> list3=odao.getOrdersByStatusUser("delivered", principal.getName());
        m.addAttribute("list3",list3);
        return "viewPreviousOrders"; 
 
    }

    @RequestMapping(value="/customer/orderProducts/{OrderId}")
    public String orderProduct(@PathVariable("OrderId") int OrderId,Model m){
        
        List<Product> list = productdao.getProductWithOrderId(OrderId);
        m.addAttribute("list", list);
        return "orderProducts";

    }

    @RequestMapping(value="/customer/deleteProductOrder/{ProductId}/{OrderId}",method = RequestMethod.GET)  
    public String deletep(@PathVariable("OrderId") int OrderId,@PathVariable("ProductId") int ProductId){
        productorderdao.deleteProductOrder(ProductId,OrderId);
        return "redirect:/customer/OrdersForm/"+OrderId;

    }

    @RequestMapping(value="/customer/cancelOrder//{OrderId}",method = RequestMethod.GET)  
    public String cancelOrder(@PathVariable("OrderId") int OrderId){
        productorderdao.deleteProductOrderbyOrder(OrderId);
        odao.deleteOrder(OrderId);
        return "redirect:/customer/viewPreviousOrders";

    }

    @RequestMapping(value="/customer/deleteProductOrderbyOrder/{OrderId}",method = RequestMethod.GET)  
    public String deletep(@PathVariable int OrderId){
        productorderdao.deleteProductOrderbyOrder(OrderId);
        return "redirect:/customer/viewPreviousOrders";
    }

   

    //Customer Details form

    @RequestMapping(value="/adddetailsc/{UserName}",method = RequestMethod.GET)  
    public ModelAndView addc(@PathVariable("UserName") String UserName){
        ModelAndView model=new ModelAndView("CustomerForm");
        Customer customer=new Customer();
        customer.setUserName(UserName);
        model.addObject("customer", customer);
        // ${customer.UserName};
        return model;
    }


    @PostMapping("/customer/a")
    public String addedc(@ModelAttribute("customer") Customer pro) {
        customerdao.addCustomer(pro.getName(), pro.getUserName(), pro.getPhone(), pro.getAddress());
        
        return "redirect:/login";
    }




    

    
}