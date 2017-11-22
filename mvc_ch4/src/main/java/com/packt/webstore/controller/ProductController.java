package com.packt.webstore.controller;

import com.packt.webstore.domain.Product;
import com.packt.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/products")
    public String list(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @RequestMapping("/products/{category}")
    public String getProductsByCategory(@PathVariable("category") String productCategory, Model model) {
        model.addAttribute("products", productService.getProductsByCategory(productCategory));
        return "products";
    }

    @RequestMapping("/products/filter/{params}")
    public String getProductsByFilter(@MatrixVariable(pathVar = "params") Map<String, List<String>> filterParams, Model model) {
        model.addAttribute("products", productService.getProductsByFilter(filterParams));
        return "products";
    }

    @RequestMapping("/product")
    public String getProductById(@RequestParam("id") String productId, Model model) {
        model.addAttribute("product", productService.getProductById(productId));
        return "product";
    }

    @RequestMapping("/products/{category}/{price}")
    public String filterProducts(
            @RequestParam("brand") String brand,
            @MatrixVariable(pathVar = "price") Map<String, String> filterPrice,
            @PathVariable("category") String productCategory,
            Model model) {
        model.addAttribute("products", productService.filterProducts(brand, filterPrice, productCategory));
        return "products";
    }

    @RequestMapping(value = "/products/add", method = RequestMethod.GET)
    public String getAddNewProductForm(@ModelAttribute("newProduct") Product newProduct) {
//        Product newProduct = new Product();
//        model.addAttribute("newProduct", newProduct);
        return "addProduct";
    }

    @RequestMapping(value = "/products/add", method = RequestMethod.POST)
    public String processAddNewProductForm(@ModelAttribute("newProduct") Product newProduct, BindingResult result) {
//        String[] suppressedFields = result.getSuppressedFields();
//        if (suppressedFields.length > 0) {
//            throw new RuntimeException("Attempting to bind disallowed fields: " +
//                    StringUtils.arrayToCommaDelimitedString(suppressedFields));
//        }
        productService.addProduct(newProduct);
        return "redirect:/products";
    }

//    @InitBinder
//    public void initialiseBinder(WebDataBinder binder) {
//        binder.setAllowedFields("productId",
//                "name",
//                "unitPrice",
//                "description",
//                "manufacturer",
//                "category",
//                "unitsInStock",
//                "condition1");
//    }

    @InitBinder
    public void initialiseBinder (WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("MMM d, YYYY");
        CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat,
                true);
        binder.registerCustomEditor(Date.class, orderDateEditor);
    }
}