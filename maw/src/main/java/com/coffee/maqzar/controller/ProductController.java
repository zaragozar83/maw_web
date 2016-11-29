package com.coffee.maqzar.controller;

import com.coffee.maqzar.domain.Product;
import com.coffee.maqzar.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by exrzaragoza on 28/11/2016.
 */
@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping
    public String showProducts(Model model){
        List<Product> listProducts = new ArrayList<Product>();
        listProducts = productService.getProducts();

        model.addAttribute("products", listProducts);
        return "products";
    }

    @RequestMapping("/update/stock")
    public String updateStock(Model model){
        productService.updateAllProducts();

        return "redirect:/products";
    }

    @RequestMapping("/{category}")
    public String showProductsByCategory(Model model, @PathVariable("category") String category){
        model.addAttribute("products", productService.getProductsByCategoryLike(category));
        return "products";
    }

    //url- http://localhost:8080/maw/products/filter/params;category=Google,Apple,Dell;price=1000
    @RequestMapping("/filter/{params}")
    public String showProductsByCategoryAndPrice(Model model, @MatrixVariable(pathVar = "params")Map<String, List<String>> params){
        model.addAttribute("products", productService.getProductsByCategoryAndPrice(params));
        return "products";
    }

    //url - http://localhost:8080/maw/products/product?id=1
    @RequestMapping("/product")
    public String showProductById(Model model, @RequestParam("id") String id){
        Long idProduct = Long.valueOf(id);
        model.addAttribute("product", productService.getProductById(idProduct));
        return "productDetail";
    }

    //url - http://localhost:8080/products/manufacturerPrice?manufacturer=Apple&price=1000
    @RequestMapping("/manufacturerPrice")
    public String showProductsByManufacturerAndPrice(Model model, @RequestParam("manufacturer")String manufacturer, @RequestParam("price")String price){
        Long priceL = Long.valueOf(price);
        model.addAttribute("products", productService.getProductsByManufacturerAndPrice(manufacturer, priceL));
        return "products";
    }

    //url - http://localhost:8080/maw/products/Laptop/priceFilter;minPrice=100;maxPrice=1000?manufacturer=Apple
    @RequestMapping("/{category}/{priceFilter}")
    public String showProductsByCriteria(Model model, @PathVariable("category")String category, @MatrixVariable(pathVar = "priceFilter")Map<String, List<String>> filterPrice, @RequestParam("manufacturer")String manufacturer){

        model.addAttribute("products", productService.getProductsByCriterias(category, filterPrice, manufacturer));

        return "products";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddProduct(Model model){
        model.addAttribute("newProduct", new Product());
        return "productForm";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddProduct(@ModelAttribute("newProduct")Product product){
        productService.addProduct(product);
        return "redirect:/products";
    }
}
