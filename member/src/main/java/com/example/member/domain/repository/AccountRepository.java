package com.example.member.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.member.domain.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	Account findByAccountname(String accountname);
}
