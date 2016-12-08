package member;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import kr.ac.itschool.entities.Member;
import kr.ac.itschool.service.MemberDaoService;

public class MemberGuiMouseListener implements MouseListener {
	JTable table;
	JTextField id;
	JTextField password;
	JTextField name;
	JTextField phone1;
	JTextField phone2;
	JTextField phone3;
	JTextField post;
	JTextField addr1;
	JTextField addr2;
	JTextField find;
	DefaultTableModel model;
	
	MemberGuiMouseListener(JTable table, JTextField id, JTextField name, JTextField phone1, JTextField phone2,
			JTextField phone3, JTextField post,JTextField addr1, 
			JTextField addr2,JTextField password,JTextField find,DefaultTableModel model,boolean confirmchk) {
		
		this.table = table;
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
		this.post = post;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.find = find;
		this.model = model;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		JTable target = (JTable) e.getSource();
		int row = target.getSelectedRow();
		if ( row == -1){
			JOptionPane.showMessageDialog(id, "항목을 선택하시오");
		    return;
		}
		
		String idd = (String) target.getValueAt(row, 0);
		String names = (String) target.getValueAt(row, 1);
			
		if (e.getButton() == 3 ){
			deleteMember( idd, names, row );
			return;
		}
		
		MemberDaoService service = new MemberDaoService();
		Member data = service.selectRowone(idd);
		id.setText(data.getId());
		name.setText(data.getName());
		password.setText(data.getPassword());
		phone1.setText(data.getPhone1());
		phone2.setText(data.getPhone2());
		phone3.setText(data.getPhone3());
		post.setText(data.getPost());
		addr1.setText(data.getAddr1());
		addr2.setText(data.getAddr2());
	}

	private void deleteMember(String id,String name,int row) {
		System.out.println("---->"+id+","+name);
		int result = JOptionPane.showConfirmDialog(null, "ID : "+id+"\n"+"Name :"+name+"\n"+"\n"+ "Do you want to remove?","Test Spanish", JOptionPane.OK_CANCEL_OPTION);
		System.out.println(result);
		if (result == 0){
			MemberDaoService service= new MemberDaoService();
			boolean success = service.deleteRow(id);
			if (success){
				model.removeRow(row);
			}
		}else{
			return;
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

}
