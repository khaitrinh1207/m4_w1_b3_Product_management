package controller;

import DAO.ProductDAO;
import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("list")
public class ProductController {
    private ProductDAO productDAO = new ProductDAO();
    @GetMapping("")
    public ModelAndView showAll(){
        List<Product> products = productDAO.findAll();
        ModelAndView modelAndView = new ModelAndView("list","productList",products);
        return modelAndView;
    }

    @GetMapping("create")
    public ModelAndView showFormCreate(){
        return new ModelAndView("create", "product",new Product());
    }

    @PostMapping("create")
    public ModelAndView create(@ModelAttribute Product product){
        productDAO.save(product);
        return new ModelAndView("redirect:/list");
    }

    @GetMapping("edit")
    public ModelAndView showFormEdit(@RequestParam int id){
        return new ModelAndView("edit","productById", productDAO.findById(id));
    }

    @PostMapping("edit")
    public ModelAndView edit(@ModelAttribute Product product, @RequestParam int id){
        productDAO.update(id,product);
        return new ModelAndView("redirect:/list");
    }

    @GetMapping("delete")
    public ModelAndView delete(@RequestParam int id ){
        productDAO.delete(id);
        return new ModelAndView("redirect:/list");
    }

    @GetMapping("search")
    public ModelAndView search(@RequestParam String p){
        return new ModelAndView("search","listSearch",productDAO.search(p));
    }
}
