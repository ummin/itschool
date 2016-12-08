package kr.ac.itschool.custom;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ComboboxDemoMain extends JFrame{

	public static void main(String[] args) {
		JFrame frame = new JFrame("hello java");
		frame.setLocation(500,400);
		frame.setPreferredSize(new Dimension(450,120));
		Container contentPane = frame.getContentPane();
		
		JComboBox combo = new JComboBox();
		String comarr[] = {"010","011","016","017","019"};
		combo.setModel( new DefaultComboBoxModel(comarr));
		JPanel panel = new JPanel();
		panel.add(combo);
		String result = combo.getSelectedItem().toString();
		System.out.println(result);
		contentPane.add(panel, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}
}
