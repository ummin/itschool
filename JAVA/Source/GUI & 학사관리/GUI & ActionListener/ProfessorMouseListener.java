package kr.ac.itschool.DBJoin0801;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import kr.ac.itschool.entities.join0801.ProfessorBean;
import kr.ac.itschool.service.join0801.ProfessorDaoService;

public class ProfessorMouseListener implements MouseListener {
	JTextField code;
	JTextField name;
	DefaultTableModel model;
	
	public ProfessorMouseListener(JTextField code, JTextField name, DefaultTableModel model) {
		this.code = code;
		this.name = name;
		this.model = model;
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
		System.out.println(idd+"  "+names);
		
		if (e.getButton() == 3 ) {
			System.out.println(idd+" "+names+" "+row);
			deleteMember(idd ,names,row);
			return;
		}
		ProfessorDaoService service = new ProfessorDaoService();
		ProfessorBean data = service.selectRowone(idd);
		
		code.setText(data.getCode());
		name.setText(data.getName());
	}

	private void deleteMember(String idd, String names, int row) {
		System.out.println("---->"+idd+","+names);
		int result = JOptionPane.showConfirmDialog(null, "ID : "+idd+"\n"+"Name :"+names+"\n"+"\n"+ "Do you want to remove?","Test Spanish", JOptionPane.OK_CANCEL_OPTION);
		if (result == 0){
			ProfessorDaoService service= new ProfessorDaoService();
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
