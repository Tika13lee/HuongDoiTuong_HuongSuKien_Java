package mdi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MDIDemo extends JFrame implements ActionListener{
	private JDesktopPane desktop;
	private JMenuItem mnuOpenF1, mnuOpenF2;

	FrameCongViec1 f1;
	FrameCongViec2 f2;

	public MDIDemo() {
		setTitle("");
		setSize(600, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		desktop = new JDesktopPane();
		setContentPane(desktop);

		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		JMenu mnuOpen = new JMenu("Open");
		bar.add(mnuOpen);
		mnuOpen.add(mnuOpenF1 = new JMenuItem("Frame 1"));
		mnuOpen.add(mnuOpenF2 = new JMenuItem("Frame 2"));

		mnuOpenF1.addActionListener(this);
		mnuOpenF2.addActionListener(this);

	}

	public static void main(String[] args) {
		new MDIDemo().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mnuOpenF1) {
			if (f1 == null || f1.isClosed()) {
				f1 = new FrameCongViec1();
				desktop.add(f1);
				f1.setVisible(true);
			} else {
				try {
					f1.setSelected(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} else if (e.getSource() == mnuOpenF2) {
			if (f2 == null || f2.isClosed()) {
				f2 = new FrameCongViec2();
				desktop.add(f2);
				f2.setVisible(true);
			} else {
				try {
					f2.setSelected(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
	}

	/*public void OpenFrame(JInternalFrame f) {
		if (f == null || f.isClosed()) {
			f = new FrameCongviec1();
			desktop.add(f1);
			f1.setVisible(true);
		} else {
			try {
				f1.setSelected(true);
			} catch (PropertyVetoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}*/
//	private void HienForm( Form f )
//	{
//	bool thay = false;
//	foreach (Form frm in this.MdiChildren) 
//	{
//	    if (frm.Name.ToUpper().Equals(f.Name.ToUpper()))
//	    {
//			frm.Activate();
//			thay = true;
//	    }
//	}
//	if (thay == false)
//	{
//	     f.MdiParent = this;
//	     f.Show();
//	}
//	}

	 
}

//f1.setLocation(this.getWidth() / 2 - f1.getWidth() / 2, (this
//.getHeight() - 20)
/// 2 - f1.getHeight() / 2 - 20);
