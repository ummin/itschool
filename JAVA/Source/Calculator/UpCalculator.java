package kr.ac.itschool.w0714GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpCalculator implements ActionListener {
	private JTextField text1;
	private JTextField text2;
	private JLabel label;
	
	public UpCalculator(JTextField text1, JTextField text2, JLabel label) {
		this.text1 = text1;
		this.text2 = text2;
		this.label = label;
	}
	public void actionPerformed(ActionEvent e) {
		JFrame frame = new JFrame();
		String co = e.getActionCommand();
		if (label.getText().equals("=")) {
			text2.setText("");
			label.setText("");
		}
		
		boolean intchk = chknumber(co);
			 if(intchk){
				text2.setText(text2.getText()+co);
				return;
			}
			else if ( !intchk && co != "=" && co == "CE"){
				text1.setText("");
				text2.setText("");
				return;
			}
			else if (!intchk && co != "=" && co != "CE" ) {
				label.setText(co);
				text1.setText(text2.getText()+label.getText());
				text2.setText("");
				return;
			}
			String input = text1.getText();
			String cal = label.getText();
			int index = input.lastIndexOf(cal);
			String input2 = input.substring(0,index);
			
			int num1 = Integer.parseInt(input2);
			int num2 = Integer.parseInt(text2.getText());
			int num3 = 0;
			
			if ( label.getText().equals("+") && co.equals("=")){
				 num3 = num1 + num2;
				String total= String.valueOf(num3);
				label.setText(co);
				text2.setText(total);
				text1.setText("");
			}
			else if ( label.getText().equals("-") && co.equals("=")){
				 num3 = num1 - num2;
				String total= String.valueOf(num3);
				label.setText(co);
				text2.setText(total);
				text1.setText("");
			}
			else if ( label.getText().equals("*") && co.equals("=")){
			    num3 = num1 * num2;
				String total= String.valueOf(num3);
				label.setText(co);
				text2.setText(total);
				text1.setText("");
			}
			else if (num1 == 0 || num2 == 0 ){
				JOptionPane.showMessageDialog(frame, "0으로 나눌 수 없습니다.");
				text1.setText("");
				text2.setText("");
			}
			else if (label.getText().equals("/") && co.equals("=") ){
			    num3 = num1/num2;
				String total= String.valueOf(num3);
				label.setText(co);
				text2.setText(total);
				text1.setText("");
			}
			
	}
	private boolean chknumber(String co) {
		boolean intchk = false;
		try {
			Integer.parseInt(co);
			intchk = true;
		} catch (Exception e) {
		}
		return intchk;
	}
}

