package com.example.member.app;

import java.util.List;

import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.member.domain.model.Member;
import com.example.member.domain.model.Prefecture;
import com.example.member.domain.service.MemberService;
import com.example.member.domain.service.PrefectureService;

@Controller
public class MemberController {
	private final MemberService memberService;
	private final PrefectureService prefectureService;

	public MemberController(MemberService memberService, PrefectureService prefectureService) {
		this.memberService = memberService;
		this.prefectureService = prefectureService;
	}

	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}

	@GetMapping("member/new")
	public String newMember(Model model) {
		List<Prefecture> prefecturesList = prefectureService.findAll();
		model.addAttribute("prefecturesList", prefecturesList);
		model.addAttribute("member", new Member());
		return "member/new";
	}

	@GetMapping("members")
	public String getMembers(Model model) {
		List<Member> members = memberService.findAll();
		model.addAttribute("members", members);
		return "member/list";
	}

	@Transactional
	@PostMapping("member/regist")
	public String postMember(@ModelAttribute @Validated Member member, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Prefecture> prefecturesList = prefectureService.findAll();
			model.addAttribute("prefecturesList", prefecturesList);
			return "member/new";
		}
		memberService.save(member);
		return "redirect:search";
	}

	@GetMapping("members/{id}")
	public String showMember(@PathVariable Integer id, Model model) {
		Member member = memberService.findById(id);
		if(member.getId()==null) {
			model.addAttribute("error", "対象データが存在しません");
			return "member/list";
		}
		model.addAttribute("member", member);
		return "member/show";
	}
	
	@GetMapping("member/{id}/edit")
	public String editMember(@PathVariable Integer id, Model model) {
		Member member = memberService.findById(id);
		if(member.getId()==null) {
			model.addAttribute("error", "対象データが存在しません");
			return "member/show";
		}
		List<Prefecture> prefecturesList = prefectureService.findAll();
		model.addAttribute("prefecturesList", prefecturesList);
		model.addAttribute("member", member);
		return "member/edit";
	}
	
	@PostMapping("member/update")
	public String updateMember(@ModelAttribute @Validated Member member, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Prefecture> prefecturesList = prefectureService.findAll();
			model.addAttribute("prefecturesList", prefecturesList);
			return "member/edit";
		}
		try {
			memberService.save(member);
			List<Prefecture> prefecturesList = prefectureService.findAll();
			model.addAttribute("prefecturesList", prefecturesList);
			model.addAttribute("member", member);
			return "member/show";
		} catch (ObjectOptimisticLockingFailureException e) {
			Member updatedMember = memberService.findById(member.getId());
			model.addAttribute("error", "更新できませんでした");
			model.addAttribute("member", updatedMember);
			return "member/show";
		}
	}
	
	@GetMapping("member/{id}/delete")
	  public String delete(@PathVariable Integer id, Model model) {
		memberService.delete(id);
	    return "redirect:/members";
	}
	
	@GetMapping("member/search")
	public String searchMembers(@RequestParam(required = false) String searchQuery, Model model) {
	    List<Member> members;
	    if (searchQuery != null && !searchQuery.isEmpty()) {
	        members = memberService.searchMembers(searchQuery);
	    } else {
	        members = memberService.findAll();
	    }
	    model.addAttribute("members", members);
	    return "member/list";
	}
}