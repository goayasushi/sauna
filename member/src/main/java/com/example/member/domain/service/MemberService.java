package com.example.member.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.member.domain.model.Member;
import com.example.member.domain.repository.MemberRepository;

@Service
public class MemberService {
	private final MemberRepository memberRepository;

	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public List<Member> findAll() {
		return memberRepository.findAll();
	}

	public Member save(Member member) {
		return memberRepository.save(member);
	}
	
	public Member findById(Integer id) {
	    return memberRepository.findById(id).orElse(new Member());
	  }
	
	public void delete(Integer id) {
		Member member = findById(id);
	    memberRepository.delete(member);
	  }
}