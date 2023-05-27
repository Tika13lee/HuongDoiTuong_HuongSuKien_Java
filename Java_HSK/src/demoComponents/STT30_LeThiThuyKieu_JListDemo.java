package demoComponents;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class STT30_LeThiThuyKieu_JListDemo extends JFrame implements ActionListener {
	private DefaultListModel modelName;
	private JList listName;
	private JTextField txtName;
	private JButton btnAdd, btnRemove;
	private JButton btnEdit;

	public STT30_LeThiThuyKieu_JListDemo() {
		setTitle("List Edit Demo");
		setSize(500, 320);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		modelName = new DefaultListModel();
		listName = new JList(modelName);
		add(new JScrollPane(listName), BorderLayout.CENTER);

		JPanel jpTop, jpBottom, jpRight;
		jpTop = new JPanel();
		jpTop.add(new JLabel("Input Name"));
		jpTop.add(txtName = new JTextField(15));
		jpBottom = new JPanel();
		jpBottom.add(btnAdd = new JButton("Add Item"));
		jpBottom.add(btnEdit = new JButton("Edit"));
		jpBottom.add(btnRemove = new JButton("Remove Item"));

		jpRight = new JPanel(new BorderLayout());
		jpRight.add(jpTop, BorderLayout.NORTH);
		jpRight.add(jpBottom, BorderLayout.CENTER);
		add(jpRight, BorderLayout.EAST);

		txtName.addActionListener(this);
		btnAdd.addActionListener(this);
		btnRemove.addActionListener(this);
		btnEdit.addActionListener(this);
	}

	public static void main(String[] args) {
		new STT30_LeThiThuyKieu_JListDemo().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnAdd)) {
			String name = txtName.getText().trim();
			if (name.equals("")) {
				JOptionPane.showMessageDialog(this, "Please input name!");
			} else {
				modelName.addElement(name);
				txtName.setText("");
			}
			txtName.requestFocus();
		} else if (o.equals(btnRemove)) {
			if (listName.getSelectedIndex() == -1)
				JOptionPane.showMessageDialog(this, "Phai chon dong can xoa");
			else {
				if (JOptionPane.showConfirmDialog(this, "Ban chac chan muon xoa?", "Canh bao",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
					;
				modelName.removeElement(listName.getSelectedValue());
			}
		} else if (o.equals(btnEdit)) {
			modelName.setElementAt(txtName.getText(), listName.getSelectedIndex());
		}
	}
}
