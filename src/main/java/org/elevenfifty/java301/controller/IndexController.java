package org.elevenfifty.java301.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.elevenfifty.java301.beans.Product;
import org.elevenfifty.java301.beans.Transaction;
import org.elevenfifty.java301.beans.User;
import org.elevenfifty.java301.repository.ProductRepository;
import org.elevenfifty.java301.repository.TransactionRepository;
import org.elevenfifty.java301.repository.UserPropertyRepository;
import org.elevenfifty.java301.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController
{
	private static final Logger log = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ProductRepository productRepo;



	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, HttpServletRequest request)
	{
		return "login";
	}

	@GetMapping("/user/{id}")
	public String user_detail(Model model, @PathVariable(name = "id") long id)
	{
		User u = userRepo.findOne(id);
		model.addAttribute("user", u);
		return "user_detail";
	}
	
	@GetMapping("/products")
    public String product(Model model, @PathVariable(name = "productId") long productId) {
		model.addAttribute("products", productRepo.findAll());
        return "products";
    }
	
	@GetMapping("/product/{productId}")
	public String product_detail(Model model, @PathVariable(name = "productId") long productId)
	{
		Product p = productRepo.findOne(productId);
		model.addAttribute("product", p);
		return "product_detail";
	}

	@GetMapping("/user/{id}/edit")
	public String userEdit(Model model, @PathVariable(name = "id") long id)
	{
		User u = userRepo.findOne(id);
		model.addAttribute("user", u);

		model.addAttribute("id", id);
		return "user_edit";
	}
	
	@GetMapping("/product/{productId}/edit")
	public String productEdit(Model model, @PathVariable(name = "productId") long productId)
	{
		Product p = productRepo.findOne(productId);
		model.addAttribute("product", p);
		model.addAttribute("id", productId);
		return "product_edit";
	}

	@GetMapping("/product/add")
	public String productAdd(Model model)
	{
		model.addAttribute(new Product());
		return "product_add";
	}
	
	@PostMapping("/product/add")
	public String productAdd(Model model,@ModelAttribute @Valid Product product, BindingResult result)
	{
		if (result.hasErrors())
		{	
			model.addAttribute("product", product);
			return "product_add";
		}
		else
		{
			productRepo.save(product);
			return "redirect:/";
		}
	}
	
	@GetMapping("/product/{productId}/delete")
    public String productDelete(Model model, @PathVariable(name = "productId") long productId) {
        model.addAttribute("productId", productId);
        Product p = productRepo.findOne(productId);
        model.addAttribute("product", p);
        return "product_delete";
    }

    @PostMapping("/product/{productId}/delete")
    public String productDeleteSave(@PathVariable(name = "productId") long productId, @ModelAttribute @Valid Product product,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("product", product);
            return "product_delete";
        } else {
            productRepo.delete(product);
            return "redirect:/";
        }
    }
	
	@PostMapping("/user/{id}/edit")
	public String userEditSave(@PathVariable(name = "id") long id, @ModelAttribute @Valid User user,
			BindingResult result, Model model)
	{

		if (result.hasErrors())
		{
			model.addAttribute("user", user);
			return "user_edit";
		} else
		{
				userRepo.save(user);
				return "redirect:/user/" + user.getId();
			}
	}
	@PostMapping("/product/{productId}/edit")
	public String productEditSave(@PathVariable(name = "productId") long productId, @ModelAttribute @Valid Product product,
			BindingResult result, Model model)
	{

		if (result.hasErrors())
		{
			model.addAttribute("product", product);
			return "prodcut_edit";
		} else
		{
				productRepo.save(product);
				return "redirect:/product/" + product.getProductId();
			}
	}
	
	@Autowired
	private TransactionRepository transactionRepo;
	
	@GetMapping("/transactions")
	public String findAllTransactions(Model model) throws SQLException {
		model.addAttribute("transactions", transactionRepo.findAll());
		return "transactions";
	}
	
	@GetMapping("/transaction/{id}")
	public String transaction_detail(Model model, @PathVariable(name = "id") long id)
	{
		Transaction t = transactionRepo.findOne(id);
		model.addAttribute("transaction", t);
		return "transaction_detail";
	}
	
	@GetMapping("/transaction/{id}/edit")
	public String transactionEdit(Model model, @PathVariable(name = "id") long id) {
		model.addAttribute("id", id);
		Transaction t = transactionRepo.findOne(id);
		model.addAttribute("transaction", t);
		model.addAttribute("customers", userRepo.findAll());
		model.addAttribute("products", productRepo.findAll());
		return "transaction_edit";
	}
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public String index(Model model, HttpServletRequest request)
	{
		model.addAttribute("users", userRepo.findAll());
		model.addAttribute("products", productRepo.findAll());
		return "index";
	}

}
