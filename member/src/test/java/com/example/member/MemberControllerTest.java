package com.example.member;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.example.member.app.MemberController;
import com.example.member.domain.model.Prefecture;
import com.example.member.domain.service.MemberService;
import com.example.member.domain.service.PrefectureService;

@WebMvcTest(MemberController.class)
@WithMockUser(username = "admin", roles = {"ADMIN"})
public class MemberControllerTest {
	
	@Autowired
	MockMvc mockMvc;

    @MockBean
    private MemberService memberService;

    @MockBean
    private PrefectureService prefectureService;
    
    @BeforeEach
    void setUp() {
        List<Prefecture> prefecturesList = Collections.singletonList(new Prefecture());
        when(prefectureService.findAll()).thenReturn(prefecturesList);
    }

    @Test
    public void indexShouldReturnIndexView() throws Exception {
        this.mockMvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(view().name("index"));
    }

}
