package com.example.member.domain.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.member.domain.model.Account;
import com.example.member.domain.repository.AccountRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    // コンストラクタ
    public UserDetailsServiceImpl(AccountRepository accountRepository, PasswordEncoder passwordEncoder){
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }
    
    @Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
    	Account account = accountRepository.findByAccountname(username);
		if(account == null) {
			throw new UsernameNotFoundException("Not Found");
		}
		return User.withUsername(account.getAccountname())
	            .password(account.getPassword())
	            .authorities("ROLE_" + account.getRole()) // ユーザーのロールを設定
	            .build();
	}
    
    public void save(Account account) {
		String hashedPassword = passwordEncoder.encode(account.getPassword());
		Account newAccount = new Account();
        newAccount.setAccountname(account.getAccountname());
        newAccount.setPassword(hashedPassword);
        newAccount.setRole(account.getRole());
        accountRepository.save(newAccount);
	}
}
