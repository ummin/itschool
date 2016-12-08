package com.naver.sdu0920;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.naver.sdu0920.entities.Board;
import com.naver.sdu0920.entities.BoardPaging;
import com.naver.sdu0920.entities.Member;
import com.naver.sdu0920.service.BoardDao;

@Controller
public class BoardController implements ApplicationContextAware {
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private Member board;
	
	private WebApplicationContext context = null;
	private int selectedPage;
	public static String selectbox;
	public static String find;
	
	@RequestMapping(value = "/memberboard", method = RequestMethod.GET)
	public String board(HttpServletRequest request) {
		HttpSession session=request.getSession();
		System.out.println("selectbox - > " + this.selectbox);
		System.out.println("find - > " + this.find);
		Object data = session.getAttribute("sessionid");
		if( data ==  null)	{
		return "redirect:/boardrequest";
		} else{
			return "board/member_board";
		}
	}
	
	@RequestMapping(value = "/boardrequest", method = RequestMethod.GET)
	public String loginFail(Locale locale, Model model) {
		return "board/board_request";
	}


	@RequestMapping(value = "/boardInsert", method = RequestMethod.POST)
	public ModelAndView boardInsert(@ModelAttribute("board") Board board, HttpServletRequest request,@RequestParam CommonsMultipartFile file ) {
		ModelAndView mav = new ModelAndView("board/board_result");
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		String b_ip = request.getRemoteAddr();
		
		SimpleDateFormat simple = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.KOREA);
		Date currentdate = new Date();
		String b_date = simple.format(currentdate);
		
		String path="D:/JAVASOURCE/itschoolspring/src/main/webapp/resources/uploadefolder/";
		String filename = file.getOriginalFilename();
		
		 try {
			byte barr[] = file.getBytes();
			BufferedOutputStream bout = new BufferedOutputStream(
					new FileOutputStream(path+filename));
			bout.write(barr);
			bout.flush();
			bout.close();
		 } catch (Exception e) {
			 System.out.println(e.getMessage());
		  }
		 
		if(filename.equals("")){
			board.setB_attach("");
		} else {
			board.setB_attach(path+filename);
		}
		
		board.setB_ip(b_ip);
		board.setB_date(b_date);
		board.setB_step(0);
		board.setB_hit(0);
		board.setB_level(0);
		String msg = "";
		int result = dao.insertRow(board);
		if (result == 1 ){
			msg = "success Insert your data";
		} else {
			msg = "failed Insert your data";
		}
		
		
		mav.addObject("msg",msg);
		mav.addObject("result", "ok");
		
		return mav;
	}
	
	@RequestMapping(value = "/boardlist", method = RequestMethod.GET)
	public  ModelAndView memberList(@ModelAttribute("board") Board board, @ModelAttribute("boardpaging") BoardPaging boardpaging) {
		
		if(this.selectbox == null){
			this.selectbox="b_title";
			this.find="";
		}
		
		boardpaging.setSelectbox(this.selectbox);
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		int rowCount  =dao.selectCountAll();
		int pageSize = 10;
		int absPage = 1;
		int pageCount = rowCount / pageSize + absPage;
		int pages[] = new int[pageCount];
		
		for ( int i = 0 ; i < pageCount  ;  i ++ ){
				pages[i] = i + 1;
		}
		
		ModelAndView mav = new ModelAndView("board/board_list");
		ArrayList <Board> boards =dao.selectAll();
		mav.addObject("boardpaging", boardpaging);	
		mav.addObject("boards", boards);
		mav.addObject("pages", pages);
		return mav;
	}
	
	@RequestMapping(value = "/boardPageList", method = RequestMethod.POST)
	public  ModelAndView boardPageList(@ModelAttribute("boardpaging") BoardPaging boardpaging) {
		
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		ModelAndView mav = new ModelAndView("board/board_list");
		
		this.selectbox = boardpaging.getSelectbox();
		this.find = boardpaging.getFind();
		
		int rowCount  =dao.selectCount(boardpaging);
		int pageSize = 10;
		int pageCount = 0;
		int absPage = 0;
		
		if ( selectedPage == 0 )
			selectedPage = 1; 
		 int startrow = (selectedPage -1) * pageSize;
		 int endrow = startrow + 10;
		 boardpaging.setStartrow(startrow);
		 boardpaging.setEndrow(endrow);
		
		 ArrayList <Board> boards =dao.selectPageList(boardpaging);
		 
		if ( rowCount > 0 && rowCount %pageSize !=0 )
			absPage =1;
			pageCount = rowCount / pageSize + absPage;
			int pages[] = new int[pageCount];
			
			for ( int i = 0 ; i < pageCount  ;  i ++ ){
					pages[i] = i + 1;
			}
		mav.addObject("boardpaging", boardpaging);	
		mav.addObject("boards", boards);
		mav.addObject("pages", pages);
		
		return mav;
	}
	
	@RequestMapping(value = "/boardPageSelect", method = RequestMethod.GET)
	public ModelAndView boardPageSelect (@RequestParam int page, @ModelAttribute("boardpaging") BoardPaging boardpaging) {
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		
		boardpaging.setSelectbox(this.selectbox);
		boardpaging.setFind(this.find);
		
		int rowCount  =dao.selectCount(boardpaging);
		int pageSize = 10;
		int pageCount = 0;
		int absPage = 0;
		
		 int startrow = (page -1) * pageSize;
		 int endrow = startrow + 10;
		 boardpaging.setStartrow(startrow);
		 boardpaging.setEndrow(endrow);
		 
		 ArrayList <Board> boards =dao.selectPageList(boardpaging);
		 
			if ( rowCount > 0 && rowCount %pageSize !=0 )
				absPage =1;
				pageCount = rowCount / pageSize + absPage;
				int pages[] = new int[pageCount];
				
				for ( int i = 0 ; i < pageCount  ;  i ++ ){
						pages[i] = i + 1;
				}
				
		    ModelAndView mav = new ModelAndView("board/board_list");
		    mav.addObject("boards", boards);
			mav.addObject("pages", pages);
			return mav;
	}
	
	@RequestMapping(value = "/boardUpdate", method = RequestMethod.POST)
	public ModelAndView boardUpdate(@ModelAttribute("board") Board board, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("board/board_result");
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		String b_ip = request.getRemoteAddr();
		
		SimpleDateFormat simple = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.KOREA);
		Date currentdate = new Date();
		String b_date = simple.format(currentdate);
		
		board.setB_ip(b_ip);
		board.setB_date(b_date);
		board.setB_step(0);
		board.setB_hit(0);
		board.setB_level(0);
		
		String msg = "";
		int result = dao.updateRow(board);
		if (result == 1 ){
			msg = "success update your data";
		} else {
			msg = "failed update your data";
		}
		
		
		mav.addObject("msg",msg);
		mav.addObject("result", "ok");
		
		return mav;
	}
	
	@RequestMapping(value = "/boardDetail", method = RequestMethod.GET)
	public ModelAndView boardDeatail (@RequestParam int b_seq, HttpServletResponse response, HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView("board/board_detail");
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		dao.updateHit(b_seq);
		Board board = dao.selectOne(b_seq);
		
		mav.addObject("board", board);
		return mav;
		
	}
	
	@RequestMapping(value = "/boardDeleteYN", method = RequestMethod.GET)
	public ModelAndView boardDeleteYN (@RequestParam int b_seq ) {
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		ModelAndView mav = new ModelAndView("board/board_result_yn");
		mav.addObject("b_seq",b_seq);
		return mav;
	}
	
	
	
	@RequestMapping(value = "/boardDelete", method = RequestMethod.POST)
	public ModelAndView memberDelte (@RequestParam int b_seq  ) {
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		ModelAndView mav = new ModelAndView("board/board_result");
		int result = dao.deleteRow(b_seq);
		String msg = "";
		if (result == 1 ){
			msg = "Success Delete your data";
		} else {
			msg = "Failed Delete your data";
		}
		mav.addObject("msg",msg);
		
		return mav;
	}

@RequestMapping(value = "/boardReply", method = RequestMethod.GET)
public ModelAndView boardReply (@RequestParam int b_seq ) {
	ModelAndView mav = new ModelAndView("board/board_reply");
	BoardDao dao = sqlSession.getMapper(BoardDao.class);
	dao.updateHit(b_seq);
	Board board = dao.selectOne(b_seq);
	mav.addObject("board", board);
	return mav;
}

@RequestMapping(value = "/boardReplySave", method = RequestMethod.POST)
public ModelAndView boardReplySave(@ModelAttribute("board") Board board, HttpServletRequest request) {
	ModelAndView mav = new ModelAndView("board/board_result");
	BoardDao dao = sqlSession.getMapper(BoardDao.class);
	String b_ip = request.getRemoteAddr();
	
	SimpleDateFormat simple = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.KOREA);
	Date currentdate = new Date();
	String b_date = simple.format(currentdate);
	
	
	board.setB_ip(b_ip);
	board.setB_date(b_date);
	board.setB_step(0);
	board.setB_hit(0);
	board.setB_level(0);
	
	String msg = "";
	int result = dao.insertReply(board);
	if (result == 1 ){
		msg = "success Insert your data";
	} else {
		msg = "failed Insert your data";
	}
	
	
	mav.addObject("msg",msg);
	mav.addObject("result", "ok");
	
	return mav;
 }

 @RequestMapping(value="/uploadFile", method=RequestMethod.POST)
 public ModelAndView upload(@RequestParam CommonsMultipartFile file, HttpSession session) {
//	 String path = session.getServletContext().getRealPath("/");
  String path="D:/JAVASOURCE/itschoolspring/src/main/webapp/resources/uploadefolder/";
  String filename = file.getOriginalFilename();
 try {
	byte barr[] = file.getBytes();
	BufferedOutputStream bout = new BufferedOutputStream(
			new FileOutputStream(path+"/"+filename));
	bout.write(barr);
	bout.flush();
	bout.close();
 } catch (Exception e) {
	 System.out.println(e.getMessage());
  }
 return new ModelAndView("board/board_result");
 }
 
 @RequestMapping(value = "/uploadfileform", method = RequestMethod.GET)
 public String uploadfileform ( ) {
 	
 	return "board/file_upload";
 }
 
 @RequestMapping(value = "/boardDownload", method = RequestMethod.GET)
 public ModelAndView download(@RequestParam("b_attach") String b_attach) {
	 
	 File file = new File(b_attach);
	 
	 return new ModelAndView("download", "downloadFile", file);
 }
 

@Override
public void setApplicationContext(ApplicationContext arg0) throws BeansException {
	// TODO Auto-generated method stub
	this.context=(WebApplicationContext)arg0;
	}
}


