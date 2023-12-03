package com.example.member.domain.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.member.domain.model.Member;
import com.example.member.domain.repository.MemberRepository;

@Service
public class MemberService {
	private final MemberRepository memberRepository;

	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	
	public List<Member> findAll() {
		return memberRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	@Transactional
	public Member save(Member member) {
		return memberRepository.save(member);
	}
		
	public Member findById(Integer id) {
	    return memberRepository.findById(id).orElse(new Member());
	  }
	
	@Transactional
	public void delete(Integer id) {
		Member member = findById(id);
	    memberRepository.delete(member);
	  }
	
	public List<Member> searchMembers(String searchQuery) {
	    return memberRepository.searchMembers(searchQuery);
	}
}