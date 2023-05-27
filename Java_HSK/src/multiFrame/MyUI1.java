package multiFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyUI1 extends JFrame {
	private static final long serialVersionUID = 1L;

	public JTextField txt1;

	public MyUI1(String title) {
		setTitle("My JFrame");
		doAddSomeControl();
	}

	public void doAddSomeControl() {
		JPanel pn = new JPanel();
		JButton btn1 = new JButton("Hello I’m JFrame");
		txt1 = new JTextField(15);
		pn.add(btn1);
		pn.add(txt1);
		add(pn);

		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});

//		btn1.addActionListener(new ActionListener(){
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				dispose();				
//			}			
//		});

		setSize(300, 200);
		setLocationRelativeTo(null);
	}
}
