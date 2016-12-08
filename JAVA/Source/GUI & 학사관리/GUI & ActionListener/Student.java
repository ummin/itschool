package kr.ac.itschool.DBJoin0801;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import org.springframework.beans.factory.annotation.Autowired;

import kr.ac.itschool.entities.join0801.DeptBean;
import kr.ac.itschool.service.join0801.DeptDaoService;
import kr.ac.itschool.service.join0801.ProfessorDaoService;

public class Student  implements ActionListener{
	JFrame frame;
	public Student(JFrame frame) {
		this.frame = frame;
	}
	@Autowired
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.setVisible(false);
		JFrame frame1 = new JFrame("Student");
		frame1.setPreferredSize(new Dimension(1000,600));
		frame1.setLocation(200, 200);
		Container contentPane = frame1.getContentPane();
		boolean confirmchk = false;
		
		Font font = new Font("바탕체", Font.TYPE1_FONT,17);
		Font font15 = new Font ("바탕체",Font.TYPE1_FONT, 12);
		String colNames[] = {"학번","학과","성명","지도교수"};
		
		DefaultTableModel model = new DefaultTableModel(colNames,0);
		JTable table = new JTable(model);
		contentPane.add(new JScrollPane(table), BorderLayout.EAST);
		JTableHeader header = table.getTableHeader();
		header.setPreferredSize(new Dimension(100,30));
		header.setBackground(Color.LIGHT_GRAY);
		
		table.setFont(font15);
		table.setRowHeight(30);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(8,2));
		
		JLabel labelcode = new JLabel("학번");
		labelcode.setFont(font);
		labelcode.setHorizontalAlignment(JLabel.CENTER);
		JTextField code = new JTextField(11);
		JButton codechk = new JButton("중복검사");
		JPanel panelcode = new JPanel();
		panelcode.add(code);
		panelcode.add(codechk);
		
		JLabel labeldept = new JLabel("학과");
		labeldept.setFont(font);
		labeldept.setHorizontalAlignment(JLabel.CENTER);
		
		DeptDaoService service = new DeptDaoService();
		ArrayList<DeptBean> list = service.selectAll();
		JComboBox dept = new JComboBox();
		DeptBean data = new DeptBean();
		for( DeptBean list1 : list) {
			dept.addItem(new DeptBean(list1.getName(), list1.getCode()));
		}
		
//		DeptDaoService service = new DeptDaoService();
//		ArrayList<String> list = service.selectDept();
//		JComboBox dept = new JComboBox();
//		DeptBean data = new DeptBean();
//		for ( String list1 : list){
//		dept.addItem(list1);
//		}
//		dept.setModel( new DefaultComboBoxModel(list.toArray()));
		
		JLabel labelname = new JLabel("이름");
		labelname.setFont(font);
		labelname.setHorizontalAlignment(JLabel.CENTER);
		JTextField name = new JTextField(4);
		
		JLabel labelno = new JLabel("주민번호");
		labelno.setFont(font);
		labelno.setHorizontalAlignment(JLabel.CENTER);
		JTextField no = new JTextField(11);
		
		JLabel labelpost = new JLabel("우편번호");
		labelpost.setFont(font);
		labelpost.setHorizontalAlignment(JLabel.CENTER);
		JTextField postno = new JTextField(7);
		
		JLabel labeladr = new JLabel("주소");
		labeladr.setFont(font);
		labeladr.setHorizontalAlignment(JLabel.CENTER);
		JTextField addr1 = new JTextField(11);
		JLabel labeladr2 = new JLabel("  ");
		JTextField addr2 = new JTextField(11);
		
		JLabel labelprofessor = new JLabel("지도교수");
		labelprofessor.setFont(font);
		labelprofessor.setHorizontalAlignment(JLabel.CENTER);
	
		ProfessorDaoService service1 = new ProfessorDaoService();
		ArrayList<String> list1 = service1.selectPro();
		JComboBox professor = new JComboBox();
		professor.setModel( new DefaultComboBoxModel(list1.toArray()));
		
		panel1.add(labelcode);
		panel1.add(panelcode);
		panel1.add(labeldept);
		panel1.add(dept);
		panel1.add(labelname);
		panel1.add(name);
		panel1.add(labelno);
		panel1.add(no);
		panel1.add(labelpost);
		panel1.add(postno);
		panel1.add(labeladr);
		panel1.add(addr1);
		panel1.add(labeladr2);
		panel1.add(addr2);
		panel1.add(labelprofessor);
		panel1.add(professor);
		panel1.setSize(50,50);
		contentPane.add(panel1, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		JTextField find = new JTextField(5);
		String arrbtn[] = {"입력","수정","검색","삭제","취소","Home"};
		ActionListener listener = new StudentActionListener(frame,frame1,code,dept,name,no,postno,addr1,addr2,professor,confirmchk,table,model,find);
		codechk.addActionListener(listener);
		codechk.setFont(font);
		for ( int i = 0 ; i < arrbtn.length ; i ++){
			JButton button = new JButton( arrbtn[i] );
			panel.add(button);
			if (i == 1)
				panel.add(find);
			button.addActionListener(listener);
		}
		MouseListener mouse = new StudentMouseListener(code,dept,name,no,postno,addr1,addr2,professor,confirmchk,table,model,find);
		table.addMouseListener( mouse );
		contentPane.add(panel, BorderLayout.SOUTH);
		frame1.pack();
		frame1.setVisible(true);
	}
}



