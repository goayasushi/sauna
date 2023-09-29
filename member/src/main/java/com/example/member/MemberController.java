package com.example.member;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
	private final MemberService memberService;
	private final PrefectureService prefectureService;

	public MemberController(MemberService memberService, PrefectureService prefectureService) {
		this.memberService = memberService;
		this.prefectureService = prefectureService;
	}
	
	@GetMapping("index")
	public String index(Model model) {
		return "index";
	}

	@GetMapping("member/new")
	public String newMember(Model model) {
		List<Prefecture> prefecturesList = prefectureService.findAll();
        model.addAttribute("prefecturesList", prefecturesList);
        System.out.println(prefecturesList.size());
		return "member/new";
	}

	@GetMapping("member/search")
	public String getMembers(Model model) {
		List<Member> members = memberService.findAll();
		model.addAttribute("members", members);
		return "member/list";
	}

	@PostMapping("member/regist")
	public String postMember(@ModelAttribute @Validated  Member member, BindingResult result, Model model) {
		 if (result.hasErrors()) {
	            List<String> errorList = new ArrayList<String>();
	            for (ObjectError error : result.getAllErrors()) {
	                errorList.add(error.getDefaultMessage());
	            }
	            model.addAttribute("validationError", errorList);
	            return "member/new";
	        }
		memberService.save(member);
		return "redirect:search";
	}
}