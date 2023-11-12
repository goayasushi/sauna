package com.example.member.domain.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.member.domain.model.User;
import com.example.member.domain.model.UserDetailsImpl;
import com.example.member.domain.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    // コンストラクタ
    public UserDetailsServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    
    @Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		User user = userRepository.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("Not Found");
		}
		return new UserDetailsImpl(user);
	}
}
