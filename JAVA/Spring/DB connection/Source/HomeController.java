package com.naver.sdu0920;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.naver.sdu0920.entities.Member;
import com.naver.sdu0920.service.MemberDao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private Member member;
	
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "index";
	}
	@RequestMapping(value = "/memberInsertForm", method = RequestMethod.GET)
	public String memberInsertForm(@ModelAttribute("member") Member member) {
		return "member/memberinsert";
	}

	
	@RequestMapping(value = "/memberInsert", method = RequestMethod.POST)
	public String memberInsert(@ModelAttribute("member") Member member) {
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		int result = dao.insertRow(member);
		System.out.println("result ="+result);
		return "member/memberinsert";
	}
	
	@RequestMapping(value = "/result_submit", method = RequestMethod.POST)
	public String result(Locale locale, Model model) {
		return "member/result_submit";
	}
	@RequestMapping(value = "/cancel", method = RequestMethod.GET)
	public String cancel(Locale locale, Model model) {
		return "member/memberinsert";
	}
	@RequestMapping(value = "/memberSearch", method = RequestMethod.GET)
	public String memberSearch(Locale locale, Model model) {
		return "member/member_search";
	}
	
//	@RequestMapping(value = "/memberInsert", method = RequestMethod.POST)
//	public @ResponseBody int json(@RequestParam("id") String id, HttpServletResponse response)throws Exception {
//		System.out.println("--------------<"+id);
//		response.setContentType("application/json");
//		response.setContentType("text/xml;charset-utf-8");
//		response.setHeader("Cache-Control", "no-cache");
//		return 0;
//	}
	
	@RequestMapping(value = "/idconfirm", method = RequestMethod.POST)
	@ResponseBody
	public int idconfirm (@RequestParam("id") String id) {
		int count = 0;
		int find = 0;
		try {
			MemberDao dao = sqlSession.getMapper(MemberDao.class);
			count = dao.selectCount(id);
		}
			catch (Exception e) {
		}
		if ( count >  0) {
			find = 1;
		}
		else
			find = 0;
		return find;
	}
	
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String board(Locale locale, Model model) {
		return "board";
	}
}