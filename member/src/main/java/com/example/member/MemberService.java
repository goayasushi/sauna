package com.example.member;

import java.util.List;

import org.springframework.stereotype.Service;

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

}