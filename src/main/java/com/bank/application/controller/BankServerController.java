package com.bank.application.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bank.application.dto.RegisterRequestDTO;
import com.bank.application.entity.Account;
import com.bank.application.entity.Customer;
import com.bank.application.entity.Transaction;
import com.bank.application.service.AccountService;
import com.bank.application.service.CustomerService;
import com.bank.application.service.TransactionService;

import jakarta.validation.Valid;

@Controller
public class BankServerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/")
    public String home(Model model){
		RegisterRequestDTO registerRequestDTO = new RegisterRequestDTO();
		model.addAttribute("customer", registerRequestDTO);
        return "register";
    }

	@PostMapping("/register")
    public String register(@Valid @ModelAttribute("customer") RegisterRequestDTO registerRequestDTO, BindingResult bindingResult){
		if(StringUtils.isEmpty(registerRequestDTO.getEmail()) && StringUtils.isEmpty(registerRequestDTO.getPhone())) {
			return "register";
		} else {
			Customer customerExists = customerService.findCustomerByEmail(registerRequestDTO.getEmail());
			if(customerExists == null) {
				customerService.add(registerRequestDTO);
		        return "redirect:/dashboard?email="+registerRequestDTO.getEmail();		
			}
			return "register";
		}
    }
	
	@GetMapping("/login")
    public String login(Model model){
		String username = ""; 
		String password = "";
		model.addAttribute("username", username);
		model.addAttribute("password", password);
		return "login";
    }
	
	@PostMapping("/loginSubmit")
	public String loginSubmit(@Valid @ModelAttribute("username") String username, @Valid @ModelAttribute("password") String password, BindingResult bindingResult){
		if(StringUtils.isEmpty(username) && StringUtils.isEmpty(password)) {
			return "register";
		} else {
			Customer existingCustomer = customerService.findCustomerByEmail(username);
			if(existingCustomer != null) {
				return "redirect:/dashboard?email="+username;
			} else {
				return "login";
			}
		}
    }
	
	@GetMapping("/dashboard")
	public String dashboard(@RequestParam(value="email") String email, Model model) {
		Customer customer = customerService.findCustomerByEmail(email);
		model.addAttribute("account", customer.getAccountNumber());
		List<Transaction> transactions = customer.getAccountNumber().getTransactions();
		model.addAttribute("transactions", transactions);
		model.addAttribute("email", email);
		return "dashboard";
	}
	
	@GetMapping("/deposit")
    public String deposit(@RequestParam(value="email") String email, Model model){
		model.addAttribute("email", email);
        return "deposit";
    }
	
	@PostMapping("/depositAmount")
    public String depositAmount(@RequestParam(value="email") String email, @Valid @ModelAttribute("amount") String amount){
		Customer customer = customerService.findCustomerByEmail(email);
		Account account = customer.getAccountNumber();
		List<Transaction> transactions = account.getTransactions();
		double balance = account.getBalance() + Double.parseDouble(amount);
		Transaction transaction = new Transaction("Deposit 01", LocalDateTime.now(), "Deposit", Double.parseDouble(amount), balance);
		transactions.add(transaction);
		transactionService.add(transaction);
		account.setTransactions(transactions);
		account.setBalance(balance);
		accountService.add(account);
        return "redirect:/dashboard?email="+email;
    }
	
	@GetMapping("/withdraw")
    public String withdraw(@RequestParam(value="email") String email, Model model){
		model.addAttribute("email", email);
        return "withdraw";
    }
	
	@PostMapping("/withdrawAmount")
    public String withdrawAmount(@RequestParam(value="email") String email, @Valid @ModelAttribute("amount") String amount){
		Customer customer = customerService.findCustomerByEmail(email);
		Account account = customer.getAccountNumber();
		List<Transaction> transactions = account.getTransactions();
		double balance = account.getBalance() - Double.parseDouble(amount);
		Transaction transaction = new Transaction("Deposit 01", LocalDateTime.now(), "withdraw", Double.parseDouble(amount), balance);
		transactions.add(transaction);
		account.setTransactions(transactions);
		account.setBalance(balance);
		accountService.add(account);
        return "redirect:/dashboard?email="+email;
    }
}
