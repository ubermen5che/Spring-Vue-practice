package com.example.coinwiki.controller;

import com.example.coinwiki.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.coinwiki.service.MemberService;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SampleController {
    private MemberService memberService;

    @Autowired
    public SampleController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    @ResponseBody
    public List<Member> sample(Model model){
        List<Member> member = memberService.findMembers();
        model.addAttribute("Member", member);

        return member;
    }

    @GetMapping("data")
    @ResponseBody
    public Map<String, Object> data(@RequestParam(name="msg") String msg) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", "Server message with " + msg);
        return map;
    }
}
