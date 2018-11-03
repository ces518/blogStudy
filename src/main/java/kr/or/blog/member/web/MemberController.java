package kr.or.blog.member.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.blog.constant.Message;
import kr.or.blog.constant.Template;
import kr.or.blog.entities.Member;
import kr.or.blog.member.service.MemberService;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping(path="/member",method=RequestMethod.GET)
    public String memberList(
        Model model,
        @ModelAttribute("member") Member member){

        List<Member> memberList = memberService.getMembers(member);
        model.addAttribute("memberList",memberList);
        model.addAttribute("template",Template.MEMBER_LIST);
        return Template.MAIN;
    }

    @RequestMapping(path="/join/{id}",method=RequestMethod.POST)
    public String join(
        @PathVariable(name="id") String id,
        @ModelAttribute("member") Member member){
        memberService.insertMember(member);
        return "redirect:/";
    }

    @RequestMapping(path="/login/{id}",method=RequestMethod.POST)
    public String login(
        @PathVariable(name="id") String id,
        @ModelAttribute("member") Member member,
        HttpServletRequest request,
        RedirectAttributes redirectAttributes){
        Member memberInfo = memberService.getMember(member);
        if(memberInfo.getSeq() != null){
            request.getSession().setAttribute("MEMBER", memberInfo);
            return "redirect:/";
        }
        redirectAttributes.addFlashAttribute("message", Message.LOGIN_FAIL);
        return "redirect:/login";
    }

    @ResponseBody
    @RequestMapping(path="/join/{id}",method=RequestMethod.GET,produces="application/json")
    public Map<String,String> idCheck(
        @PathVariable("id") String id,
        @ModelAttribute("member") Member member){
        Map<String,String> result = memberService.checkMemberId(member);
        return result;
    }
}