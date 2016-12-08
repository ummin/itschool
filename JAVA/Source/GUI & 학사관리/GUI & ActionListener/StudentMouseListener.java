package kr.ac.itschool.DBJoin0801;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import kr.ac.itschool.entities.join0801.DeptBean;
import kr.ac.itschool.entities.join0801.StudentBean;
import kr.ac.itschool.service.join0801.StudentDaoService;

public class StudentMouseListener implements MouseListener {
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
	public StudentMouseListener(JTextField code, JComboBox dept, JTextField name, JTextField no, JTextField postno, 
			JTextField addr1, JTextField addr2, JComboBox professor, boolean confirmchk, JTable table, DefaultTableModel model, JTextField find)
	{
		
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
	@Override
	public void mouseClicked(MouseEvent e) {
		JTable target = (JTable) e.getSource();
		int row = target.getSelectedRow();
		if ( row == -1){
			JOptionPane.showMessageDialog(code, "항목을 선택하시오");
		    return;
		}

		String idd = (String) target.getValueAt(row, 0);
		String names = (String) target.getValueAt(row, 1);
		
		if (e.getButton() == 3 ) {
			System.out.println(idd+" "+names+" "+row);
			deleteMember(idd ,names,row);
			return;
		}
		StudentDaoService service = new StudentDaoService();
		StudentBean data = service.selectRowone(idd,table);
		
		
		
		DeptBean Dept = (DeptBean) dept.getSelectedItem();
		System.out.println(Dept.getName());
		
		code.setText(data.getCode());
		dept.setSelectedItem(Dept.getName());
		name.setText(data.getName());
		no.setText(data.getIdcard());
		postno.setText(data.getPostno());
		addr1.setText(data.getAddr1());
		addr2.setText(data.getAddr2());
		professor.setSelectedItem(data.getProfessor());
		
	}

	private void deleteMember(String idd, String names, int row) {
		System.out.println("---->"+idd+","+names);
		int result = JOptionPane.showConfirmDialog(null, "ID : "+idd+"\n"+"Name :"+names+"\n"+"\n"+ "Do you want to remove?","Test Spanish", JOptionPane.OK_CANCEL_OPTION);
		if (result == 0){
			StudentDaoService service= new StudentDaoService();
			boolean success = service.deleteRow(idd);
			if (success){
				System.out.println(idd+" "+names+" "+row);
				model.removeRow(row);
			 }
			}else{
			return;
	}
	}
	

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
