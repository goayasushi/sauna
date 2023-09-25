package com.example.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class MemberController {
    @Autowired
    MemberService memberService;

    @GetMapping("index")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("member/new")
    public String newMember(Model model) {
        return "member/new";
    }

    @GetMapping("member/list")
    public String getMembers(Model model) {
        List<Member> members = memberService.findAll();
        System.out.println(members);
        model.addAttribute("members", members);
    	  return "member/list";
    }

    @PostMapping("member/regist")
    public String postMember(@ModelAttribute Member member) {
    	  memberService.save(member);
    	  return "member/list";
    }
}