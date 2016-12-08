package kr.ac.itschool.w0714GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpgradeCalCulaterMain {


	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setLocation(400, 300);
		frame.setPreferredSize(new Dimension(300,300));
		JButton button = new JButton();
		GridLayout Layout = new GridLayout(4,4);
		Font font = new Font ("바탕체",Font.BOLD, 25);
		Container contentPane = frame.getContentPane();
		JPanel panel = new JPanel();
		JLabel label = new JLabel();
		panel.setLayout(Layout);
		
		JTextField text1 = new JTextField(20);
		JTextField text2 = new JTextField(20);
		JPanel panel1 = new JPanel();
		panel1.add(text1);
		panel1.add(text2);
		BoxLayout boxlayout = new BoxLayout(panel1,BoxLayout.Y_AXIS);
		panel1.setLayout(boxlayout);		
		contentPane.add(panel, BorderLayout.CENTER);
		contentPane.add(panel1, BorderLayout.NORTH);
		
		text1.setHorizontalAlignment(text1.RIGHT);
		text2.setHorizontalAlignment(text2.RIGHT);
		
		text1.setFont(font);
		text2.setFont(font);
		text1.setEditable(true);
		text2.setEditable(true);

		ArrayList<String> list = new ArrayList();
		String arr[] = {"1","2","3","+","4","5","6","-","7","8","9","*","CE","0","=","/"};
		ActionListener listener = new UpCalculator(text1,text2,label);
		for ( int i = 0 ; i < arr.length ; i ++){
			button = new JButton(arr[i]);
			panel.add(button);
			button.addActionListener(listener);
		}
		frame.pack();
		frame.setVisible(true);
	}
}
