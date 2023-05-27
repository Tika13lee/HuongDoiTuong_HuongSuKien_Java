package tuan5_30_Country;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.table.DefaultTableModel;

public class GUICountry extends JFrame implements ActionListener, MouseListener {
	private JLabel lblTitle;
	private JLabel lblCountry;
	private JLabel lblCapital;
	private JLabel lblPop;
	private JLabel lblDemocracy;
	private JTextField txtCountry;
	private JTextField txtCapital;
	private JTextField txtPop;
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane sp;
	private JButton btnAdd;
	private JButton btnClear;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnSearch;
	private JButton btnSave;
	private JComboBox<String> cbo;

	private ListCountry ds = new ListCountry();
	private static final String FILE = "src/data/dsCountry.txt";

	public GUICountry() {
		setTitle("Using JTable Component & IO Stream");
		setSize(800, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		JPanel jpN, jpC, jpS;

		// north
		jpN = new JPanel();
		this.add(jpN, BorderLayout.NORTH);
		jpN.add(lblTitle = new JLabel("Using JTable Component"));
		lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
		lblTitle.setForeground(Color.BLUE);

		// center
		jpC = new JPanel();
		this.add(jpC);
		jpC.setLayout(new BoxLayout(jpC, BoxLayout.Y_AXIS));

		Box b1, b2, b3, b4;
		b1 = Box.createHorizontalBox();
		b1.add(lblCountry = new JLabel("Enter country:"));
		b1.add(txtCountry = new JTextField(10));
		lblCountry.setPreferredSize(new Dimension(100, 20));

		b2 = Box.createHorizontalBox();
		b2.add(lblCapital = new JLabel("Enter capital:"));
		b2.add(txtCapital = new JTextField(10));
		lblCapital.setPreferredSize(lblCountry.getPreferredSize());

		b3 = Box.createHorizontalBox();
		b3.add(lblPop = new JLabel("Enter population:"));
		b3.add(txtPop = new JTextField(10));
		lblPop.setPreferredSize(lblCountry.getPreferredSize());

		b4 = Box.createHorizontalBox();
		b4.add(lblDemocracy = new JLabel("Enter democracy:"));
		String[] str = { "false", "true" };
		b4.add(cbo = new JComboBox<String>(str));
		lblDemocracy.setPreferredSize(lblCountry.getPreferredSize());

		jpC.add(b1);
		jpC.add(Box.createRigidArea(new DimensionUIResource(10, 10)));
		jpC.add(b2);
		jpC.add(Box.createRigidArea(new DimensionUIResource(10, 10)));
		jpC.add(b3);
		jpC.add(Box.createRigidArea(new DimensionUIResource(10, 10)));
		jpC.add(b4);
		jpC.add(Box.createRigidArea(new DimensionUIResource(10, 10)));

		// set data
		txtCountry.setText("Germany");
		txtCapital.setText("Berlin");
		txtPop.setText("83");

		// create table
		String[] cols = { "Country", "Capital", "Population", "Democracy" };
		model = new DefaultTableModel(cols, 0);
		table = new JTable(model);
		sp = new JScrollPane(table);
		jpC.add(sp);

		// load data
		LuuTru lt = new LuuTru();
		try {
			ds = (ListCountry) lt.docFile(FILE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loadDataToTable();

		// south
		jpS = new JPanel();
		this.add(jpS, BorderLayout.SOUTH);
		jpS.add(btnAdd = new JButton("Add"));
		jpS.add(btnClear = new JButton("Clear"));
		jpS.add(btnUpdate = new JButton("Update"));
		jpS.add(btnDelete = new JButton("Delete"));
		jpS.add(btnSearch = new JButton("Search"));
		jpS.add(btnSave = new JButton("Save"));

		// event
		btnAdd.addActionListener(this);
		btnClear.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnSearch.addActionListener(this);
		btnSave.addActionListener(this);
		table.addMouseListener(this);
	}

	public static void main(String[] args) {
		new GUICountry().setVisible(true);
	}

	private void loadDataToTable() {
		model.setRowCount(0);
		for (Country c : ds.getDs()) {
			Object[] obj = { c.getCountry(), c.getCapital(), c.getPop(), c.isDemocracy() == true ? "true" : "false" };
			model.addRow(obj);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnAdd)) {
			if (txtCountry.getText().equals("") || txtCapital.getText().equals("") || txtPop.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Vui long dien day du thong tin");
			} else {
				String country = txtCountry.getText();
				String capital = txtCapital.getText();
				int pop = Integer.parseInt(txtPop.getText());
				boolean d = cbo.getSelectedItem().equals("true");
				Country c = new Country(country, capital, pop, d);
				if (ds.them(c))
					loadDataToTable();
				else
					JOptionPane.showMessageDialog(this, "Them khong thanh cong");
			}
		} else if (o.equals(btnClear)) {
			txtCountry.setText("");
			txtCapital.setText("");
			txtPop.setText("");
			txtCountry.requestFocus();
		} else if (o.equals(btnDelete)) {
			int r = table.getSelectedRow();
			Country c = ds.getElement(r);
			if (r != -1) {
				if (JOptionPane.showConfirmDialog(this, "Bạn muốn xóa dòng này không?", "Cảnh báo",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					ds.xoa(c.getCountry());
					model.removeRow(r);
					JOptionPane.showMessageDialog(this, "Xóa thành công");
				}
			} else {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xóa");
			}
		} else if (o.equals(btnSearch)) {
			String s = JOptionPane.showInputDialog("Nhập country cần tìm: ");
			Country c = ds.tim(s);
			if (c != null) {
				model = (DefaultTableModel) table.getModel();
				model.getDataVector().removeAllElements();
				model.addRow(new Object[] { c.getCountry(), c.getCapital(), c.getPop(),
						c.isDemocracy() == true ? "true" : "false" });
			} else {
				JOptionPane.showMessageDialog(this, "Not found");
			}
		} else if (o.equals(btnSave)) {
			LuuTru lt = new LuuTru();
			try {
				lt.ghiFile(ds, FILE);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(this, "Lưu thành công");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int r = table.getSelectedRow();
		if (r != -1) {
			txtCountry.setText(model.getValueAt(r, 0).toString());
			txtCapital.setText(model.getValueAt(r, 1).toString());
			txtPop.setText(model.getValueAt(r, 3).toString());
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}