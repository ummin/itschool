package com.naver.sdu0920;

import java.text.DateFormat;
import java.util.ArrayList;
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
import org.springframework.web.servlet.ModelAndView;

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
		
		return "layout/body";
	}
	@RequestMapping(value = "/memberInsertForm", method = RequestMethod.GET)
	public String memberInsertForm(@ModelAttribute("member") Member member) {
		return "member/memberinsert";
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(@ModelAttribute("member") Member member) {
		return "member/index";
	}
	@RequestMapping(value = "/memberTable", method = RequestMethod.GET)
	public ModelAndView Table(@ModelAttribute("member") Member member) {
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		ArrayList <Member> members =dao.selectAll();
		ModelAndView mav = new ModelAndView("member/member_list");
		mav.addObject("members", members);
		return mav;
	}

	
	@RequestMapping(value = "/memberInsert", method = RequestMethod.POST)
	public ModelAndView memberInsert(@ModelAttribute("member") Member member) {
		ModelAndView mav = new ModelAndView("member/member_result");
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		
		try {
			member.setPhoto(member.getImgfile().getBytes());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		int result = dao.insertRow(member);
		
		String msg = "";
		if (result == 1 ){
			msg = "success Insert your data";
		} else {
			msg = "failed Insert your data";
		}
		
		
		mav.addObject("msg",msg);
		mav.addObject("result", "ok");
		
		return mav;
	}
	
	
	
	@RequestMapping(value = "/memberResult", method = RequestMethod.GET)
	public String result(Locale locale, Model model) {
		return "layout/body";
	}
	@RequestMapping(value = "/membercancel", method = RequestMethod.GET)
	public ModelAndView cancel(Locale locale, Model model) {
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		ArrayList <Member> members =dao.selectAll();
		ModelAndView mav = new ModelAndView("member/member_list");
		mav.addObject("members", members);
		return mav;
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
	@RequestMapping(value = "/memberUpdateForm", method = RequestMethod.GET)
	public ModelAndView memberUpdate (@RequestParam String id ) {
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		Member member = dao.selectOne(id);
		
		ModelAndView mav = new ModelAndView("member/member_update_form");
		mav.addObject("member", member);
		return mav;

	}
	@RequestMapping(value = "/memberDelete", method = RequestMethod.GET)
	public ModelAndView memberDelte (@RequestParam String id ) {
		System.out.println("id--->"+id);
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		ModelAndView mav = new ModelAndView("member/member_result");
		int result = dao.deleteRow(id);
		String msg = "";
		if (result == 1 ){
			msg = "Success Delete your data";
		} else {
			msg = "Failed Delete your data";
		}
		mav.addObject("msg",msg);
		
		return mav;
	}
	@RequestMapping(value = "/memberSelectedDelete", method = RequestMethod.GET)
	public String memberSelectdDelte (@RequestParam String saveids[] ) {
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		for ( String ids : saveids){
			dao.deleteRow(ids);
		}
		return "redirect:/memberlist";
	}
	
	@RequestMapping(value = "/memberDeleteYn", method = RequestMethod.GET)
	public ModelAndView memberDelteYn (@RequestParam String id ) {
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		ModelAndView mav = new ModelAndView("member/member_result_yn");
		mav.addObject("id",id);
		return mav;
	}
	
	@RequestMapping(value = "/memberUpdate", method = RequestMethod.POST)
	public ModelAndView memberUpdate(@ModelAttribute("member") Member member) {
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		
		int result = dao.updateRow(member);
		String msg = "";
		if (result == 1 ){
			msg = "success Insert your data";
		} else {
			msg = "failed Insert your data";
		}
		
		ModelAndView mav = new ModelAndView("member/member_result");
		mav.addObject("msg",msg);
		mav.addObject("result", "ok");
		
		return mav;
	}
	
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String board(Locale locale, Model model) {
		return "member/member_board";
	}
	
	@RequestMapping(value = "/memberlist", method = RequestMethod.GET)
	public  ModelAndView memberList(@ModelAttribute("member") Member member) {
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		ArrayList <Member> members =dao.selectAll();
		ModelAndView mav = new ModelAndView("member/member_list");
		mav.addObject("members", members);
		return mav;
	}
}