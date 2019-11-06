package com.example1.demo1.controllers;

import javax.servlet.http.HttpSession;

// import com.example1.demo1.Alien;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class homeController {

    // inject via application.properties
    @Value("${welcome.message}")
    private String message = "Hello World";

    // @RequestMapping("/")
    // public String index(Model model) {
    //     model.addAttribute("greeting", message);
    //     return "index";
    // }

    @RequestMapping("index")
    public String index(Model model) {
        model.addAttribute("greeting", message);
        return "index";
    }


    @RequestMapping("register")
    public String register(Model model) {
        model.addAttribute("greeting", message);
        return "register";
    }
    // @RequestMapping("home")
    // public String home(Model model) {
    //     System.out.println("\nghar\n");
    //     model.addAttribute("greeting", message);
    //     return "home";
    // }

    // public String home(HttpServletRequest req) {
    //     HttpSession session = req.getSession();
    //     String name = req.getParameter("name1");
    //     // System.out.println("hi"+nam);
    //     session.setAttribute("name1", name);
    //     // use ${name1} in home.jsp
    //     // model.addAttribute("greeting", message);
    //     return "home";
    // }

    public String home(@RequestParam("name") String name1, HttpSession session) {
        
        session.setAttribute("name", name1);
        // works with http://localhost:8080/home?name1=mayank.
        // but not with http://localhost:8080/home?name=mayank.
        //for ?name=mayank to work we write @RequestParam("name") before the String
        return "home";
    }

    // public ModelAndView home(@RequestParam("name") String name1) {
        

    //     ModelAndView mv = new ModelAndView();
    //     mv.addObject("name", name1);
    //     mv.setViewName("home");
    //     // session.setAttribute("name", name1);
    //     // works with http://localhost:8080/home?name1=mayank.
    //     // but not with http://localhost:8080/home?name=mayank.
    //     //for ?name=mayank to work we write @RequestParam("name") before the String
    //     return mv;
    // }

    // public ModelAndView home(Alien alien) {
        

    //     ModelAndView mv = new ModelAndView();
    //     mv.addObject("obj", alien);
    //     mv.setViewName("home");
    //     // session.setAttribute("name", name1);
    //     // works with http://localhost:8080/home?name1=mayank.
    //     // but not with http://localhost:8080/home?name=mayank.
    //     //for ?name=mayank to work we write @RequestParam("name") before the String
    //     return mv;
    // }

// @Transactional
// @Repository
// public class ArticleDAO {
//     private final JdbcTemplate jdbcTemplate;
//     @Autowired
//     public ArticleDAO(JdbcTemplate jdbcTemplate) {
// 	  this.jdbcTemplate = jdbcTemplate;
//     }

// }

// public class ArticleRowMapper implements RowMapper<Article> {
//     @Override
//     public Article mapRow(ResultSet row, int rowNum) throws SQLException {
//      Article article = new Article();
//      article.setArticleId(row.getInt("articleId"));
//      article.setTitle(row.getString("title"));
//      article.setCategory(row.getString("category"));
//      return article;
//     }
//  }


      
}