package com.naver.sdu0920;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.naver.sdu0920.entities.Salary;
import com.naver.sdu0920.entities.SalaryRoll;
import com.naver.sdu0920.entities.SalaryRollup;
import com.naver.sdu0920.service.SalaryDao;

@Controller
public class SalaryController {
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private SalaryRoll salaryroll;
	@Autowired
	private Salary salary;

	
	
	@RequestMapping(value = "/salaryInsertForm", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		return "salary/salary_insert";
	}
	
	@RequestMapping(value = "/noconfirm", method = RequestMethod.POST)
	@ResponseBody
	public int idconfirm (@RequestParam("no") String no) {
		int count = 0;
		int find = 0;
		try {
			SalaryDao dao = sqlSession.getMapper(SalaryDao.class);
			count = dao.selectCount(no);
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
	@RequestMapping(value = "/salaryInsert", method = RequestMethod.POST)
	public ModelAndView salaryInsert(@ModelAttribute("Salary") Salary salary) {
		ModelAndView mav = new ModelAndView("member/member_result");
		SalaryDao dao = sqlSession.getMapper(SalaryDao.class);
		
		int result = dao.insertRow(salary);
		
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
	@RequestMapping(value = "/salarylist", method = RequestMethod.GET)
	public  ModelAndView salarylist(@ModelAttribute("salary") Salary salary) {
		SalaryDao dao = sqlSession.getMapper(SalaryDao.class);
		ArrayList <Salary> salarys = dao.selectAll();
		ModelAndView mav = new ModelAndView("salary/salary_list");
		mav.addObject("salarys", salarys);
		return mav;
	}
	
	@RequestMapping(value = "/salaryDetail", method = RequestMethod.GET)
	public ModelAndView salaryDetail (@RequestParam int no, HttpServletResponse response, HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView("salary/salary_detail");
		SalaryDao dao = sqlSession.getMapper(SalaryDao.class);
		Salary salary = dao.selectOne(no);
		
		mav.addObject("salary", salary);
		return mav;
		
	}
	
	@RequestMapping(value = "/salaryUpdate", method = RequestMethod.POST)
	public ModelAndView salaryUpdate(@ModelAttribute("salary") Salary salary) {
		ModelAndView mav = new ModelAndView("salary/salary_result");
		SalaryDao dao = sqlSession.getMapper(SalaryDao.class);
		
		String msg = "";
		int result = dao.updateRow(salary);
		if (result == 1 ){
			msg = "success update your data";
		} else {
			msg = "failed update your data";
		}
		
		
		mav.addObject("msg",msg);
		mav.addObject("result", "ok");
		
		return mav;
	}
	
	@RequestMapping(value = "/salaryDeleteYN", method = RequestMethod.GET)
	public ModelAndView salaryDeleteYN (@RequestParam String no ) {
		ModelAndView mav = new ModelAndView("salary/salary_result_yn");
		SalaryDao dao = sqlSession.getMapper(SalaryDao.class);
		System.out.println("no--->"+no);
		mav.addObject("no",no);
		return mav;
	}
	
	@RequestMapping(value = "/salaryDelete", method = RequestMethod.POST)
	public ModelAndView salaryDelete (@RequestParam String no  ) {
		SalaryDao dao = sqlSession.getMapper(SalaryDao.class);
		int result = dao.deleteRow(no);
		System.out.println("no--->"+no);
		String msg = "";
		if (result == 1 ){
			msg = "Success Delete your data";
		} else {
			msg = "Failed Delete your data";
		}
		ModelAndView mav = new ModelAndView("salary/salary_result");
		mav.addObject("msg",msg);
		
		return mav;
	}
	
	@RequestMapping(value = "/salarySelectedDelete", method = RequestMethod.GET)
	public String memberSelectdDelte (@RequestParam String saveids[] ) {
		SalaryDao dao = sqlSession.getMapper(SalaryDao.class);
		for ( String ids : saveids){
			dao.deleteRow(ids);
		}
		return "redirect:/salarylist";
	}
	@RequestMapping(value = "/salaryCreateForm", method = RequestMethod.GET)
	public ModelAndView salaryCreateForm () {
		SimpleDateFormat simple = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.KOREA);
		Date currentdate = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		String yyyy = df.format(currentdate);
		ModelAndView mav = new ModelAndView("salary/salary_create");
		mav.addObject("yyyy",yyyy);
		return mav;
	}

	@RequestMapping(value = "/salaryRollupForm", method = RequestMethod.GET)
	public ModelAndView salaryRollupForm () {
		SimpleDateFormat simple = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.KOREA);
		Date currentdate = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		String yyyy = df.format(currentdate);
		ModelAndView mav = new ModelAndView("salary/salary_rollup");
		mav.addObject("yyyy",yyyy);
		return mav;
	}
	
	@RequestMapping(value = "/salaryRollup", method = RequestMethod.POST)
	public ModelAndView salaryRollup (@RequestParam String yyyy, @RequestParam String mm) {
		ModelAndView mav = new ModelAndView("salary/salary_rolluplist");
		SalaryDao dao = sqlSession.getMapper(SalaryDao.class);
		ArrayList <SalaryRollup> rollups = dao.salaryRollup(yyyy+mm);
		mav.addObject("rollups",rollups);
		System.out.println(rollups.size());
	
		return mav;
	}
	
	@RequestMapping(value = "/salaryCreate", method = RequestMethod.POST)
	public ModelAndView salaryCreateYN (@RequestParam String yyyy, @RequestParam String mm) {
		ModelAndView mav = new ModelAndView("salary/salary_list");
		SalaryDao dao = sqlSession.getMapper(SalaryDao.class);
		dao.deleteRollRow(yyyy+mm);
		ArrayList <Salary> salarys = dao.selectAll();
		List<SalaryRoll> salaryrolls = new ArrayList<SalaryRoll>();
		for ( Salary salary : salarys ){
			System.out.println(salary.getNo());
			salaryroll = new SalaryRoll();
			salaryroll.setYyyymm(yyyy+mm);
			salaryroll.setNo(salary.getNo());
			salaryroll.setAmount(salary.getBase()+salary.getExtrapay1()+salary.getExtrapay2());
			salaryroll.setAmount12(salaryroll.getAmount() * 12);
			
			
			//근로소등공제
			int incometax = 0;
			if ( salaryroll.getAmount12() < 5000001){
				incometax = (int) (salaryroll.getAmount12()  * 0.7);
			} else if ( (salaryroll.getAmount12() > 5000000) && (salaryroll.getAmount12() < 15000001) ) {
				incometax = (int) (3500000 + ((salaryroll.getAmount12() - 5000000) * 0.4));
			} else if ( (salaryroll.getAmount12() > 15000000) && (salaryroll.getAmount12() < 45000001) ) {
				incometax = (int) (7500000 + ((salaryroll.getAmount12() - 15000000) * 0.15));
			} else if ( (salaryroll.getAmount12() > 45000000) && (salaryroll.getAmount12() < 100000001) ) {
				incometax = (int) (12000000 + ((salaryroll.getAmount12() - 45000000) * 0.05));
			} else {
				incometax = (int) (14750000 + ((salaryroll.getAmount12() - 100000000) * 0.02));
			}
			salaryroll.setIncometax(incometax);
			
			int temp  = (int) (salaryroll.getAmount() * 0.001) ;
					  temp = temp * 1000;
					  
					  
				temp = (int) Math.floor((temp*0.045) * 0.1)* 10;
				temp = temp * 12;
				
				salaryroll.setInsurance(temp);
				int dependent = salary.getPartner() + salary.getDependent20() + salary.getDependent60();
				temp = dependent * 1500000;
				salaryroll.setHumandeduct(temp);
				int addtemp = (int) ((4000000 - salaryroll.getAmount12()) * 0.04);
			
			//근로 소득 금액
				temp = salaryroll.getAmount12() - salaryroll.getIncometax();
				salaryroll.setIncome(temp);
				
				
				
			//특별소등공제
//				3000만원 이하
				if( ( salaryroll.getAmount12() < 30000001 ) && (dependent == 1)){
					temp = (int) (3100000 + (salaryroll.getAmount12() * 0.04));
				}
				if( ( salaryroll.getAmount12() < 30000001 ) && (dependent == 2)){
					temp = (int) (3600000 + (salaryroll.getAmount12() * 0.04));
				}
				if( ( salaryroll.getAmount12() < 30000001 ) && (dependent > 2)){
					temp = (int) (5000000 + (salaryroll.getAmount12() * 0.07)) +addtemp;
				}
				
//				3000만원 초과 4500만원 이하				
				if( ( salaryroll.getAmount12() > 30000000 ) && ( salaryroll.getAmount12() > 45000001 ) && (dependent == 1) ){
					temp = (int) (3100000 + (salaryroll.getAmount12() * 0.04) - ((salaryroll.getAmount12()-3000000)*0.05) );
				}
				if( ( salaryroll.getAmount12() > 30000000 ) && ( salaryroll.getAmount12() > 45000001 ) && (dependent == 2) ){
					temp = (int) (3600000 + (salaryroll.getAmount12() * 0.04) - ((salaryroll.getAmount12()-3000000)*0.05) );
				}
				
				if( ( salaryroll.getAmount12() > 30000000 ) && ( salaryroll.getAmount12() > 45000001 ) && (dependent > 2) ){
					temp = (int) (5000000 + (salaryroll.getAmount12() * 0.07) - ((salaryroll.getAmount12()-3000000)*0.05) + addtemp);
				}
				
//				4500만원 초과 7000만원 이하					
				if( (  salaryroll.getAmount12() > 45000000 ) && ( salaryroll.getAmount12() < 70000001 ) && (dependent == 1)){
					temp = (int) (3100000 + (salaryroll.getAmount12() * 0.015));
				}
				if( (  salaryroll.getAmount12() > 45000000 ) && ( salaryroll.getAmount12() < 70000001 ) && (dependent == 2)){
					temp = (int) (3100000 + (salaryroll.getAmount12() * 0.02));
				}
				if( (  salaryroll.getAmount12() > 45000000 ) && ( salaryroll.getAmount12() < 70000001 ) && (dependent > 2) ){
					temp = (int) (5000000 + (salaryroll.getAmount12() * 0.05)  + addtemp);
				}
				
				
//				7000만원 초과 12000만원 이하			
				if( (  salaryroll.getAmount12() > 70000000 ) && ( salaryroll.getAmount12() < 120000001 ) && (dependent == 1)){
					temp = (int) (3100000 + (salaryroll.getAmount12() * 0.005));
				}
				if( (  salaryroll.getAmount12() > 70000000 ) && ( salaryroll.getAmount12() < 120000001 ) && (dependent == 2)){
					temp = (int) (3100000 + (salaryroll.getAmount12() * 0.01));
				}
				if( (  salaryroll.getAmount12() > 70000000 ) && ( salaryroll.getAmount12() < 120000001 ) && (dependent > 2) ){
					temp = (int) (5000000 + (salaryroll.getAmount12() * 0.03)  + addtemp);
				}

				salaryroll.setSpecial(temp);
				
				//과세 표준액
				temp  = salaryroll.getIncome() - (salaryroll.getHumandeduct() + salaryroll.getInsurance() + salaryroll.getSpecial());
				salaryroll.setStandard(temp);
				
				//산출 세액
				temp = 0;
				if ( salaryroll.getStandard() < 12000001){
					temp = (int) (salaryroll.getStandard() * 0.06);
				} 
				else if ( salaryroll.getStandard() > 12000000 && salaryroll.getStandard() < 46000001){
					temp = (int) (720000 + ((salaryroll.getStandard() - 12000000) * 0.15)); 
				}
				else if ( salaryroll.getStandard() > 46000000 && salaryroll.getStandard() < 88000001){
					temp = (int) (5820000 + ((salaryroll.getStandard() - 46000000) * 0.24)); 
				}
				else if ( salaryroll.getStandard() > 88000000 && salaryroll.getStandard() < 150000001){
					temp = (int) (15900000 + ((salaryroll.getStandard() - 88000000) * 0.35)); 
				}
				else if ( salaryroll.getStandard() > 150000000){
					temp = (int) (37600000 + ((salaryroll.getStandard() - 15900000) * 0.38)); 
				}
				salaryroll.setCalculatetax(temp);
				
				
				//근로소득 세액 공제
				temp = 0;
				if ( salaryroll.getCalculatetax() < 500001){
					temp = (int) (salaryroll.getCalculatetax() * 0.55);
				}
				else if ( salaryroll.getCalculatetax() > 500000) {
					temp = (int) (275000 + ((salaryroll.getCalculatetax()-500000)*0.3));
				}
				
				int tempincometax = temp;
				if ( tempincometax > 660000 && salaryroll.getAmount12() < 55000001) {
					temp = 660000;
				}
				if ( tempincometax > 630000 && salaryroll.getAmount12() > 55000000 && salaryroll.getAmount12() < 70000001 ) {
					temp = 630000;
				}
				if ( tempincometax > 500000 && salaryroll.getAmount12() > 70000000 ) {
					temp = 500000;
				}
				salaryroll.setIncometaxdeduct(temp);
				
				//결정세액
				temp = 0;
				temp = salaryroll.getCalculatetax() - salaryroll.getIncometaxdeduct();
				salaryroll.setDecisiontax(temp);
				
				//간이세액
				temp = (int) salaryroll.getDecisiontax()/12;
				temp = (int) Math.floor(temp * 0.1)* 10;
				salaryroll.setDecisiontax12(temp);
				
				salaryrolls.add(salaryroll);
		}
		dao.insertRollRow(salaryrolls);
		return mav;
	}
}

