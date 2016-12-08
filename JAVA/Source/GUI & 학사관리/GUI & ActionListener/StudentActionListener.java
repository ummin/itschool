package kr.ac.itschool.DBJoin0801;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import kr.ac.itschool.entities.join0801.StudentBean;
import kr.ac.itschool.service.join0801.StudentDaoService;

public class StudentActionListener implements ActionListener {
	JFrame frame;
	JFrame frame1;
	JTextField code;
	JComboBox dept;
	JTextField name;
	JTextField no;
	JTextField postno;
	JTextField addr1;
	JTextField addr2;
	JComboBox professor;
	boolean confirmchk;
	JTable table;
	DefaultTableModel model;
	JTextField find;
	StudentDaoService service = new StudentDaoService();
	public StudentActionListener(JFrame frame, JFrame frame1, JTextField code, 
			JComboBox dept, JTextField name, JTextField no, JTextField postno, 
			JTextField addr1, JTextField addr2, JComboBox professor, boolean confirmchk, JTable table, 
			DefaultTableModel model, JTextField find) {
		this.frame = frame;
		this.frame1 = frame1;
		this.code = code;
		this.dept = dept;
		this.name = name;
		this.no = no;
		this.postno = postno;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.professor = professor;
		this.confirmchk = confirmchk;
		this.table = table;
		this.model = model;
		this.find = find;
	}
	
	boolean confirmchk() {
     	StudentDaoService service = new StudentDaoService();
		boolean findcode = service.findCode(code.getText());
	
		if ( findcode ){
			JOptionPane.showMessageDialog(code, "Code 중복입니다.");
			code.setText("");
			confirmchk = false;
		}
		else if ( !findcode ){
			JOptionPane.showMessageDialog(code, "사용가능한 Code 입니다.");
			confirmchk = true;
		}
		return findcode;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String btn = e.getActionCommand();
		if ( btn.equals("Home")){
			frame1.setVisible(false);
			frame.setVisible(true);
			return;
		}
		
		StudentBean data = new StudentBean();
		
	
		
//		String deptname = dept.getSelectedItem().toString();
//		int dept = deptname.lastIndexOf(" ");
//		String deptname1 = deptname.substring(0,dept);
		
//		DeptDaoService deptservice = new DeptDaoService();
//		String deptnum = deptservice.deptName(deptname);
//		System.out.println("deptnum --->>"+deptnum);
		
//		String proname = professor.getSelectedItem().toString();
//		int pro = proname.lastIndexOf(" ");
//		String proname1 = proname.substring(0,pro);
//		
//		String proname = professor.getSelectedItem().toString();
//		ProfessorDaoService proservice = new ProfessorDaoService();
//		String pronum = proservice.proName(proname);
//		System.out.println("pronum--->>"+pronum);
		
		data.setCode(code.getText());
		data.setDept(dept.getSelectedItem().toString());
		System.out.println("deptItem-->"+dept.getSelectedItem());
		data.setName(name.getText());
		data.setIdcard(no.getText());
		data.setPostno(postno.getText());
		data.setAddr1(addr1.getText());
		data.setAddr2(addr2.getText());
		data.setProfessor(professor.getSelectedItem().toString());
		
		if ( btn.equals("중복검사")) {
			if ( code.getText().equals("")){
				JOptionPane.showMessageDialog(code, "code를 입력하시오");
				return;
			}
			boolean findcode = confirmchk();
			if (findcode)
				return;
		}
		if (btn.equals("입력")){
	    	if ( code.getText().equals("")){
				JOptionPane.showMessageDialog(code, "code를 입력하시오");
			}
			insertRow(data);
		}
		
		if (btn.equals("검색")){
			searchRow(find.getText());
			find.setText("");
		}
	
	   if (btn.equals("수정")){
		Object after = table.getValueAt(table.getSelectedRow(), 0);
		String result = after.toString();
		
		if ( !result.equals( code.getText() ) ){
			code.setText(result);
			code.getText();
			JOptionPane.showMessageDialog(code, "Code를 변경 할 수 없습니다.");
			return;
		}
		updateRow(data);
	  }
	   
	 if (btn.equals("취소")){
		 screenClear();
		 model.setRowCount(0);
	 }
	 
	 if (btn.equals("삭제")){
		if(table.getSelectedRow() == -1){
			JOptionPane.showMessageDialog(code, "삭제 할 항목을 선택하시오");
			return;
		}
		deleteMember();
   }
 }

 private void deleteMember() {
	boolean success = service.deleteRow(code.getText());
	if ( success ){
		JOptionPane.showMessageDialog(code, "삭제완료");
	}
	model.removeRow(table.getSelectedRow());
	screenClear();
	if (!success) {
		JOptionPane.showMessageDialog(code, "삭제실패");
		}
}

 private void updateRow(StudentBean data) {
	boolean success = service.updateRow(data);
	if (success){
		model.setRowCount(0);
		Object row[] = {"","","",""};
		row[0] = data.getCode();
		row[1] = dept.getSelectedItem().toString();
		row[2] = data.getName();
		row[3] = professor.getSelectedItem().toString();
		model.addRow(row);
		screenClear();
	}
}

 private void searchRow(String text) {
	model.setRowCount(0);
	ArrayList<StudentBean> list = new ArrayList<StudentBean>();
	if(text.equals("")){
		list = service.selectAll();
	}
	else if(!text.equals("")){
		list = service.selectFind(text);
	}
	
	Object row[] = {"","","",""};
	for( StudentBean list1 : list){
	row[0] = list1.getCode();
	row[1] = list1.getDept();
	row[2] = list1.getName();
	row[3] = list1.getProfessor();
	model.addRow(row);
	}
	System.out.println(list.size());
 }

 private void insertRow(StudentBean data) { 
	 if ( !confirmchk ){
			JOptionPane.showMessageDialog(code, "중복체크하시오");
			confirmchk = false;
			return;
		}
		boolean success = service.insertRow(data);
	if ( success ){
		JOptionPane.showMessageDialog(code, "입력완료");
		confirmchk = false;
	}
	else if ( !success ){
		JOptionPane.showMessageDialog(code, "입력실패");
		return;
	}
	
	Object row[] = {"","","",""};
	row[0] = data.getCode();
	row[1] = dept.getSelectedItem().toString();
	row[2] = data.getName();
	row[3] = professor.getSelectedItem().toString();
	model.addRow(row);
	screenClear();
 }
 
 private void screenClear() {
	code.setText("");
	name.setText("");
	dept.setSelectedItem(0);
	no.setText("");
	postno.setText("");
	addr1.setText("");
	addr2.setText("");
	professor.setSelectedItem(0);
 }
}
