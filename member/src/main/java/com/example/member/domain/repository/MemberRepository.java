package com.example.member.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.member.domain.model.Member;

public interface MemberRepository extends JpaRepository<Member, Integer>{

}
