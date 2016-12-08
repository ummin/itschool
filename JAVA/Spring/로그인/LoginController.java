package com.naver.sdu0920;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.naver.sdu0920.entities.Member;
import com.naver.sdu0920.service.MemberDao;

@Controller
public class LoginController {
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private Member member;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		return "login/member_login";
	}
	
	@RequestMapping(value = "/loginfail", method = RequestMethod.GET)
	public String loginFail(Locale locale, Model model) {
		return "login/login_fail";
	}
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String board(HttpServletRequest request) {
		HttpSession session=request.getSession();
		session.invalidate();
		return "redirect:/index";
	}
	
	@RequestMapping(value = "/loginup", method = RequestMethod.POST)
	public String loginUp(@ModelAttribute("member") Member member,HttpSession session) {
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		Member data = dao.selectlogin(member);
		if(data == null) {
			return "redirect:/loginfail";
		} else {
			session.setAttribute("sessionid", data.getId());
			session.setAttribute("sessionpassword", data.getPassword());
			session.setAttribute("sessionemail", data.getEmail());
			session.setAttribute("sessionname", data.getName());
		
			return "redirect:/index";
		}
	}
}
