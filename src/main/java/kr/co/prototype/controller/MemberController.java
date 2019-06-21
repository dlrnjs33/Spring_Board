package kr.co.prototype.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.prototype.domain.LoginDto;
import kr.co.prototype.domain.vo.MemberVo;
import kr.co.prototype.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService service;

	@GetMapping("/login")
	public String login() {

		return "/member/login";
	}

	@PostMapping("/login")
	@ResponseBody
	public MemberVo login(@Valid LoginDto loginDto, BindingResult bindingResult, MemberVo memberVo,
			HttpSession httpSession) {

		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);

			return service.login(memberVo);
		}

		MemberVo member = service.login(memberVo);

		httpSession.setAttribute("member", member);

		return member;
	}

	@GetMapping("/logout")
	public String logout(HttpSession httpSession) {
		httpSession.invalidate();

		return "redirect:/";
	}

	@GetMapping("/register")
	public String register() {

		return "/member/register";
	}

	@PostMapping("/register")
	public String register(@Valid MemberVo memberVo, BindingResult bindingResult, HttpSession httpSession) {
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "/member/register";
		}

		return service.register(memberVo, httpSession);
	}

	@PostMapping("/existUid")
	@ResponseBody
	public Map<Object, Object> existUid(@RequestBody String uid) {
		Map<Object, Object> map = new HashMap<Object, Object>();

		map.put("count", service.existUid(uid));

		return map;
	}

	@PostMapping("/loginCheck")
	@ResponseBody
	public Map<Object, Object> loginCheck(HttpSession httpSession) {
		Map<Object, Object> map = new HashMap<Object, Object>();

		map.put("count", httpSession.getAttribute("member") != null ? 1 : 0);

		return map;
	}

}