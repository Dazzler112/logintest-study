package com.logintest.logintest.controller.member;

import com.logintest.logintest.domain.Member;
import com.logintest.logintest.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/member/")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memService;
    @GetMapping("sign")
    public void signForm(){

    }

    @PostMapping("sign")
    public String signProcess(Member mem, RedirectAttributes rttr){
        try{
            memService.signUP(mem);
            rttr.addFlashAttribute("","회원가입이 완료되었습니다.");
            System.out.println("회원가입이 완료되었습니다.");
            return "redirect:/login";
        } catch (Exception e){
            e.printStackTrace();
            rttr.addFlashAttribute("members",mem);
            System.out.println("회원가입에 실패하였습니다.");
            return "redirect:/member/signup";
        }
    }

    @GetMapping("checkId/{login_id}")
    @ResponseBody
    public Map<String, Object> checkId(@PathVariable("login_id")String id) {

        return memService.checkId(id);
    }

    @GetMapping("main")
    @PreAuthorize("isAuthenticated() and hasAuthority('user')")
    public void main (){

    }

}
