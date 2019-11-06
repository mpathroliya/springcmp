package com.example1.demo1.controllers;

import java.security.Principal;

// import com.dbms.fresh.dao.Categorydao;
// import com.example1.demo1.dao.Ordersdao;
// import com.example1.demo1.dao.Productdao;
import com.example1.demo1.dao.Userdao;
import com.example1.demo1.models.User;
import com.example1.demo1.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    Userdao dao;

    @Autowired
    private UserService userService;

    @RequestMapping("/register1")
    public ModelAndView savex( ){
        ModelAndView m=new ModelAndView("Cregister");
        m.addObject( "command",new User() );
        return m;
    }

    @PostMapping("/savex")
    public String savex(@ModelAttribute("command") User pro) {
        pro.setUserType("customer");
        userService.save(pro);
        return "redirect:/adddetailsc/" + pro.getUserName();
        
    }


    
    @RequestMapping("/register2")
    public ModelAndView savem( ){
        ModelAndView m=new ModelAndView("Eregister");
        m.addObject( "command",new User() );
        return m;
    }

    @PostMapping("/savem")
    public String savem(@ModelAttribute("command") User pro) {
        pro.setUserType("exhibit");
        userService.save(pro);
        
        return "redirect:/exhibit/adddetailsc/"+ pro.getUserName();
    }

    @GetMapping("/welcome")
    public String welcome(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        // System.out.println("/n/n look at the user name");
        // System.out.println(user.getUserName());
        // System.out.println("/n/n look at the userType");
        // System.out.println(user.getUserType());
        String foo = user.getUserType();
        // System.out.println(foo);
        if ("customer".equals(foo))
            return "redirect:/customer";
        else if (user.getUserType() == "exhibit")
            return "redirect:/exhibit";
        else
         return "redirect:/admin";
    }

    

}
