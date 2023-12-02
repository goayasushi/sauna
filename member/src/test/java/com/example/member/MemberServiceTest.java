package com.example.member;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;

import com.example.member.domain.model.Member;
import com.example.member.domain.repository.MemberRepository;
import com.example.member.domain.service.MemberService;

@SpringBootTest
@ContextConfiguration(classes = TestConfig.class)
public class MemberServiceTest {
	@Mock
    private MemberRepository memberRepository;

    private MemberService memberService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        memberService = new MemberService(memberRepository);
    }

    @Test
    void findAllShouldReturnAllMembers() {
        List<Member> members = List.of(new Member(), new Member());
        when(memberRepository.findAll(Sort.by(Sort.Direction.ASC, "id"))).thenReturn(members);
        List<Member> result = memberService.findAll();
        assertEquals(2, result.size());
        verify(memberRepository).findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Test
    void saveShouldPersistMember() {
        Member member = new Member();
        when(memberRepository.save(member)).thenReturn(member);
        Member result = memberService.save(member);
        assertEquals(member, result);
        verify(memberRepository).save(member);
    }

    @Test
    void findByIdShouldReturnMember() {
        Member member = new Member();
        when(memberRepository.findById(1)).thenReturn(Optional.of(member));
        Member result = memberService.findById(1);
        assertEquals(member, result);
        verify(memberRepository).findById(1);
    }

    @Test
    void deleteShouldRemoveMember() {
        Member member = new Member();
        when(memberRepository.findById(1)).thenReturn(Optional.of(member));
        doNothing().when(memberRepository).delete(member);
        memberService.delete(1);
        verify(memberRepository).findById(1);
        verify(memberRepository).delete(member);
    }
}
