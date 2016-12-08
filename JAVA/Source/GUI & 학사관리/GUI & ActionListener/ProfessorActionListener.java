package kr.ac.itschool.DBJoin0801;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import kr.ac.itschool.entities.join0801.ProfessorBean;
import kr.ac.itschool.service.join0801.ProfessorDaoService;

public class ProfessorActionListener implements ActionListener {
	JFrame frame;
	JFrame frame1;
	JTable table;
	JTextField code;
	JTextField name;
	boolean confirmchk;
	DefaultTableModel model;
	ProfessorDaoService service = new 	ProfessorDaoService();
	JTextField find;
	
	public ProfessorActionListener(JFrame frame, JFrame frame1, JTable table, JTextField code, JTextField name, boolean confirmchk, DefaultTableModel model, JTextField find) {
		this.frame = frame;
		this.frame1 = frame1;
		this.code = code;
		this.name = name;
		this.confirmchk = confirmchk;
		this.model = model;
		this.find = find;
		this.table = table;
	}

	private boolean confirmchk() {
		boolean findcode = service.findId(code.getText());
		
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
		
		ProfessorBean data = new ProfessorBean();
		data.setCode(code.getText());
		data.setName(name.getText());
		
		if ( btn.equals("중복검사")){
			if ( code.getText().equals("")){
				JOptionPane.showMessageDialog(code, "code를 입력하시오");
				return;
			}
			boolean findcode = confirmchk();
			if ( findcode )
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
			System.out.println(result+"<-->"+code.getText());
			
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
			System.out.println(table.getSelectedRow());
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

	private void updateRow(ProfessorBean data) {
		boolean success = service.updateRow(data);
		if ( success ){
		 	JOptionPane.showMessageDialog(code, "수정완료");
		 	screenClear();
			model.setValueAt(data.getCode(), table.getSelectedRow(), 0);
			model.setValueAt(data.getName(), table.getSelectedRow(), 1);
		 	}
		else
			JOptionPane.showMessageDialog(code, "수정되지않았습니다 \n");
	}

	private void searchRow(String text) {
		model.setRowCount(0);
		ArrayList<ProfessorBean> list = new ArrayList<ProfessorBean>();
		if(text.equals("")){
			list = service.selectAll();
		}
		else if(!text.equals("")){
			list = service.selectFind(text);
		}
		
		Object row[] = {"",""};
		for( ProfessorBean list1 : list){
		row[0] = list1.getCode();
		row[1] = list1.getName();
		model.addRow(row);
		}
		System.out.println(list.size());
	}

	private void insertRow(ProfessorBean data) { 
		if ( !confirmchk ){
			JOptionPane.showMessageDialog(code, "중복체크하시오");
			confirmchk = false;
			return;
		}
		boolean success = service.insertRow(data);
		if ( success ){
			JOptionPane.showMessageDialog(code, "입력완료");
		}
		else if ( !success ){
			JOptionPane.showMessageDialog(code, "입력실패");
			return;
		}
		confirmchk = false;
		Object row[] = {"",""};
		row[0] = data.getCode();
		row[1] = data.getName();
		model.addRow(row);
		screenClear();
	}
	
	private void screenClear() {
		code.setText("");
		name.setText("");
	}
}
