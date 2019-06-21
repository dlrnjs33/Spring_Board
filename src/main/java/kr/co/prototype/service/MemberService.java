package kr.co.prototype.service;

import javax.servlet.http.HttpSession;

import kr.co.prototype.domain.vo.MemberVo;

public interface MemberService {

	public MemberVo login(MemberVo memberVo);

	public String register(MemberVo memberVo, HttpSession httpSession);

	public int existUid(String uid);
}
