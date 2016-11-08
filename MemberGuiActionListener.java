package member;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import kr.ac.itschool.entities.Member;
import kr.ac.itschool.service.MemberDaoService;

public class MemberGuiActionListener implements  ActionListener {
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
	boolean confirmchk;
	MemberDaoService service = new MemberDaoService();
	
	public MemberGuiActionListener(JTable table, JTextField id, JTextField name, JTextField phone1, JTextField phone2,
			JTextField phone3, JTextField post,JTextField addr1, 
			JTextField addr2,JTextField password,JTextField find,DefaultTableModel model,boolean confirmchk)
	{
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
		this.confirmchk = confirmchk;
	}
	boolean confirmchk() {
		boolean findid = service.findId(id.getText());

	if ( findid ) {
		JOptionPane.showMessageDialog(id, "id 중복입니다");
		id.setText("");
		confirmchk = false;
	 }
	else {
		JOptionPane.showMessageDialog(id, "사용가능한 id입니다.");
		confirmchk = true;
	 }
	return findid;
	}

	public void actionPerformed(ActionEvent e) {
		String btntxt =  e.getActionCommand();
		Member data = new Member();
		data.setId(id.getText());
		data.setName(name.getText());
		data.setPassword(password.getText());
		data.setPhone1(phone1.getText());
		data.setPhone2(phone2.getText());
		data.setPhone3(phone3.getText());
		data.setPost(addr1.getText());
		data.setPost(addr2.getText());
		data.setAddr1(post.getText());
		
		if(btntxt.equals("중복검사")){
			if(id.getText().equals("")){
				JOptionPane.showMessageDialog(id, "id를입력하세요");
				return;
			}
			boolean findid = confirmchk();
			if(findid)
				return;
		}
		if ( btntxt.equals("입력")){
			 insertMember ( data, btntxt );
		}
		if ( btntxt.equals("검색")){
			 searchMember ( find.getText() );
		}
		if (btntxt.equals("취소")){
			model.setRowCount(0);
			screenClear();
		}
		if (btntxt.equals("수정")){
			Object after = table.getValueAt(table.getSelectedRow(), 0);
			String result = after.toString();
			
			if(id.getText().equals("")){
				JOptionPane.showMessageDialog(id, "검색 후 수정 항목을 선택하시오.");
				return;
			}
			else if ( result != id.getText() ){
				id.setText(result);
				id.getText();
				JOptionPane.showMessageDialog(id, "ID를 변경 할 수 없습니다.");
				return;
			}
			updateMember( data );
		}
    }
	
	
	private void insertMember(Member data, String btntxt) {
		
		String message = "  입력시 체크 사항 \n\n  ";
		if ( !confirmchk )
			message += "중복 체크 하시오\n";
		if(id.getText().equals("") || id.getText() == null ){
			message += "ID를입력하시오 \n";
			confirmchk = false;
		}
		if(name.getText().equals("") || name.getText() == null ){
			message += "이름를입력하시오 \n";
		}
		if ( !message.equals("  입력시 체크 사항 \n\n  ")){
			JOptionPane.showMessageDialog(id, message);
		return;
		}
		boolean success = service.insertRow(data);
		if(success){
			JOptionPane.showMessageDialog(id, "저장되었습니다.");
			Object row [] = {"","",""};
			 row [0] = data.getId(); 
			 row [1] = data.getName(); 
			 row [2] = data.getPhone1() +"-"+ data.getPhone2() +"-"+ data.getPhone3();
			 model.addRow(row);
			 screenClear();
		}else{
			JOptionPane.showMessageDialog(id, "저장실패");
		}
		 confirmchk = false;
	}
	
	private void updateMember(Member data) {
	String result = service.updateRow(data);
	if ( result.equals("")){
	 	JOptionPane.showMessageDialog(id, "수정완료");
	 	screenClear();
		model.setValueAt(data.getName(), table.getSelectedRow(), 1);
		String phone = data.getPhone1() +"-"+ data.getPhone2() +"-"+ data.getPhone3();
		model.setValueAt(phone, table.getSelectedRow(), 2);
	 	}
	else
		JOptionPane.showMessageDialog(id, "수정되지않았습니다 \n"+result);
	}
	
	private void deleteMember(String id) {
	}
	
	void searchMember( String find ){
		model.setRowCount(0);
		ArrayList<Member> list = null;
		if(find.equals("")){
		list = service.selectAll();
		}  
		else{
		list = service.selectFind(find);
		}
		Object row [] = {"","",""};
		for ( Member list1 : list ) {
		 row [0] = list1.getId(); 
		 row [1] = list1.getName(); 
		 row [2] = list1.getPhone1()+"-"+ list1.getPhone2() +"-"+ list1.getPhone3();
		 model.addRow(row);
		}
		System.out.println(list.size());
	}
	
	void screenClear() {
		id.setText("");
		password.setText("");
		name.setText("");
		phone1.setText("");
		phone2.setText("");
		phone3.setText("");
		addr1.setText("");
		addr2.setText("");
		post.setText("");
	}
}
