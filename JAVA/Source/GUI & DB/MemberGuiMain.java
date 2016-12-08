package member;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberGuiMain {

	@Autowired
	public static void main(String[] args) {
		boolean confirmchk = false;
		JFrame frame = new JFrame();
		frame.setPreferredSize(new Dimension(900,300));
		frame.setLocation(500, 400);
		Container contentPane = frame.getContentPane();
		Font font = new Font("바탕체", Font.TYPE1_FONT,20);
		Font font15 = new Font ("바탕체",Font.TYPE1_FONT, 19);
		String colNames[] = {"ID","이름","전화번호"};
		
		DefaultTableModel model = new DefaultTableModel(colNames,0);
		JTable table = new JTable(model);
		contentPane.add(new JScrollPane(table), BorderLayout.EAST);
		
		JTableHeader header = table.getTableHeader();
		header.setPreferredSize(new Dimension(100,30));
		header.setBackground(Color.LIGHT_GRAY);
		
		table.setFont(font15);
		table.setRowHeight(30);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(7,2));
		
		JLabel labelid = new JLabel("ID");
		labelid.setFont(font);
		labelid.setHorizontalAlignment(JLabel.CENTER);
		JTextField id = new JTextField(8);
		JButton idchk = new JButton("중복검사");
		JPanel panelid = new JPanel();
		panelid.add(id);
		panelid.add(idchk);
		
		JLabel labelpw = new JLabel("PW");
		labelpw.setFont(font);
		labelpw.setHorizontalAlignment(JLabel.CENTER);
		JTextField password = new JTextField(11);
		
		JLabel labelname = new JLabel("이름");
		labelname.setFont(font);
		labelname.setHorizontalAlignment(JLabel.CENTER);
		JTextField name = new JTextField(11);
		
		JLabel labelphone = new JLabel("전화번호");
		labelphone.setFont(font);
		labelphone.setHorizontalAlignment(JLabel.CENTER);
		JPanel phone = new JPanel();
		JLabel labelphone1 = new JLabel("-");
		JLabel labelphone2 = new JLabel("-");
		JTextField phone1 = new JTextField(4);
		JTextField phone2 = new JTextField(4);
		JTextField phone3 = new JTextField(4);
		phone.add(phone1);
		phone.add(labelphone1);
		phone.add(phone2);
		phone.add(labelphone2);
		phone.add(phone3);
		
		JLabel labeladrnum = new JLabel("우편번호");
		labeladrnum.setFont(font);
		labeladrnum.setHorizontalAlignment(JLabel.CENTER);
		JTextField post = new JTextField(7);
		
		JLabel labeladr = new JLabel("주소");
		labeladr.setFont(font);
		labeladr.setHorizontalAlignment(JLabel.CENTER);
		JTextField addr1 = new JTextField(11);
		JLabel labeladr2 = new JLabel("  ");
		JTextField addr2 = new JTextField(11);
		
		panel1.add(labelid);
		panel1.add(panelid);
		panel1.add(labelpw);
		panel1.add(password);
		panel1.add(labelname);
		panel1.add(name);
		panel1.add(labelphone);
		panel1.add(phone);
		panel1.add(labeladrnum);
		panel1.add(post);
		panel1.add(labeladr);
		panel1.add(addr1);
		panel1.add(labeladr2);
		panel1.add(addr2);
		panel1.setSize(50,50);
		contentPane.add(panel1, BorderLayout.CENTER);
		JPanel panel = new JPanel();
		JTextField find = new JTextField(5);
		
		String arrbtn[] = {"입력","수정","검색","삭제","취소"};
		ActionListener listener = new MemberGuiActionListener(table,id,name,phone1,phone2,phone3,post,addr1,addr2,password,find,model,confirmchk);
		idchk.addActionListener(listener);
		find.setFont(font);
		for ( int i = 0 ; i < arrbtn.length ; i ++){
			JButton button = new JButton( arrbtn[i] );
			panel.add(button);
			if (i == 2)
				panel.add(find);
			button.addActionListener(listener);
		}
		MouseListener mouse = new MemberGuiMouseListener(table,id,name,phone1,phone2,phone3,post,addr1,addr2,password,find,model,confirmchk);
		table.addMouseListener( mouse );
		contentPane.add(panel, BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
	}
	}

