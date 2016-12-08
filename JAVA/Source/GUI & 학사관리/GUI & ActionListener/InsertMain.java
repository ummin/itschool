package kr.ac.itschool.DBJoin0801;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class InsertMain {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Main");
		frame.setPreferredSize(new Dimension(300,300));
		frame.setLocation(500, 400);
		Container contentPane = frame.getContentPane();
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,1));
		
		JButton dept = new JButton("학과등록");
		JButton professor = new JButton("교수등록");
		JButton student = new JButton("학생등록");
		
		panel.add(dept);
		panel.add(professor);
		panel.add(student);
		
		contentPane.add(panel, BorderLayout.CENTER);
		ActionListener deptltn = new Dept(frame);
		ActionListener professorltn = new Professor(frame);
		ActionListener studentltn = new Student(frame);
		dept.addActionListener(deptltn);
		professor.addActionListener(professorltn);
		student.addActionListener(studentltn);
		
		frame.pack();
		frame.setVisible(true);
	}
}
