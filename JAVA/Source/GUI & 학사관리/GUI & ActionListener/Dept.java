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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Dept implements ActionListener{
	public static Object rs;
	JFrame frame;
	public Dept(JFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		frame.setVisible(false);
		boolean confirmchk = false;
		JFrame frame1 = new JFrame("DEPT");
		frame1.setPreferredSize(new Dimension(850,200));
		frame1.setLocation(500, 400);
		Container contentPane = frame1.getContentPane();
		Font font = new Font("바탕체", Font.TYPE1_FONT,20);
		Font font15 = new Font ("바탕체",Font.TYPE1_FONT, 19);
		String colNames[] = {"CODE","학과명"};
		
		DefaultTableModel model = new DefaultTableModel(colNames,0);
		JTable table = new JTable(model);
		contentPane.add(new JScrollPane(table), BorderLayout.EAST);
		
		JTableHeader header = table.getTableHeader();
		header.setPreferredSize(new Dimension(100,30));
		header.setBackground(Color.LIGHT_GRAY);
		
		table.setFont(font15);
		table.setRowHeight(30);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,2));
		
		JLabel labelcode = new JLabel("CODE");
		labelcode.setFont(font);
		labelcode.setHorizontalAlignment(JLabel.CENTER);
		JTextField code = new JTextField(8);
		JButton codechk = new JButton("중복검사");
		JPanel panelcode = new JPanel();
		panelcode.add(code);
		panelcode.add(codechk);
		
		JLabel labeldept = new JLabel("학과명");
		labeldept.setFont(font);
		labeldept.setHorizontalAlignment(JLabel.CENTER);
		JTextField name = new JTextField(8);
		
		panel.add(labelcode);
		panel.add(panelcode);
		panel.add(labeldept);
		panel.add(name);
		
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel panel1 = new JPanel();
		JTextField find = new JTextField(5);
		String arrbtn[] = {"입력","수정","검색","삭제","취소","Home"};
		ActionListener listener = new DeptActionListener(frame,frame1,table,code,name,confirmchk,model,find);
		codechk.addActionListener(listener);
		find.setFont(font);
		for ( int i = 0 ; i < arrbtn.length ; i ++){
			JButton button = new JButton( arrbtn[i] );
			panel1.add(button);
			if (i == 1)
				panel1.add(find);
			button.addActionListener(listener);
	}
		MouseListener mouse = new DeptMouseListener(code,name,model);
		table.addMouseListener( mouse );
		contentPane.add(panel1, BorderLayout.SOUTH);
		frame1.pack();
		frame1.setVisible(true);
  }
}