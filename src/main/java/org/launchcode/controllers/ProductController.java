package org.launchcode.controllers;

import org.launchcode.models.Category;
import org.launchcode.models.Product;
import org.launchcode.models.data.CategoryDao;
import org.launchcode.models.data.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CategoryDao categoryDao;

    // Request path: /Product
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("products", productDao.findAll());
        model.addAttribute("title", "My Products");

        return "product/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddProductForm(Model model) {
        model.addAttribute("title", "Add Product");
        model.addAttribute(new Product());
        model.addAttribute("categories", categoryDao.findAll());
        return "product/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddProductForm(@ModelAttribute  @Valid Product newProduct, Errors errors,
                                       @RequestParam int categoryId, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Product");
            return "product/add";
        }

        Category cat = categoryDao.findOne(categoryId);

        newProduct.setCategory(cat);

        productDao.save(newProduct);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveProductForm(Model model) {
        model.addAttribute("products", productDao.findAll());
        model.addAttribute("title", "Remove Product");
        return "product/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveProductForm(@RequestParam int[] productIds) {

        for (int productId : productIds) {
            productDao.delete(productId);
        }

        return "redirect:";
    }

}
