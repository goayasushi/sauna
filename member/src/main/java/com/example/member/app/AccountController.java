package com.example.member.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.member.domain.model.Account;
import com.example.member.domain.service.UserDetailsServiceImpl;

@Controller
public class AccountController {
	private final UserDetailsServiceImpl userDetailsServiceImpl;

    public AccountController(UserDetailsServiceImpl userDetailsServiceImpl){
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }
	
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/account/regist")
	public String newAccount(Model model) {
    	model.addAttribute("account", new Account());
		return "registration";
	}
    
    @PostMapping("/account/regist")
	public String registerAccount(@ModelAttribute @Validated Account account, BindingResult result) {
		if(result.hasErrors()) {
			return "registration";
		}
		userDetailsServiceImpl.save(account);
		return "redirect:/";
	}
}
