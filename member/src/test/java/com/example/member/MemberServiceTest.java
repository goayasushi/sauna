package com.example.member;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberServiceTest {
	MemberService memberService;

//    @Autowired
//    public MemberServiceTest(MemberService memberService) {
//        this.memberService = memberService;
//    }
    
    @BeforeEach
    void setUp() {
        // CustomerMapperのモックを作成
        memberService = mock(MemberService.class);

    }
    
	@Test
	void testFindAll() throws Exception {
		Member member = new Member();
		member.setId(1);
		member.setFirstName("test");
		member.setLastName("test");
		Member member2 = new Member();
		member2.setId(2);
		member2.setFirstName("test2");
		member2.setLastName("test2");
		when(memberService.findAll()).thenReturn(List.of(member, member2));
		List<Member> result = memberService.findAll();
		assertEquals(2, result.size());
	}
}
