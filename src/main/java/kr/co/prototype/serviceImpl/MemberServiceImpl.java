package kr.co.prototype.serviceImpl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.prototype.dao.MemberDao;
import kr.co.prototype.domain.vo.MemberVo;
import kr.co.prototype.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao dao;

	@Override
	public MemberVo login(MemberVo memberVo) {
		return dao.findByUidAndPassword(memberVo);
	}

	@Override
	public int existUid(String uid) {
		return dao.countByUid(uid);
	}

	@Override
	public String register(MemberVo memberVo, HttpSession httpSession) {
		if (dao.save(memberVo) == 1) {
			httpSession.setAttribute("member", memberVo);
			return "redirect:/";
		}

		return "/member/register";
	}

}